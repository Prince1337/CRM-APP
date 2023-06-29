import { Component, OnInit } from '@angular/core';
import { DocumentResponse } from 'src/app/shared/models/document-response';
import { Page } from 'src/app/shared/models/page';
import { DocumentService } from '../../document.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-document-list',
  templateUrl: './document-list.component.html',
  styleUrls: ['./document-list.component.scss']
})
export class DocumentListComponent implements OnInit {
  documents: DocumentResponse[] = [];

  constructor(private documentService: DocumentService, private router: Router) { }

  ngOnInit(): void {
    this.loadDocuments();
  }

  loadDocuments(): void {
    const page = 0; // Current page number
    const size = 10; // Number of documents per page

    this.documentService.getAllDocuments(page, size)
      .subscribe((page: Page<DocumentResponse>) => {
        this.documents = page.content;
      });
  }

  goToDocumentCreate(): void {
    this.router.navigate(['/documents/create']);
  }

  goToReports(): void {
    this.router.navigate(['/documents/reports']);
  }

  goToSearch(): void {
    this.router.navigate(['/documents/search']);
  }
}
