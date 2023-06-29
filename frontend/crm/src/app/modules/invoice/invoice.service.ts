import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { InvoiceRequest } from 'src/app/shared/models/invoice-request';
import { InvoiceResponse } from 'src/app/shared/models/invoice-response';
import { Page } from 'src/app/shared/models/page';

@Injectable({
  providedIn: 'root'
})
export class InvoiceService {
  private baseUrl = 'http://localhost:8080/invoices';

  constructor(private http: HttpClient) { }

  createInvoice(request: InvoiceRequest): Observable<InvoiceResponse> {
    const headers = this.getHeaders();
    return this.http.post<InvoiceResponse>(`${this.baseUrl}`, request, { headers });
  }

  getInvoice(id: number): Observable<InvoiceResponse> {
    const headers = this.getHeaders();
    return this.http.get<InvoiceResponse>(`${this.baseUrl}/${id}`, { headers });
  }

  getAllInvoices(page: number, size: number): Observable<Page<InvoiceResponse>> {
    const headers = this.getHeaders();
    const params = new HttpParams()
      .set('page', String(page))
      .set('size', String(size));
    return this.http.get<Page<InvoiceResponse>>(this.baseUrl, { headers, params });
  }

  updateInvoice(id: number, request: InvoiceRequest): Observable<InvoiceResponse> {
    const headers = this.getHeaders();
    return this.http.put<InvoiceResponse>(`${this.baseUrl}/${id}`, request, { headers });
  }

  deleteInvoice(id: number): Observable<any> {
    const headers = this.getHeaders();
    return this.http.delete<any>(`${this.baseUrl}/${id}`, { headers });
  }

  getInvoicesByContactId(contactId: number): Observable<InvoiceResponse[]> {
    const headers = this.getHeaders();
    return this.http.get<InvoiceResponse[]>(`${this.baseUrl}/byContact?contactId=${contactId}`, { headers });
  }

  countInvoicesByStatus(status: string): Observable<number> {
    const headers = this.getHeaders();
    return this.http.get<number>(`${this.baseUrl}/countByStatus?status=${status}`, { headers });
  }

  getInvoicesByDescription(description: string): Observable<InvoiceResponse[]> {
    const headers = this.getHeaders();
    return this.http.get<InvoiceResponse[]>(`${this.baseUrl}/byDescription?description=${description}`, { headers });
  }

  private getHeaders(): HttpHeaders {
    const token = localStorage.getItem('access_token'); // Get the access token from localStorage
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    });
  }
}