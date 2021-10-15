package com.iuliana;

import com.iuliana.config.AppConfig;
import com.iuliana.model.Category;
import com.iuliana.model.Post;
import com.iuliana.model.User;
import com.iuliana.service.PostService;
import com.iuliana.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Set;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean("userService", UserService.class);

        User newUser = new User("I", "i");
        userService.insertUser(newUser);
        System.out.println("New user inserted successfully! Username: " + newUser);


        System.out.println("\nAll users: ");
        for(User user : userService.getAllUsers()){
            System.out.println(user);
        }

        System.out.println("\nUser with id = 2: ");
        User user = userService.getUserById(2);
        System.out.println(user);

        user.setFirstName("Iuliana");
        userService.updateUser(user);

        PostService postService = context.getBean("postService", PostService.class);

        System.out.println("\nAll posts: ");
        Set<Post> posts = postService.getAllPosts();
        for(Post post : posts){
            System.out.println(post);
        }

        System.out.println("\nPosts from category Style: ");
        posts = postService.getPostsByCategory(Category.Style);
        for(Post post : posts){
            System.out.println(post);
        }

        System.out.println("\nPosts from " + user + ": ");
        posts = postService.getPostsByUser(user);
        for(Post post : posts){
            System.out.println(post);
        }
    }
}
