import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DocumentResponse } from 'src/app/shared/models/document-response';
import { DocumentService } from '../../document.service';

@Component({
  selector: 'app-document-details',
  templateUrl: './document-details.component.html',
  styleUrls: ['./document-details.component.scss']
})
export class DocumentDetailsComponent implements OnInit {
  document!: DocumentResponse;

  constructor(
    private documentService: DocumentService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    const id = this.route.snapshot.params['id'];
    this.getDocument(id);
  }

  getDocument(id: number) {
    this.documentService.getDocument(id)
      .subscribe(document => {
        this.document = document;
      });
  }

  goToEdit(){
    this.router.navigate(['/documents/edit', this.document.id]);
  }
}
