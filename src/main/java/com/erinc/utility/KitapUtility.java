package com.erinc.utility;

import com.erinc.entity.Kitap;

import java.util.ArrayList;
import java.util.List;

public class KitapUtility {

    static Long id=0L;
    public static List<Kitap> kitapListesi = new ArrayList<>();

    public KitapUtility(){


    }






    public static long idOlustur() {
        id++;
        return id;
    }


}
