import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTest {
    private final int countKitten;
    private final int countExpected;

    public FelineTest(int countKitten, int countActual) {
        this.countKitten = countKitten;
        this.countExpected = countActual;
    }

    @Test
    public void eatMeatShouldGetListForPredator() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = feline.eatMeat();
        List<String> actualFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Должен быть представлен список еды для хищника", expectedFood, actualFood);
    }

    @Test
    public void getFamilyShouldGetFeline() {
        Feline feline = new Feline();
        assertEquals("Метод должен возвращать \"Кошачьи\"", "Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensNotParamShouldReturnOneKitten() {
        Feline feline = new Feline();
        int actualCountKitten = feline.getKittens();
        assertEquals("Метод должен возвращать 1", 1, actualCountKitten);
    }


    @Parameterized.Parameters
    public static Object[][] getKittenCount() {
        return new Object[][] {
                {0, 0},
                {1, 1},
                {2, 2}
        };
    }

    @Test
    public void getKittensWithParam() {
        Feline feline = new Feline();
        int actualCount = feline.getKittens(countKitten);
        assertEquals("Количество котят не совпадает",countExpected, actualCount);
    }
}
