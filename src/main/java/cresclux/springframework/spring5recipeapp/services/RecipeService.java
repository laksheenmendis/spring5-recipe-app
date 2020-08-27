package cresclux.springframework.spring5recipeapp.services;

import cresclux.springframework.spring5recipeapp.commands.RecipeCommand;
import cresclux.springframework.spring5recipeapp.domain.Recipe;

import java.util.Set;

/**
 * Created by laksheenmendis on 6/28/20 at 1:08 AM
 */
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);

    RecipeCommand findCommandById(Long l);

    void deleteById(Long idToDelete);
}
