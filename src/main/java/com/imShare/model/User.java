package com.imShare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String password;
    @ManyToMany(mappedBy = "users")
    private List<Role> roles;
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
    @ManyToMany(mappedBy = "users")
    private List<Follower> followers;
    @ManyToMany(mappedBy = "users")
    private List<UserLike> userLikes;
}
