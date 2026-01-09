package src;

import java.nio.file.Files; 
import java.nio.file.Path; 
import java.util.List; 
import java.io.IOException; 

public class Dag1 {
    public static void main (String[] args) throws IOException {

        int sum = 0; 
        int pos = 50; 

        List<String> lines = Files.readAllLines(Path.of("input_dag1.txt")); 
        
        for (String line : lines) { 
            int steps = Integer.parseInt(line.substring(1)); 
            int nyPos; 
            if (line.startsWith("L")) {
                nyPos = (pos - steps + 100) %100;
            } else {
                nyPos = (pos + steps + 100) %100; 
            } 
            pos = nyPos;
            if (pos == 0) {
            sum++;
        }
        }
        System.out.println(sum);
    }
}  
