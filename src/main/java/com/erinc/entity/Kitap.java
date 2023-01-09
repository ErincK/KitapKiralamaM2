package com.erinc.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Kitap extends BaseEntity {
    String ad;
    String yazar;
    int sayfaSayisi;

    List<LocalDateTime> kiralayanListesi = new ArrayList<>();

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public int getSayfaSayisi() {
        return sayfaSayisi;
    }

    public void setSayfaSayisi(int sayfaSayisi) {
        this.sayfaSayisi = sayfaSayisi;
    }

    public List<LocalDateTime> getKiralayanListesi() {
        return kiralayanListesi;
    }

    public void setKiralayanListesi(List<LocalDateTime> kiralayanListesi) {
        this.kiralayanListesi = kiralayanListesi;
    }

    @Override
    public String toString() {
        return "Kitap{" +
                "ad='" + ad + '\'' +
                ", yazar=" + yazar +
                ", sayfaSayisi=" + sayfaSayisi +
                '}';
    }

    public Kitap() {
    }

    public Kitap(String ad, String yazar, int sayfaSayisi) {
        this.ad = ad;
        this.yazar = yazar;
        this.sayfaSayisi = sayfaSayisi;
    }

}