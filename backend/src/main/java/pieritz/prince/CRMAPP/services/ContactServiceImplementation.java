package pieritz.prince.CRMAPP.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pieritz.prince.CRMAPP.domain.Contact;
import pieritz.prince.CRMAPP.dto.ContactMapper;
import pieritz.prince.CRMAPP.dto.ContactRequest;
import pieritz.prince.CRMAPP.dto.ContactResponse;
import pieritz.prince.CRMAPP.exceptions.ContactNotFoundException;
import pieritz.prince.CRMAPP.repositories.ContactRepository;
import pieritz.prince.CRMAPP.services.interfaces.ContactService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactServiceImplementation implements ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    @Override
    public ContactResponse createContact(ContactRequest request) {
        log.info("ContactService:createContact execution started");
        Contact contact = contactMapper.mapToContact(request);
        log.debug("ContactService:createContact request parameters {} ", contact);
        Contact savedContact = contactRepository.save(contact);
        ContactResponse contactResponse = contactMapper.mapToContactResponse(savedContact);
        log.debug("ContactService:createContact received response from Database {} ", contactResponse);

        return contactResponse;
    }

    @Override
    public ContactResponse getContactById(Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact not found with id: " + id));
        return contactMapper.mapToContactResponse(contact);
    }

    @Override
    @Cacheable(value = "contacts")
    public Page<ContactResponse> getAllContacts(Pageable pageable) {
        log.info("ContactService:getAllContacts execution started");
        Page<Contact> contactPage = contactRepository.findAll(pageable);
        List<ContactResponse> contactResponses = contactPage.getContent()
            .stream()
            .map(contactMapper::mapToContactResponse)
            .toList();
        return new PageImpl<>(contactResponses, pageable, contactPage.getTotalElements());
    }

    @Override
    public ContactResponse updateContact(Long id, ContactRequest request) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact not found with id: " + id));
        contactMapper.updateContactFromRequest(request, contact);
        Contact updatedContact = contactRepository.save(contact);
        return contactMapper.mapToContactResponse(updatedContact);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Page<ContactResponse> searchContacts(String searchTerm, Pageable pageable) {
        Page<Contact> contacts = contactRepository.findByVornameContainingIgnoreCaseOrNameContainingIgnoreCase(searchTerm, searchTerm, pageable);
        return contacts.map(contactMapper::mapToContactResponse);
    }

    @Override
    public long countByCompany(String company) {
        return contactRepository.countByFirma(company);
    }

    @Override
    public long countByEmailContaining(String email) {
        return contactRepository.countByEmailContaining(email);
    }



    @Override
    public Page<ContactResponse> getContactsByIndustry(String industry, Pageable pageable) {
        Page<Contact> contacts = contactRepository.findByBranche(industry, pageable);
        return contacts.map(contactMapper::mapToContactResponse);
    }
}
