import { ProductRequest } from "./product-request";

export interface InvoiceRequest {
    kontaktId: number;
    rechnungsdatum: Date;
    bruttobetrag?: number;
    leistungsbezeichnung: string;
    status: string;
    zahlungsfrist: Date;
    produkte?: ProductRequest[];
  }