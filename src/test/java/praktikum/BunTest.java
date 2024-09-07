package praktikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BunTest {

    @Test
    public void testBunCreation() {

        Bun bun = new Bun("Wheat Bun", 1.5f);
        assertEquals("Wheat Bun", bun.getName());
        assertEquals(1.5f, bun.getPrice(), 0.001);

    }

    @Test
    public void testGetName() {

        Bun bun = new Bun("Sesame Bun", 2.0f);
        assertEquals("Sesame Bun", bun.getName());

    }

    @Test
    public void testGetPrice() {

        Bun bun = new Bun("Butter Bun", 2.5f);
        assertEquals(2.5f, bun.getPrice(), 0.001);

    }

}
