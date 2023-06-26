import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Page } from 'src/app/shared/models/page';
import { ProductResponse } from 'src/app/shared/models/product-response';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-product-search',
  templateUrl: './product-search.component.html',
  styleUrls: ['./product-search.component.scss']
})
export class ProductSearchComponent implements OnInit {
  searchParams: {
    bezeichnung?: string,
    gruppe?: string,
    status?: string,
    notizen?: string
  } = {};
  
  products$: Observable<Page<ProductResponse>> | undefined;

  constructor(private productService: ProductService) { }

  ngOnInit() { }

  searchProducts() {
    const pageable = { page: 0, size: 10 }; // Example: Use your desired page size and initial page number
    this.products$ = this.productService.searchProducts(
      this.searchParams.bezeichnung,
      this.searchParams.gruppe,
      this.searchParams.status,
      this.searchParams.notizen,
      pageable
    );
  }

  goToPage(page: number) {
    const pageable = { page, size: 10 }; // Example: Use your desired page size
    this.products$ = this.productService.searchProducts(
      this.searchParams.bezeichnung,
      this.searchParams.gruppe,
      this.searchParams.status,
      this.searchParams.notizen,
      pageable
    );
  }
}