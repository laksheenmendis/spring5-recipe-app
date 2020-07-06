package cresclux.springframework.spring5recipeapp.domain;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

/**
 * Created by laksheenmendis on 6/27/20 at 5:08 PM
 */
@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

}
