package lu.atozdigital.api.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//lombok
@Getter
@Setter
@NoArgsConstructor


//jpa
@Entity
@Table(name="t_article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private String pic;

    public Article(String name, double price, String pic) {
        this.name = name;
        this.price = price;
        this.pic = pic;
    }


}
