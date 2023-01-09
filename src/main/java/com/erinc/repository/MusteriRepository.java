package com.erinc.repository;

import com.erinc.entity.Musteri;
import java.util.List;

import static com.erinc.utility.MusteriUtility.*;

public class MusteriRepository implements ICrud<Musteri> {

    public MusteriRepository(){
        for (int i = 0; i < 10; i++) {
            musteriListesi.add(new Musteri("Ahmet"+String.valueOf(i),"musterisoyad"+String.valueOf(i)));
        }
    }


    @Override
    public void save(Musteri musteri) {
        musteriListesi.add(musteri);
    }

    @Override
    public void update(Musteri musteri) {
        for (int i = 0; i < musteriListesi.size(); i++) {
            if(musteriListesi.get(i).getId().equals(musteri.getId())){
                musteriListesi.set(i,musteri);
                break;
            }
        }
    }

    @Override
    public void delete(Long id) {
        for (int i = 0; i < musteriListesi.size(); i++) {
            if(musteriListesi.get(i).getId().equals(id)) {
                musteriListesi.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Musteri> findAll() {
        return musteriListesi;
    }

    @Override
    public Musteri findById(Long id) {
        for (int i = 0; i < musteriListesi.size(); i++) {
            if(musteriListesi.get(i).getId()==id) {
                return musteriListesi.get(i);
            }
        }
        return null;
    }
}
