package pieritz.prince.CRMAPP.services.interfaces;

import pieritz.prince.CRMAPP.dto.ContactRequest;
import pieritz.prince.CRMAPP.dto.ContactResponse;

import java.util.List;

public interface ContactService {
    ContactResponse createContact(ContactRequest request);
    ContactResponse getContactById(Long id);
    List<ContactResponse> getAllContacts();
    ContactResponse updateContact(Long id, ContactRequest request);
    void deleteContact(Long id);
}
