import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private baseUrl = 'http://localhost:8080/tasks';

  constructor(private http: HttpClient) { }

  createTask(request: any): Observable<any> {
    const headers = this.getHeaders();
    return this.http.post<any>(`${this.baseUrl}`, request, { headers });
  }

  getTask(id: number): Observable<any> {
    const headers = this.getHeaders();
    return this.http.get<any>(`${this.baseUrl}/${id}`, { headers });
  }

  getAllTasks(pageable: any): Observable<any> {
    const headers = this.getHeaders();
    return this.http.get<any>(`${this.baseUrl}`, { headers, params: pageable });
  }

  updateTask(id: number, request: any): Observable<any> {
    const headers = this.getHeaders();
    return this.http.put<any>(`${this.baseUrl}/${id}`, request, { headers });
  }

  deleteTask(id: number): Observable<any> {
    const headers = this.getHeaders();
    return this.http.delete<any>(`${this.baseUrl}/${id}`, { headers });
  }

  getTasksByContactId(contactId: number, pageable: any): Observable<any> {
    const headers = this.getHeaders();
    return this.http.get<any>(`${this.baseUrl}/byContact`, { headers, params: { contactId, ...pageable } });
  }

  countTasksByArt(art: string): Observable<any> {
    const headers = this.getHeaders();
    return this.http.get<any>(`${this.baseUrl}/countByArt`, { headers, params: { art } });
  }

  getTasksByDescription(description: string, pageable: any): Observable<any> {
    const headers = this.getHeaders();
    return this.http.get<any>(`${this.baseUrl}/byDescription`, { headers, params: { description, ...pageable } });
  }

  private getHeaders(): HttpHeaders {
    const token = localStorage.getItem('access_token'); // Get the access token from localStorage
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    });
  }
}
