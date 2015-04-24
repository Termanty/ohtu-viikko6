package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {
    private static final Scanner  lukija = new Scanner(System.in);
    private static IntJoukko A, B, C;

    private static IntJoukko mikaJoukko() {
        String luettu = lukija.nextLine();
        while (true) {
            if (luettu.equalsIgnoreCase("A")) {
                return A;
            } else if (luettu.equalsIgnoreCase("B")) {
                return B;
            } else if (luettu.equalsIgnoreCase("C")) {
                return C;
            } else {
                System.out.println("Virheellinen joukko! " + luettu);
                System.out.print("Yritä uudelleen!");
                luettu = lukija.nextLine();
            }
        }
    }

    private static void lisaa() {
        System.out.print("Mihin joukkoon? ");
        IntJoukko joukko = mikaJoukko();
        System.out.println("");
        System.out.print("Mikä luku lisätään? ");
        int luku = lukija.nextInt();
        joukko.lisaa(luku);
    }

    private static void yhdiste() {
        IntJoukko a, b, c;
        System.out.print("1. joukko? ");
        a = mikaJoukko();
        System.out.print("2. joukko? ");
        b = mikaJoukko();
        c = IntJoukko.yhdiste(a, b);
        System.out.println("A yhdiste B = " + c.toString());
    }

    private static void leikkaus() {
        IntJoukko a, b, c;
        System.out.print("1. joukko? ");
        a = mikaJoukko();
        System.out.print("2. joukko? ");
        b = mikaJoukko();
        c = IntJoukko.leikkaus(a, b);
        System.out.println("A leikkaus B = " + c.toString());
    }

    private static void erotus() {
        IntJoukko a, b, c;
        System.out.print("1. joukko? ");
        a = mikaJoukko();
        System.out.print("2. joukko? ");
        b = mikaJoukko();
        c = IntJoukko.erotus(a, b);
        System.out.println("A erotus B = " + c.toString());
    }

    private static void poista() {
        System.out.print("Mistä joukosta? ");
        IntJoukko joukko = mikaJoukko();
        System.out.print("Mikä luku poistetaan? ");
        joukko.poista(lukija.nextInt());
    }

    private static void kuuluu() {
        System.out.print("Mihin joukkoon? ");
        IntJoukko joukko = mikaJoukko();
        System.out.print("Mikä luku? ");
        int luku = lukija.nextInt();
        if (joukko.kuuluu(luku) >= 0) {
            System.out.println(luku + " kuuluu joukkoon ");
        } else {
            System.out.println(luku + " ei kuulu joukkoon ");
        }
    }

    public static void main(String[] args) {
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();

        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");

        while (true) {
            String luettu = lukija.nextLine();
            if (luettu.equals("lisää") || luettu.equals("li")) {
                lisaa();
            } else if (luettu.equalsIgnoreCase("poista") || luettu.equalsIgnoreCase("p")) {
                poista();
            } else if (luettu.equalsIgnoreCase("kuuluu") || luettu.equalsIgnoreCase("k")) {
                kuuluu();
            } else if (luettu.equalsIgnoreCase("yhdiste") || luettu.equalsIgnoreCase("y")) {
                yhdiste();
            } else if (luettu.equalsIgnoreCase("leikkaus") || luettu.equalsIgnoreCase("le")) {
                leikkaus();
            } else if (luettu.equalsIgnoreCase("erotus") || luettu.equalsIgnoreCase("e")) {
                erotus();
            } else if (luettu.equalsIgnoreCase("A")) {
                System.out.println(A);
            } else if (luettu.equalsIgnoreCase("B")) {
                System.out.println(B);
            } else if (luettu.equalsIgnoreCase("C")) {
                System.out.println(C);
            } else if (luettu.equalsIgnoreCase("lopeta") || luettu.equalsIgnoreCase("quit") || luettu.equalsIgnoreCase("q")) {
                System.out.println("Lopetetaan, moikka!");
                break;
            } else {
                System.out.println("Virheellinen komento! " + luettu);
                System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
            }
            System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
        }
    }
}
