export interface ContactRequest {
    vorname: string;
    name: string;
    firma?: string;
    email: string;
    strasse: string;
    plz: string;
    stadt: string;
    branche?: string;
    anrede: string;
    position?: string;
    webseite?: string;
    telefon?: string;
    mobil?: string;
    geburtsdatum?: Date;
    bic?: string;
    iban: string;
    kategorie?: string;
    notizen?: string;
    }