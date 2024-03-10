import model.Animals;
import exceptions.NegativePriceException;
import org.junit.jupiter.api.Test;

class AnimalsTest {

    @Test
    void test1() throws NegativePriceException {
        Animal animal=new Animal("1234567890","My Toy","My Brand",42.3,3,3,"Wooden","L");
        assertEquals("Category:Animal, Serial Number: 1234567890, Name:My Toy, Brand:My Brand, Price:42.3, Available Count:3, Age Appropriate:3, Material:Wooden, Size:L");
    }
/**
 * This is a testing for the NegativePriceException.
 * If a negative number is added in place of the price, it will fail.
 * The try & catch will display the NegativePriceException message, should the test fail.
 */
    @Test
    void test2() throws NegativePriceException {
        try {
            Animal animal=new Animal("1234567890","My Toy","My Brand",-42.3,3,3,"Wooden","L");
            fail();
        }catch (NegativePriceException e){

        }
    }

}