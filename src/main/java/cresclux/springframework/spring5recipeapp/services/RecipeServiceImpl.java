package cresclux.springframework.spring5recipeapp.services;

import cresclux.springframework.spring5recipeapp.commands.RecipeCommand;
import cresclux.springframework.spring5recipeapp.converters.RecipeCommandToRecipe;
import cresclux.springframework.spring5recipeapp.converters.RecipeToRecipeCommand;
import cresclux.springframework.spring5recipeapp.domain.Recipe;
import cresclux.springframework.spring5recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by laksheenmendis on 6/28/20 at 1:11 AM
 */
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    // both of these are converters
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("In the service");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long l) {
        Optional<Recipe> recipeOpt = recipeRepository.findById(l);

        if(!recipeOpt.isPresent())
        {
            throw new RuntimeException("Recipe not found");
        }

        return recipeOpt.get();
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(recipeCommand);

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved recipeId " + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }
}
