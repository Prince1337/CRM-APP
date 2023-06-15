package pieritz.prince.CRMAPP.services.interfaces;

import pieritz.prince.CRMAPP.dto.DocumentRequest;
import pieritz.prince.CRMAPP.dto.DocumentResponse;

import java.util.List;

public interface DocumentService {
    DocumentResponse createDocument(DocumentRequest request);
    DocumentResponse getDocumentById(Long id);
    List<DocumentResponse> getAllDocuments();
    DocumentResponse updateDocument(Long id, DocumentRequest request);
    void deleteDocument(Long id);
}
