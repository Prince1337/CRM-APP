import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ContactResponse } from 'src/app/shared/models/contact-response';
import { ContactService } from '../../contact.service';

@Component({
  selector: 'app-contact-details',
  templateUrl: './contact-details.component.html',
  styleUrls: ['./contact-details.component.scss']
})
export class ContactDetailsComponent implements OnInit {
  contact!: ContactResponse;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private contactService: ContactService
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    this.getContact(id);
  }

  getContact(id: number): void {
    this.contactService.getContactById(id)
      .subscribe(contact => this.contact = contact);
  }

  deleteContact(): void {
    if (confirm('Are you sure you want to delete this contact?')) {
      this.contactService.deleteContact(this.contact.id)
        .subscribe(() => {
          // Handle successful deletion (e.g., show success message, navigate to contacts list)
        });
    }
  }

  editContact(): void {
    this.router.navigate(['/contacts/edit', this.contact.id]);
  }
}