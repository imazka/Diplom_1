package praktikum;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedTests {

    @ParameterizedTest
    @EnumSource(IngredientType.class)
    public void testGetType(IngredientType ingredientType) {

        Ingredient ingredient = new Ingredient(ingredientType, "Cheese", 2.0f);
        IngredientType type = ingredient.getType();
        assertEquals(ingredientType, type);

    }
}
