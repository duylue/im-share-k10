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
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fid;
    @ManyToMany(mappedBy = "followings")
    private List<User> followerUsers;
    @OneToOne(mappedBy = "follower")
    private User user;
}
