import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductResponse } from 'src/app/shared/models/product-response';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.scss']
})
export class ProductDetailsComponent implements OnInit {
  product!: ProductResponse;

  constructor(
    private route: ActivatedRoute,
    private productService: ProductService,
    private router: Router
  ) { }

  ngOnInit(): void {
    const productId = this.route.snapshot.params['id'];
    this.getProductDetails(productId);
  }

  getProductDetails(productId: number): void {
    this.productService.getProduct(productId)
      .subscribe(
        response => {
          this.product = response;
        },
        error => {
          console.log('Fehler beim Abrufen der Produktdetails:', error);
        }
      );
  }

  goToEdit() {
    this.router.navigate(['/products/edit', this.product.id]);
  }

  deleteProduct() {
    this.productService.deleteProduct(this.product.id)
      .subscribe(
        () => {
          this.router.navigate(['/products']);
          alert('Produkt erfolgreich gelöscht.');
        },
        error => {
          console.log('Fehler beim Löschen der Produktdetails:', error);
        }
      );
  }
}
