package com.erinc.controller;

import com.erinc.Exceptions.ErrorType;
import com.erinc.Exceptions.KiralamaExc;
import com.erinc.entity.Kitap;
import com.erinc.entity.Musteri;
import com.erinc.service.KiralamaService;
import com.erinc.service.KitapService;
import com.erinc.service.MusteriService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Controller {

    private static Scanner sc;
    private final KitapService kitapService;
    private final MusteriService musteriService;
    private final KiralamaService kiralamaService;

    public Controller() {
        kitapService = new KitapService();
        musteriService = new MusteriService();
        kiralamaService = new KiralamaService();
    }

//    public void save() {
//
//        sc = new Scanner(System.in);
//        System.out.println("Lutfen kitap adi giriniz...: ");
//        String ad = sc.nextLine();
//        System.out.println("Lutfen yazar adi giriniz...: ");
//        String yazar = sc.nextLine();
//        System.out.println("Lutfen kitap sayfa sayisi giriniz...: ");
//        int sayfaSayisi = sc.nextInt();
//
//        kitapService.save(ad,yazar,sayfaSayisi);
//    }

    public void findAll() {
        for (Kitap kitap: kitapService.findAll()) {
            System.out.println("Kitabin Adi.............: " + kitap.getAd());
            System.out.println("Kitabin Sayfa Sayisi:...: " + kitap.getSayfaSayisi());
            System.out.println("Kitabin Yayin Evi Adi...: " + kitap.getYazar());
        }
    }

    public void kiralamaYap() {

        System.out.println("Kitap ismi girin");
        sc = new Scanner(System.in);
        String kitapadi = sc.nextLine();
        System.out.println("Musteri ismi girin");
        String musteriadi = sc.nextLine();

        Kitap k = null;
        Musteri m = null;
        for (int i=0; i<kitapService.findAll().size();i++)
        {
            if(kitapService.findAll().get(i).getAd().equals(kitapadi))
            {
                k = kitapService.findAll().get(i);
            }
        }

        for (int i = 0; i<musteriService.findAll().size(); i++)
        {
            if(musteriService.findAll().get(i).getMusteriAdi().equals(musteriadi))
            {
                m = musteriService.findAll().get(i);
            }
        }

        kiralamaService.kirala(k,m);
    }
    public void kiralananKitapListesi() {

        kiralamaService.findAll().forEach((k,v) -> {

            System.out.println(k.getCreateDate()+ "-" +k.getAd()+ " ==> " +v.getMusteriAdi());
        });
    }

    private void kitapAra() {
        System.out.println("Aramak istediginiz kitap ismi girin.");
        sc = new Scanner(System.in);
        String arananKitap = sc.nextLine();

        boolean varmi =false;
        for(int i=0;i<kitapService.findAll().size();i++) {
            if(kitapService.findAll().get(i).getAd().equals(arananKitap)){
                varmi = true;
            }
        }

        if(varmi){
            System.out.println("Evet, kitap var. Naaapacan?");
        }else {
            throw new KiralamaExc(ErrorType.ERROR_NOTFOUND_BYID);
        }
    }

    private void musteriAra() {
        System.out.println("Aramak istediginiz musteri ismi girin.");
        sc = new Scanner(System.in);
        String arananMusteri = sc.nextLine();

        boolean varmi =false;
        for(int i=0;i<musteriService.findAll().size();i++) {
            if(musteriService.findAll().get(i).getMusteriAdi().equals(arananMusteri)){
                varmi = true;
            }
        }
        if(varmi){
            System.out.println("Evet, musteeri var. Sesleneyim mi?");
        }else {
            throw new KiralamaExc(ErrorType.ERROR_INVALID_PARAMETER);
        }
    }
    private void kitapKimde() {
        System.out.println("Hangi kitap lazım haci?.");
        sc = new Scanner(System.in);
        String kiralanmisKitap = sc.nextLine();

        AtomicReference<Boolean> varmi = new AtomicReference<>(false);
        kiralamaService.findAll().forEach((k,v) -> {
            if(k.getAd().equals(kiralanmisKitap))
            {
                varmi.set(true);
                System.out.println("Kitap su anda "+ v.getMusteriAdi() + " isimli musteride");
            }
        });

        if(!varmi.get())
            throw new KiralamaExc(ErrorType.ERROR_EMPTY);
    }

    private void kitapKimdebyId() {

        System.out.println("Kitap id girin");
        sc = new Scanner(System.in);
        int kiralanmisKitap = sc.nextInt();

        AtomicReference<Boolean> varmi = new AtomicReference<>(false);
        kiralamaService.findAll().forEach((k,v) -> {
            System.out.println("Kiralanan Kitaplar Id Listesi");
            System.out.println("Id " + k.getId());
            if(k.getId() == kiralanmisKitap)
            {
                varmi.set(true);
                System.out.println("Kitap su anda "+ v.getMusteriAdi() + " isimli musteride");
            }
        });

        if(!varmi.get()) {
            System.out.println("Kiralanan kitaplar arasinda boyle bir kitap namevcut");
            throw new KiralamaExc(ErrorType.ERROR_EMPTY);
        }
    }
    private void ahmIleBaslayan() {

        List<String> ahmIleBaslayanlar = new ArrayList<>();
        for(int i=0;i<musteriService.findAll().size();i++) {
            if(musteriService.findAll().get(i).getMusteriAdi().contains("Ahm")){
                ahmIleBaslayanlar.add(musteriService.findAll().get(i).getMusteriAdi());
            }
        }
        if(ahmIleBaslayanlar.size() > 0){
            System.out.println("ismi Ahm ile baslayan musteriler");
            for(int i=0;i<ahmIleBaslayanlar.size();i++)
                System.out.println(ahmIleBaslayanlar.get(i));
        }else {
            System.out.println("Ahm ile baslayan musteri yok");
            throw new KiralamaExc(ErrorType.ERROR);

        }
    }
    private void musterininKiraladiklari() {
        System.out.println("Hangi musteri lazim bacenek?");
        sc = new Scanner(System.in);
        String musteriAdi = sc.nextLine();

        AtomicReference<Boolean> varmi = new AtomicReference<>(false);
        System.out.println(musteriAdi + " isimli musterinin kiraladiklari");
        kiralamaService.findAll().forEach((k,v) -> {
            if(v.getMusteriAdi().equals(musteriAdi))
            {
                varmi.set(true);
                System.out.println(k.getCreateDate() +"-"+ k.getAd() + " id:" + k.getId());
            }
        });

        if(!varmi.get())
            System.out.println("Kiralanan kitaplar arasinda boyle bir kitap namevcut");
    }


    public static void run() {
        Controller controller = new Controller();
        sc = new Scanner(System.in);
        int secim = 0;

        do{
            System.out.println("Lutfen bir secim yapiniz.");
            System.out.println("1- Kiralama Yap");
            System.out.println("2- Kitap Ara");
            System.out.println("3- Musteri Ara");
            System.out.println("4- Kiralanan Kitap Listesi");
            System.out.println("5- Kitabı Kim Kiralamis?");
            System.out.println("6- Kitabı Kimler Kiralamis?");
            System.out.println("7- ahm ile Baslayan Musteriler");
            System.out.println("8- Musterinin Kiraladigi Kitap Listesi");
            System.out.println("0- Cikis");
            secim = sc.nextInt();
            switch (secim) {
                case 1: controller.kiralamaYap();
                    break;
                case 2: controller.kitapAra();
                    break;
                case 3: controller.musteriAra();
                    break;
                case 4: controller.kiralananKitapListesi();
                    break;
                case 5: controller.kitapKimdebyId();
                    break;
                case 6: controller.kitapKimde();
                    break;
                case 7: controller.ahmIleBaslayan();
                    break;
                case 8: controller.musterininKiraladiklari();
                    break;
                case 0:
                    System.out.println("Cikis Yapiliyor.");
                default:
                    System.out.println("Lutfen Gecerli Bir Secim Yapiniz.");
                    break;
            }
        }while(secim != 0);

    }




}
