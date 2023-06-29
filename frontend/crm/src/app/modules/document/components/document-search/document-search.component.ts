import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { DocumentResponse } from 'src/app/shared/models/document-response';
import { Page } from 'src/app/shared/models/page';
import { DocumentService } from '../../document.service';

@Component({
  selector: 'app-document-search',
  templateUrl: './document-search.component.html',
  styleUrls: ['./document-search.component.scss']
})
export class DocumentSearchComponent implements OnInit {
  contactId!: number;
  fileType!: string;
  page = 0;
  pageSize = 10;
  documents!: DocumentResponse[];

  constructor(private documentService: DocumentService) { }

  ngOnInit(): void {
  }

  searchDocuments(): void {
    if (this.contactId) {
      this.documentService.getDocumentsByContactId(this.contactId, this.page, this.pageSize).subscribe
      ((page: Page<DocumentResponse>) => {
        console.log(page.content);
        this.documents = page.content;
      });
    } else if (this.fileType) {
      this.documentService.getDocumentsByFileType(this.fileType, this.page, this.pageSize).subscribe
      ((page: Page<DocumentResponse>) => {
        console.log(page.content);
        this.documents = page.content;
      });
    } else {
      // Handle invalid search criteria
      alert('Invalid search criteria');
    }
  }

  onPageChange(page: number): void {
    this.page = page;
    this.searchDocuments();
  }
}