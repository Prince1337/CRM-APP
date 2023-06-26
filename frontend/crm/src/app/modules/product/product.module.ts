import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductCreateComponent } from './components/product-create/product-create.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { ProductEditComponent } from './components/product-edit/product-edit.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ProductService } from './services/product.service';
import { MatPaginatorModule } from '@angular/material/paginator';
import { RouterModule } from '@angular/router';
import { ProductReportsComponent } from './components/product-reports/product-reports.component';
import { ProductSearchComponent } from './components/product-search/product-search.component';

@NgModule({
  declarations: [
    ProductListComponent,
    ProductCreateComponent,
    ProductDetailsComponent,
    ProductEditComponent,
    ProductReportsComponent,
    ProductSearchComponent
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
    ProductService
  ],
})
export class ProductModule { }
