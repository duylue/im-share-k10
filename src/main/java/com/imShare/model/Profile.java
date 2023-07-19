package com.imShare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String name;
    private Date birthday;
    private String gender;
    private String bio;
    private String profilePhoto;
    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name = "user_profile",
            joinColumns={@JoinColumn(name="pid", referencedColumnName="pid")},
            inverseJoinColumns={@JoinColumn(name="user_id", referencedColumnName="userId")})
    private User user;
}
