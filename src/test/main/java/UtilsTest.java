package test.main.java;

import java.io.File;
import java.io.IOException;
import main.java.Utils;


public class UtilsTest {
    
    File file;
    String path =  System.getProperty("user.dir") + File.separator + "res" + File.separator + "test" +  File.separator + "test.utf.ans"  + File.separator;

    public static void main(String[] args) throws IOException{
        File f = new  File(System.getProperty("user.dir") + File.separator + "res" + File.separator + "test" +  File.separator + "test.utf.ans"  + File.separator);
        Utils.printAnsi(f);
    }
    
}
