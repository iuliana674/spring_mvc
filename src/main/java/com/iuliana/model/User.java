package com.iuliana.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @TableGenerator(name = "id_generator", initialValue = 2, allocationSize = 1)
    @GeneratedValue(generator = "id_generator")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String lastName;

    @JsonIgnoreProperties(value = {"id", "author"})
    @OneToMany(mappedBy="author", fetch = FetchType.EAGER)
    private Set<Post> posts;

    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
