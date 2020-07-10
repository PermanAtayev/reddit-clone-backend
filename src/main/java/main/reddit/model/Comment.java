package main.reddit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.time.Instant;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity essentially shows that this class maps to the database table
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Long id;
    public Instant createdDate;
    @NotEmpty
    public String text;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "postId", referencedColumnName = "postId")
    public Post post;
}
