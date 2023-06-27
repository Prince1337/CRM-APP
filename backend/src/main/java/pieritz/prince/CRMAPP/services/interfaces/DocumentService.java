package pieritz.prince.CRMAPP.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pieritz.prince.CRMAPP.dto.DocumentRequest;
import pieritz.prince.CRMAPP.dto.DocumentResponse;

import java.util.List;

public interface DocumentService {
    DocumentResponse createDocument(DocumentRequest request);
    DocumentResponse getDocumentById(Long id);
    Page<DocumentResponse> getAllDocuments(Pageable pageable);
    DocumentResponse updateDocument(Long id, DocumentRequest request);
    void deleteDocument(Long id);
    Page<DocumentResponse> getDocumentsByContactId(Long contactId, Pageable pageable);
    long countByType(String type);
    Page<DocumentResponse> getDocumentsByFileType(String fileType, Pageable pageable);
}
