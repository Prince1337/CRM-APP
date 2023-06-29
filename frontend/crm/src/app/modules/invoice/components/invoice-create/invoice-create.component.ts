import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { InvoiceRequest } from 'src/app/shared/models/invoice-request';
import { InvoiceResponse } from 'src/app/shared/models/invoice-response';
import { InvoiceService } from '../../invoice.service';
import { Route, Router } from '@angular/router';
import { ContactService } from 'src/app/modules/contact/contact.service';
import { ContactResponse } from 'src/app/shared/models/contact-response';
import { Page } from 'src/app/shared/models/page';
import { ProductRequest } from 'src/app/shared/models/product-request';
import { ProductService } from 'src/app/modules/product/services/product.service';
import { ProductResponse } from 'src/app/shared/models/product-response';

@Component({
  selector: 'app-invoice-create',
  templateUrl: './invoice-create.component.html',
  styleUrls: ['./invoice-create.component.scss']
})
export class InvoiceCreateComponent implements OnInit {
  invoiceForm!: FormGroup;
  contacts!: ContactResponse[];
  availableProducts: ProductResponse[] = []; // Liste der verfügbaren Produkte
  selectedProducts: ProductResponse[] = []; // Liste der ausgewählten Produkte

  constructor(
    private formBuilder: FormBuilder,
    private invoiceService: InvoiceService,
    private contactService: ContactService,
    private router: Router,
    private productService: ProductService
  ) {}
  
  ngOnInit(): void {
    this.invoiceForm = this.formBuilder.group({
      kontaktId: ['', Validators.required],
      rechnungsdatum: ['', Validators.required],
      bruttobetrag: [''],
      leistungsbezeichnung: ['', Validators.required],
      status: ['', Validators.required],
      zahlungsfrist: ['', Validators.required]
    });

    this.loadContacts();
    this.loadAvailableProducts();
  }

  loadContacts(): void {
    const pageable = { page: 0, size: 10 };
    this.contactService.getAllContacts(pageable).subscribe((page: Page<ContactResponse>) => {
      this.contacts = page.content;
    });
  }

  loadAvailableProducts(): void {
    const page = 0;
    const size = 10;
    this.productService.getAllProducts(page, size).subscribe((page: Page<ProductResponse>) => {
      console.log(page.content);
      this.availableProducts = page.content;
    })
  }

  addProduct(productId: number): void {
    this.productService.getProduct(productId).subscribe((product: ProductResponse) => {
      const selectedProduct: ProductResponse = {
        // Setze die Eigenschaften des ausgewählten Produkts
        id: product.id,
        bezeichnung: product.bezeichnung,
        nettopreis: product.nettopreis,
        umst: product.umst,
        gruppe: product.gruppe,
        status: product.status,
        notizen: product.notizen
        // Weitere Eigenschaften des Produkts
      };
      this.selectedProducts.push(selectedProduct);
    });
  }

  removeProduct(index: number): void {
    // Entferne das Produkt aus selectedProducts anhand des Indexes
    this.selectedProducts.splice(index, 1);
  }

  createInvoice(): void {
    if (this.invoiceForm.invalid) {
      console.log('Form is invalid');
      console.log(this.invoiceForm.value);
      return;
    }

    const invoiceRequest: InvoiceRequest = {
      kontaktId: this.invoiceForm.value.kontaktId,
      rechnungsdatum: this.invoiceForm.value.rechnungsdatum,
      bruttobetrag: this.invoiceForm.value.bruttobetrag,
      leistungsbezeichnung: this.invoiceForm.value.leistungsbezeichnung,
      status: this.invoiceForm.value.status,
      zahlungsfrist: this.invoiceForm.value.zahlungsfrist,
      produkte: this.selectedProducts
    };
    console.log(invoiceRequest);

    this.invoiceService.createInvoice(invoiceRequest)
      .subscribe(
        (invoiceResponse: InvoiceResponse) => {
          console.log('Invoice created successfully:', invoiceResponse);
          // Weitere Aktionen nach erfolgreicher Erstellung der Rechnung
          this.router.navigate(['/invoices']);
        },
        error => {
          console.log('Error creating invoice:', error);
          // Fehlerbehandlung
        }
      );
  }
}