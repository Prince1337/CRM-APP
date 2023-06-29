import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { InvoiceRequest } from 'src/app/shared/models/invoice-request';
import { InvoiceResponse } from 'src/app/shared/models/invoice-response';
import { InvoiceService } from '../../invoice.service';

@Component({
  selector: 'app-invoice-edit',
  templateUrl: './invoice-edit.component.html',
  styleUrls: ['./invoice-edit.component.scss']
})
export class InvoiceEditComponent implements OnInit {
  invoiceForm!: FormGroup;
  invoiceId!: number;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private invoiceService: InvoiceService
  ) { }

  ngOnInit(): void {
    this.invoiceId = +this.route.snapshot.paramMap.get('id')!; // Annahme: Die ID wird als Route-Parameter übergeben

    this.invoiceForm = this.formBuilder.group({
      kontaktId: ['', Validators.required],
      rechnungsdatum: ['', Validators.required],
      bruttobetrag: ['', Validators.min(0)],
      leistungsbezeichnung: ['', Validators.required],
      status: ['', Validators.required],
      zahlungsfrist: ['', Validators.required],
      produkte: this.formBuilder.array([])
    });

    this.loadInvoiceDetails();
  }

  loadInvoiceDetails(): void {
    this.invoiceService.getInvoice(this.invoiceId)
      .subscribe(
        (invoiceResponse: InvoiceResponse) => {
          this.invoiceForm.patchValue(invoiceResponse);
        },
        error => {
          console.log('Error retrieving invoice details:', error);
          // Fehlerbehandlung
        }
      );
  }

  onSubmit(): void {
    if (this.invoiceForm.valid) {
      const invoiceRequest: InvoiceRequest = this.invoiceForm.value;

      this.invoiceService.updateInvoice(this.invoiceId, invoiceRequest)
        .subscribe(
          (invoiceResponse: InvoiceResponse) => {
            console.log('Invoice updated successfully:', invoiceResponse);
            // Weiterleitung zur Invoice-Detailseite oder andere Aktionen
          },
          error => {
            console.log('Error updating invoice:', error);
            // Fehlerbehandlung
          }
        );
    }
  }
}