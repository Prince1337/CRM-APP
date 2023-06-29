import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ContactResponse } from 'src/app/shared/models/contact-response';
import { Page } from 'src/app/shared/models/page';
import { ContactService } from '../../contact.service';

@Component({
  selector: 'app-contact-search',
  templateUrl: './contact-search.component.html',
  styleUrls: ['./contact-search.component.scss']
})
export class ContactSearchComponent implements OnInit {
  searchForm!: FormGroup;
  contactsPage!: Page<ContactResponse>;

  constructor(private formBuilder: FormBuilder, private contactService: ContactService) { }

  ngOnInit() {
    this.searchForm = this.formBuilder.group({
      searchTerm: [''],
      industry: ['']
    });
  }

  onSubmit() {
    const searchTerm = this.searchForm.get('searchTerm')?.value;
    const industry = this.searchForm.get('industry')?.value;
    const pageable = { page: 0, size: 10 }; // Change the values according to your needs

    if (industry) {
      this.contactService.getContactsByIndustry(industry, pageable)
        .subscribe(page => {
          this.contactsPage = page;
        });
    } else {
      this.contactService.searchContacts(searchTerm, pageable)
        .subscribe(page => {
          this.contactsPage = page;
        });
    }
  }
}
