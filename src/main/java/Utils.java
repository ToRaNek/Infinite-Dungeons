package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class Utils {
    

    public static String readString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));             
                
        return br.readLine();
    }


    public static void printAnsi(File file) throws IOException {
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            while(br.ready()) {
                System.out.println(br.readLine());
            }

        } 

    }
}
