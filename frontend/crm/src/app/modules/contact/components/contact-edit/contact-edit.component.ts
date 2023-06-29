import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ContactRequest } from 'src/app/shared/models/contact-request';
import { ContactResponse } from 'src/app/shared/models/contact-response';
import { ContactService } from '../../contact.service';

@Component({
  selector: 'app-contact-edit',
  templateUrl: './contact-edit.component.html',
  styleUrls: ['./contact-edit.component.scss']
})
export class ContactEditComponent implements OnInit {
  contactForm!: FormGroup;
  contactId!: number;
  contact!: ContactResponse;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private contactService: ContactService
  ) { }

  ngOnInit(): void {
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

    this.route.params.subscribe(params => {
      this.contactId = params['id'];
      this.loadContact();
    });
  }

  loadContact(): void {
    this.contactService.getContactById(this.contactId).subscribe(
      response => {
        this.contact = response;
        this.contactForm.patchValue(this.contact);
      },
      error => {
        // Handle error
      }
    );
  }

  onSubmit(): void {
    if (this.contactForm.invalid) {
      return;
    }

    const request: ContactRequest = this.contactForm.value;

    this.contactService.updateContact(this.contactId, request).subscribe(
      response => {
        // Handle success (e.g., show success message)
        this.router.navigate(['/contacts']);
      },
      error => {
        // Handle error
      }
    );
  }
}