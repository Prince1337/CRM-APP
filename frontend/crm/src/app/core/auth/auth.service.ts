import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RegisterRequest } from 'src/app/shared/models/register-request';
import { AuthenticationRequest } from 'src/app/shared/models/authentication-request';
import { AuthenticationResponse } from 'src/app/shared/models/authentication-response';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private authUrl = 'http://localhost:8080/auth';

  private isLoggedInVar: boolean = false;

  constructor(private http: HttpClient) { }

  register(request: RegisterRequest): Observable<AuthenticationResponse> {
    return this.http.post<AuthenticationResponse>(`${this.authUrl}/register`, request);
  }

  authenticate(request: AuthenticationRequest): Observable<AuthenticationResponse> {
    this.isLoggedInVar = true;
    return this.http.post<AuthenticationResponse>(`${this.authUrl}/authenticate`, request);
  }

  logout(): void {
    this.http.post(`${this.authUrl}/logout`, {}).subscribe(() => {
      localStorage.removeItem('access_token');
      this.isLoggedInVar = false;
      console.log('Logout erfolgreich');
    }, (error) => {
      console.error('Logout fehlgeschlagen', error.message);
    });
  }

  updateUser(id: number, request: RegisterRequest): Observable<any> {
    return this.http.put<any>(`${this.authUrl}/user/${id}`, request);
  }

  refreshToken(): Observable<any> {
    return this.http.post<any>(`${this.authUrl}/refresh-token`, {});
  }

  public isLoggedIn(): boolean {
    return this.isLoggedInVar;
  }
}
