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
public class Save {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int saveId;
    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name = "post_save",
            joinColumns={@JoinColumn(name="save_id", referencedColumnName="saveId")},
            inverseJoinColumns={@JoinColumn(name="post_id", referencedColumnName="postId")})
    private List<Post> posts;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
