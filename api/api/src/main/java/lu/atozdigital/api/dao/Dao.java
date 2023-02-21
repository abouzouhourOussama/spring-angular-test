package lu.atozdigital.api.dao;

import lu.atozdigital.api.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface Dao {

    public Article addArticle(Article a);
    public void addOrder(Order o);

    public Article getArticleById(Long id);
    public List<Article> getArticles();
    public List<Order> getOrders();

    public Order getOrderById(Long id);

    public void modifyOrder(Order order);



}
