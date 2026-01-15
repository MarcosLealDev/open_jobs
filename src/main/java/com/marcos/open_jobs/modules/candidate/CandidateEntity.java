package com.marcos.open_jobs.modules.candidate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class CandidateEntity {

        private UUID id;
        private String name;

        @NotBlank()
        @Pattern(regexp = "\\S+", message="WRONG, no blah blah, you dummass!")
        private String username;

        @Email(message="Email not valid. Fix it, Matthew LEAL!")
        private String email;

        @Length(min=3, max=10, message = "Between 3 and 10 dumbass.")
        private String password;
        private String description;
        private String resume;

}
