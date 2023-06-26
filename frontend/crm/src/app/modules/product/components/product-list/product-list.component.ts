import { Component, OnInit } from '@angular/core';
import { ProductResponse } from 'src/app/shared/models/product-response';
import { ProductService } from '../../services/product.service';
import { PageEvent } from '@angular/material/paginator';


@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {
  products: ProductResponse[] = [];
  currentPage: number = 0;
  totalPages!: number;
  pageSize!: number;
  totalElements!: number;

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.getAllProducts();
  }

  getAllProducts(page: number = 0, size: number = 10): void {
    this.productService.getAllProducts(page, size).subscribe(
      response => {
        this.products = response.content;
        this.currentPage = response.number;
        this.totalPages = response.totalPages;
        this.pageSize = response.size;
        this.totalElements = response.totalElements;
      },
      error => {
        console.log('Error retrieving products:', error);
      }
    );
  }

  onPageChange(event: PageEvent): void {
    const page = event.pageIndex;
    const size = event.pageSize;
    this.getAllProducts(page, size);
  }
}