package src;

import java.io.IOException; 
import java.util.List; 
import java.nio.file.Files; 
import java.nio.file.Path; 


public class Dag3 {

    public static void main (String[] args) throws IOException {

        int sum = 0; 

        List<String> lines = Files.readAllLines(Path.of("input_dag3.txt")); 

        for (String line : lines) { 
                sum += toSiffer(line);
        }
    
        //sum må ta i bruk toSiffre metoden for å legge samen riktige tall
        System.out.println(sum); 
    }

    public static int toSiffer(String n) {
        //oppretter en siffer variabel
        int siffer = 0; 

        //en for løkke som iterer gjennom og henter det første sifferet
        for (int i = 0; i < n.length() - 1; i++) {
            //definerer at det er det første, og gjør om char til tall
            int forste = n.charAt(i) - '0';

            //løkke for å finne det andre sifferet, starter på i+1 for de skal ikke kunne rearrangeres
            for (int j = i + 1; j < n.length(); j++) {
                //definerer det som siffer to, og gjør om til tall
                int andre = n.charAt(j) - '0'; 

                //finner verdien av tallene, ganger det første sifferet med 10 slik at det blir et sammenhengende tall, og ikke to siffer
                int verdi = forste * 10 + andre; 

                //hvis verdien er høyere enn sifferet vi har, skal sifferet få ny verdi. 
                if (verdi > siffer) {
                    siffer = verdi; 
                }

            }
        }

        //skriv ut de to høyeste sifferne fra stringen
        return siffer; 
    }
    
}
