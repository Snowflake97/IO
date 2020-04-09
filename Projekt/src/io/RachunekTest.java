package io;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(MockitoJUnitRunner.class)
public class RachunekTest {

    private static final String NUMER_RACHUNKU = "NUMER_RACHUNKU";
    @Mock
    private Karta karta = new Karta("1230000000000000000");
    @Mock
    private Operacja operacja = Dane.operacje[0];


    @Test
    public void dodajOperacje() {

        for (int i = 0; i < 5; i++) {
            Rachunek rachunek = Dane.rachunki[i];
            int size = rachunek.getOperacje().size();
            Operacja operacja = Dane.operacje[i];
            rachunek.dodajOperacje(operacja);
            System.out.println(operacja);
            assertEquals(rachunek.getOperacje().get(size), operacja);
            System.out.println("Operacja dodana do historii");
        }

    }

    @Test
    public void dodajKarte() {

        for (int i = 0; i < 5; i++) {
            Rachunek rachunek = Dane.rachunki[i];
            rachunek.dodajKarte(karta);
            assertEquals(rachunek.getKarty().get(0), karta);
            System.out.println("Zmockowana karta dodana");
        }

    }

    @Test
    public void dodajOperacjeMock() {
        for (int i = 0; i < 5; i++) {
            Rachunek rachunek = Dane.rachunki[i];
            int size = rachunek.getOperacje().size();
            rachunek.dodajOperacje(operacja);
            System.out.println(operacja);
            assertEquals(rachunek.getOperacje().get(size), operacja);
            System.out.println("Operacja dodana do historii");
        }
    }
}