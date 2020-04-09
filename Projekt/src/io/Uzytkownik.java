package io;

public class Uzytkownik {
    private String imie;
    private String nazwisko;
    private String numer_telefonu;
    private String pesel;
    private String adres;

    public Uzytkownik(String imie, String nazwisko, String numer_telefonu, String pesel, String adres) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numer_telefonu = numer_telefonu;
        this.pesel = pesel;
        this.adres = adres;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getNumer_telefonu() {
        return numer_telefonu;
    }

    public String getPesel() {
        return pesel;
    }

    public String getAdres() {
        return adres;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setNumer_telefonu(String numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Uzytkownik{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", numer_telefonu='" + numer_telefonu + '\'' +
                ", pesel='" + pesel + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }
}
