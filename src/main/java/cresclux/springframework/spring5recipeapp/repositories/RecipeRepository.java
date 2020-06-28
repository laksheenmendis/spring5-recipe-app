package cresclux.springframework.spring5recipeapp.repositories;

import cresclux.springframework.spring5recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by laksheenmendis on 6/27/20 at 9:49 PM
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
