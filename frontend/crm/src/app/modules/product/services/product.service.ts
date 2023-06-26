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

  getTotalProductCount(): Observable<number> {
    const headers = this.createHeadersWithJwtToken();
    return this.http.get<number>(`${this.apiUrl}/total-count`, { headers });
  }

  getAverageNetPrice(): Observable<number> {
    const headers = this.createHeadersWithJwtToken();
    return this.http.get<number>(`${this.apiUrl}/average-net-price`, { headers });
  }

  getProductCountByGroup(): Observable<Map<string, number>> {
    const headers = this.createHeadersWithJwtToken();
    return this.http.get<Map<string, number>>(`${this.apiUrl}/count-by-group`, { headers });
  }

  getProductCountByStatus(status: string): Observable<number> {
    const headers = this.createHeadersWithJwtToken();
    return this.http.get<number>(`${this.apiUrl}/count-by-status?status=${status}`, { headers });
  }

  getAverageTaxRate(): Observable<number> {
    const headers = this.createHeadersWithJwtToken();
    return this.http.get<number>(`${this.apiUrl}/average-tax-rate`, { headers });
  }

  searchProducts(
    bezeichnung?: string,
    gruppe?: string,
    status?: string,
    notizen?: string,
    pageable?: { page: number; size: number }
  ): Observable<Page<ProductResponse>> {
    const headers = this.createHeadersWithJwtToken();
    let params = new HttpParams();
    
    if (bezeichnung) {
      params = params.set('bezeichnung', bezeichnung);
    }
    if (gruppe) {
      params = params.set('gruppe', gruppe);
    }
    if (status) {
      params = params.set('status', status);
    }
    if (notizen) {
      params = params.set('notizen', notizen);
    }
    if (pageable) {
      params = params.set('page', pageable.page.toString());
      params = params.set('size', pageable.size.toString());
    }

    return this.http.get<Page<ProductResponse>>(`${this.apiUrl}/search`, { headers, params });
  }

  private createHeadersWithJwtToken(): HttpHeaders {
    const token = localStorage.getItem('access_token'); // Replace with your actual JWT token
    return new HttpHeaders().set('Authorization', `Bearer ${token}`);
  }
}