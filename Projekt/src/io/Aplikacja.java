package io;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Aplikacja {
    private ArrayList<Konto> konta;
    private Konto konto;
    private Scanner input;

    public Aplikacja() {
        this.konta = new ArrayList<Konto>();
        this.input = new Scanner(System.in);
    }

    public ArrayList<Konto> getKonta() {
        return konta;
    }

    public void setKonta(ArrayList<Konto> konta) {
        this.konta = konta;
    }

    public Konto getKonto() {
        return konto;
    }

    public Aplikacja setKonto(Konto konto) {
        this.konto = konto;
        return null;
    }

    public void dodajKonto(Konto konto) {
        this.konta.add(konto);
    }

    public void logowanie() {
        System.out.println("LOGOWANIE\n");

        System.out.println("Wprowadz login: ");
        String login = input.nextLine();

        System.out.println("Wprowadz haslo: ");
        String haslo = input.nextLine();

        for (Konto item : konta) {
            if ((login.equals(item.getLogin())) & (haslo.equals(item.getHaslo()))) {
                System.out.println("Zalogowano pomyslnie, witaj " + item.getUzytkownik().getImie() + "\n");
                this.setKonto(item);
                break;
            }
        }

        if (getKonto() == null) {
            System.out.println("Wprowadzono bledne dane\n");
            this.logowanie();
        } else {
            this.menuUzytkownika();
        }
    }

    public void menuUzytkownika() {
        System.out.println("Menu\n1.Wyswietl historie\n2.Sprawdz saldo\n3.Zamow karte\n4.Doladuj telefon\n5.Zrob przelew\n6.Zmien haslo\n7.Zlecenia stale\n8.Karty platnicze\n\n0.Zakoncz");
        //zrobPrzelew();
        int choise = Integer.parseInt(input.nextLine());
        switch (choise) {
            case 1:
                this.wyswietlHistorie();
                break;
            case 2:
                this.sprawdzSaldo();
                break;
            case 3:
                this.zamowKarte();
                break;
            case 4:
                this.doladowania();
                break;
            case 5:
                this.przelewy();
                break;
            case 6:
                this.zmianaHasla();
                break;
            case 7:
                this.wyswietlZleceniaStale();
                break;
            case 8:
                this.wyswietlKarty();
                break;
            case 0:
                break;
        }
    }

    public void wyswietlHistorie() {
        this.konto.wybierzRachunek();
        Rachunek rachunek = konto.getRachunek();
        System.out.println("Operacje: " + rachunek.getOperacje());
        this.menuUzytkownika();
    }

    public void sprawdzSaldo() {
        this.konto.wybierzRachunek();
        Rachunek rachunek = konto.getRachunek();
        System.out.println("Saldo: " + rachunek.getSaldo());
        this.menuUzytkownika();
    }

    public void zamowKarte() {
        System.out.println("Dodaj karte do rachunku");
        this.konto.wybierzRachunek();

        this.konto.wyslijSms();
        this.konto.wprowadzSms();
        if (this.konto.getSmsKod() == this.konto.getWprowadzonySmsKod()) {
            String numerKarty = wygenerujNumerKarty();
            this.konto.dodajKarte(numerKarty);
        }
        this.menuUzytkownika();
    }

    public void doladowania() {
        System.out.println("Wprowadz numer telefonu: ");
        String numerTelefonu = input.nextLine();
        if (numerTelefonu.length() != 9) {
            this.konto.wyswietlKomunikat();
        } else {
            System.out.println("Wprowadz kwote: ");
            String kwota = input.nextLine();
            Double kwotaDouble = Double.parseDouble(kwota);

            this.konto.wybierzRachunek();
            if (this.konto.getRachunek().getSaldo() < kwotaDouble) {
                this.konto.wyswietlKomunikat();
            } else {
                this.konto.wyslijSms();
                this.konto.wprowadzSms();
                if (this.konto.getSmsKod() == this.konto.getWprowadzonySmsKod()) {
                    this.konto.doladujTelefon(numerTelefonu, kwotaDouble);
                } else {
                    this.konto.wyswietlKomunikat();
                }
            }
        }
        this.menuUzytkownika();
    }

    public void przelewy() {
        System.out.println("Przelew cykliczny?(y/n): ");
        String cykliczny = input.nextLine();

        System.out.println("Wprowadz numer rachunku odbiorcy: ");
        String rachunekOdbiorcy = input.nextLine();

        if (rachunekOdbiorcy.length() != 10) {
            this.konto.wyswietlKomunikat();
        } else {
            System.out.println("Wprowadz kwote: ");
            String kwota = input.nextLine();
            Double kwotaDouble = Double.parseDouble(kwota);

            this.konto.wybierzRachunek();
            this.konto.wyslijSms();
            this.konto.wprowadzSms();
            if (this.konto.getSmsKod() == this.konto.getWprowadzonySmsKod()) {
                if (cykliczny.equals("n")) {
                    if (this.konto.getRachunek().getSaldo() < kwotaDouble) {
                        this.konto.wyswietlKomunikat();
                    } else {
                        this.konto.zrobPrzelew(rachunekOdbiorcy, kwotaDouble);
                    }
                }
                else  {
                    LocalDate data = this.wybierzDate();
                    int cykl = this.wybierzCykl();
                    this.konto.zlecPrzelewCykliczny(rachunekOdbiorcy, kwotaDouble, cykl, data);
                }
            }
        }
        this.menuUzytkownika();
    }

    public void zmianaHasla() {
        Scanner input = new Scanner(System.in);

        System.out.println("Wprowadz stare haslo: ");
        String stareHaslo = input.nextLine();

        if (!stareHaslo.equals(this.konto.getHaslo())) {
            this.konto.wyswietlKomunikat();
        }
        else {
            System.out.println("Wprowadz nowe haslo: ");
            String noweHaslo1 = input.nextLine();
            System.out.println("Powtorz haslo: ");
            String noweHaslo2 = input.nextLine();
            if ((noweHaslo1.equals(noweHaslo2)) & (this.konto.sprawdzHasloZeStandardami(noweHaslo1))) {
                this.konto.setHaslo(noweHaslo1);
            } else {
                this.konto.wyswietlKomunikat();
            }
        }
        this.menuUzytkownika();
    }

    public void wyswietlZleceniaStale() {
        this.konto.wybierzRachunek();
        System.out.println(this.konto.getRachunek().getZleceniaStale());
        this.menuUzytkownika();
    }

    public void wyswietlKarty() {
        this.konto.wybierzRachunek();
        System.out.println(this.konto.getRachunek().getKarty());
        this.menuUzytkownika();
    }

    public LocalDate wybierzDate() {
        System.out.println("Data pierwszego przelewu");
        System.out.println("Wprowadz dzien: ");
        int day = Integer.parseInt(input.nextLine());

        System.out.println("Wprowadz miesiac: ");
        int month = Integer.parseInt(input.nextLine());
        String nameOfMonth = new String();
        switch (month) {
            case 1:
                nameOfMonth = "JANUARY";
                break;
            case 2:
                nameOfMonth = "FEBRUARY";
                break;
            case 3:
                nameOfMonth = "MARCH";
                break;
            case 4:
                nameOfMonth = "APRIL";
                break;
            case 5:
                nameOfMonth = "MAY";
                break;
            case 6:
                nameOfMonth = "JUNE";
                break;
            case 7:
                nameOfMonth = "JULY";
                break;
            case 8:
                nameOfMonth = "AUGUST";
                break;
            case 9:
                nameOfMonth = "SEPTEMBER";
                break;
            case 10:
                nameOfMonth = "OCTOBER";
                break;
            case 11:
                nameOfMonth = "NOVEMBER";
                break;
            case 12:
                nameOfMonth = "DECEMBER";
                break;
        }

        System.out.println("Wprowadz rok: ");
        int year = Integer.parseInt(input.nextLine());

        LocalDate data = LocalDate.of(year, Month.valueOf(nameOfMonth), day);
        return data;
    }

    public int wybierzCykl() {
        System.out.println("Podaj ilosc dni cyklu: ");
        int cykl = Integer.parseInt(input.nextLine());
        return cykl;
    }

    public String wygenerujNumerKarty() {
        String number = "";
        Random rand = new Random();
        for (int i = 0; i < 16; i++) {
            int randomNum = rand.nextInt(10);
            String Stringnum = Integer.toString(randomNum);
            number = number + Stringnum;
        }
        return number;
    }

    @Override
    public String toString() {
        return "Aplikacja{" +
                "konto=" + konto +
                '}';
    }
}
