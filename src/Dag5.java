package src;

import java.io.IOException; 
import java.util.List; 
import java.nio.file.Path; 
import java.nio.file.Files; 

public class Dag5 {

    public static void main (String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("input_dag5.txt"));

        int blankIndex = lines.indexOf("");

        List<String> ranges = lines.subList(0, blankIndex);
        List<String> ingredientIds = lines.subList(blankIndex + 1, lines.size());

        int sum = 0; 

        for (String idLine : ingredientIds) {
            long id = Long.parseLong(idLine);

                if (isFresh(id, ranges)) {
                    sum++;   
            }

        }

        System.out.println(sum);

    }

    //en hjelpemetode for å sjekke om id-ingrediens e innenfor id-fresh
    public static boolean isFresh(long id, List<String> ranges) {
        for (String range : ranges) {
            String[] parts = range.split("-");
            long start = Long.parseLong(parts[0]);
            long end = Long.parseLong(parts[1]);

            if (id >= start && id <= end) {
                return true; 
            }
        } 
        return false; 
    }
    
}
