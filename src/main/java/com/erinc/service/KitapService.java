package com.erinc.service;

import com.erinc.entity.Kitap;
import com.erinc.repository.KitapRepository;

import java.util.List;

public class KitapService {

    private final KitapRepository kitapRepository;

    public KitapService() {
        super();
        this.kitapRepository = new KitapRepository();
    }

    public void save(Kitap kitap){
        kitapRepository.save(kitap);
    }

    public void save(String kitapAdi, String yazar, int sayfaSayisi) {
        Kitap kitap = new Kitap();
        kitap.setAd(kitapAdi);
        kitap.setYazar(yazar);
        kitap.setSayfaSayisi(sayfaSayisi);

        kitapRepository.save(kitap);
    }

    public void delete(Long id) {
        kitapRepository.delete(id);
    }

    public void update(Kitap kitap) {
        kitapRepository.update(kitap);
    }

    public List<Kitap> findAll() {
        return kitapRepository.findAll();
    }

    public Kitap findById(Long id) {
        return kitapRepository.findById(id);
    }






}
