package pieritz.prince.CRMAPP.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pieritz.prince.CRMAPP.dto.ContactRequest;
import pieritz.prince.CRMAPP.dto.ContactResponse;

import java.util.List;

public interface ContactService {
    ContactResponse createContact(ContactRequest request);
    ContactResponse getContactById(Long id);
    Page<ContactResponse> getAllContacts(Pageable pageable);
    ContactResponse updateContact(Long id, ContactRequest request);
    void deleteContact(Long id);
    Page<ContactResponse> searchContacts(String searchTerm, Pageable pageable);
    long countByCompany(String company);
    long countByEmailContaining(String email);
    Page<ContactResponse> getContactsByIndustry(String industry, Pageable pageable);
}
