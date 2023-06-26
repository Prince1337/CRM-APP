import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductRequest } from 'src/app/shared/models/product-request';
import { ProductResponse } from 'src/app/shared/models/product-response';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.scss']
})
export class ProductEditComponent implements OnInit {
  productForm!: FormGroup;
  productId!: number;

  constructor(
    private formBuilder: FormBuilder,
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.productForm = this.formBuilder.group({
      bezeichnung: ['', Validators.required],
      nettopreis: ['', Validators.required],
      umst: ['', Validators.required],
      gruppe: ['', Validators.required],
      status: [''],
      notizen: ['']
    });

    this.route.params.subscribe(params => {
      this.productId = params['id'];
      this.getProductDetails(this.productId);
    });
  }

  getProductDetails(productId: number) {
    this.productService.getProduct(productId).subscribe(
      (response: ProductResponse) => {
        this.productForm.patchValue(response);
      },
      error => {
        console.log('Error retrieving product details:', error);
      }
    );
  }

  onSubmit() {
    if (this.productForm.valid) {
      const productRequest: ProductRequest = this.productForm.value;
      this.productService.updateProduct(this.productId, productRequest).subscribe(
        (response: ProductResponse) => {
          console.log('Product updated successfully:', response);
          // Redirect to product details page
          this.router.navigate(['/products', this.productId]);
        },
        error => {
          console.log('Error updating product:', error);
        }
      );
    }
  }
}