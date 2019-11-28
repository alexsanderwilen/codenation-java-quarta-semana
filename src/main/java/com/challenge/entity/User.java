package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity(name = "user")
@EntityListeners(CandidateListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    @Size(max = 100)
    @NotNull
    private String fullName;

    @Column(name = "email")
    @Size(max = 100)
    @NotNull
    @Email
    private String email;

    @Column(name = "nickname")
    @Size(max = 50)
    @NotNull
    private String nickname;

    @Column(name = "password")
    @Size(max = 255)
    @NotNull
    private String password;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDate createdAt;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="candidate",
            joinColumns={@JoinColumn(name="acceleration_id",
                    referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="user_id",
                    referencedColumnName="id")})
    private Collection<Candidate> candidates;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="submission",
            joinColumns={@JoinColumn(name="challenge_id",
                    referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="user_id",
                    referencedColumnName="id")})
    private Collection<Submission> submissions;
}
