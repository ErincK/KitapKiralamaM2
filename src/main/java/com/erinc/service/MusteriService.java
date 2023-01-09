package com.erinc.service;

import com.erinc.entity.Musteri;
import com.erinc.repository.MusteriRepository;
import java.util.List;

public class MusteriService  {
    private final MusteriRepository musteriRepository;

    public MusteriService() {
        super();
        this.musteriRepository = new MusteriRepository();
    }

    public void save(Musteri musteri){
        musteriRepository.save(musteri);
    }

    public void save(String musteriAdi, String musteriSoyadi) {
        Musteri musteri = new Musteri(musteriAdi, musteriSoyadi);

        musteriRepository.save(musteri);
    }

    public void delete(Long id) {
        musteriRepository.delete(id);
    }

    public void update(Musteri musteri) {
        musteriRepository.update(musteri);
    }

    public List<Musteri> findAll() {
        return musteriRepository.findAll();
    }

    public Musteri findById(Long id) {
        return musteriRepository.findById(id);
    }









}
