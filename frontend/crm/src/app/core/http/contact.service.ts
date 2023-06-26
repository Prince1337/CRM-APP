import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ContactRequest } from 'src/app/shared/models/contact-request';
import { ContactResponse } from 'src/app/shared/models/contact-response';

@Injectable({
  providedIn: 'root'
})
export class ContactService {
  private authUrl = 'http://localhost:4200/auth';

  constructor(private http: HttpClient) { }

  private getAuthenticationHeaders(): HttpHeaders {
    const token = localStorage.getItem('access_token');
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + token);
    return headers;
  }

  createContact(request: ContactRequest): Observable<ContactResponse> {
    const headers = this.getAuthenticationHeaders();
    return this.http.post<ContactResponse>(`${this.authUrl}/contacts`, request, { headers });
  }

  getContact(id: number): Observable<ContactResponse> {
    const headers = this.getAuthenticationHeaders();
    return this.http.get<ContactResponse>(`${this.authUrl}/contacts/${id}`, { headers });
  }

  getAllContacts(): Observable<ContactResponse[]> {
    const headers = this.getAuthenticationHeaders();
    return this.http.get<ContactResponse[]>(`${this.authUrl}/contacts`, { headers });
  }

  updateContact(id: number, request: ContactRequest): Observable<ContactResponse> {
    const headers = this.getAuthenticationHeaders();
    return this.http.put<ContactResponse>(`${this.authUrl}/contacts/${id}`, request, { headers });
  }

  deleteContact(id: number): Observable<void> {
    const headers = this.getAuthenticationHeaders();
    return this.http.delete<void>(`${this.authUrl}/contacts/${id}`, { headers });
  }
}
