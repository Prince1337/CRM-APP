import { Component, OnInit } from '@angular/core';
import { InvoiceResponse } from 'src/app/shared/models/invoice-response';
import { InvoiceService } from '../../invoice.service';
import { Router } from '@angular/router';
import { Page } from 'src/app/shared/models/page';

@Component({
  selector: 'app-invoice-list',
  templateUrl: './invoice-list.component.html',
  styleUrls: ['./invoice-list.component.scss']
})
export class InvoiceListComponent implements OnInit {
  invoices: InvoiceResponse[] = [];
  currentPage = 0;
  pageSize = 10;
  totalElements = 0;
  totalPages = 0;

  constructor(private invoiceService: InvoiceService, private router: Router) { }

  ngOnInit(): void {
    this.loadInvoices();
  }

  loadInvoices(): void {
    this.invoiceService.getAllInvoices(this.currentPage, this.pageSize)
      .subscribe((page: Page<InvoiceResponse>) => {
        this.invoices = page.content;
        this.totalElements = page.totalElements;
      });
  }

  getPaginationArray(): number[] {
    const totalPages = Math.ceil(this.totalElements / this.pageSize);
    return Array.from({ length: totalPages }, (_, i) => i + 1);
  }
  

  onPageChange(page: number): void {
    this.currentPage = page - 1; // Adjust the page index
    this.loadInvoices();
  }

  goToCreate(): void {
    this.router.navigate(['/invoices/create']);
  }

  goToReports(): void {
    this.router.navigate(['invoices/reports']);
  }

  goToSearch(): void {
    this.router.navigate(['invoices/search']);
  }
}