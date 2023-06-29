import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { DocumentListComponent } from "./components/document-list/document-list.component";
import { DocumentCreateComponent } from "./components/document-create/document-create.component";
import { DocumentDetailsComponent } from "./components/document-details/document-details.component";
import { DocumentEditComponent } from "./components/document-edit/document-edit.component";
import { DocumentSearchComponent } from "./components/document-search/document-search.component";

const routes: Routes = [
    { path: "documents", component: DocumentListComponent},
    { path: "documents/create", component: DocumentCreateComponent},
    { path: "documents/details/:id", component: DocumentDetailsComponent},
    { path: "documents/edit/:id", component: DocumentEditComponent},
    { path: "documents/search", component: DocumentSearchComponent}

];
  @NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class DocumentRoutingModule { }
  