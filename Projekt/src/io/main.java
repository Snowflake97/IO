package io;

import java.time.LocalDate;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
//        Uzytkownik root = new Uzytkownik("Jan", "Kowalski", "123456789", "00000000000", "Wyspianskiego 0/0");
//
//        Operacja op = new Operacja(LocalDate.now(), 97.65, "1111111111", "1111111112");
//        Karta karta = new Karta("0000000000000000");
//        Karta karta2 = new Karta("0000000000000001");
//        Rachunek rachunek = new Rachunek("1111111111", 500000.00);
//        rachunek.pomniejszSaldo(50);
//        rachunek.dodajKarte(karta);
//        rachunek.dodajKarte(karta2);
//        rachunek.dodajOperacje(op);
//        Konto konto = new Konto(root, 0000, "root", "root");
//        konto.dodajRachunek(rachunek);
//
//        Aplikacja appka = new Aplikacja();
//        appka.dodajKonto(konto);
//
//        appka.logowanie();

        Dane dane = new Dane();
//        Konto konto = dane.konta[0];
//        Aplikacja appka = new Aplikacja();
//        appka.dodajKonto(konto);
//        appka.logowanie();
        FabrykaKont fab = new FabrykaKont();
        Konto konto = fab.stworzNoweKonto(dane.daneKont[1]);
        System.out.println(konto);

    }
}
