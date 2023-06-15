package pieritz.prince.CRMAPP.dto;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import pieritz.prince.CRMAPP.domain.Document;

@Component
public class DocumentMapper {
    public DocumentMapper() {
    }

    public DocumentResponse toDocumentResponse(Document document) {
        return DocumentResponse.builder()
                .id(document.getId())
                .art(document.getArt())
                .kontaktId(document.getKontaktId())
                .speicherdatum(document.getSpeicherdatum())
                .dateityp(document.getDateityp())
                .dateigroesse(document.getDateigroesse())
                .pfad(document.getPfad())
                .notizen(document.getNotizen())
                .erstelltDatum(document.getErstelltDatum())
                .geaendertDatum(document.getGeaendertDatum())
                .build();
    }

    public Document toDocument(DocumentRequest request) {
        return Document.builder()
                .art(request.getArt())
                .kontaktId(request.getKontaktId())
                .speicherdatum(request.getSpeicherdatum())
                .dateityp(request.getDateityp())
                .dateigroesse(request.getDateigroesse())
                .pfad(request.getPfad())
                .notizen(request.getNotizen())
                .erstelltDatum(request.getErstelltDatum())
                .geaendertDatum(request.getGeaendertDatum())
                .build();
    }

    public void updateDocumentFromRequest(DocumentRequest request, Document document) {
        document.setArt(request.getArt());
        document.setKontaktId(request.getKontaktId());
        document.setSpeicherdatum(request.getSpeicherdatum());
        document.setDateityp(request.getDateityp());
        document.setDateigroesse(request.getDateigroesse());
        document.setPfad(request.getPfad());
        document.setNotizen(request.getNotizen());
        document.setErstelltDatum(request.getErstelltDatum());
        document.setGeaendertDatum(request.getGeaendertDatum());
    }
}