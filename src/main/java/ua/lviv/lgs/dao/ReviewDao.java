package ua.lviv.lgs.dao;

import ua.lviv.lgs.entities.Review;

import java.util.List;

/**
 * Created by Max on 25.04.2017.
 */
public interface ReviewDao {
    void add(Review review);

    List<Review> findByArticleId(int id);

    void delete(int id);

    Review findById(int id);

    void edit(Review review);

    List<Review> findByLogin(String login);
}
