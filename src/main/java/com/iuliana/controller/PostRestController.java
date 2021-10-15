package com.iuliana.controller;

import com.iuliana.model.Post;
import com.iuliana.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class PostRestController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET, produces = "application/json")
    public Set<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping(value = "/post/{id}", produces = "application/json")
    public Post getPostById(@PathVariable int id){
        return postService.getPostById(id);
    }

    @GetMapping(value = "/delete-post/{id}", produces = "application/json")
    public Post deletePost(@PathVariable int id){
        return postService.deletePost(id);
    }

    @PatchMapping(value = "/update-post", produces = "application/json")
    public Post updatePost(@RequestBody Post post){
        return postService.updatePost(post);
    }

    @PostMapping(value = "/add-post", produces = "application/json")
    public Post insertPost(@RequestBody Post post){
        return postService.insertPost(post);
    }

    @GetMapping(value = "/find-by-title", produces = "application/json")
    public Set<Post> findByTitle(@RequestParam String title){
        return postService.findByTitle(title);
    }
}
