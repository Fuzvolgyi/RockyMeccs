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
        int mecsSzamlalo = 0;
        
        
        
        Bokszolo Rocky = new Bokszolo();
        Rocky.setNev("Rocky");
        
        
        Bokszolo Ken = new Bokszolo();
        Ken.setNev("Ken");
              
        
        
    
        // meccs
        do {
        
            
            
            
            
            mecsSzamlalo++;
            Ken.setUtesekSzama(mecsSzamlalo);
        } while (Rocky.getEronletiPont() > 0 || Ken.getEronletiPont() > 0);
        
        
        
        



    }
    
    public String gyoztes(int eronlet1, int eronlet2){
        if (eronlet1 < 0 || eronlet2 < 0) {
            return eronlet1 < eronlet2 ? "Rocky" : "Ken";
        }
    return "";
    }
    
    public void utesSorrend(){
        
    
    }
    
}
