package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dao.ReviewDao;
import ua.lviv.lgs.entities.Article;
import ua.lviv.lgs.entities.Gest;
import ua.lviv.lgs.entities.Review;
import ua.lviv.lgs.services.OpinionService;

import java.util.Date;
import java.util.List;

/**
 * Created by Max on 25.04.2017.
 */
@Service
public class OpinionServiceImpl implements OpinionService {
    @Autowired
    private ReviewDao reviewDao;

    public void add(String textOpinion, int mark, Date date, Gest gest, Article article) {
        Review review = new Review(textOpinion, mark, date);
        review.setArticle(article);
        review.setGest(gest);
        reviewDao.add(review);
    }

    public List<Review> findByArticleId(int id) {
        return reviewDao.findByArticleId(id);
    }

    public void delete(int id) {
        reviewDao.delete(id);
    }

    public Review findById(int id) {
        return reviewDao.findById(id);
    }

    public void edit(int id, String textOpinion, int mark, Date date) {
        Review review = reviewDao.findById(id);
        if (textOpinion != null && textOpinion.equalsIgnoreCase("")==false) {
            review.setText(textOpinion);
        }
        if (mark > -1) {
            review.setMark(mark);
        }
        if (date != null) {
            review.setDate(date);
        }
        reviewDao.edit(review);
    }

    public List<Review> findByLogin(String login) {
        return reviewDao.findByLogin(login);
    }
}
