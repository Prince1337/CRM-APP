import { ProductResponse } from "./product-response";

export interface InvoiceResponse {
    rechnungsnummer?: number;
    kontaktId: number;
    rechnungsdatum: Date;
    bruttobetrag: number;
    leistungsbezeichnung: string;
    status: string;
    zahlungsfrist: Date;
    produkte?: ProductResponse[];
  }