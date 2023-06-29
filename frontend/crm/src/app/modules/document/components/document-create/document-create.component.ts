import { Component, OnInit } from '@angular/core';
import { DocumentRequest } from 'src/app/shared/models/document-request';
import { DocumentService } from '../../document.service';
import { ContactService } from 'src/app/modules/contact/contact.service';
import { Observable } from 'rxjs';
import { ContactResponse } from 'src/app/shared/models/contact-response';
import { Page } from 'src/app/shared/models/page';
import { Router } from '@angular/router';

@Component({
  selector: 'app-document-create',
  templateUrl: './document-create.component.html',
  styleUrls: ['./document-create.component.scss']
})
export class DocumentCreateComponent implements OnInit {
  document: DocumentRequest = {
    art: '',
    kontaktId: 0,
    speicherdatum: new Date(),
    dateityp: '',
    dateigroesse: 0,
    pfad: '',
    notizen: '',
    erstelltDatum: new Date(),
    geaendertDatum: new Date()
  };
  contacts!: ContactResponse[];

  constructor(
    private documentService: DocumentService,
    private contactService: ContactService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadContacts();
  }

  loadContacts(): void {
    const pageable = { page: 0, size: 10 };
    this.contactService.getAllContacts(pageable).subscribe((page: Page<ContactResponse>) => {
      this.contacts = page.content;
    });
  }

  onSubmit(): void {
    this.documentService.createDocument(this.document)
      .subscribe(response => {
        alert('Document created successfully');
        this.router.navigate(['/documents']);
        // Handle successful creation (e.g., show success message, navigate to details page)
      });
  }
}