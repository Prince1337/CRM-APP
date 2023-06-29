import { Component } from '@angular/core';
import { ProductRequest } from 'src/app/shared/models/product-request';
import { ProductService } from '../../services/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.scss']
})
export class ProductCreateComponent {
  product: ProductRequest = {
    bezeichnung: '',
    nettopreis: 0,
    umst: 0,
    gruppe: ''
  };

  constructor(private productService: ProductService, private router: Router) {}

  createProduct() {
    this.productService.createProduct(this.product).subscribe(
      response => {
        alert('Product created successfully');
        this.router.navigate(['/products']);
        // Füge hier die Logik hinzu, um die Benutzer über das erfolgreiche Erstellen des Produkts zu informieren
      },
      error => {
        console.error('Failed to create product', error.message);
        // Füge hier die Fehlerbehandlungslogik hinzu, um den Benutzer über einen Fehler beim Erstellen des Produkts zu informieren
      }
    );
  }
}
