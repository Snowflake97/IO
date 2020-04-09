package io;

import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
//import org.junit.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class KontoTest {

    static Dane dane;
    static Konto konto;
    static Rachunek rachunek;
    static String numerTelefonu;
    static double kwota;
    static double saldo;

    @BeforeAll
    static public void SetUp(){
        dane = new Dane();
    }

    @Mock
    ZlecenieStale zlecenie = new ZlecenieStale("1111000000",25.11,30,LocalDate.now());

    @Test
    public void doladujTelefon() {
        for (int i=0; i<5; i++) {
            konto = dane.konta[i];
            rachunek = dane.rachunki[i];
            konto.dodajRachunek(rachunek);
            konto.setRachunek(rachunek);
            numerTelefonu = dane.daneUzytkownikow[i][2];
            kwota = 500;

            int index = konto.getRachunek().getOperacje().size();
            Operacja operacja = new Operacja(LocalDate.now(),kwota, rachunek.getNumerRachunku(), numerTelefonu);
            saldo = konto.getRachunek().getSaldo();


            konto.doladujTelefon(numerTelefonu, kwota);
            Operacja operacjaZHistorii = konto.getRachunek().getOperacje().get(index);

            assertEquals(operacja.getData(), operacjaZHistorii.getData());
            assertEquals(operacja.getKwota(), operacjaZHistorii.getKwota());
            assertEquals(operacja.getRachunekNadawcy(), operacjaZHistorii.getRachunekNadawcy());
            assertEquals(operacja.getRachunekOdbiorcy(),operacja.getRachunekOdbiorcy());
            System.out.println("Operacja dodana zgodna");

            assertEquals(saldo - kwota, konto.getRachunek().getSaldo());
            System.out.println("Pomniejszenie salda zgodne");
        }
    }

    @Test
    public void zlecPrzelewCyklicznyMock() {
        for (int i=0; i<5; i++) {
            konto = dane.konta[i];
            rachunek = dane.rachunki[i];
            konto.dodajRachunek(rachunek);
            konto.setRachunek(rachunek);
            String rachunekOdbiorcy = dane.daneRachunkow[i][0];
            kwota = 234;
            int index = konto.getRachunek().getZleceniaStale().size();
            konto.zlecPrzelewCykliczny(rachunekOdbiorcy,kwota,10, LocalDate.now());
            konto.getRachunek().dodajZlecenie(zlecenie);

            assertNotEquals(konto.getRachunek().getZleceniaStale().get(index).getRachunekOdbiorcy(), zlecenie.getRachunekOdbiorcy());

        }
    }
}