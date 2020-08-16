package cresclux.springframework.spring5recipeapp.domain;

import org.junit.Before;
import static org.junit.Assert.assertEquals;

/**
 * Created by laksheenmendis on 8/15/20 at 5:31 PM
 */
public class CategoryTest {

    Category category;

    @Before
    public void setUp() throws Exception {
        category = new Category();
    }

    @org.junit.Test
    public void getId() {

        Long idVal = 4L;
        category.setId(idVal);

        assertEquals(idVal, category.getId());
    }

    @org.junit.Test
    public void getDescription() {
    }

    @org.junit.Test
    public void getRecipes() {
    }
}