
public class Test03 {

    public static void main(String[] args) {
        PostniNaslov[] naslovi = new PostniNaslov[9];
        naslovi[0] = new PostniNaslov("Sprednja 7", 1000, "Ljubljana");
        naslovi[1] = new PostniNaslov("Zadnja 11",  2000, "Maribor");
        naslovi[2] = new PostniNaslov("Zgornja 6",  3000, "Celje");
        naslovi[3] = new PostniNaslov("Spodnja 9",  4000, "Kranj");
        naslovi[4] = new PostniNaslov("Velika 10",  5000, "Nova Gorica");
        naslovi[5] = new PostniNaslov("Mala 2",     6000, "Koper");
        naslovi[6] = new PostniNaslov("Sprednja 8", 1000, "Ljubljana");
        naslovi[7] = new PostniNaslov("Zadnja 11",  2000, "Maribor");
        naslovi[8] = new PostniNaslov("Sprednja 7", 2000, "Maribor");

        Oseba anka   = new Oseba("Anka Avbelj",     52, naslovi[5]);
        Oseba branko = new Oseba("Branko Brezovar", 58, naslovi[3]);
        Oseba cvetka = new Oseba("Cvetka Cajzek",   79, naslovi[4]);
        Oseba drago  = new Oseba("Drago Debeljak",  48, naslovi[5]);
        Oseba ema    = new Oseba("Ema Ertl",        31, naslovi[0]);
        Oseba franci = new Oseba("Franci Frelih",   28, naslovi[1]);
        Oseba gregor = new Oseba("Gregor Golob",    33, naslovi[0]);
        Oseba helga  = new Oseba("Helga Hojnik",    56, naslovi[5]);
        Oseba iva    = new Oseba("Iva Ihan",        33, naslovi[0]);
        Oseba janko  = new Oseba("Janko Jelenc",    72, naslovi[2]);
        Oseba katja  = new Oseba("Katja Kobal",     26, naslovi[0]);

        // -- Vzajemne skupine prijateljev:
        //    -- Anka, Branko, Drago, Helga
        //    -- Cvetka, Janko
        //    -- Ema, Gregor, Iva
        //
        // -- Asimetri"cna prijateljstva:
        //    -- Ema --> Katja
        //    -- Katja --> Franci

        anka.nastaviPrijatelje(new Oseba[]{branko, drago, helga});
        branko.nastaviPrijatelje(new Oseba[]{anka, drago, helga});
        cvetka.nastaviPrijatelje(new Oseba[]{janko});
        drago.nastaviPrijatelje(new Oseba[]{anka, branko, helga});
        ema.nastaviPrijatelje(new Oseba[]{gregor, iva, katja});
        franci.nastaviPrijatelje(new Oseba[]{});
        gregor.nastaviPrijatelje(new Oseba[]{ema, iva});
        helga.nastaviPrijatelje(new Oseba[]{anka, branko, drago});
        iva.nastaviPrijatelje(new Oseba[]{gregor, ema});
        janko.nastaviPrijatelje(new Oseba[]{cvetka});
        katja.nastaviPrijatelje(new Oseba[]{franci});

        // vse osebe, zbrane v tabeli
        Oseba[] osebe = {
            anka, branko, cvetka, drago, ema, franci, gregor, helga, iva, janko, katja
        };

        for (int i = 0;  i < osebe.length;  i++) {
            System.out.println(osebe[i].toString());
        }
    }
}
