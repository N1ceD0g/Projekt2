import java.util.Random;
import java.util.Scanner;

public class Schiffeversenken {


    public static void spielgenerieren(int[][] spielfeld, int anzahlschiffe_gesamt) {
        Random rd = new Random();
        int randomRow;
        int randomColumn;
        int counterSchiff = 0;

        while (counterSchiff < anzahlschiffe_gesamt) {
            randomRow = rd.nextInt(10);
            randomColumn = rd.nextInt(10);

            if (spielfeld[randomRow][randomColumn] == 0) {
                spielfeld[randomRow][randomColumn] = 1;
                counterSchiff++;


                // Hier mit Zufallszahlen, die gewünschte Anzahl an schiffen auf dem}}
                // Spielfeld verteilen (zahlenwert 1 !)
            }
        }
    }

    public static void spielanzeigen(int[][] spielfeld) {
        System.out.print("Dein Spielfeld:");
        for (int row = 0; row < 10; row++) {
            System.out.println();
            for (int column = 0; column < 10; column++) {
                System.out.print("[" + spielfeld[row][column] + "]\t");

                // diese Funktion soll das Spielfeld formatiert auf der Konsole anzeigen.
            }
        }
    }

    public static boolean trefferchecken(int[][] spielfeld, int tip_reihe, int tip_spalte) {
        if (spielfeld[tip_reihe - 1][tip_spalte - 1] == 1) {
            return true;

        } else {
            return false;

            // Hier Methode soll überprüfen, ob sich auf dem getippten feld (reihe, spalte)
            // ein schiff befindet oder nicht. Wenn sich auf dem feld ein schiff befindet
            // soll die Methode true zurückliefern, andernfalls false.
        }
    }

    public static boolean spielstatus(int[][] spielfeld) {
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                if (spielfeld[row][column] == 1) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] spielfeld = new int[10][10];
        System.out.println("Anzahl der Schiffe am Spielfeld (zwischen 3 und 10) : ");
        int anzahlschiffe_gesamt = sc.nextInt();
        spielgenerieren(spielfeld, anzahlschiffe_gesamt);
        int counter = 0;
        System.out.println();


        while (spielstatus(spielfeld) == true) {
            counter++;
            spielanzeigen(spielfeld);
            System.out.println();
            System.out.println("Tipp Spalte: ");
            int tip_spalte = sc.nextInt();
            System.out.println("Tipp Reihe: ");
            int tip_reihe = sc.nextInt();

            if ((trefferchecken(spielfeld, tip_reihe, tip_spalte)) == true) {
                System.out.println("Getroffen!");
                spielfeld[tip_reihe - 1][tip_spalte - 1] = 9;

            } else {
                System.out.println("Schuss ins Wasser :(");
                spielfeld[tip_reihe - 1][tip_spalte - 1] = 5;
            }

        }
        System.out.println();
        System.out.println("Das Spiel ist vorbei, du hast " + counter + " versuche gebraucht.");
        System.out.println();
        spielanzeigen(spielfeld);
    }
}


// Spielfeld ist Prinzipiell mit 0 befüllt
// 1 auf dem Spielfeld heißt es befindet sich ein Schiff darauf
// 9 ist ein versenktes / getroffenes Schiff
// 5 ist ein Schuß, Treffer im Wasser
// Hier spiel implementieren und obige methoden verwenden
// sie können beliebig viele zusätzliche Methoden schreiben und verwenden