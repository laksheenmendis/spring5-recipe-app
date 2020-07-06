package cresclux.springframework.spring5recipeapp.controllers;

import cresclux.springframework.spring5recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by laksheenmendis on 5/29/20 at 12:41 AM
 */
@Slf4j
@Controller
public class IndexController {

    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getRecipes(Model model)
    {
        log.debug("In index request mapping");
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
