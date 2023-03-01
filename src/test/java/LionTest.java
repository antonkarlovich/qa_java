
import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.List;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void shouldReturnTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean actualHasMane = lion.doesHaveMane();
        assertTrue("При создании самца hasMane должно быть true", actualHasMane);
    }

    @Test
    public void shouldReturnFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean actualHasMane = lion.doesHaveMane();
        assertFalse("При создании самки hasMane должно быть false", actualHasMane);
    }

    @Test(expected = Exception.class)
    public void shouldReturnThrowException() throws Exception {
        new Lion("родитель №1", feline);
    }
    @Test
    public void shouldReturnOneKitten() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualCountKitten = lion.getKittens();
        assertEquals("Метод getKittens при использовании без параметров должен вернуть 1",
                1, actualCountKitten);
    }


    @Test
    public void shouldReturnEatForPredator() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные, Птицы, Рыба"));
        List<String> expectedEat = List.of("Животные, Птицы, Рыба");
        List<String> actualEat = lion.getFood();
        assertEquals(expectedEat, actualEat);

    }
}
