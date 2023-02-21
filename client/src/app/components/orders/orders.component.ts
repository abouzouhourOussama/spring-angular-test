import { Component } from '@angular/core';
import { ArticleOrderService } from 'src/app/services/article-order.service';
import { Order } from 'src/app/models/Order';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent {

  orders:Order[]=[];
  constructor(private articleOrderService:ArticleOrderService){
    this.getOrders();
  }
  getOrders(){
    this.articleOrderService.getOrders().subscribe(
      (data)=>{
        this.orders=data;
        console.log(data);
        
      }
    )
  }

}
