package org.example.Schachspiel;

import java.util.Scanner;

public class Spiel {
    private Schachbrett schachbrett;
    private boolean weissterZug = true; // true = Weiß am Zug, false = Schwarz am Zug

    public Spiel() {
        schachbrett = new Schachbrett();
    }

    // Methode zur Anzeige der Spielanweisungen
    private void zeigeAnweisungen() {
        System.out.println("Willkommen zum Schachspiel!");
        System.out.println("Spielanweisungen:");
        System.out.println("Geben Sie Ihre Züge im Format 'e2 e4' ein.");
        System.out.println("Beispiele für Züge:");
        System.out.println("  e2 e4 - Bewegt den Bauern von e2 nach e4");
        System.out.println("  d2 d4 - Bewegt den Bauern von d2 nach d4");
        System.out.println("  g1 f3 - Bewegt den Springer von g1 nach f3");
        System.out.println("Tipps:");
        System.out.println("  - Weiß zieht zuerst.");
        System.out.println("  - Züge müssen gültig sein.");
        System.out.println("  - Schachmatt beendet das Spiel.");
        System.out.println("Viel Spaß!");
        System.out.println();
    }

    public void starteSpiel() {
        Scanner scanner = new Scanner(System.in);

        // Anweisungen anzeigen
        zeigeAnweisungen();

        while (true) {
            schachbrett.zeigeBrett();
            System.out.println((weissterZug ? "Weiß" : "Schwarz") + " ist am Zug. Geben Sie Ihren Zug ein (z.B. e2 e4): ");
            String zug = scanner.nextLine();
            String[] zuege = zug.split(" ");
            if (zuege.length == 2) {
                String von = zuege[0];
                String nach = zuege[1];
                if (schachbrett.zugMachen(von, nach)) {
                    // Wechsel der Zugseite
                    weissterZug = !weissterZug;
                } else {
                    System.out.println("Ungültiger Zug. Bitte versuchen Sie es erneut.");
                }
            } else {
                System.out.println("Bitte geben Sie den Zug im richtigen Format ein.");
            }
        }
    }

    public static void main(String[] args) {
        Spiel spiel = new Spiel();
        spiel.starteSpiel();
    }
}
