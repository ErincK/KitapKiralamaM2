package com.erinc.utility;

import com.erinc.entity.Musteri;

import java.util.ArrayList;
import java.util.List;

public class MusteriUtility {
    static Long id=0L;
    public static List<Musteri> musteriListesi = new ArrayList<>();


    public MusteriUtility() {

    }


    public static long idOlustur() {
        id++;
        return id;
    }

}
