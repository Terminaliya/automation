import org.junit.Test;

public class MainClass {

    private int class_number = 20;
    private String class_string = "Hello, world";

    public String getClassString(){
        return this.class_string;
    }
    public int getLocalNumber(){
        return 14;
    }

    public int getClassNumber (){
        return this.class_number;
    }
}