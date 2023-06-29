import { CommonModule } from "@angular/common";
import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MatPaginatorModule } from "@angular/material/paginator";
import { RouterModule } from "@angular/router";
import { DocumentListComponent } from "./components/document-list/document-list.component";
import { DocumentService } from "./document.service";
import { DocumentDetailsComponent } from './components/document-details/document-details.component';
import { DocumentEditComponent } from './components/document-edit/document-edit.component';
import { DocumentCreateComponent } from './components/document-create/document-create.component';
import { DocumentSearchComponent } from './components/document-search/document-search.component';


@NgModule({
  declarations: [
    DocumentListComponent,
    DocumentDetailsComponent,
    DocumentEditComponent,
    DocumentCreateComponent,
    DocumentSearchComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    MatPaginatorModule,
    RouterModule,
    ReactiveFormsModule
  ],
  providers: [
    DocumentService
  ],
})
export class DocumentModule { }
