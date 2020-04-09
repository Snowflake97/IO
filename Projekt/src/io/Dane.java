package io;

import java.time.LocalDate;
import java.util.ArrayList;

public class Dane {


    // uzytkownicy
    public static String[][] daneUzytkownikow = new String[][]{
            {"Anna", "Jopek", "123456789", "987654321", "Wyspianskiego"},
            {"Jan", "Kowalski", "00000000000", "000000000", "Wyspianskiego"},
            {"Pawel", "Nowak", "11111111111", "111111111", "Wyspianskiego"},
            {"Michal", "Rodzyn", "22222222222", "222222222", "Wyspianskiego"},
            {"Michalina", "Rodzyn", "22222222223", "222222223", "Wyspianskiego"}};

    public static Uzytkownik[] uzytkownicy = {
            new Uzytkownik("Anna", "Jopek", "123456789", "987654321", "Wyspianskiego"),
            new Uzytkownik("Jan", "Kowalski", "00000000000", "000000000", "Wyspianskiego"),
            new Uzytkownik("Pawel", "Nowak", "11111111111", "111111111", "Wyspianskiego"),
            new Uzytkownik("Michal", "Rodzyn", "22222222222", "222222222", "Wyspianskiego"),
            new Uzytkownik("Michalina", "Rodzyn", "22222222223", "222222223", "Wyspianskiego"),
    };


    //karty

    public static String[][] numeryKart = new String[][]{
            {"0000000000000000", "0000000000000001", "0000000000000002", "0000000000000003", "0000000000000004"}
    };

    public static Karta[] karty = {
            new Karta("0000000000000000"),
            new Karta("0000000000000001"),
            new Karta("0000000000000002"),
            new Karta("0000000000000003"),
            new Karta("0000000000000004")};


    //rachunki
    public static String[][] daneRachunkow = new String[][]{
            {"0000000000", "500"},
            {"0000000001", "5500"},
            {"0000000002", "3500"},
            {"0000000003", "2500"},
            {"0000000004", "1500"}};

    public static Rachunek[] rachunki = {
            new Rachunek("0000000000", 500),
            new Rachunek("0000000001", 5500),
            new Rachunek("0000000002", 3500),
            new Rachunek("0000000003", 2500),
            new Rachunek("0000000004", 1500)};

    static LocalDate data = LocalDate.parse("2020-01-30");

    // operacje
    public static String[][] daneOperacji = new String[][]{
            {"2020-01-30", "5000", "0000000000", "0000000001"},
            {"2020-01-30", "50.5", "00000000001", "0000000002"},
            {"2020-01-30", "150", "0000000002", "0000000003"},
            {"2020-01-30", "250", "0000000003", "0000000004"},
            {"2020-01-30", "49.99", "0000000004", "0000000000"}};

    public static Operacja[] operacje = {
            new Operacja(data, 5000, "0000000000", "0000000001"),
            new Operacja(data, 50.5, "0000000001", "0000000002"),
            new Operacja(data, 150, "0000000002", "0000000003"),
            new Operacja(data, 250, "0000000003", "0000000004"),
            new Operacja(data, 49.99, "0000000004", "0000000000")};


    public static String[][] loginy = new String[][]{
            {"root"},
            {"root1"},
            {"root2"},
            {"root3"},
            {"root4"}};

    public static String[][] hasla = new String[][]{
            {"root"},
            {"root1"},
            {"root2"},
            {"root3"},
            {"root4"}};

    public static int smsKod = 0000;

    public static int[][] daneKont = new int[][]{
            //uzytkownik, login, haslo, rachunki
            {0, 0, 0, 0},
            {1, 1, 1,1},
            {2, 2, 2, 2},
            {3, 3, 3,3},
            {4, 4, 4,4},
    };
    public static Konto[] konta = {
            new Konto(uzytkownicy[0], 0000, "root", "root"),
            new Konto(uzytkownicy[1], 0000, "root1", "root1"),
            new Konto(uzytkownicy[2], 0000, "root2", "root2"),
            new Konto(uzytkownicy[3], 0000, "root3", "root3"),
            new Konto(uzytkownicy[4], 0000, "root4", "root4")};


}

