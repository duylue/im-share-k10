package com.imShare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Like1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeId;
    private int userId;
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name = "post_like",
            joinColumns={@JoinColumn(name="like_id", referencedColumnName="likeId")},
            inverseJoinColumns={@JoinColumn(name="post_id", referencedColumnName="postId")})
    private Post post;
}
