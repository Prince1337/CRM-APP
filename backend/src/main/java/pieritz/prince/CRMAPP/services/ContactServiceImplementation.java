package pieritz.prince.CRMAPP.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pieritz.prince.CRMAPP.domain.Contact;
import pieritz.prince.CRMAPP.dto.ContactMapper;
import pieritz.prince.CRMAPP.dto.ContactRequest;
import pieritz.prince.CRMAPP.dto.ContactResponse;
import pieritz.prince.CRMAPP.repositories.ContactRepository;
import pieritz.prince.CRMAPP.services.interfaces.ContactService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactServiceImplementation implements ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    @Override
    public ContactResponse createContact(ContactRequest request) {
        Contact contact = contactMapper.mapToContact(request);
        Contact savedContact = contactRepository.save(contact);
        return contactMapper.mapToContactResponse(savedContact);
    }

    @Override
    public ContactResponse getContactById(Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with id: " + id));
        return contactMapper.mapToContactResponse(contact);
    }

    @Override
    public List<ContactResponse> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream()
                .map(contactMapper::mapToContactResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ContactResponse updateContact(Long id, ContactRequest request) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with id: " + id));
        contactMapper.updateContactFromRequest(request, contact);
        Contact updatedContact = contactRepository.save(contact);
        return contactMapper.mapToContactResponse(updatedContact);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
