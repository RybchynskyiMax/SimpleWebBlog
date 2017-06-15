package ua.lviv.lgs.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Max on 25.04.2017.
 */
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subject;
    private String text;
    private Date date;
    @ManyToOne
    private Gest gest;
    @OneToMany(mappedBy = "article" ,cascade = CascadeType.ALL)
    List<Review> reviewList;
    public Article() {
    }

    public Article(String subject, String text, Date date) {
        this.subject = subject;
        this.text = text;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }
}
