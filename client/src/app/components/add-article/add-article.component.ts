import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { Article } from 'src/app/models/Article';
import { ArticleOrderService } from 'src/app/services/article-order.service';

@Component({
  selector: 'app-add-article',
  templateUrl: './add-article.component.html',
  styleUrls: ['./add-article.component.css']
})
export class AddArticleComponent {
  articleForm!: FormGroup;
  img!: File;
  newArticle!: Article;

  constructor(
    private articleOrderService: ArticleOrderService
    , private fb: FormBuilder) {
    this.articleForm = this.fb.group(
      {

        name: this.fb.control("")
        , img: this.fb.control("")
        , price: this.fb.control("")

      }
    )
  }

  upload(event: any) {
    this.img = event.target.files[0];
    //console.log(this.img.name);

  }

  addArticle() {
    this.newArticle = new Article(
      0,
      this.articleForm.value.name,
      this.articleForm.value.price,
      this.img.name);

      this.articleOrderService.uploadImg(this.img)
      .subscribe(
        (x)=>{console.log(x)});

    this.articleOrderService.addArticle(this.newArticle)
      .subscribe(
        (data) => {
          if (data != null) {
            alert("product added !");
          } else {
            alert("ERROR!");
          }
            
          this.articleForm.reset();
      
        }
      )

      
  }
}
