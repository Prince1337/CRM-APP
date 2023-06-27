package pieritz.prince.CRMAPP.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pieritz.prince.CRMAPP.domain.Document;
import pieritz.prince.CRMAPP.dto.DocumentMapper;
import pieritz.prince.CRMAPP.dto.DocumentRequest;
import pieritz.prince.CRMAPP.dto.DocumentResponse;
import pieritz.prince.CRMAPP.exceptions.DocumentNotFoundException;
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
                .orElseThrow(() -> new DocumentNotFoundException("Document not found"));
        return documentMapper.toDocumentResponse(document);
    }

    @Override
    public Page<DocumentResponse> getAllDocuments(Pageable pageable) {
        Page<Document> documentPage = documentRepository.findAll(pageable);
        List<DocumentResponse> documentResponses = documentPage.getContent()
                .stream()
                .map(documentMapper::toDocumentResponse)
                .toList();
        return new PageImpl<>(documentResponses, pageable, documentPage.getTotalElements());
    }

    @Override
    public DocumentResponse updateDocument(Long id, DocumentRequest request) {
        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new DocumentNotFoundException("Document not found"));
        documentMapper.updateDocumentFromRequest(request, document);
        Document updatedDocument = documentRepository.save(document);
        return documentMapper.toDocumentResponse(updatedDocument);
    }

    @Override
    public void deleteDocument(Long id) {
        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new DocumentNotFoundException("Document not found"));
        documentRepository.delete(document);
    }

    @Override
    public Page<DocumentResponse> getDocumentsByContactId(Long contactId, Pageable pageable) {
        Page<Document> documents = documentRepository.findByKontaktId(contactId, pageable);
        return documents.map(documentMapper::toDocumentResponse);
    }

    @Override
    public long countByType(String type) {
        return documentRepository.countByArt(type);
    }

    @Override
    public Page<DocumentResponse> getDocumentsByFileType(String fileType, Pageable pageable) {
        Page<Document> documents = documentRepository.findByDateityp(fileType, pageable);
        return documents.map(documentMapper::toDocumentResponse);
    }
}
