package com.erinc.entity;

import java.util.ArrayList;
import java.util.List;

public class Musteri extends BaseEntity {

    String musteriAdi;
    String musteriSoyadi;


    List<Kitap> kitapListesi = new ArrayList<>();



    @Override
    public String toString() {
        return "Musteri{" +
                "musteriAdi='" + musteriAdi + '\'' +
                ", musteriSoyadi='" + musteriSoyadi + '\'' +
                ", kitapListesi=" + kitapListesi +
                '}';
    }

    public Musteri(String musteriAdi, String musteriSoyadi) {
        this.musteriAdi = musteriAdi;
        this.musteriSoyadi = musteriSoyadi;
        this.kitapListesi = kitapListesi;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = musteriAdi;
    }

    public String getMusteriSoyadi() {
        return musteriSoyadi;
    }

    public void setMusteriSoyadi(String musteriSoyadi) {
        this.musteriSoyadi = musteriSoyadi;
    }

    public List<Kitap> getKitapListesi() {
        return kitapListesi;
    }

    public void setKitapListesi(List<Kitap> kitapListesi) {
        this.kitapListesi = kitapListesi;
    }
}
