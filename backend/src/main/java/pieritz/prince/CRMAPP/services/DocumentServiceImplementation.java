package pieritz.prince.CRMAPP.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pieritz.prince.CRMAPP.domain.Document;
import pieritz.prince.CRMAPP.dto.DocumentMapper;
import pieritz.prince.CRMAPP.dto.DocumentRequest;
import pieritz.prince.CRMAPP.dto.DocumentResponse;
import pieritz.prince.CRMAPP.repositories.DocumentRepository;
import pieritz.prince.CRMAPP.services.interfaces.DocumentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class DocumentServiceImplementation implements DocumentService {
    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;


    @Override
    public DocumentResponse createDocument(DocumentRequest request) {
        Document document = documentMapper.toDocument(request);
        Document savedDocument = documentRepository.save(document);
        return documentMapper.toDocumentResponse(savedDocument);
    }

    @Override
    public DocumentResponse getDocumentById(Long id) {
        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));
        return documentMapper.toDocumentResponse(document);
    }

    @Override
    public List<DocumentResponse> getAllDocuments() {
        List<Document> documents = documentRepository.findAll();
        return documents.stream()
                .map(documentMapper::toDocumentResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DocumentResponse updateDocument(Long id, DocumentRequest request) {
        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));
        documentMapper.updateDocumentFromRequest(request, document);
        Document updatedDocument = documentRepository.save(document);
        return documentMapper.toDocumentResponse(updatedDocument);
    }

    @Override
    public void deleteDocument(Long id) {
        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));
        documentRepository.delete(document);
    }
}
