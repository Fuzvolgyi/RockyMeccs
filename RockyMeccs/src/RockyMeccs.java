/*
 A meccs körökre van osztva. Minden körben mindkét játékos üt
 egyet. 
 Az ütés erőssége egy 1-10-ig terjedő skálán mozog (véletlenszerűen). Ezen érték aztán
 levonásra kerül az ütést fogadó játékos erőnléti pontjaiból. A meccs kezdetén mindkét szereplőnek
 100-100 erőnléti pontja van. Amennyiben valakinek ez az érték eléri a 0-t az nem képes többet ütni
 és a meccs véget ér. Természetesen a másik lesz a győztes. Egy körben az ütés sorrendje szintén
 véletlenszerűen dől el.

 Az ütéseket ki kell írni a képernyőre a következő módon:
 páros erősségű ütés: [név] bal horgot vitt be.
 páratlan erősségű ütés: [név] jobb egyenessel támadott

 Ken: Abban az esetben, ha az ütés erőssége kisebb mint 5 annak értékét 20% eséllyel meg tudja
 növelni eggyel. Ezt csak minden második ilyen ütés esetén teheti meg.

 Rocky: A meccs folyamán egyszer amennyiben erőnléte 20 alá csökken 30% eséllyel szerezhet plusz
 20 erőnléti pontot. Erre mindenképpen csak egyszer van lehetősége, abban az esetben, ha az első
 próbálkozás nem sikerült többet nem próbálhatja meg a képesség érvényesítését.

 */

/**
 *
 * @author FZs
 */
public class RockyMeccs {

    public static void main(String[] args) {
        int mecsSzamlalo = 1;
        int rockyEletero20Alatt = 0;

        Bokszolo Rocky = new Bokszolo("Rocky");

        Bokszolo Ken = new Bokszolo("Ken");

        while (Rocky.getEronletiPont() > 0 && Ken.getEronletiPont() > 0) {
            System.out.println("\n" + "Induljon a " + mecsSzamlalo + ". menet!");
            Rocky.setSzerencse();
            int rockySzerencse = Rocky.getSzerencse();
            Ken.setSzerencse();
            int kenSzerencse = Ken.getSzerencse();
            Rocky.setUtesErosseg();
            Ken.setUtesErosseg();
            
            if (Ken.kenKülönlegesEro(Ken.getUtesErosseg(), mecsSzamlalo - 1)) {
                Ken.setUtesErosseg(Ken.getUtesErosseg(), 1);
                System.out.println("Ken felhasználta a különleges képeségét.");
            }
            

            if (rockySzerencse > kenSzerencse) {
                Ken.setEronletiPont(Ken.getEronletiPont() - Rocky.getUtesErosseg());
                System.out.println("Rocky " + utesFajta(Rocky.getUtesErosseg()));

                if (Ken.getEronletiPont() <= 0) {
                    foldreKerult(Ken.getNev());
                    continue;
                }
                eronletKiir(Ken.getNev(), Ken.getEronletiPont());
                
                Rocky.setEronletiPont(Rocky.getEronletiPont() - Ken.getUtesErosseg());
                System.out.println("Ken " + utesFajta(Ken.getUtesErosseg()));
                if (Rocky.getEronletiPont() <= 0) {
                    foldreKerult(Rocky.getNev());
                    continue;
                }
                eronletKiir(Rocky.getNev(), Rocky.getEronletiPont());
            } else {
                Rocky.setEronletiPont(Rocky.getEronletiPont() - Ken.getUtesErosseg());
                System.out.println("Ken " + utesFajta(Ken.getUtesErosseg()));
                if (Rocky.getEronletiPont() <= 0) {
                    foldreKerult(Rocky.getNev());
                    continue;
                }
                eronletKiir(Rocky.getNev(), Rocky.getEronletiPont());
                Ken.setEronletiPont(Ken.getEronletiPont() - Rocky.getUtesErosseg());
                System.out.println("Rocky " + utesFajta(Rocky.getUtesErosseg()));
                if (Ken.getEronletiPont() <= 0) {
                    foldreKerult(Ken.getNev());
                    continue;
                }
                eronletKiir(Ken.getNev(), Ken.getEronletiPont());
            }
            mecsSzamlalo++;
            Ken.setUtesekSzama(mecsSzamlalo);
            
            if (Rocky.rockyKülönlegesEro(Rocky.getEronletiPont(), rockyEletero20Alatt)) {
                Rocky.setEronletiPont(Rocky.getEronletiPont() + 20);
                rockyEletero20Alatt++;
                System.out.println("Rocky felhasználta a különleges képességét.");
            }
        }

        String eredmeny;
        eredmeny = gyoztes(Rocky.getEronletiPont(), Ken.getEronletiPont());
        System.out.println("A mecs győztese " + " a " + mecsSzamlalo
                + ". menetben " + eredmeny + " !");

    }

    public static String gyoztes(int eronlet1, int eronlet2) {
        if (eronlet1 <= 0 || eronlet2 <= 0) {
            return eronlet1 < eronlet2 ? "Ken" : "Rocky";
        }
        return "";
    }

    public static String utesFajta(int utesErosseg) {
        return (utesErosseg % 2 == 0) ? "bal horgot vitt be!"
                : "jobb egyenessel támadott!";
    }

    public static void eronletKiir(String nev, int eronlet) {
        System.out.println(nev + " erőnléte " + eronlet);
    }

    private static void foldreKerult(String nev) {
        System.out.println(nev + " a földre került!");
    }
}
