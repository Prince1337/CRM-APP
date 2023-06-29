import { NgModule } from "@angular/core";
import { InvoiceService } from "./invoice.service";
import { InvoiceListComponent } from './components/invoice-list/invoice-list.component';
import { InvoiceCreateComponent } from './components/invoice-create/invoice-create.component';
import { InvoiceDetailsComponent } from './components/invoice-details/invoice-details.component';
import { InvoiceEditComponent } from './components/invoice-edit/invoice-edit.component';
import { InvoiceReportsComponent } from './components/invoice-reports/invoice-reports.component';
import { InvoiceSearchComponent } from './components/invoice-search/invoice-search.component';
import { CommonModule } from "@angular/common";
import { HttpClientModule } from "@angular/common/http";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MatPaginatorModule } from "@angular/material/paginator";
import { RouterModule } from "@angular/router";

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        HttpClientModule,
        MatPaginatorModule,
        RouterModule,
        ReactiveFormsModule
    ],
    exports: [],
    declarations: [
        InvoiceListComponent,
        InvoiceCreateComponent,
        InvoiceDetailsComponent,
        InvoiceEditComponent,
        InvoiceReportsComponent,
        InvoiceSearchComponent
    ],
    providers: [InvoiceService],
})
export class InvoiceModule { }