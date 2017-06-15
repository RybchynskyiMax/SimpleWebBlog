package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dao.ArticleDao;
import ua.lviv.lgs.entities.Article;
import ua.lviv.lgs.entities.Gest;
import ua.lviv.lgs.services.ArticleService;

import java.util.Date;
import java.util.List;

/**
 * Created by Max on 25.04.2017.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    public void add(String subject, String textArticle, Date date, Gest gest) {
        Article article = new Article(subject, textArticle, date);
        article.setGest(gest);
        articleDao.add(article);
    }

    public List<Article> findall() {
        return articleDao.findall();
    }

    public Article findById(int id) {
        return articleDao.findById(id);
    }

    public List<Article> findMyArticles(String login) {
        return articleDao.findMyArticles(login);
    }

    public void edit(int id, String subject, String textArticle, Date date) {
        Article article = articleDao.findById(id);
        if (subject != null && subject.equalsIgnoreCase("")) {
            article.setSubject(subject);
        }
        if (textArticle != null && textArticle.equalsIgnoreCase("")) {
            article.setText(textArticle);
        }
        if (date != null) {
            article.setDate(date);
        }
        articleDao.edit(article);
    }

    public void delete(int id) {
        articleDao.delete(id);
    }
}
