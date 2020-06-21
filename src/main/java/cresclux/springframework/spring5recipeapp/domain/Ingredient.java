package cresclux.springframework.spring5recipeapp.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by laksheenmendis on 6/21/20 at 1:51 PM
 */
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;

    // here we don't need to cascade, because we shouldn't delete a measure, when an Ingredient is removed
    // default fetch type for OneToOne is EAGER, but we're explicitly setting it here
    // we need to load the UnitOfMeasure every time an Ingredient is loaded
    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;

    // here we don't need to specify cascade, because there's no need to remove a Recipe,
    // if an Ingredient is removed.
    @ManyToOne
    private Recipe recipe;

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public UnitOfMeasure getUom() {
        return uom;
    }

    public void setUom(UnitOfMeasure uom) {
        this.uom = uom;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
