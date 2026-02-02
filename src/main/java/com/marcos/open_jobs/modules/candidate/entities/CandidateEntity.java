package com.marcos.open_jobs.modules.candidate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name="candidate")
public class CandidateEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;
        private String name;

        @NotBlank()
        @Pattern(regexp = "\\S+", message="WRONG, no blah blah, you dummass!")
        private String username;

        @Email(message="Email not valid. Fix it, now!")
        private String email;

        @Length(min=3, max=10, message = "Between 3 and 10 dumbass.")
        private String password;
        private String description;
        private String resume;

        @CreationTimestamp
        private LocalDateTime createdAt;

}
