package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        burger = new Burger();

        // Настройка моков
        when(mockBun.getName()).thenReturn("Mock Bun");
        when(mockBun.getPrice()).thenReturn(5.0f);

        when(mockIngredient1.getName()).thenReturn("Ingredient 1");
        when(mockIngredient1.getPrice()).thenReturn(2.0f);
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);

        when(mockIngredient2.getName()).thenReturn("Ingredient 2");
        when(mockIngredient2.getPrice()).thenReturn(3.0f);
        when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);

    }

    @Test
    public void testSetBuns() {

        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);

    }

    @Test
    public void testAddIngredient() {

        burger.addIngredient(mockIngredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient1, burger.ingredients.get(0));

    }

    @Test
    public void testRemoveIngredient() {

        burger.addIngredient(mockIngredient1);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());

    }

    @Test
    public void testMoveIngredient() {

        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals(mockIngredient1, burger.ingredients.get(1));
        assertEquals(mockIngredient2, burger.ingredients.get(0));

    }

    @Test
    public void testGetPrice() {

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        assertEquals(15f, burger.getPrice());

    }

    @Test
    public void testGetReceipt() {

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        String expectedValue = String.format("(==== Mock Bun ====)%n") + String.format("= filling Ingredient 1 =%n") +
                String.format("= sauce Ingredient 2 =%n") +
                String.format("(==== Mock Bun ====)%n") +
                String.format("%nPrice: 15,000000%n");

        assertEquals(expectedValue, burger.getReceipt());

    }

}
