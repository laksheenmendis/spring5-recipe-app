package cresclux.springframework.spring5recipeapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by laksheenmendis on 6/21/20 at 1:34 PM
 */
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
    private String directions;

    @Lob //will be saved as BLOB in DB
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    // mappedBy will tell in which attribute of the child, the Recipe will get saved
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredientSet;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @ManyToMany
    @JoinTable(name = "recipe_category", // name of the table
            joinColumns = @JoinColumn(name="recipe_id"), // from this side
            inverseJoinColumns = @JoinColumn(name="category_id")) // from the other side, in this Category
    private Set<Category> categories;

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

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public Set<Ingredient> getIngredientSet() {
        if(ingredientSet == null)
        {
            ingredientSet = new HashSet<>();
        }
        return ingredientSet;
    }

    public void setIngredientSet(Set<Ingredient> ingredientSet) {
        this.ingredientSet = ingredientSet;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
