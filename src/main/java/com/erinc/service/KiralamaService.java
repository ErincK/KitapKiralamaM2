package com.erinc.service;

import com.erinc.entity.Kitap;
import com.erinc.entity.Musteri;
import com.erinc.repository.KiralamaRepository;
import com.erinc.repository.KitapRepository;

import java.util.Map;

public class KiralamaService {
    private final KiralamaRepository kiralamapRepository;

    public KiralamaService() {

        kiralamapRepository = new KiralamaRepository();
    }


    public void kirala(Kitap k, Musteri m)
    {

        kiralamapRepository.save(k,m);
    }

    public Map<Kitap, Musteri> findAll() {
        return kiralamapRepository.findAll();
    }
}
