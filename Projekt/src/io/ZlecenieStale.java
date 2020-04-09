package io;

import java.time.LocalDate;

public class ZlecenieStale {
    private String rachunekOdbiorcy;
    private double kwota;
    private int cykl;
    private LocalDate data;

    public ZlecenieStale(String rachunekOdbiorcy, double kwota, int cykl, LocalDate data) {
        this.rachunekOdbiorcy = rachunekOdbiorcy;
        this.kwota = kwota;
        this.cykl = cykl;
        this.data = data;
    }

    public String getRachunekOdbiorcy() {
        return rachunekOdbiorcy;
    }

    public double getKwota() {
        return kwota;
    }

    public int getCykl() {
        return cykl;
    }

    public LocalDate getData() {
        return data;
    }

    public void setRachunekOdbiorcy(String rachunekOdbiorcy) {
        this.rachunekOdbiorcy = rachunekOdbiorcy;
    }

    public void setKwota(double kwota) {
        this.kwota = kwota;
    }

    public void setCykl(int cykl) {
        this.cykl = cykl;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ZlecenieStale{" +
                "rachunekOdbiorcy='" + rachunekOdbiorcy + '\'' +
                ", kwota=" + kwota +
                ", cykl='" + cykl + '\'' +
                ", date=" + data +
                '}';
    }
}
