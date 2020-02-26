package org.wcci.blog.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.PostStorage;

public class PostController {

    private PostStorage postStorage;
//    private CommentStorage commentStorage;
    public PostController(PostStorage postStorage){
        this.postStorage = postStorage;
    }
    @RequestMapping("/post/{id}")
    public String displayPost(@PathVariable Long id, Model model){
        Post retreivedPost = postStorage.findPostById(id);
        model.addAttribute("post", retreivedPost);
        return "post-view";

    }


}
