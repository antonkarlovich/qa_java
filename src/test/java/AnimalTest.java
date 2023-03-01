import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import java.util.List;

@RunWith(Parameterized.class)
public class AnimalTest {
    private final String checkedTextAnimalKind;
    private final List<String> expectedTextFood;


    public AnimalTest(String checkedTextAnimalKind, List<String> expectedTextFood) {
        this.checkedTextAnimalKind = checkedTextAnimalKind;
        this.expectedTextFood = expectedTextFood;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        };
    }

    @Test
    public void shouldReturnGetCorrectListFood() throws Exception {
        Animal animal = new Animal();
        List<String> actualFood = animal.getFood(checkedTextAnimalKind);
        assertEquals("Еда должна соответствовать отряду животного",expectedTextFood, actualFood);
    }

    @Test(expected = Exception.class)
    public void shouldReturnThrowException() throws Exception {
        Animal animal = new Animal();
        animal.getFood("Неизвестное животное");
    }

    @Test
    public void shouldReturnCorrectFamily() {
        Animal animal = new Animal();
        String checkText = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actualText = animal.getFamily();
        assertEquals("Список семейств отличается",checkText, actualText);
    }
}
