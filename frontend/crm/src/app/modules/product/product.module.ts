import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductCreateComponent } from './components/product-create/product-create.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { ProductEditComponent } from './components/product-edit/product-edit.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ProductService } from './services/product.service';



@NgModule({
  declarations: [
    ProductListComponent,
    ProductCreateComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    ProductService
  ],
})
export class ProductModule { }
