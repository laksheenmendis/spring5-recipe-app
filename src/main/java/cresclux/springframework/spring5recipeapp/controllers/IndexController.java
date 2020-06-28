package cresclux.springframework.spring5recipeapp.controllers;

import cresclux.springframework.spring5recipeapp.domain.Category;
import cresclux.springframework.spring5recipeapp.domain.UnitOfMeasure;
import cresclux.springframework.spring5recipeapp.repositories.CategoryRepository;
import cresclux.springframework.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

/**
 * Created by laksheenmendis on 5/29/20 at 12:41 AM
 */
@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getRecipes()
    {
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        System.out.println("Category ID is " + categoryOptional.get().getId());
        System.out.println("UOM ID is " + uomOptional.get().getId());

        return "index";
    }
}
