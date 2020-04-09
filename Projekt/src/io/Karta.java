package io;

public class Karta {
    private String numer_karty;

    public Karta(String numer_karty) {
        this.numer_karty = numer_karty;
    }

    public String getNumer_karty() {
        return numer_karty;
    }

    public void setNumer_karty(String numer_karty) {
        this.numer_karty = numer_karty;
    }

    @Override
    public String toString() {
        return "Karta{" +
                "numer_karty='" + numer_karty + '\'' +
                '}';
    }
}
