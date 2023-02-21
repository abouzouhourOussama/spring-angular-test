import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddArticleComponent } from './components/add-article/add-article.component';
import { ArticlesComponent } from './components/articles/articles.component';
import { OrdersComponent } from './components/orders/orders.component';

const routes: Routes = [
  {
    path:"",
    component:ArticlesComponent
  },
  {

  path:"articles"
  ,component:ArticlesComponent
},
{
  path:"orders"
  ,component:OrdersComponent
},{
  path:"articles/add"
  ,component:AddArticleComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
