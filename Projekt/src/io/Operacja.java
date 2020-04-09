package io;

import java.time.LocalDate;

public class Operacja {
    private LocalDate data;
    private double kwota;
    private String rachunekNadawcy;
    private String rachunekOdbiorcy;

    public Operacja(LocalDate data, double kwota, String rachunekNadawcy, String rachunekOdbiorcy) {
        this.data = data;
        this.kwota = kwota;
        this.rachunekNadawcy = rachunekNadawcy;
        this.rachunekOdbiorcy = rachunekOdbiorcy;
    }

    public LocalDate getData() {
        return data;
    }

    public double getKwota() {
        return kwota;
    }

    public String getRachunekNadawcy() {
        return rachunekNadawcy;
    }

    public String getRachunekOdbiorcy() {
        return rachunekOdbiorcy;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setKwota(double kwota) {
        this.kwota = kwota;
    }

    public void setRachunekNadawcy(String rachunekNadawcy) {
        this.rachunekNadawcy = rachunekNadawcy;
    }

    public void setRachunekOdbiorcy(String rachunekOdbiorcy) {
        this.rachunekOdbiorcy = rachunekOdbiorcy;
    }

    @Override
    public String toString() {
        return "Operacja{" +
                "data=" + data +
                ", kwota=" + kwota +
                ", rachunek_nadawcy='" + rachunekNadawcy + '\'' +
                ", rachunek_odbiorcy='" + rachunekOdbiorcy + '\'' +
                '}';
    }
}
