package ua.lviv.lgs.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.lgs.dao.ArticleDao;
import ua.lviv.lgs.entities.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Max on 25.04.2017.
 */
@Repository
public class ArticleDaoImpl implements ArticleDao {
    @PersistenceContext(unitName = "Main")
    private EntityManager entityManager;

    @Transactional
    public void add(Article article) {
        entityManager.persist(article);
    }

    @Transactional

    public List<Article> findall() {
        List<Article> articles = entityManager.createQuery("SELECT a FROM Article a ").getResultList();
        return articles;
    }

    @Transactional

    public Article findById(int id) {
        Article article = entityManager.find(Article.class, id);
        return article;
    }

    @Transactional
    public List<Article> findMyArticles(String login) {
        List<Article> articles = entityManager.createQuery("select a FROM Article a WHERE a.gest.login=:login").setParameter("login", login).getResultList();
        return articles;
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(Article.class, id));
    }

    @Transactional

    public void edit(Article article) {
        entityManager.merge(article);
    }
}
