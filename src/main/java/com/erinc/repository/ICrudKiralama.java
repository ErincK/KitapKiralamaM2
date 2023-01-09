package com.erinc.repository;

import com.erinc.entity.Kitap;
import com.erinc.entity.Musteri;

import java.util.List;
import java.util.Map;

public interface ICrudKiralama<K> {
    void save(Kitap kitap, Musteri musteri);

    void update(K k);

    void delete(Kitap key);

    Map<Kitap, Musteri> findAll();

    K findById(Long id);




}
