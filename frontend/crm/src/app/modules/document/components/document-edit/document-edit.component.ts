import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DocumentRequest } from 'src/app/shared/models/document-request';
import { DocumentResponse } from 'src/app/shared/models/document-response';
import { DocumentService } from '../../document.service';

@Component({
  selector: 'app-document-edit',
  templateUrl: './document-edit.component.html',
  styleUrls: ['./document-edit.component.scss']
})
export class DocumentEditComponent implements OnInit {
  document!: DocumentResponse;

  constructor(
    private documentService: DocumentService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    const id = +this.route.snapshot.params['id'];
    this.getDocument(id);
  }

  getDocument(id: number) {
    this.documentService.getDocument(id)
      .subscribe(document => {
        console.log(document);
        this.document = document;
      });
  }

  onSubmit() {
    const request: DocumentRequest = {
      art: this.document.art,
      kontaktId: this.document.kontaktId,
      speicherdatum: this.document.speicherdatum,
      dateityp: this.document.dateityp,
      dateigroesse: this.document.dateigroesse,
      pfad: this.document.pfad,
      notizen: this.document.notizen,
      erstelltDatum: this.document.erstelltDatum,
      geaendertDatum: this.document.geaendertDatum
    };

    this.documentService.updateDocument(this.document.id, request)
      .subscribe(response => {
        alert('Document updated successfully');
        this.router.navigate(['/documents']);
        // Handle successful update (e.g., show success message, navigate to details page)
      });
  }
}
