package ua.lviv.lgs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.lgs.services.ArticleService;
import ua.lviv.lgs.services.GestService;
import ua.lviv.lgs.services.OpinionService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Max on 25.04.2017.
 */
@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private GestService gestService;
    @Autowired
    private OpinionService opinionService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addArticlePage() {
        return "addArticle";
    }

    @RequestMapping(value = "/addarticle", method = RequestMethod.POST)
    public String addArticle(@RequestParam("subject") String subject, @RequestParam("textArticle") String textArticle) {
        long curTime = System.currentTimeMillis();
        String curStringDate = new SimpleDateFormat("yyyy-MM-dd").format(curTime);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = dateFormat.parse(curStringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        articleService.add(subject, textArticle, date1, gestService.findByLogin(gestService.getLoginOfAutUser()));
        return "redirect:/";
    }

    @RequestMapping(value = "/articles/{id}", method = RequestMethod.GET)
    public String article(@PathVariable Integer id, Model model) {
        model.addAttribute("article", articleService.findById(id));
        model.addAttribute("opinions", opinionService.findByArticleId(id));
        model.addAttribute("myopinions", opinionService.findByLogin(gestService.getLoginOfAutUser()));
        model.addAttribute("login", gestService.getLoginId(gestService.getLoginOfAutUser()));
        return "article";
    }

    @RequestMapping(value = "/myarticles/{id}", method = RequestMethod.GET)
    public String myarticle(@PathVariable Integer id, Model model) {
        model.addAttribute("article", articleService.findById(id));
        model.addAttribute("opinions", opinionService.findByArticleId(id));
        return "article";
    }

    @RequestMapping(value = "/myarticles/delete/{id}", method = RequestMethod.GET)
    public String deleteArticle(@PathVariable Integer id) {
        articleService.delete(id);
        return "redirect:/myarticles";
    }

    @RequestMapping(value = "/myarticles/edit/{id}", method = RequestMethod.GET)
    public String editArticlePage(@PathVariable Integer id, Model model) {
        model.addAttribute("article", articleService.findById(id));
        return "editArticle";
    }

    @RequestMapping(value = "/myarticles/edit/{id}", method = RequestMethod.POST)
    public String editArtecle(@PathVariable Integer id, @RequestParam("subject") String subject, @RequestParam("textArticle") String textArticle, @RequestParam("date") String date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date1 = null;
        try {
            date1 = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        articleService.edit(id, subject, textArticle, date1);
        return "redirect:/myarticles";
    }
    @RequestMapping(value = "/articles",method = RequestMethod.GET)
    public String articlesPage(Model model){
        model.addAttribute("articles", articleService.findall());
        return "articles";
    }
}





