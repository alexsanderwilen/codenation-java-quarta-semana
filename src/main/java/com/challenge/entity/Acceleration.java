package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity(name = "acceleration")
@EntityListeners(CandidateListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Acceleration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @Size(max = 100)
    @NotNull
    private String name;

    @Column(name = "slug")
    @Size(max = 50)
    @NotNull
    private String slug;

    @ManyToOne
    @JoinColumn(name = "chalenge_id")
    private Challenge challenge;

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
}
