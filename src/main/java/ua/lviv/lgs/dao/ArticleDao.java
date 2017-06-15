package ua.lviv.lgs.dao;

import ua.lviv.lgs.entities.Article;

import java.util.List;

/**
 * Created by Max on 25.04.2017.
 */
public interface ArticleDao {
    void add(Article article);

    List<Article> findall();

    Article findById(int id);

    List<Article> findMyArticles(String login);

    void delete(int id);

    void edit(Article article);
}
