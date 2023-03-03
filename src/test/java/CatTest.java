import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CatTest {

    @Test
    public void getSoundShouldGetMeow() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        String expectedGetSound = "Мяу";
        String actualGetSound = cat.getSound();
        assertEquals("Звук, который издает кошка - Мяу",expectedGetSound, actualGetSound);
    }

    @Test
    public void getFoodShouldListForPredator() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        List<String> expectedFood = cat.getFood();
        List<String> actualFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals("У кошки должен быть набор еды для хищника", expectedFood, actualFood);
    }
}
