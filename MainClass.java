import org.junit.Test;

public class MainClass {

    @Test
    public void numberEquality(){
        int a = this.getLocalNumber(); //в данном случае можно ведь и без this?
        if (a < 14){
            System.out.println("Number less than 14");
        } else if (a > 14){
            System.out.println("Number greater than 14");
        } else System.out.println("The number is 14");
    }

    public int getLocalNumber(){
        return 14;
    }
}
