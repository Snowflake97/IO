package io;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Konto {
    private Uzytkownik uzytkownik;
    private ArrayList<Rachunek> rachunki;
    private Rachunek rachunek;
    private int smsKod;
    private String login;
    private String haslo;
    private int wprowadzonySmsKod;


    public int getWprowadzonySmsKod() {
        return wprowadzonySmsKod;
    }

    public void setWprowadzonySmsKod(int wprowadzonySmsKod) {
        this.wprowadzonySmsKod = wprowadzonySmsKod;
    }

    public Konto(Uzytkownik uzytkownik, int smsKod, String login, String haslo) {
        this.uzytkownik = uzytkownik;
        this.rachunki = new ArrayList<Rachunek>();
        this.smsKod = smsKod;
        this.login = login;
        this.haslo = haslo;
    }

    public Konto(Uzytkownik uzytkownik, ArrayList<Rachunek> rachunki, int smsKod, String login, String haslo) {
        this.uzytkownik = uzytkownik;
        this.rachunki = rachunki;
        this.smsKod = smsKod;
        this.login = login;
        this.haslo = haslo;
    }

    public Konto() {
    }

    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public ArrayList<Rachunek> getRachunki() {
        return rachunki;
    }

    public void setRachunki(ArrayList<Rachunek> rachunki) {
        this.rachunki = rachunki;
    }

    public Rachunek getRachunek() {
        return rachunek;
    }

    public void setRachunek(Rachunek rachunek) {
        this.rachunek = rachunek;
    }

    public int getSmsKod() {
        return smsKod;
    }

    public void setSmsKod(int smsKod) {
        this.smsKod = smsKod;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public void wyslijSms() {
        this.smsKod = 0000;
    }

    public boolean sprawdzHasloZeStandardami(String haslo) {
        boolean result = true;

        String array[] = new String[]{"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+"};

        if (haslo.length() < 8) {
            result = false;
        }

        for (String item : array) {
            if (haslo.contains(item)) {
                result = true;
                break;
            } else {
                result = false;
            }
        }
        if (result == true) {
            return true;
        } else {
            return false;
        }
    }

    public void wybierzRachunek() {
        Scanner input = new Scanner(System.in);
        if (rachunki.size() != 0) {
            int i = 0;
            System.out.println("Dostepne rachunki: ");

            for (Rachunek item : rachunki) {
                i++;
                System.out.println(i + ". " + item.getNumerRachunku());
            }

            System.out.println("Wybierz rachunek: ");
            int choise = input.nextInt();
            choise = choise - 1;
            System.out.println(rachunki.size());
            if (choise >= rachunki.size()) {
                System.out.println("Nie ma takiego rachunku");
            } else {
                System.out.println("Wybrano aktualny rachunek: " + rachunki.get(choise).getNumerRachunku());
                this.setRachunek(rachunki.get(choise));
            }
        } else {
            System.out.println("Brak rachunkow");
        }
    }

    public void dodajRachunek(Rachunek rachunek) {
        rachunki.add(rachunek);
    }

    public void wyswietlKomunikat() {
        System.out.println("Error!");
    }

    public void dodajKarte(String numerKarty) {
        if(numerKarty.length()==16) {
            Karta karta = new Karta(numerKarty);
            Rachunek rachunek = getRachunek();
            rachunek.dodajKarte(karta);
            System.out.println("Do rachunku " + this.getRachunek().getNumerRachunku() + " dodano karte o numerze: " + karta.getNumer_karty());
        }
    }

    public void doladujTelefon(String numerTelefonu, double kwota) {
        if(getRachunek().getSaldo()>=kwota && numerTelefonu.length() == 9) {
            this.rachunek.pomniejszSaldo(kwota);
            Operacja operacja = new Operacja(LocalDate.now(), kwota, rachunek.getNumerRachunku(), numerTelefonu);
            this.rachunek.dodajOperacje(operacja);
        }
    }

    public void zrobPrzelew(String rachunekOdbiorcy, double kwota) {
        this.rachunek.pomniejszSaldo(kwota);
        Operacja operacja = new Operacja(LocalDate.now(), kwota, rachunek.getNumerRachunku(), rachunekOdbiorcy);
        this.rachunek.dodajOperacje(operacja);
    }

    public void zlecPrzelewCykliczny(String rachunekOdbiorcy, double kwota, int cykl, LocalDate data) {
        ZlecenieStale zlecenie = new ZlecenieStale(rachunekOdbiorcy, kwota, cykl, data);
        this.rachunek.dodajZlecenie(zlecenie);
    }

    public void wprowadzSms() {
        Scanner input = new Scanner(System.in);
        System.out.println("Wprowadz sms kod");
        String smsKod = input.nextLine();
        this.setWprowadzonySmsKod(Integer.parseInt(smsKod));
    }

    @Override
    public String toString() {
        return "Konto{" +
                "uzytkownik=" + uzytkownik +
                ", rachunki=" + rachunki +
                ", rachunek=" + rachunek +
                ", smsKod=" + smsKod +
                ", login='" + login + '\'' +
                ", haslo='" + haslo + '\'' +
                '}';
    }


}
