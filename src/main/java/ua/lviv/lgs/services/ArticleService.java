package ua.lviv.lgs.services;

import ua.lviv.lgs.entities.Article;
import ua.lviv.lgs.entities.Gest;

import java.util.Date;
import java.util.List;

/**
 * Created by Max on 25.04.2017.
 */
public interface ArticleService {
    void add(String subject, String textArticle, Date date, Gest gest);

    List<Article> findall();

    Article findById(int id);

    List<Article> findMyArticles(String login);

    void edit(int id, String subject, String textArticle, Date date);

    void delete(int id);
}
