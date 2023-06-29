import { Component, OnInit } from '@angular/core';
import { ContactService } from '../../contact.service';
import { ContactResponse } from 'src/app/shared/models/contact-response';
import { Page } from 'src/app/shared/models/page';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contact-list',
  templateUrl: './contact-list.component.html',
  styleUrls: ['./contact-list.component.scss']
})
export class ContactListComponent implements OnInit {
  contactsPage!: Page<ContactResponse>;

  constructor(private contactService: ContactService, private router: Router) { }

  ngOnInit(): void {
    this.getAllContacts();
  }

  getAllContacts(): void {
    const pageable = { page: 0, size: 10 }; // Customize the pagination parameters as needed
    this.contactService.getAllContacts(pageable)
      .subscribe((page: Page<ContactResponse>) => {
        this.contactsPage = page;
      });
  }

  onPageChange(page: number): void {
    const pageable = { page, size: 10 }; // Customize the pagination parameters as needed
    this.contactService.getAllContacts(pageable)
      .subscribe((page: Page<ContactResponse>) => {
        this.contactsPage = page;
      });
  }

  goToContactCreate(): void {
    this.router.navigate(['/contacts/create']);
  }

  goToReports(): void {
    this.router.navigate(['contacts/reports']);
  }

  goToSearch(): void {
    this.router.navigate(['contacts/search']);
  }
}