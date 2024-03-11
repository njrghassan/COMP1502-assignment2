package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.negativePriceException;
import model.Puzzles;

class PuzzlesTest {

    @Test
    void test1() throws negativePriceException {
        Puzzles p = new Puzzles("1987654321", "My Toy", "My Brand", 42.9, 3, 3, 'M');
        assertEquals("1987654321", p.getSN());
    }

    @Test
    void test2() throws negativePriceException {
        Puzzles p = new Puzzles("1987654321", "My Toy", "My Brand", -42.9, 3, 3, 'M');

        if (p.getPrice() < 0) {
            try {
                throw new negativePriceException("Price cannot be negative");
            } catch (negativePriceException e) {
                System.out.println(e.getMessage());
            }
        } else {
            fail("Test failed: Price is not negative");
        }
    }

}
