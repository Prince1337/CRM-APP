import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ContactRequest } from 'src/app/shared/models/contact-request';
import { ContactResponse } from 'src/app/shared/models/contact-response';
import { Page } from 'src/app/shared/models/page';

@Injectable({
  providedIn: 'root'
})
export class ContactService {
  private baseUrl = 'http://localhost:8080/contacts';

  constructor(private http: HttpClient) {}

  createContact(request: ContactRequest): Observable<ContactResponse> {
    const headers = this.getHeaders();
    console.log(request);
    return this.http.post<ContactResponse>(this.baseUrl, request, { headers });
  }

  getContactById(id: number): Observable<ContactResponse> {
    const headers = this.getHeaders();
    return this.http.get<ContactResponse>(`${this.baseUrl}/${id}`, { headers });
  }

  getAllContacts(pageable: any): Observable<Page<ContactResponse>> {
    const headers = this.getHeaders();
    return this.http.get<Page<ContactResponse>>(this.baseUrl, { headers, params: pageable });
  }

  updateContact(id: number, request: ContactRequest): Observable<ContactResponse> {
    const headers = this.getHeaders();
    return this.http.put<ContactResponse>(`${this.baseUrl}/${id}`, request, { headers });
  }

  deleteContact(id: number): Observable<void> {
    const headers = this.getHeaders();
    return this.http.delete<void>(`${this.baseUrl}/${id}`, { headers });
  }

  searchContacts(searchTerm: string, pageable: any): Observable<Page<ContactResponse>> {
    const headers = this.getHeaders();
    const params = { searchTerm, ...pageable };
    return this.http.get<Page<ContactResponse>>(`${this.baseUrl}/search`, { headers, params });
  }

  countContactsByCompany(company: string): Observable<number> {
    const headers = this.getHeaders();
    return this.http.get<number>(`${this.baseUrl}/countByCompany?company=${company}`, { headers });
  }

  countContactsByEmailContaining(email: string): Observable<number> {
    const headers = this.getHeaders();
    return this.http.get<number>(`${this.baseUrl}/countByEmailContaining?email=${email}`, { headers });
  }

  getContactsByIndustry(industry: string, pageable: any): Observable<Page<ContactResponse>> {
    const headers = this.getHeaders();
    const params = { industry, ...pageable };
    return this.http.get<Page<ContactResponse>>(`${this.baseUrl}/industry`, { headers, params });
  }

  private getHeaders(): HttpHeaders {
    const token = localStorage.getItem('access_token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return headers;
  }
}