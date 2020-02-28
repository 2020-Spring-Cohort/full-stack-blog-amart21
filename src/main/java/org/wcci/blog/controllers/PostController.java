package org.wcci.blog.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wcci.blog.*;

public class PostController {

    private PostStorage postStorage;
//    private CommentStorage commentStorage;
    private HashtagRepository hashtagRepo;

    public PostController(PostStorage postStorage, HashtagRepository hashtagRepo){
        this.postStorage = postStorage;
        this.hashtagRepo = hashtagRepo;
    }
    @RequestMapping("/post/{id}")
    public String displayPost(@PathVariable Long id, Model model){
        Post retreivedPost = postStorage.findPostById(id);
        model.addAttribute("post", retreivedPost);
        return "post-view";

    }
    @PostMapping("/add-post")
    public String addPost(@RequestParam Category category, String title, String postBody, Hashtag... hashtag) {
        postStorage.store(new Post(category, title, postBody, hashtag));
        return "redirect:post";
    }


}
