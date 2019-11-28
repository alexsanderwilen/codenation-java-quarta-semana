package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity(name = "submission")
@EntityListeners(SubmissionListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Submission {

    @EmbeddedId
    private SubmissionId id;

    @Column(name = "score")
    @NotNull
    private Float score;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDate createdAt;
}
