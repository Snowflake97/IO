package acceptationTests;

import fit.Fixture;
import io.Aplikacja;
import io.Dane;
import io.Konto;
import io.Rachunek;


public class SetUp extends Fixture{
    static Aplikacja aplikacja;
    public SetUp(){
        aplikacja = new Aplikacja();
        Konto konto = new Konto(Dane.uzytkownicy[0], 0000,"root", "root");
        Rachunek rachunek = Dane.rachunki[0];
        konto.dodajRachunek(rachunek);
        konto.setRachunek(rachunek);
        aplikacja.setKonto(konto);
    }

}
