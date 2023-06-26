import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-product-reports',
  templateUrl: './product-reports.component.html',
  styleUrls: ['./product-reports.component.scss']
})
export class ProductReportsComponent implements OnInit {

  totalProductCount!: number;
  averageNetPrice!: number;
  productCountByGroup!: Map<string, number>;
  productCountByStatus1!: number;
  productCountByStatus2!: number;
  averageTaxRate!: number;

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.productService.getTotalProductCount().subscribe(count => {
      this.totalProductCount = count;
    });

    this.productService.getAverageNetPrice().subscribe(price => {
      this.averageNetPrice = price;
    });

    this.productService.getProductCountByGroup().subscribe(countByGroup => {
      this.productCountByGroup = countByGroup;
    });

    this.productService.getProductCountByStatus('ausverkauft').subscribe(count => {
      this.productCountByStatus1 = count;
    });

    this.productService.getProductCountByStatus('auf Lager').subscribe(count => {
      this.productCountByStatus2 = count;
    });

    this.productService.getAverageTaxRate().subscribe(rate => {
      this.averageTaxRate = rate;
    });
  }
}