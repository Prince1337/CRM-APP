import { Component, OnInit } from '@angular/core';
import { ProductResponse } from 'src/app/shared/models/product-response';
import { ProductService } from '../../services/product.service';
import { RouterModule } from '@angular/router';


@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {
  products!: ProductResponse[];

  constructor(private productService: ProductService, private router: RouterModule) {}

  ngOnInit(): void {
    this.getAllProducts();
  }

  getAllProducts(): void {
    this.productService.getAllProducts().subscribe(
      (response: ProductResponse[]) => {
        this.products = response;
      },
      (error) => {
        console.error('Failed to get products:', error.message);
      }
    );
  }
}
