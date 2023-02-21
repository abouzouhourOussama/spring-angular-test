package lu.atozdigital.api.dao;

import lu.atozdigital.api.entities.Article;
import lu.atozdigital.api.entities.Order;
import lu.atozdigital.api.repositories.ArticleRepo;
import lu.atozdigital.api.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DaoImp implements Dao{

    @Autowired
    private ArticleRepo articleRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Override
    public Article addArticle(Article a) {

        return this.articleRepo.save(a);
    }


    @Override
    public void addOrder(Order o) {
        this.orderRepo.save(o);
    }

    @Override
    public Article  getArticleById(Long id) {
        return articleRepo.findById(id).get();
    }

    @Override
    public List<Article> getArticles() {
        return articleRepo.findAll();
    }

    public List<Order> getOrders(){
        return orderRepo.findAll();
    }

    @Override
    public Order getOrderById(Long id) {

        return orderRepo.findById(id).get();
    }

    @Override
    public void modifyOrder(Order order) {
        orderRepo.save(order);
    }


}
