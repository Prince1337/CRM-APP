import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './modules/authentication/components/login/login.component';
import { ProductRoutingModule } from './modules/product/product-routing.module';
import { ProductModule } from './modules/product/product.module';
import { SidebarComponent } from './shared/components/sidebar/sidebar.component';
import { HeaderComponent } from './shared/components/header/header.component';
import { MatIconModule } from '@angular/material/icon';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AuthenticationRoutingModule } from './modules/authentication/components/authentication-routing.module';
import { DocumentListComponent } from './modules/document/components/document-list/document-list.component';
import { DocumentRoutingModule } from './modules/document/document-routing.module';
import { DocumentModule } from './modules/document/document.module';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SidebarComponent,
    HeaderComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    ProductRoutingModule,
    AuthenticationRoutingModule,
    ProductModule,
    DocumentRoutingModule,
    DocumentModule,
    MatIconModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
