package com.imShare.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    private int userId;
    private String content;
    private Date cdate;
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name = "post_comment",
            joinColumns={@JoinColumn(name="cid", referencedColumnName="cid")},
            inverseJoinColumns={@JoinColumn(name="post_id", referencedColumnName="postId")})

    private Post post;
}
