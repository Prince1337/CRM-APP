import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { ProductRequest } from 'src/app/shared/models/product-request';
import { ProductResponse } from 'src/app/shared/models/product-response';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private apiUrl = 'http://localhost:8080/products'; // Aktualisiere die URL entsprechend deiner Spring Boot-Anwendung

  constructor(private http: HttpClient) {}

  createProduct(request: ProductRequest): Observable<ProductResponse> {
    const headers = this.createHeadersWithJwtToken(); // Erstelle die Header mit JWT-Token
    return this.http.post<ProductResponse>(this.apiUrl, request, { headers });
  }

  getProduct(id: number): Observable<ProductResponse> {
    const headers = this.createHeadersWithJwtToken();
    return this.http.get<ProductResponse>(`${this.apiUrl}/${id}`, { headers });
  }

  getAllProducts(): Observable<ProductResponse[]> {
    const headers = this.createHeadersWithJwtToken();
    return this.http.get<GetResponseProducts>(this.apiUrl, { headers }).pipe(
      map(response => response.content)
    );;
  }

  updateProduct(id: number, request: ProductRequest): Observable<ProductResponse> {
    const headers = this.createHeadersWithJwtToken();
    return this.http.put<ProductResponse>(`${this.apiUrl}/${id}`, request, { headers });
  }

  deleteProduct(id: number): Observable<void> {
    const headers = this.createHeadersWithJwtToken();
    return this.http.delete<void>(`${this.apiUrl}/${id}`, { headers });
  }

  private createHeadersWithJwtToken(): HttpHeaders {
    const token = localStorage.getItem('access_token'); // Hole den JWT-Token aus dem Local Storage (angepasst an deine Implementierung)
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return headers;
  }
}

interface GetResponseProducts {
	content: ProductResponse[];
}