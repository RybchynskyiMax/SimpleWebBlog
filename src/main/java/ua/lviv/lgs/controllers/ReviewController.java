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
public class ReviewController {
    @Autowired
    private OpinionService opinionService;
    @Autowired
    private GestService gestService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/article/addopinion/{id}", method = RequestMethod.GET)
    public String addOpinionPage(@PathVariable Integer id, Model model) {
        model.addAttribute("article", articleService.findById(id));
        return "addOpinion";
    }

    @RequestMapping(value = "/article/addopinion/{id}", method = RequestMethod.POST)
    public String addOpinion(@PathVariable Integer id, @RequestParam("textOpinion") String textOpinion, @RequestParam("mark") String mark) {
        long curTime = System.currentTimeMillis();
        String curStringDate = new SimpleDateFormat("yyyy-MM-dd").format(curTime);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = dateFormat.parse(curStringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int makrnew = Integer.parseInt(mark);
        opinionService.add(textOpinion, makrnew, date1, gestService.findByLogin(gestService.getLoginOfAutUser()), articleService.findById(id));
        return "redirect:/";
    }

    @RequestMapping(value = "/article/deleteopinion/{id}", method = RequestMethod.GET)
    public String deleteArticle(@PathVariable Integer id) {
        opinionService.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/article/editopinion/{id}", method = RequestMethod.GET)
    public String editArticlePage(@PathVariable Integer id, Model model) {
        model.addAttribute("opinion", opinionService.findById(id));
        return "editOpinion";
    }

    @RequestMapping(value = "/article/editopinion/{id}", method = RequestMethod.POST)
    public String editArtecle(@PathVariable Integer id, @RequestParam("textOpinion") String textOpinion, @RequestParam("mark") String mark, @RequestParam("date") String date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int newMark = Integer.parseInt(mark);
        Date date1 = null;
        try {
            date1 = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        opinionService.edit(id, textOpinion, newMark, date1);
        return "redirect:/";
    }
}
