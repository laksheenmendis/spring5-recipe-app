package cresclux.springframework.spring5recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by laksheenmendis on 5/29/20 at 12:41 AM
 */
@Controller
public class IndexController {

    @RequestMapping({"", "/", "/index"})
    public String getRecipes()
    {
        return "index";
    }
}
