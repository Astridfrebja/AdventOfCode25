package src;

import java.io.IOException; 
import java.util.List; 
import java.nio.file.Path; 
import java.nio.file.Files; 

public class Dag5 {

    public static void main (String[] args) throws IOException {
        //Leser gjennom alle linjene
        List<String> lines = Files.readAllLines(Path.of("input_dag5.txt"));

        /*
        finner indeksen til den tomme linjen som skiller ranges og 
        ingredient id
        */
        int blankIndex = lines.indexOf("");

        //Oppretter en liste med alle fresh-ranges (linjen før den tomme linjen)
        List<String> ranges = lines.subList(0, blankIndex);
        //Oppretter en liste for ingrediens Id-ene
        List<String> ingredientIds = lines.subList(blankIndex + 1, lines.size());

        //teller antall fresh ingredienser
        int sum = 0; 

        /*
        en for-løkke for gjennomgang av ingredienser og hvorvidt de er 
        gode eller ikke
        */
        for (String idLine : ingredientIds) {
            /*
            bruker long istedet for int for lange heltall, parser ingredient
            ID fra tekst til tall
            */
            long id = Long.parseLong(idLine);

                /*
                en if-løkke som sjekker hvorvidt ingrediensene er innenfor
                grensen
                */
                if (isFresh(id, ranges)) {
                    //hvis ingrediensene enda er gode legges det til i sum
                    sum++;   
            }

        }

        //printer ut antall gode ingredienser
        System.out.println(sum);

    }

    //en hjelpemetode for å sjekke om id-ingrediens er innenfor id-fresh
    public static boolean isFresh(long id, List<String> ranges) {
        //en for-løkke for å dele opp linjene i ranges
        for (String range : ranges) {
            //splitter de med "-"
            String[] parts = range.split("-");
            //start
            long start = Long.parseLong(parts[0]);
            //slutt
            long end = Long.parseLong(parts[1]);

            //sjekker om ingrediens id-en er innenfor rangen
            if (id >= start && id <= end) {
                //returner true hvis den er innenfor
                return true; 
            }
        } 
        //returnerer false hvis ikke
        return false; 
    }
    
}
