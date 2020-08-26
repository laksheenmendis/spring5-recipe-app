package cresclux.springframework.spring5recipeapp.services;

import cresclux.springframework.spring5recipeapp.commands.RecipeCommand;
import cresclux.springframework.spring5recipeapp.converters.RecipeCommandToRecipe;
import cresclux.springframework.spring5recipeapp.converters.RecipeToRecipeCommand;
import cresclux.springframework.spring5recipeapp.domain.Recipe;
import cresclux.springframework.spring5recipeapp.repositories.RecipeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * Created by laksheenmendis on 8/25/20 at 10:45 PM
 */

@RunWith(SpringRunner.class)
//@DataJpaTest // it only loads a light weight spring context, therefore, there's a chance that tests might fail
@SpringBootTest // this loads the entire spring context
public class RecipeServiceIT {

    public static final String NEW_DESCRIPTION = "New Description";
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;
    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;
    @Autowired
    RecipeService recipeService;

    @Transactional // because we're accessing lazily loaded properties, hence, to keep that inside of the context we need this annotation
    @Test
    public void saveOfDescriptionTest() throws Exception{
        //given
        Iterable<Recipe> recipes = recipeRepository.findAll();
        Recipe testRecipe = recipes.iterator().next();
        RecipeCommand testRecipeCommand = recipeToRecipeCommand.convert(testRecipe);

        //when
        testRecipeCommand.setDescription(NEW_DESCRIPTION);
        RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(testRecipeCommand);

        //then
        assertEquals(NEW_DESCRIPTION, savedRecipeCommand.getDescription()); // change the previous description to a new one
        assertEquals(testRecipe.getId(), savedRecipeCommand.getId());
        assertEquals(testRecipe.getCategories().size(), savedRecipeCommand.getCategories().size());
        assertEquals(testRecipe.getIngredients().size(), savedRecipeCommand.getIngredients().size());
    }
}