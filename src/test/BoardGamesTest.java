package test;

import model.BoardGames;
import exceptions.NegativePriceException;
import org.junit.jupiter.api.Test;

class BoardGamesTest {

    @Test
    void test1() throws NegativePriceException {
        BoardGame boardGame=new BoardGame("11123456789","My Toy","My Brand",12.9,3,3,"2-3","No-one");
        assertEquals("Category:BoardGame, Serial Number: 11123456789, Name:My Toy, Brand:My Brand, Price:12.9, Available Count:3, Age Appropriate:3, Number Of Players:2-3, Designer(s):No-one");
    }

    @Test
    void test2() throws NegativePriceException {
        try {
            BoardGame boardGame=new BoardGame("11123456789","My Toy","My Brand",-12.9,3,3,"2-3","No-one");
            fail();
        }catch (NegativePriceException e){

        }
    }

}