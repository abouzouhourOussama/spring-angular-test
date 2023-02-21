package lu.atozdigital.api.controllers;

import lu.atozdigital.api.dao.DaoImp;
import lu.atozdigital.api.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class ArticleController {

    @Autowired
    private DaoImp daoImp;
    @PostMapping("/articles")
    public Article _addArticle(@RequestBody Article a){

        return daoImp.addArticle(a);


    }



    @GetMapping("/articles")
    public List<Article> _getArticles(){

        return daoImp.getArticles();
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> _getArticleById(@PathVariable(value = "id") Long id){
        Article article= daoImp.getArticleById(id);
        if(article!=null)
            return new ResponseEntity<>(article, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/upload")
    public String uploadImg(MultipartFile f){
        String dest="C:/Users/abzhr/Desktop/atoz-test/spring-angular-test/client/src/assets/pics/"+f.getOriginalFilename();
        try{
            Files.copy(
                    f.getInputStream()
                    , Paths.get(dest)
                    , StandardCopyOption.REPLACE_EXISTING
            );

        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return "image uploaded";
    }





}
