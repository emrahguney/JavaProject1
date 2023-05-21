package Modeller.Calisanlar;

import Modeller.Departmanlar.BilisimTeklonojileriDepartmani;
import Modeller.Departmanlar.Departman;
import Modeller.Departmanlar.InsanKaynaklariDepartmani;
import Modeller.Departmanlar.YonetimDepartmani;
import Veritabani.Calisanlar;
import Veritabani.Departmanlar;

import java.util.ArrayList;

public class Calisan {

    private String calisanId;
    private String adSoyad;
    private int maas;
    private Departman Departman;
    private String isimKodu = "";
    private static int sayacId=0;

    public Calisan(String adSoyad, int maas, String departmanKodu) {
        this.adSoyad = adSoyad;
        this.maas = maas;
        setDepartman(departmanKodu);
        this.setCalisanId();
        Calisanlar.addACalisan(this);
    }



    // Kullanicinin departman koduna göre, gerekli departman set edilmelidir.
    private void setDepartman(String departman) {
        /*
            İpucu: Departman listesinin (Veritabani.Departmanlar.DepartmanList) içerisindeki departmanların kodları var,
        bu kodlari donguye tutmak ise yarayabilir.
       */
        for (Departman d:Departmanlar.getDepartmanList()){
            if (d.getDepartmanKodu().equals(departman))
                this.Departman=d;
        }

    }

    // Calisanin ID sinin kendisine özel olduğundan bahsetmistik, ID nin nasil kaydedileceği CalisanKaydetmeProjesiTanıtım.txt
    // içerisinde yer aliyor.
    private void setCalisanId() {
        /*
            İpucu: Detayli anlatim CalisanKaydetmeProjesiTanıtım.txt içerisinde.
         */
//        String ilkparca;
//        for (Departman d:Departmanlar.getDepartmanList()) {
//            if(d instanceof BilisimTeklonojileriDepartmani)
//                ilkparca=Departman.getDepartmanKodu();
//            sayacId=sayacId+1;
//            String sayac=String.valueOf(sayacId);
//        }
        this.calisanId=this.Departman.getDepartmanKodu()+(Calisanlar.getCalisanList().size()+1)+getCalisanIsimKodu();
    }

    // Calisanin ID sinin sonuna isim kodu eklenmesi için, ismi parçalayan bir method.
    private String getCalisanIsimKodu() {
        /*

            Basit string metodlari ise isinice cok yarayacaktir fakat dinamik olmasina dikkat edelim... Mesela 2 isim bir
            soyisim girildiğinde hata vermesin.

         */
        this.isimKodu+=this.adSoyad.charAt(0);
        for (int i = 0; i < adSoyad.length(); i++) {
            if(adSoyad.charAt(i)==' ')
                this.isimKodu+=adSoyad.charAt(i+1);
        }


        return this.isimKodu;
    }

    // Calisanin id sini almak icin basit getter method
    public String getCalisanId() {
        return this.calisanId;
    }

    // Calisanin departmanini almak icin basit getter method
    public Departman getDepartman() {
        return this.Departman;
    }

    // Departman adini verebilmek için bir method
    public String getDepartmanAdi() {
        /*
                İpucu: Departman Kodu YD ise departman adi Yonetim Departmani olarak kaydedilmelidir.
         */
        String dep="";
        if (this.Departman.getDepartmanKodu().equals("YD"))
            dep="Yönetim Departmanı";
        else if (this.Departman.getDepartmanKodu().equals("BTD")) {
            dep="Bilişim Teknolojileri Departmanı";
        } else if (this.Departman.getDepartmanKodu().equals("IKD")) {
            dep="Insan Kaynakları Departmanı";
        }


        return dep;
    }

    // Calisana zam yapilmasi için gerekli bir method
    public static void zamYap(String calisanId) {
        /*

            İpucu: Calisan ID si kullanilarak yapilmalidir, diğer attributelarin aynilarindan 1 er tane daha
            olabilirdi.

         */
        ArrayList<Calisan> cal=Calisanlar.getCalisanList();
        for (int i = 0; i < cal.size(); i++) {
            if (cal.get(i).getCalisanId().equals(calisanId)){
                cal.get(i).maas+=(cal.get(i).maas*cal.get(i).Departman.getZamOrani())/100;
            }
        }
    }

    @Override
    public String toString() {
        return "Calisan{" +
                "calisanId='" + calisanId + '\'' +
                ", adSoyad='" + adSoyad + '\'' +
                ", maas=" + maas +
                ", Departman=" + getDepartmanAdi() +
                ", isimKodu='" + isimKodu + '\'' +
                '}';
    }
}
