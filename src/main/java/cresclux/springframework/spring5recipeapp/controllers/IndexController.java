package cresclux.springframework.spring5recipeapp.controllers;

import cresclux.springframework.spring5recipeapp.domain.Category;
import cresclux.springframework.spring5recipeapp.domain.UnitOfMeasure;
import cresclux.springframework.spring5recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

/**
 * Created by laksheenmendis on 5/29/20 at 12:41 AM
 */
@Controller
public class IndexController {

    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getRecipes(Model model)
    {
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
