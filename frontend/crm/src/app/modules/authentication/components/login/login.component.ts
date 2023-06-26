import { Component } from '@angular/core';
import { AuthService } from 'src/app/core/auth/auth.service';
import { AuthenticationRequest } from 'src/app/shared/models/authentication-request';
import { AuthenticationResponse } from 'src/app/shared/models/authentication-response';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  username!: string;
  password!: string;

  constructor(private authService: AuthService) { }

  login() {
    const request: AuthenticationRequest = {
      username: this.username,
      password: this.password
    };

    this.authService.authenticate(request).subscribe(
      (response: AuthenticationResponse) => {
        // Handle successful login
        localStorage.setItem('access_token', response.access_token);
        localStorage.setItem('refresh_token', response.refresh_token);
        console.log('Logged in', response);
      },
      (error) => {
        // Handle login error
        console.error('Login failed', error.message);
      }
    );
  }

  logout() {
    this.authService.logout();
  }
}
