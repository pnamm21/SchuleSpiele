package org.example.Schachspiel;

import java.util.Scanner;

public class Schachbrett {
    private String[][] brett;
    private Scanner scanner;

    public Schachbrett() {
        brett = new String[8][8];
        initialisiereBrett();
        scanner = new Scanner(System.in);
    }

    private void initialisiereBrett() {
        brett[0][0] = "Turm Schwarz";
        brett[0][1] = "Springer Schwarz";
        brett[0][2] = "Läufer Schwarz";
        brett[0][3] = "Dame Schwarz";
        brett[0][4] = "König Schwarz";
        brett[0][5] = "Läufer Schwarz";
        brett[0][6] = "Springer Schwarz";
        brett[0][7] = "Turm Schwarz";

        brett[7][0] = "Turm Weiß";
        brett[7][1] = "Springer Weiß";
        brett[7][2] = "Läufer Weiß";
        brett[7][3] = "Dame Weiß";
        brett[7][4] = "König Weiß";
        brett[7][5] = "Läufer Weiß";
        brett[7][6] = "Springer Weiß";
        brett[7][7] = "Turm Weiß";

        for (int i = 0; i < 8; i++) {
            brett[1][i] = "Bauer Schwarz";
            brett[6][i] = "Bauer Weiß";
        }
    }

    public void zeigeBrett() {
        System.out.println("  a   b   c   d   e   f   g   h");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                String figur = brett[i][j];
                System.out.print("[" + (figur != null ? figur : "Leer") + "] ");
            }
            System.out.println((8 - i));
        }
        System.out.println("  a   b   c   d   e   f   g   h");
    }

    public void spielStarten() {
        while (true) {
            zeigeBrett();
            System.out.println("Geben Sie Ihren Zug ein (z.B. a2 a3): ");
            String zug = scanner.nextLine();
            String[] teile = zug.split(" ");

            if (teile.length != 2) {
                System.out.println("Ungültiger Zug. Bitte geben Sie Ihren Zug im Format 'von nach' ein.");
                continue;
            }

            String von = teile[0];
            String nach = teile[1];

            // Überprüfen und Ausführen des Zugs
            if (!zugMachen(von, nach)) {
                System.out.println("Ungültiger Zug. Bitte versuchen Sie es erneut.");
            }
        }
    }

    public boolean zugMachen(String von, String nach) {
        int vonZeile = 8 - Character.getNumericValue(von.charAt(1));
        int vonSpalte = von.charAt(0) - 'a';
        int nachZeile = 8 - Character.getNumericValue(nach.charAt(1));
        int nachSpalte = nach.charAt(0) - 'a';

        String figur = brett[vonZeile][vonSpalte];

        if (figur == null) {
            return false; // Ungültiger Zug, keine Figur zum Bewegen
        }

        // Überprüfen der Zugmöglichkeiten für den Bauern
        if (figur.startsWith("Bauer")) {
            if (brett[nachZeile][nachSpalte] == null) {
                if (nachSpalte == vonSpalte && nachZeile == vonZeile - 1) {
                    brett[nachZeile][nachSpalte] = figur; // Figur verschieben
                    brett[vonZeile][vonSpalte] = null; // Ursprüngliche Position leeren
                    return true;
                }
                if (vonZeile == 6 && nachSpalte == vonSpalte && nachZeile == 4) {
                    brett[nachZeile][nachSpalte] = figur;
                    brett[vonZeile][vonSpalte] = null;
                    return true;
                }
            } else if (Math.abs(nachSpalte - vonSpalte) == 1 && nachZeile == vonZeile - 1) {
                brett[nachZeile][nachSpalte] = figur;
                brett[vonZeile][vonSpalte] = null;
                return true;
            }
            return false; // Ungültiger Zug
        }

        // Beispielhafte Zuglogik für den Turm
        if (figur.startsWith("Turm")) {
            if (nachZeile == vonZeile) {
                if (isHorizontalPathClear(vonZeile, vonSpalte, nachSpalte)) {
                    brett[nachZeile][nachSpalte] = figur;
                    brett[vonZeile][vonSpalte] = null;
                    return true;
                }
            } else if (nachSpalte == vonSpalte) {
                if (isVerticalPathClear(vonSpalte, vonZeile, nachZeile)) {
                    brett[nachZeile][nachSpalte] = figur;
                    brett[vonZeile][vonSpalte] = null;
                    return true;
                }
            }
            return false; // Ungültiger Zug für den Turm
        }

        // Hier können weitere Figuren und deren Zuglogik hinzugefügt werden

        return false; // Ungültiger Zug
    }

    private boolean isHorizontalPathClear(int zeile, int startSpalte, int endSpalte) {
        int step = startSpalte < endSpalte ? 1 : -1; // Bestimmen der Richtung
        for (int spalte = startSpalte + step; spalte != endSpalte; spalte += step) {
            if (brett[zeile][spalte] != null) {
                return false; // Ein Hindernis gefunden
            }
        }
        return true; // Pfad ist frei
    }

    private boolean isVerticalPathClear(int startSpalte, int zeile, int endZeile) {
        int step = zeile < endZeile ? 1 : -1; // Bestimmen der Richtung
        for (int z = zeile + step; z != endZeile; z += step) {
            if (brett[z][startSpalte] != null) {
                return false; // Ein Hindernis gefunden
            }
        }
        return true; // Pfad ist frei
    }

    public static void main(String[] args) {
        Schachbrett schach = new Schachbrett();
        schach.spielStarten();
    }
}
