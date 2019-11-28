package com.challenge.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity(name = "candidate")
@EntityListeners(CandidateListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {

    @EmbeddedId
    private CandidateId id;

    @Column(name = "status")
    @NotNull
    private int status;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDate createdAt;
}
