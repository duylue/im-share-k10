package com.imShare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    private String content;
    private String caption;
    private Date pdate;
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
    @OneToMany(mappedBy = "post")
    private List<Like1> likes;
    @ManyToMany(mappedBy = "posts")
    private List<Save> saves;
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name = "user_post",
            joinColumns={@JoinColumn(name="post_id", referencedColumnName="postId")},
            inverseJoinColumns={@JoinColumn(name="user_id", referencedColumnName="userId")})
    private User user;

}
