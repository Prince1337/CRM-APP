import { CommonModule } from "@angular/common";
import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MatPaginatorModule } from "@angular/material/paginator";
import { RouterModule } from "@angular/router";
import { ContactCreateComponent } from "./components/contact-create/contact-create.component";
import { ContactService } from "./contact.service";
import { ContactListComponent } from './components/contact-list/contact-list.component';
import { ContactDetailsComponent } from './components/contact-details/contact-details.component';
import { ContactReportsComponent } from './components/contact-reports/contact-reports.component';
import { ContactEditComponent } from "./components/contact-edit/contact-edit.component";
import { ContactSearchComponent } from './components/contact-search/contact-search.component';

@NgModule({
    declarations: [
      ContactCreateComponent,
      ContactListComponent,
      ContactDetailsComponent,
      ContactEditComponent,
      ContactReportsComponent,
      ContactSearchComponent
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
      ContactService
    ],
  })
  export class ContactModule { }