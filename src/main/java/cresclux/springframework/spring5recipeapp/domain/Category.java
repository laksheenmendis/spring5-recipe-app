package cresclux.springframework.spring5recipeapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by laksheenmendis on 6/27/20 at 5:08 PM
 */
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Recipe> getRecipes() {
        if(recipes == null)
        {
            recipes = new HashSet<>();
        }
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
