import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { InvoiceResponse } from 'src/app/shared/models/invoice-response';
import { InvoiceService } from '../../invoice.service';

@Component({
  selector: 'app-invoice-details',
  templateUrl: './invoice-details.component.html',
  styleUrls: ['./invoice-details.component.scss']
})
export class InvoiceDetailsComponent implements OnInit {
  invoice!: InvoiceResponse;

  constructor(
    private route: ActivatedRoute,
    private invoiceService: InvoiceService,
    private router: Router
  ) { }

  ngOnInit(): void {
    const invoiceId = this.route.snapshot.params['id'];
    this.getInvoiceDetails(invoiceId);
  }

  getInvoiceDetails(invoiceId: number): void {
    this.invoiceService.getInvoice(invoiceId)
      .subscribe(
        (invoiceResponse: InvoiceResponse) => {
          this.invoice = invoiceResponse;
        },
        error => {
          console.log('Error retrieving invoice details:', error);
          // Fehlerbehandlung
        }
      );
  }

  goToEdit(): void {
    this.router.navigate(['invoices/edit', this.invoice?.rechnungsnummer]);
  }

  deleteInvoice(): void {
    if (this.invoice?.rechnungsnummer) {
      this.invoiceService.deleteInvoice(this.invoice?.rechnungsnummer)
        .subscribe(
          () => {
            this.router.navigate(['/invoices']);
          },
          error => {
            console.log('Error deleting invoice:', error);
            // Fehlerbehandlung
          }
        );
    }
  }
}