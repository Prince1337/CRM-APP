import { NgModule } from "@angular/core"
import { Routes, RouterModule } from "@angular/router"
import { InvoiceCreateComponent } from "./components/invoice-create/invoice-create.component"
import { InvoiceDetailsComponent } from "./components/invoice-details/invoice-details.component"
import { InvoiceEditComponent } from "./components/invoice-edit/invoice-edit.component"
import { InvoiceListComponent } from "./components/invoice-list/invoice-list.component"
import { InvoiceReportsComponent } from "./components/invoice-reports/invoice-reports.component"
import { InvoiceSearchComponent } from "./components/invoice-search/invoice-search.component"

const routes: Routes = [
    { path: 'invoices', component: InvoiceListComponent },
    { path: 'invoices/create', component: InvoiceCreateComponent },
    { path: 'invoices/details/:id', component: InvoiceDetailsComponent },
    { path: 'invoices/edit/:id', component: InvoiceEditComponent },
    { path: 'invoices/reports', component: InvoiceReportsComponent },
    { path: 'invoices/search', component: InvoiceSearchComponent },
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class InvoiceRoutingModule { }