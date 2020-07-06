package cresclux.springframework.spring5recipeapp.domain;

import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by laksheenmendis on 6/21/20 at 1:34 PM
 */
@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    @Lob //will be saved as BLOB in DB
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    // mappedBy will tell in which attribute of the child, the Recipe will get saved
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @ManyToMany
    @JoinTable(name = "recipe_category", // name of the table
            joinColumns = @JoinColumn(name="recipe_id"), // from this side
            inverseJoinColumns = @JoinColumn(name="category_id")) // from the other side, in this Category
    private Set<Category> categories = new HashSet<>();

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);  // using the setter for JPA Bidirectional relationship
    }

    public Recipe addIngredient(Ingredient ingredient){
        ingredient.setRecipe(this); // using the setter for JPA Bidirectional relationship
        this.ingredients.add(ingredient);
        return this;
    }
}
