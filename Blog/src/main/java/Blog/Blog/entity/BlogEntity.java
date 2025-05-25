package Blog.Blog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class BlogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer blogId;
    private String blogName;
    private String description;
    private String story;
    private String comment;

}
