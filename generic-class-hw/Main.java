public class Main {
    public static void main(String[] args) {
         testMain1();
        // testMain2();
        // testMain3();
    }

    static void testMain1() {
        MyList<Integer> liste = new MyList<>();
        System.out.println("Dizideki Eleman Sayısı : " + liste.size());
        System.out.println("Dizinin Kapasitesi : " + liste.getCapacity());
        liste.add(10);
        liste.add(20);
        liste.add(30);
        liste.add(40);
        System.out.println("Dizideki Eleman Sayısı : " + liste.size());
        System.out.println("Dizinin Kapasitesi : " + liste.getCapacity());
        liste.add(50);
        liste.add(60);
        liste.add(70);
        liste.add(80);
        liste.add(90);
        liste.add(100);
        liste.add(110);
        System.out.println("Dizideki Eleman Sayısı : " + liste.size());
        System.out.println("Dizinin Kapasitesi : " + liste.getCapacity());

        /* Output must be:
            Dizideki Eleman Sayısı : 0
            Dizinin Kapasitesi : 10
            Dizideki Eleman Sayısı : 4
            Dizinin Kapasitesi : 10
            Dizideki Eleman Sayısı : 11
            Dizinin Kapasitesi : 20
        */
    }
    static void testMain2() {
        MyList<Integer> liste = new MyList<>();
        liste.add(10);
        liste.add(20);
        liste.add(30);
        System.out.println("2. indisteki değer : " + liste.get(2));
        liste.remove(2);
        liste.add(40);
        liste.set(0, 100);
        System.out.println("2. indisteki değer : " + liste.get(2));
        System.out.println(liste.toString());

        /* Output must be:
            2. indisteki değer : 30
            2. indisteki değer : 40
            [100,20,40]
        */
    }
    static void testMain3() {
        MyList<Integer> liste = new MyList<>();
        System.out.println("Liste Durumu : " + (liste.isEmpty() ? "Boş" : "Dolu"));
        liste.add(10);
        liste.add(20);
        liste.add(30);
        liste.add(40);
        liste.add(20);
        liste.add(50);
        liste.add(60);
        liste.add(70);

        System.out.println("Liste Durumu : " + (liste.isEmpty() ? "Boş" : "Dolu"));

        // Bulduğu ilk indeksi verir
        System.out.println("Indeks : " + liste.indexOf(20));

        // Bulamazsa -1 döndürür
        System.out.println("Indeks :" + liste.indexOf(100));

        // Bulduğu son indeksi verir
        System.out.println("Indeks : " + liste.lastIndexOf(20));

        // Listeyi Object[] dizisi olarak geri verir.
        Object[] dizi = liste.toArray();
        System.out.println("Object dizisinin ilk elemanı :" + dizi[0]);

        // Liste veri türünde alt bir liste oluşturdu
        MyList<Integer> altListem = liste.subList(0, 3);
        System.out.println(altListem.toString());

        // Değerim listedeki olup olmadığını sorguladı
        System.out.println("Listemde 20 değeri : " + liste.contains(20));
        System.out.println("Listemde 120 değeri : " + liste.contains(120));

        // Listeyi tamamen boşaltır ve varsayılan boyutuna çevirir
        liste.clear();
        System.out.println(liste.toString());
        System.out.println(altListem.toString());
        System.out.println("altlist cap: " + altListem.getCapacity());

        /* Output must be:
            Liste Durumu : Boş
            Liste Durumu : Dolu
            Indeks : 1
            Indeks :-1
            Indeks : 4
            Object dizisinin ilk elemanı :10
            [10,20,30,40]
            Listemde 20 değeri : true
            Listemde 120 değeri : false
            []
        */
    }
}
