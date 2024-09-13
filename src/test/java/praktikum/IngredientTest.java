package praktikum;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {

    @Test
    public void testGetPrice() {

        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Lettuce", 1.5f);
        float price = ingredient.getPrice();
        assertEquals(1.5f, price, 0.0f);

    }

    @Test
    public void testGetName() {

        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 0.5f);
        String name = ingredient.getName();
        assertEquals("Ketchup", name);

    }

}
