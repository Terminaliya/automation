import org.junit.Assert;
import org.junit.Test;

public class MainClassTest{

    MainClass mainClass = new MainClass();

    @Test
    public void testGetLocalNumber(){
        int a = mainClass.getLocalNumber();
        if (a < 14){
            System.out.println("Number less than 14");
        } else if (a > 14){
            System.out.println("Number greater than 14");
        } else
            System.out.println("The number is 14");
    }

    @Test
    public void testGetClassNumber(){
        int a = mainClass.getClassNumber();

        if (a > 45){
            System.out.println("Test passed. Number greater than 45"); // Если это ожидаемый результат. А то я не очень поняла условие проверки
        } else
            System.out.println("Test Failed. Number less or equal 45");
    }

    @Test
    public void testGetClassString (){
        String testString = mainClass.getClassString();
        String substring = "Hello"; // можно было бы написать проверку ниже просто с игнорированием регистра, но я не была уверена, что это удовлетворит условию
        String substring2 = "hello";
        
        Assert.assertTrue("The source string doesn`t contain the searched substring",(testString.contains(substring)) || testString.contains(substring2));
    }
}
