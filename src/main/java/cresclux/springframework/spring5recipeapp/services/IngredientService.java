package cresclux.springframework.spring5recipeapp.services;

import cresclux.springframework.spring5recipeapp.commands.IngredientCommand;
import org.springframework.stereotype.Service;

/**
 * Created by laksheenmendis on 8/27/20 at 12:13 AM
 */
public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long id);
}
