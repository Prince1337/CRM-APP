import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { ContactCreateComponent } from "./components/contact-create/contact-create.component";
import { ContactDetailsComponent } from "./components/contact-details/contact-details.component";
import { ContactEditComponent } from "./components/contact-edit/contact-edit.component";
import { ContactListComponent } from "./components/contact-list/contact-list.component";
import { ContactSearchComponent } from "./components/contact-search/contact-search.component";
import { ContactReportsComponent } from "./components/contact-reports/contact-reports.component";

const routes: Routes = [
    { path: 'contacts', component: ContactListComponent },
    { path: 'contacts/create', component: ContactCreateComponent },
    { path: 'contacts/details/:id', component: ContactDetailsComponent },
    { path: 'contacts/edit/:id', component: ContactEditComponent },
    { path: 'contacts/search', component: ContactSearchComponent },
    { path: 'contacts/reports', component: ContactReportsComponent}

  ];
  @NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class ContactRoutingModule { }
  