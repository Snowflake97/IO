package io;

import java.util.ArrayList;

public class Rachunek {
    private String numerRachunku;
    private ArrayList<Karta> karty;
    private ArrayList<Operacja> operacje;
    private ArrayList<ZlecenieStale> zleceniaStale;
    private double Saldo;


    public Rachunek(String numerRachunku, double saldo) {
        this.numerRachunku = numerRachunku;
        this.karty = new ArrayList<Karta>();
        this.operacje = new ArrayList<Operacja>();
        this.zleceniaStale = new ArrayList<ZlecenieStale>();
        Saldo = saldo;
    }

    public String getNumerRachunku() {
        return numerRachunku;
    }

    public ArrayList<Karta> getKarty() {
        return karty;
    }

    public ArrayList<Operacja> getOperacje() {
        return operacje;
    }

    public ArrayList<ZlecenieStale> getZleceniaStale() {
        return zleceniaStale;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setNumerRachunku(String numerRachunku) {
        this.numerRachunku = numerRachunku;
    }

    public void setSaldo(double saldo) {
        Saldo = saldo;
    }

    public void pomniejszSaldo(double kwota) {
        Saldo = Saldo - kwota;
    }

    @Override
    public String toString() {
        return "Rachunek{" +
                "numer_rachunku='" + numerRachunku + '\'' +
                ", karty=" + karty +
                ", operacje=" + operacje +
                ", zleceniaStale=" + zleceniaStale +
                ", Saldo=" + Saldo +
                '}';
    }

    public void dodajKarte(Karta karta) {
        karty.add(karta);
    }

    public void dodajOperacje(Operacja operacja) {
        operacje.add(operacja);
    }

    public void dodajZlecenie(ZlecenieStale zlecenie) {
        zleceniaStale.add(zlecenie);
    }

}
