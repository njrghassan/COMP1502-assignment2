package test;

import model.BoardGames;
import exceptions.negativePriceException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardGamesTest {
	private String[] desginers;
    @Test
    void test1() {
        BoardGames boardGame = new BoardGames("11123456789","My Toy","My Brand",12.9,3,3,2, 3, desginers);
        assertEquals("11123456789", boardGame.getSN());
    }

    @Test
    void test2() throws negativePriceException {
        BoardGames boardGame = new BoardGames("11123456789","My Toy","My Brand",-12.9,3,3,2, 3, desginers);

        if (boardGame.getPrice() < 0) {
            try {
                throw new negativePriceException("Price cannot be negative");
            } catch (negativePriceException e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            fail("Test failed: Price is not negative");
        }
    }

}