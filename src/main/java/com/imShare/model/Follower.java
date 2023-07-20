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
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fid;
    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name = "user_follower",
            joinColumns={@JoinColumn(name="fid", referencedColumnName="fid")},
            inverseJoinColumns={@JoinColumn(name="user_id", referencedColumnName="userId")})
    private List<User> users;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
