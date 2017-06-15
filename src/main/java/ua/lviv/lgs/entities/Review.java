package ua.lviv.lgs.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Max on 25.04.2017.
 */
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private int mark;
    private Date date;
    @ManyToOne
    private Gest gest;
    @ManyToOne
    private Article article;

    public Review() {
    }

    public Review(String text, int mark, Date date) {
        this.text = text;
        this.mark = mark;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Gest getGest() {
        return gest;
    }

    public void setGest(Gest gest) {
        this.gest = gest;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
