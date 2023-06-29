import { Component, OnInit } from '@angular/core';
import { ContactService } from '../../contact.service';

@Component({
  selector: 'app-contact-reports',
  templateUrl: './contact-reports.component.html',
  styleUrls: ['./contact-reports.component.scss']
})
export class ContactReportsComponent implements OnInit {
  companyCount: number = 0;
  emailCount: number = 0;

  constructor(private contactService: ContactService) { }

  ngOnInit() {
    this.getContactsCountByCompany('exampleCompany');
    this.getContactsCountByEmailContaining('exampleEmail');
  }

  getContactsCountByCompany(company: string) {
    this.contactService.countContactsByCompany(company)
      .subscribe(count => {
        this.companyCount = count;
      });
  }

  getContactsCountByEmailContaining(email: string) {
    this.contactService.countContactsByEmailContaining(email)
      .subscribe(count => {
        this.emailCount = count;
      });
  }
}
