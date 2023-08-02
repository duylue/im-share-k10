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
public class UserLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeId;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name = "users_like",
            joinColumns={@JoinColumn(name="like_id", referencedColumnName="likeId")},
            inverseJoinColumns={@JoinColumn(name="user_id", referencedColumnName="userId")})
    private List<User> users;
}
