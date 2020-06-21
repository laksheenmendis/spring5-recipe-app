package cresclux.springframework.spring5recipeapp.domain;

import javax.persistence.*;

/**
 * Created by laksheenmendis on 6/21/20 at 1:34 PM
 */
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // here we don't need to specify cascade, because Recipe owns it
    // and there's no need to remove a Recipe, if a Notes is removed. Thus, no need of cascade
    @OneToOne
    private Recipe recipe;

    @Lob // will be saved as CLOB
    private String recipeNotes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
}
