package src;

import java.io.IOException; 
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List; 


public class Dag4 {
    public static void main (String[] args) throws IOException {

        //oppretter en tom variabel sum
        int sum = 0; 

        //Leser gjennom input fra oppgaven
        List<String> lines = Files.readAllLines(Path.of("input_dag4.txt"));

        //en for løkke som itererer gjennom alle radene 
        for (int rad = 0; rad < lines.size(); rad++) {
            //en linje er en string, altså en rad
            String line = lines.get(rad);

            //en for løkke som iterer gjennom kolonnene
            for (int kol = 0; kol < line.length(); kol++) {
                //char for å sjekke tegnene i kolonenne
                char rute = line.charAt(kol);

                //sjekker om denne ruten er en papirrull
                if (ledig(rute)) {
                    //sjekker 8 posisjoner, teller hvor mange papirruller 
                    //som er i de posisjonene
                    int naboer = sjekkNabo(lines, rad, kol);

                    //en if løkke som sier at hvis det er mindre er 4 naboer
                    //så legger du den til i sum
                    if (naboer < 4) {
                        sum++; 
                    }
                }
            }
        }
        //skriv ut summen av papirruller vi får tak i 
        System.out.println(sum);
        }


    //en hjelpemetode som sjekke om den e papirrull eller ikke
    public static boolean ledig(char rute) {
        //skal returnere true dersom den har en papirrull
        return rute == '@';
    }

    //en hjelpemetode for å sjekke hvor mange ledige plasser er vedsiden 
    //av papirrullen
    public static int sjekkNabo(List<String> grid, int rad, int kol) {
        //Teller antall naboer som er papiruller
        int count = 0; 

        //for-løkke som går gjennom rad-offets (-1, 0, 1)
        for (int dr = -1; dr <= 1; dr++) {
            //for løkke som går gjennom kolonne-offsets (-1, 0, 1)
            for (int dk = -1; dk <= 1; dk++) {

                //hopper over selve ruten, sjekker bare naboer
                if (dr == 0 && dk == 0) {
                    continue; 
                }
                //Beregner posisjonen til naboen
                int nyRad = rad + dr;
                int nyKol = kol + dk; 

                //sjekker at nabo-posisjonen er innenfor rutenettet
                if (nyRad >= 0 && nyRad < grid.size() && nyKol >= 0 && nyKol < grid.get(nyRad).length()) {
                   
                    //hvis naboen inneholder en papirrull, øk telleren
                    if (grid.get(nyRad).charAt(nyKol) == '@') {
                        count++;    
                    }
                }
            }
        }
        //returnerer totalt antall papirruller 
        return count; 

    }

    
}
