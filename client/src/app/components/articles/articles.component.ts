import { Component } from '@angular/core';
import { Article } from 'src/app/models/Article';
import { Order } from 'src/app/models/Order';
import { ArticleOrderService } from 'src/app/services/article-order.service';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent {

  articles: Article[] = [];
  orders: Order[] = [];
  orderArticles: Article[] = [];
  validateBtnEnable: boolean = false;
  newBtnEnable: boolean = true;

  constructor(private articleOrderService: ArticleOrderService) {
    this.getArticles();
  }

  getArticles() {
    this.articleOrderService.getArticles().subscribe(
      (data) => {

        this.articles = data;
        //console.log( this.articles);
        
        //console.log(data);

      }
    )
  }

  

  getOrders() {
    this.articleOrderService.getOrders().subscribe(
      (data) => {
        this.orders = data;
        console.log(data);

      }
    )
  }


  addToOrder(a: Article) {
    this.orderArticles.push(a);
    console.log(this.orderArticles);

    this.validateBtnEnable = true;
    this.newBtnEnable = false;
  }

  validateOrder() {

    //envoyer les donner de l'article
    var _orderArticles = new Array<Article>();
    this.orderArticles.map(
      (elm) => {
        let e = new Article(elm.id,elm.name, elm.price, elm.pic);
        _orderArticles.push(e);
      }
    )
    //console.log(_orderArticles);


    this.articleOrderService.addOrder(_orderArticles)
      .subscribe(
        (data) => {
          console.log(data)

          alert("your order is placed!");
          this.validateBtnEnable = false;
          this.newBtnEnable = true;
          this.orderArticles = [];

        })

  }




  createOrder() {
    this.newBtnEnable = false;
    alert("please choose products !");

  }
}
