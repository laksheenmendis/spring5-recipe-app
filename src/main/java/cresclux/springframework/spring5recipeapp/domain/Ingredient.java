package cresclux.springframework.spring5recipeapp.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by laksheenmendis on 6/21/20 at 1:51 PM
 */
@Data
@EqualsAndHashCode(exclude = {"recipe"})
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

    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
        this.recipe = recipe;
    }

}
