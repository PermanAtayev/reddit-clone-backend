package main.reddit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @NotBlank(message = "Username can't be blank")
    public String username;
    @NotBlank(message = "email can't be blank")

    @Email(message = "email should be valid")
    @Column(unique = true)
    public String email;

    private Instant created;

    @NotBlank(message = "password is required")
    private String password;

//    for the signup purposes.
    private boolean enabled;
}
