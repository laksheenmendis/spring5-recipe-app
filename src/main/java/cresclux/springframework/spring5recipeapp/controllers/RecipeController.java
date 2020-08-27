package cresclux.springframework.spring5recipeapp.controllers;

import cresclux.springframework.spring5recipeapp.commands.RecipeCommand;
import cresclux.springframework.spring5recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by laksheenmendis on 8/24/20 at 11:16 PM
 */
@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    @RequestMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model)
    {
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "recipe/show";
    }

    @GetMapping
    @RequestMapping("recipe/new")
    public String newRecipe(Model model)
    {
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipeform";
    }

    @GetMapping
    @RequestMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model)
    {
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/recipeform";
    }

//    @RequestMapping(name="recipe", method = RequestMethod.POST) // this is the old way of doing in Spring 4
    //@ModelAttribute annotation tells spring to bind the form, POST parameters to the RecipeCommand object
    @PostMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand recipeCommand)
    {
        RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(recipeCommand);
        return "redirect:/recipe/" + savedRecipeCommand.getId() + "/show";  // redirect tell Spring MVC to redirect to a specific URL
    }

    @GetMapping("recipe/{id}/delete")
    public String deleteById(@PathVariable String id)
    {
        log.debug("Deleting ID " + id);
        recipeService.deleteById(Long.valueOf(id));

        return "redirect:/"; // redirects to the index page
    }

}
