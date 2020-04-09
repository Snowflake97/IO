package io;


import java.util.ArrayList;

public class FabrykaKont{

    public Konto stworzNoweKonto(int[] daneKont){
        Uzytkownik uzytkownik = Dane.uzytkownicy[daneKont[0]];
        int smsKod = 0000;
        String login = Dane.loginy[daneKont[1]][0];
        String haslo = Dane.hasla[daneKont[2]][0];


        return new Konto(
                uzytkownik,
                smsKod,
                login,
                haslo
        );
    };
}
