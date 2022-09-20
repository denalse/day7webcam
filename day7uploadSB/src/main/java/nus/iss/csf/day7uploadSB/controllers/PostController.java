package nus.iss.csf.day7uploadSB.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import nus.iss.csf.day7uploadSB.model.Post;
import nus.iss.csf.day7uploadSB.services.PostService;

@Controller
@RequestMapping(path="/post")
public class PostController {

    @Autowired
    private PostService postSvc;
    
    @GetMapping(path="{postId}")
    public String getPOst(@PathVariable Integer postId, Model model) {

        Optional<Post> opt = postSvc.getPost(postId);
        Post p = opt.get();
        model.addAttribute("post", p);
        model.addAttribute("imageSrc", "/upload/%d".formatted(p.getPostId()));
        return "post";
    
    }

}
