package pieritz.prince.CRMAPP.dto;

import org.springframework.stereotype.Component;
import pieritz.prince.CRMAPP.domain.Contact;

@Component
public class ContactMapper {

    public Contact mapToContact(ContactRequest request) {
        return Contact.builder()
                .vorname(request.getVorname())
                .name(request.getName())
                .firma(request.getFirma())
                .email(request.getEmail())
                .ort(request.getOrt())
                .gespeichertDatum(request.getGespeichertDatum())
                .strasse(request.getStrasse())
                .plz(request.getPlz())
                .stadt(request.getStadt())
                .branche(request.getBranche())
                .anrede(request.getAnrede())
                .position(request.getPosition())
                .webseite(request.getWebseite())
                .telefon(request.getTelefon())
                .mobil(request.getMobil())
                .geburtsdatum(request.getGeburtsdatum())
                .bic(request.getBic())
                .iban(request.getIban())
                .kategorie(request.getKategorie())
                .notizen(request.getNotizen())
                .build();
    }

    public ContactResponse mapToContactResponse(Contact contact) {
        return ContactResponse.builder()
                .id(contact.getId())
                .vorname(contact.getVorname())
                .name(contact.getName())
                .firma(contact.getFirma())
                .ort(contact.getOrt())
                .gespeichertDatum(contact.getGespeichertDatum())
                .strasse(contact.getStrasse())
                .plz(contact.getPlz())
                .stadt(contact.getStadt())
                .branche(contact.getBranche())
                .anrede(contact.getAnrede())
                .position(contact.getPosition())
                .webseite(contact.getWebseite())
                .geburtsdatum(contact.getGeburtsdatum())
                .kategorie(contact.getKategorie())
                .notizen(contact.getNotizen())
                .build();
    }

    public void updateContactFromRequest(ContactRequest request, Contact contact) {
        contact.setVorname(request.getVorname());
        contact.setName(request.getName());
        contact.setFirma(request.getFirma());
        contact.setEmail(request.getEmail());
        contact.setOrt(request.getOrt());
        contact.setGespeichertDatum(request.getGespeichertDatum());
        contact.setStrasse(request.getStrasse());
        contact.setPlz(request.getPlz());
        contact.setStadt(request.getStadt());
        contact.setBranche(request.getBranche());
        contact.setAnrede(request.getAnrede());
        contact.setPosition(request.getPosition());
        contact.setWebseite(request.getWebseite());
        contact.setTelefon(request.getTelefon());
        contact.setMobil(request.getMobil());
        contact.setGeburtsdatum(request.getGeburtsdatum());
        contact.setBic(request.getBic());
        contact.setIban(request.getIban());
        contact.setKategorie(request.getKategorie());
        contact.setNotizen(request.getNotizen());
    }

}

