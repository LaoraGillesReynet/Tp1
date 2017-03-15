package com.polytech.web;

import com.polytech.business.Post;
import com.polytech.business.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Laora on 15/03/2017.
 */
@Controller
public class HelloController {

    @Autowired
    private PublicationService publicationService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String home(){
        return "hello" ;
    }

    @RequestMapping(value = "/share", method = RequestMethod.GET)
    public String share(Model model){
        List<Post> posts = publicationService.fetchAll() ;
        model.addAttribute("posts", posts) ;
        return "hello" ;
    }

    @RequestMapping(value = "/share", method = RequestMethod.POST)
    public String post(Post post){
        publicationService.post(post) ;
        return "hello" ;
    }



}
