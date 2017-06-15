package ua.lviv.lgs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.lgs.services.ArticleService;
import ua.lviv.lgs.services.GestService;

/**
 * Created by Max on 25.04.2017.
 */
@Controller
public class GestController {
    @Autowired
    private GestService gestService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String registrationPage(){
        return "registration";
    }
    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public String registration(@RequestParam("login")String login,@RequestParam("name")String name,@RequestParam("secondName")String secondName,@RequestParam("email")String email,@RequestParam("phone")String phone,@RequestParam("password")String password){
    gestService.add(login,name,secondName,email,phone,password);
    return "redirect:/";
    }
    @RequestMapping(value = "/myarticles",method = RequestMethod.GET)
    public String myArticlesPage(Model model){
        model.addAttribute("articles",articleService.findMyArticles(gestService.getLoginOfAutUser()));
        return "myArticles";
    }

}
