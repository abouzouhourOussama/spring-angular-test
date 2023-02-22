import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ArticlesComponent } from './components/articles/articles.component';
import { AddArticleComponent } from './components/add-article/add-article.component';
import { HeaderComponent } from './components/header/header.component';
import { HttpClientModule } from '@angular/common/http';
import { OrdersComponent } from './components/orders/orders.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule,ReactiveFormsModule  } from '@angular/forms';
import { ModifyOrderComponent } from './components/modify-order/modify-order.component';

@NgModule({
  declarations: [
    AppComponent,
    ArticlesComponent,
    AddArticleComponent,
    HeaderComponent,
    OrdersComponent,
    ModifyOrderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
    , HttpClientModule
    , NgbModule
    , FormsModule
    ,ReactiveFormsModule 

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
