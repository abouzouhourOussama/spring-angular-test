package lu.atozdigital.api.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

//lombok
@Getter
@Setter

//jpa
@Entity
@Table(name="t_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Ref= String.valueOf(UUID.randomUUID());
    private Date date;

    @OneToMany(targetEntity = Article.class)
    @JoinColumn(name="id_order")
    private List<Article> articles=new ArrayList<Article>();
    public Order() {
        date=new Date();
    }

    //liste des articles






}
