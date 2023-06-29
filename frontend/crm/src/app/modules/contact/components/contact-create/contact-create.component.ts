import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ContactService } from '../../contact.service';
import { ContactRequest } from 'src/app/shared/models/contact-request';
import { ContactResponse } from 'src/app/shared/models/contact-response';

@Component({
  selector: 'app-contact-create',
  templateUrl: './contact-create.component.html',
  styleUrls: ['./contact-create.component.scss']
})
export class ContactCreateComponent {
  contactForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private contactService: ContactService,
    private router: Router
  ) {
    this.contactForm = this.formBuilder.group({
      vorname: ['', Validators.required],
      name: ['', Validators.required],
      firma: [''],
      email: ['', [Validators.required, Validators.email]],
      strasse: ['', Validators.required],
      plz: ['', Validators.required],
      stadt: ['', Validators.required],
      branche: [''],
      anrede: ['', Validators.required],
      position: [''],
      webseite: [''],
      telefon: [''],
      mobil: [''],
      geburtsdatum: [''],
      bic: [''],
      iban: ['', Validators.required],
      kategorie: [''],
      notizen: ['']
    });
  }

  onSubmit() {
    if (this.contactForm.invalid) {
      return;
    }

    const contactRequest: ContactRequest = this.contactForm.value;
    this.contactService.createContact(contactRequest)
      .subscribe(response => {
        // Handle successful creation (e.g., show success message, navigate to details page)
        console.log('Contact created:', response);
        this.router.navigate(['/contacts']);
      });
  }
}