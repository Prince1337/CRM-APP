import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DocumentRequest } from 'src/app/shared/models/document-request';
import { DocumentResponse } from 'src/app/shared/models/document-response';
import { Page } from 'src/app/shared/models/page';

@Injectable({
  providedIn: 'root'
})
export class DocumentService {
  private baseUrl = 'http://localhost:8080/documents';

  constructor(private http: HttpClient) { }

  private getHeaders(): HttpHeaders {
    const token = localStorage.getItem('access_token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return headers;
  }

  createDocument(request: DocumentRequest): Observable<DocumentResponse> {
    const headers = this.getHeaders();
    return this.http.post<DocumentResponse>(this.baseUrl, request, { headers });
  }

  getDocument(id: number): Observable<DocumentResponse> {
    const headers = this.getHeaders();
    return this.http.get<DocumentResponse>(`${this.baseUrl}/${id}`, { headers });
  }

  getAllDocuments(page: number, size: number): Observable<Page<DocumentResponse>> {
    const headers = this.getHeaders();
    const params = { page: page.toString(), size: size.toString() };
    return this.http.get<Page<DocumentResponse>>(this.baseUrl, { headers, params });
  }

  updateDocument(id: number, request: DocumentRequest): Observable<DocumentResponse> {
    const headers = this.getHeaders();
    return this.http.put<DocumentResponse>(`${this.baseUrl}/${id}`, request, { headers });
  }

  deleteDocument(id: number): Observable<void> {
    const headers = this.getHeaders();
    return this.http.delete<void>(`${this.baseUrl}/${id}`, { headers });
  }

  getDocumentsByContactId(contactId: number, page: number, size: number): Observable<Page<DocumentResponse>> {
    const headers = this.getHeaders();
    const params = { contactId: contactId.toString(), page: page.toString(), size: size.toString() };
    return this.http.get<Page<DocumentResponse>>(`${this.baseUrl}/byContact`, { headers, params });
  }

  countDocumentsByType(type: string): Observable<number> {
    const headers = this.getHeaders();
    const params = { type };
    return this.http.get<number>(`${this.baseUrl}/countByType`, { headers, params });
  }

  getAverageFileSize(): Observable<number> {
    const headers = this.getHeaders();
    return this.http.get<number>(`${this.baseUrl}/averageFileSize`, { headers });
  }

  getDocumentsByFileType(fileType: string, page: number, size: number): Observable<Page<DocumentResponse>> {
    const headers = this.getHeaders();
    const params = { fileType, page: page.toString(), size: size.toString() };
    return this.http.get<Page<DocumentResponse>>(`${this.baseUrl}/byFileType`, { headers, params });
  }
}
