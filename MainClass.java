import org.junit.Test;

public class MainClass {

    private int class_number = 20;
    public int getLocalNumber(){
        return 14;
    }

    public int getClassNumber (){
        return this.class_number;
    }

    @Test
    public void mainClassTest(){
        int a = this.getLocalNumber(); //в данном случае можно ведь и без this?
        if (a < 14){
            System.out.println("Number less than 14");
        } else if (a > 14){
            System.out.println("Number greater than 14");
        } else System.out.println("The number is 14");
    }

    @Test
    public void testGetClassNumber(){
        int a = getClassNumber();

        if (a > 45){
            System.out.println("Test passed. Number greater than 45"); // Если это ожидаемый результат. А то я не очень поняла условие проверки
        } else
            System.out.println("Test Failed. Number less or equal 45");
    }
}