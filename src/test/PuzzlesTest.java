package test;

import model.Puzzles;
import exceptions.NegativePriceException;
import org.junit.jupiter.api.Test;

class PuzzlesTest {

    @Test
    void test1() throws NegativePriceException {
        Puzzle puzzle=new Puzzle("1987654321","My Toy","My Brand",42.9,3,3,"M");
        assertEquals("Category:Puzzle, Serial Number: 1987654321, Name:My Toy, Brand:My Brand, Price:42.9, Available Count:3, Age Appropriate:3, Puzzle Type:M");
    }

    @Test
    void test2() throws NegativePriceException {
        try {
            Puzzle puzzle=new Puzzle("1987654321","My Toy","My Brand",-42.9,3,3,"M");
            fail();
        }catch (NegativePriceException e){

        }
    }

}