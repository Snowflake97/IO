package acceptationTests;

import fit.ColumnFixture;
import java.util.IllegalFormatCodePointException;


public class TestDoladowaniaTelefonu extends ColumnFixture {
    String numer;
    double kwota;

    public boolean doladowanie() throws IllegalFormatCodePointException {
        int index = SetUp.aplikacja.getKonto().getRachunek().getOperacje().size();

        if (numer.length() == 9 && kwota <= getSaldo()) {
            SetUp.aplikacja.getKonto().doladujTelefon(numer, kwota);
            if (SetUp.aplikacja.getKonto().getRachunek().getOperacje().get(index).getKwota() == kwota) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public double getSaldo() {
        return SetUp.aplikacja.getKonto().getRachunek().getSaldo();
    }

}
