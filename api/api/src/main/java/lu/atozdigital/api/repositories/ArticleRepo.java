package lu.atozdigital.api.repositories;

import lu.atozdigital.api.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ArticleRepo extends JpaRepository<Article,Long> {
}
