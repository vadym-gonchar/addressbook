package barancev;


import org.testng.Assert;
import org.testng.annotations.Test;

public class RectangleTest {
  @Test
  public void testArea(){
    Square s = new Square(5);
    Assert.assertEquals(s.area(), 25);
  }
}
