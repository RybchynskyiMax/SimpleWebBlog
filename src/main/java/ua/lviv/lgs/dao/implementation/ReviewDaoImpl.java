package ua.lviv.lgs.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.lgs.dao.ReviewDao;
import ua.lviv.lgs.entities.Review;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Max on 25.04.2017.
 */
@Repository
public class ReviewDaoImpl implements ReviewDao {
    @PersistenceContext(unitName = "Main")
    private EntityManager entityManager;

    @Transactional
    public void add(Review review) {
        entityManager.persist(review);
    }

    @Transactional
    public List<Review> findByArticleId(int id) {
        List<Review> reviews = entityManager.createQuery("SELECT o FROM Review o WHERE o.article.id=:id").setParameter("id", id).getResultList();
        return reviews;
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(Review.class, id));
    }

    @Transactional
    public Review findById(int id) {
        return entityManager.find(Review.class, id);
    }

    @Transactional
    public void edit(Review review) {
        entityManager.merge(review);
    }

    @Transactional

    public List<Review> findByLogin(String login) {
        List<Review> reviews = entityManager.createQuery("SELECT o FROM Review o WHERE o.gest.login=:login").setParameter("login", login).getResultList();
        return reviews;
    }
}
