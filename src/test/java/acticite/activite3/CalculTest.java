package acticite.activite3;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculTest {
@Test
public void testSomme() { assertEquals(5,Calcul.somme(2,3)); }
@Test
public void testDivision() { assertEquals(4,Calcul.division(8,2)); }
}
