package acceptationTests;

import fit.ColumnFixture;
import java.util.IllegalFormatCodePointException;



public class TestDodawaniaKarty extends ColumnFixture{
    String numer;

    public boolean dodajKarte() throws IllegalFormatCodePointException {
        int size = SetUp.aplikacja.getKonto().getRachunek().getKarty().size();
        SetUp.aplikacja.getKonto().dodajKarte(numer);
        if(SetUp.aplikacja.getKonto().getRachunek().getKarty().size() == size+1){
            return true;
        }
        else {
            return false;
        }
    }

}
