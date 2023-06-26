import { RouterModule, Routes } from "@angular/router";
import { ProductCreateComponent } from "./components/product-create/product-create.component";
import { ProductListComponent } from "./components/product-list/product-list.component";
import { NgModule } from "@angular/core";

const routes: Routes = [
    { path: 'products', component: ProductListComponent },
    { path: 'products/create', component: ProductCreateComponent },
  ];
  @NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class ProductRoutingModule { }
  