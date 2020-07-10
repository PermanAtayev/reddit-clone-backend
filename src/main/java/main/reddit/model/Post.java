package main.reddit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.time.Instant;
import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long postId;

    @ManyToOne(fetch = LAZY)
//    join column serves as a foreign key to the other table.
    @JoinColumn(name = "id", referencedColumnName = "id")
    public Subreddit subreddit;

    @NotBlank(message = "Post name can't be blank")
    public String postName;

    @Nullable
    public String url;

    @Nullable
    @Lob
    public String description;
    private Instant createdDate;
    private Integer voteCount = 0;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;


}
