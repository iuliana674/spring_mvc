package com.iuliana.dao;

import com.iuliana.model.Category;
import com.iuliana.model.Post;
import com.iuliana.model.User;

import java.util.Set;

public interface PostDao {

    public Post insertPost(Post post);

    public Post getPostById(int id);

    public Set<Post> getAllPosts();

    public Set<Post> getPostsByCategory(Category category);

    public Set<Post> getPostsByUser(User user);

    public Post updatePost(Post post);

    public Post deletePost(int id);

    Set<Post> findByTitle(String title);
}
