package com.imShare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(value = {"user"})
public class Save {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int saveId;
    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name = "post_save",
            joinColumns={@JoinColumn(name="save_id", referencedColumnName="saveId")},
            inverseJoinColumns={@JoinColumn(name="post_id", referencedColumnName="postId")})
    @JsonIgnore
    private List<Post> posts;
    @OneToOne(mappedBy = "save")
    private User user;

}
