package io;

//import org.junit.jupiter.api.Test;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FabrykaKontTest {

    @Test
    public void stworzNoweKonto() {
        FabrykaKont fabrykaKont = new FabrykaKont();

        for (int i=0; i<5; i++){
            Konto exp_result = Dane.konta[i];
            Konto result = fabrykaKont.stworzNoweKonto(Dane.daneKont[i]);


            assertEquals(exp_result.getUzytkownik(), result.getUzytkownik());
            assertEquals(exp_result.getSmsKod(), result.getSmsKod());
            assertEquals(exp_result.getLogin(), result.getLogin());
            assertEquals(exp_result.getHaslo(), result.getHaslo());
            System.out.println("Konta zgodne");
        }

    }
}