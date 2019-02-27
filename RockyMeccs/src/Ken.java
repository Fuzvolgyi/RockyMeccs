
/**
 Ken: Abban az esetben, ha az ütés erőssége kisebb mint 5 annak értékét 20% eséllyel meg tudja
 növelni eggyel. Ezt csak minden második ilyen ütés esetén teheti meg.
 */
public class Ken extends Bokszolo{
    private int utesSzamlalo;

    
    
    public Ken(String nev, int utesErosseg, int szerencse, int utesSzamlalo) {
        super(nev);
        this.utesSzamlalo = 0;
        
        
        
    }
    
    public int getUtesSzamlalo() {
        return utesSzamlalo;
    }
    
    public boolean kenKülönlegesEro(int utesEro, int utesekSzama){
        int esely = RANDOM.nextInt(100);
        return utesekSzama % 2 == 0 && utesEro < 5 && esely <= 20;
    }

    @Override
    public String toString() {
        return  super.toString() + "Ken{" + "utesSzamlalo=" + utesSzamlalo + '}';
    }
    

}
