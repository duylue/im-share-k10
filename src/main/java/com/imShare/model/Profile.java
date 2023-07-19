package com.imShare.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
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
