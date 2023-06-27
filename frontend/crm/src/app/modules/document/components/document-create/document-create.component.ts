import { Component } from '@angular/core';
import { DocumentRequest } from 'src/app/shared/models/document-request';
import { DocumentService } from '../../document.service';

@Component({
  selector: 'app-document-create',
  templateUrl: './document-create.component.html',
  styleUrls: ['./document-create.component.scss']
})
export class DocumentCreateComponent {
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

  constructor(private documentService: DocumentService) { }

  onSubmit() {
    this.documentService.createDocument(this.document)
      .subscribe(response => {
        // Handle successful creation (e.g., show success message, navigate to details page)
      });
  }
}
