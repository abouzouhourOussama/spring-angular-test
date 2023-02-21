package lu.atozdigital.api.controllers;

import lu.atozdigital.api.dao.DaoImp;
import lu.atozdigital.api.entities.Article;
import lu.atozdigital.api.entities.Order;
import lu.atozdigital.api.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class OrderController {
    @Autowired
    private DaoImp daoImp;

    @Autowired
    private OrderRepo orderRepo;

  /*  @PostMapping("/orders")
    public void _addOrder(){
        daoImp.addOrder();
    }*/

    @PostMapping("/orders")
    public Order _addOrderArt(@RequestBody List<Article> articles) {
        Order order = new Order();
        order.setArticles(articles);
        ;
        daoImp.addOrder(order);
        return order;
    }

    @GetMapping("/orders")
    public List<Order> _getOrders() {
        return daoImp.getOrders();
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Order> _modifyOrder(
            @PathVariable(value = "id") Long id
            , @RequestBody Article article
    ) {
        Order order = orderRepo.findById(id).get();
        if (order == null)
            return new ResponseEntity<>(order, HttpStatus.BAD_REQUEST);
        //sinon on ajoute un article
        order.getArticles().add(article);
        orderRepo.save(order);
        return new ResponseEntity<>(order, HttpStatus.OK);


    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Order> _deleteOrderArticle(
            @PathVariable(value = "id") Long id
            , @RequestBody Article article
    ) {

        Order order = orderRepo.findById(id).get();
        Long articleId = article.getId();

        //si ordre ou article n'existe pas

        if((order==null)||( articleId ==null ))
                return new ResponseEntity<>(order,HttpStatus.BAD_REQUEST);


        //traitement
        Iterator itr = order.getArticles().iterator();
        while (itr.hasNext()) {
            if (articleId == ((Article) itr.next()).getId())
                itr.remove();
        }
        orderRepo.save(order);
        return new ResponseEntity<>(order, HttpStatus.OK);

    }


}
