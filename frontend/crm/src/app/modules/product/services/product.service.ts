import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { ProductRequest } from 'src/app/shared/models/product-request';
import { ProductResponse } from 'src/app/shared/models/product-response';
import { Page } from 'src/app/shared/models/page';

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

  getAllProducts(page: number, size: number): Observable<Page<ProductResponse>> {
    const headers = this.createHeadersWithJwtToken();
    const params = new HttpParams()
      .set('page', String(page))
      .set('size', String(size));
    return this.http.get<Page<ProductResponse>>(this.apiUrl, { headers, params });
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