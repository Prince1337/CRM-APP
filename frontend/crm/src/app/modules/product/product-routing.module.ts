import { RouterModule, Routes } from "@angular/router";
import { ProductCreateComponent } from "./components/product-create/product-create.component";
import { ProductListComponent } from "./components/product-list/product-list.component";
import { NgModule } from "@angular/core";
import { ProductDetailsComponent } from "./components/product-details/product-details.component";
import { ProductEditComponent } from "./components/product-edit/product-edit.component";
import { ProductReportsComponent } from "./components/product-reports/product-reports.component";
import { ProductSearchComponent } from "./components/product-search/product-search.component";

const routes: Routes = [
    { path: 'products', component: ProductListComponent },
    { path: 'products/create', component: ProductCreateComponent },
    { path: 'products/reports', component: ProductReportsComponent },
    { path: 'products/edit/:id', component: ProductEditComponent },
    { path: 'products/search', component: ProductSearchComponent },
    { path: 'products/:id', component: ProductDetailsComponent },

  ];
  @NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class ProductRoutingModule { }
  