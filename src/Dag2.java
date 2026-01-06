package src;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.io.IOException;

public class Dag2 {

    public static void main(String[] args) throws IOException {
        
        long sum = 0; 

        List<String> lines = Files.readAllLines(Path.of("input_dag2.txt"));

        for (String line : lines) {
            String[] ranges = line.split(","); 
            
            for (String range : ranges) {
                String[] parts = range.split("-"); 

                long start = Long.parseLong(parts[0]);
                long end = Long.parseLong(parts[1]); 

                for (long id = start; id <= end; id++) {
                    if (isInvalidId(id)) {
                        sum += id; 
                    }
                }
            }
          
        }
        System.out.println(sum);
    }

    public static boolean isInvalidId(long n) {
        String s = Long.toString(n); 

        //hvis oddetall antall sifre -> kan ikke være ugyldig
        if (s.length() % 2 != 0) {
            return false; 
        }
        
        int half = s.length() /2; 

        String first = s.substring(0, half);
        String second = s.substring(half);

        return first.equals(second); 
           
    }
}


