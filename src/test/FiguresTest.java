package test;

import model.Figures;
import exceptions.NegativePriceException;
import org.junit.jupiter.api.Test;

class FiguresTest {

    @Test
    void test1() throws NegativePriceException {
        Figure figure=new Figure("1112345678","My Toy","My Brand",69.9,3,3,"A");
        assertEquals("Category:Figure, Serial Number: 1112345678, Name:My Toy, Brand:My Brand, Price:69.9, Available Count:3, Age Appropriate:3, Classification:A");
    }

    @Test
    void test2() throws NegativePriceException {
        try {
            Figure figure=new Figure("1112345678","My Toy","My Brand",-69.9,3,3,"A");
            fail();
        }catch (NegativePriceException e){

        }
    }

}