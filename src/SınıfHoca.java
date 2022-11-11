
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SınıfHoca {
    public static final File notDefteri = new File("notlar/notDefteri");

    public static void main(String[] args) {
        
        System.out.println("Vize 1 notu girmek icin 1e basiniz. ");
        System.out.println("Vize 2 notu girmek icin 2e basiniz: ");
        System.out.println("Final notu girmek icin 3e basiniz: ");
        System.out.println("Harf notunu hesaplamak icin 4e basiniz: ");
        System.out.println("Ogrencinin not durumunu goruntulemek icin 5e basiniz: ");
        System.out.println("Cikmak icin 6' ya basiniz: ");
        
        Scanner klavye = new Scanner(System.in);
        int tercih = klavye.nextInt();

        while (tercih != 6) {
            switch (tercih) {
            case (1): {
                System.out.println("Ogrencinin numarasini giriniz");
                String ogrenciNo = klavye.next();
                System.out.println("Ogrencinin notunu giriniz");
                int not = klavye.nextInt();
                notGir(ogrenciNo, not, tercih);

                break;
            }
            case (2): {
                System.out.println("Ogrencinin numarasini giriniz");
                String ogrenciNo = klavye.next();
                System.out.println("Ogrencinin notunu giriniz");
                int not = klavye.nextInt();
                notGir(ogrenciNo, not, tercih);

                break;
            }
            case (3): {
                System.out.println("Ogrencinin numarasini giriniz");
                String ogrenciNo = klavye.next();
                System.out.println("Ogrencinin notunu giriniz");
                int not = klavye.nextInt();
                notGir(ogrenciNo, not, tercih);

                break;
            }
            case (4): {
                System.out.println("Ogrencinin numarasini giriniz");
                String ogrenciNo = klavye.next();
                notGir(ogrenciNo, 9 , tercih);

                break;
            }
            case (6): {
            	//System.out.println("tesekkurler");
            	break;
            	
            }
            }

            if (tercih != 6) {
                System.out.println("Isleminiz tamamlandi. Tekrar tercih yapiniz.");
                System.out.println("Vize 1 notu girmek icin 1e basiniz. ");
                System.out.println("Vize 2 notu girmek icin 2e basiniz: ");
                System.out.println("Final notu girmek icin 3e basiniz: ");
                System.out.println("Harf notunu hesaplamak icin 4e basiniz: ");
                System.out.println("Ogrencinin not durumunu goruntulemek icin 5e basiniz: ");
                System.out.println("Cikmak icin 6a basiniz: ");
                tercih = klavye.nextInt();
            }
        }
        
    }


    public static void notGir(String ogrenciNo, int not, int sinavTuru) {
        // Sinav Turu: 1 Vize1, 2 Vize2, 3 Final, 4 HarfNotu
        try {
            BufferedReader okuyucu = new BufferedReader(new FileReader(notDefteri));

            String metin = "";
            String satir = "";
            boolean ogrenciBulunduMu = false;
            while ((satir = okuyucu.readLine()) != null) {

            
                int cizgiSayaci = 0;
                if (satir.substring(0, 3).equals(ogrenciNo)) {
                    ogrenciBulunduMu = true;
                    if (sinavTuru < 4) {
                        for (int i = 0; i < satir.length(); i++) {
                            if (satir.charAt(i) == '-') {
                                cizgiSayaci++;
                            }
                        }
                        if (cizgiSayaci == sinavTuru + 1)
                            satir += "\t- " + not;
                        else if (cizgiSayaci == sinavTuru)
                            System.out.println("Ogrencinin onceki sinavlari girilmeden yeni sinav notu eklenemez");
                        else if (cizgiSayaci >= sinavTuru + 2)
                            System.out.println("Ogrencinin notu daha onceden girilmis.");
                    } else if (sinavTuru == 4) {
                        String satirYedek = satir.replace("\t", "");
                        satirYedek = satirYedek.replace(" ", "");
                        String[] notDizisi = satirYedek.split("-");

                        if (notDizisi.length == 6) {
                            double vize1Notu = Double.parseDouble(notDizisi[3]);
                            double vize2Notu = Double.parseDouble(notDizisi[4]);
                            double finalNotu = Double.parseDouble(notDizisi[5]);

                            double harfNotu = vize1Notu * 0.25 + vize2Notu * 0.25 + finalNotu * 0.50;
                            satir += "\t- " + harfNotu;
                        } else if (notDizisi.length < 6) {
                            System.out.println("Ogrencinin onceki sinavlari girilmeden yeni sinav notu eklenemez");
                        } else if (notDizisi.length > 6) {
                            System.out.println("Ogrencinin notu daha onceden girilmis.");
                        }
                    }
                }
                metin += satir + "\n";
            }
            
            if (!ogrenciBulunduMu) {
                System.out.println("Girilen ogrenci numarasi tasiyan bir ogrenci bulunamadi!");
            }
            okuyucu.close();
            
            BufferedWriter yazici = new BufferedWriter(new FileWriter(notDefteri));
            yazici.write(metin);
            yazici.close();
        } catch (IOException ioe) {
        	System.out.println("IOException hatasi var.");
        }
     
    }
}