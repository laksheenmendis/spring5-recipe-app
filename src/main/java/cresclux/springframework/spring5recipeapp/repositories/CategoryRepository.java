package cresclux.springframework.spring5recipeapp.repositories;

import cresclux.springframework.spring5recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by laksheenmendis on 6/27/20 at 9:50 PM
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
