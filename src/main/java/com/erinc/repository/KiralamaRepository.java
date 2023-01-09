package com.erinc.repository;

import com.erinc.entity.Kiralama;
import com.erinc.entity.Kitap;
import com.erinc.entity.Musteri;

import static com.erinc.utility.KiralamaUtility.*;


import java.util.List;
import java.util.Map;

public class KiralamaRepository implements ICrudKiralama<Kiralama> {



    @Override
    public void save(Kitap kitap, Musteri musteri) {
        kiralamaMap.put(kitap,musteri);
    }

    @Override
    public void update(Kiralama kiralama) {

    }


    @Override
    public void delete(Kitap key) {

    }

    @Override
    public Map<Kitap, Musteri> findAll() {
        return kiralamaMap;
    }

    @Override
    public Kiralama findById(Long id) {
        return null;
    }
}
