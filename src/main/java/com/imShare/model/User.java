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
    @OneToOne(mappedBy = "user")
    private Profile profile;
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
    @OneToOne(mappedBy = "user")
    private Save save;
}
