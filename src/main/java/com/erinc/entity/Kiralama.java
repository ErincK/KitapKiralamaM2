package com.erinc.entity;

import java.util.HashMap;
import java.util.Map;

public class Kiralama extends BaseEntity {

    double kiralamaFiyati;
    Long kiralamaZamani;
    // key:kitap , value: musteri

    Long kiraSuresi;

    public Kiralama() {
    }

    public Kiralama(Long id, Long createDate, Long updateDate, boolean isActive, int state, double kiralamaFiyati, Long kiralamaZamani, String kiralayanAdi, Long kiraSuresi) {
        super(id, createDate, updateDate, isActive, state);
        this.kiralamaFiyati = kiralamaFiyati;
        this.kiralamaZamani = kiralamaZamani;

        this.kiraSuresi = kiraSuresi;
    }

    public double getKiralamaFiyati() {
        return kiralamaFiyati;
    }

    public void setKiralamaFiyati(double kiralamaFiyati) {
        this.kiralamaFiyati = kiralamaFiyati;
    }

    public Long getKiralamaZamani() {
        return kiralamaZamani;
    }

    public void setKiralamaZamani(Long kiralamaZamani) {
        this.kiralamaZamani = kiralamaZamani;
    }



    public Long getKiraSuresi() {
        return kiraSuresi;
    }

    public void setKiraSuresi(Long kiraSuresi) {
        this.kiraSuresi = kiraSuresi;
    }
}