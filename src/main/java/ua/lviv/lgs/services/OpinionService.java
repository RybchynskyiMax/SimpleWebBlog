package ua.lviv.lgs.services;

import ua.lviv.lgs.entities.Article;
import ua.lviv.lgs.entities.Gest;
import ua.lviv.lgs.entities.Review;

import java.util.Date;
import java.util.List;

/**
 * Created by Max on 25.04.2017.
 */
public interface OpinionService {
    void add(String textOpinion, int mark, Date date, Gest gest, Article article);

    List<Review> findByArticleId(int id);

    void delete(int id);

    Review findById(int id);

    void edit(int id, String textOpinion, int mark, Date date);

    List<Review> findByLogin(String login);


}
