import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Article } from '../models/Article';
import { Order } from '../models/Order';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ArticleOrderService {

  private _host:string="http://localhost:8080";
  constructor(private _http:HttpClient) { }

  getArticles():Observable<Article[]>{
      return this._http.get<Article[]>(this._host+"/articles")
  }
  getOrders():Observable<Order[]>{
    return this._http.get<Order[]>(this._host+"/orders")
}
  addOrder(articles:Article[]){
    return this._http.post(this._host+"/orders",articles);
  }

  putArticles(articles:Article[]){
    return this._http.put(this._host+"/orders",articles);
  }

  addArticle(article:Article){
      return this._http.post(this._host+"/articles",article);
  }
  uploadImg(file:File):Observable<String>{
    const formData:FormData=new FormData();
    formData.append('f',file);
    return this._http.post<String>(this._host+"/upload",formData);
  }
}
