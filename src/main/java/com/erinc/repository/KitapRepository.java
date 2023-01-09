package com.erinc.repository;

import com.erinc.entity.Kitap;
import java.util.List;

import static com.erinc.utility.KitapUtility.*;


public class KitapRepository implements ICrud<Kitap>{

    public KitapRepository() {
        for(int i=0;i<20;i++)
            kitapListesi.add(new Kitap("kitap"+String.valueOf(i), "yazar"+String.valueOf(i),25*i+25));
    }

    @Override
    public void save(Kitap kitap) {
        kitapListesi.add(kitap);
    }

    @Override
    public void update(Kitap kitap) {
        for (int i = 0; i < kitapListesi.size(); i++) {
            if(kitapListesi.get(i).getId().equals(kitap.getId())){
                kitapListesi.set(i,kitap);
                break;
            }
        }
    }

    @Override
    public void delete(Long id) {
        for (int i = 0; i < kitapListesi.size(); i++) {
            if(kitapListesi.get(i).getId().equals(id)) {
                kitapListesi.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Kitap> findAll() {
        return kitapListesi;
    }

    @Override
    public Kitap findById(Long id) {
        for (int i = 0; i < kitapListesi.size(); i++) {
            if(kitapListesi.get(i).getId()==id) {
                return kitapListesi.get(i);
            }
        }
        return null;
    }
}
