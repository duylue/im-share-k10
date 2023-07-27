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
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportId;
    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name = "post_report",
            joinColumns={@JoinColumn(name="report_id", referencedColumnName="reportId")},
            inverseJoinColumns={@JoinColumn(name="post_id", referencedColumnName="postId")})
    private List<Post> posts;

}
