import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OfferService {
  private baseUrl = 'http://localhost:8080/offers';

  constructor(private http: HttpClient) { }

  createOffer(request: any): Observable<any> {
    const headers = this.getHeaders();
    return this.http.post<any>(`${this.baseUrl}`, request, { headers });
  }

  getOffer(id: number): Observable<any> {
    const headers = this.getHeaders();
    return this.http.get<any>(`${this.baseUrl}/${id}`, { headers });
  }

  getAllOffers(): Observable<any> {
    const headers = this.getHeaders();
    return this.http.get<any>(`${this.baseUrl}`, { headers });
  }

  updateOffer(id: number, request: any): Observable<any> {
    const headers = this.getHeaders();
    return this.http.put<any>(`${this.baseUrl}/${id}`, request, { headers });
  }

  deleteOffer(id: number): Observable<any> {
    const headers = this.getHeaders();
    return this.http.delete<any>(`${this.baseUrl}/${id}`, { headers });
  }

  getOffersByContactId(contactId: number): Observable<any> {
    const headers = this.getHeaders();
    return this.http.get<any>(`${this.baseUrl}/byContact?contactId=${contactId}`, { headers });
  }

  countOffersByStatus(status: string): Observable<any> {
    const headers = this.getHeaders();
    return this.http.get<any>(`${this.baseUrl}/countByStatus?status=${status}`, { headers });
  }

  getOffersByDescription(description: string): Observable<any> {
    const headers = this.getHeaders();
    return this.http.get<any>(`${this.baseUrl}/byDescription?description=${description}`, { headers });
  }

  private getHeaders(): HttpHeaders {
    const token = localStorage.getItem('access_token'); // Get the access token from localStorage
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    });
  }
}