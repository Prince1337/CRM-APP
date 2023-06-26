import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from 'src/app/core/auth/auth.service';
import { AuthenticationResponse } from 'src/app/shared/models/authentication-response';
import { RegisterRequest } from 'src/app/shared/models/register-request';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  registerForm!: FormGroup;

  roles = ['ROLLE_BESITZER', 'ROLLE_ANGESTELLTER'];

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService
  ) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      username: ['', Validators.required],
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      roles: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.registerForm.invalid) {
      return;
    }

    const registerRequest: RegisterRequest = this.registerForm.value;
    if (!Array.isArray(registerRequest.roles)) {
      registerRequest.roles = [registerRequest.roles];
    }
    this.authService.register(registerRequest).subscribe(
      (response: AuthenticationResponse) => {
        // Handle success response
        console.log('Registration successful:', response);
      },
      (error) => {
        // Handle error response
        console.error('Registration failed:', error);
      }
    );
  }
}
