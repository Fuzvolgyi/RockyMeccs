
import java.util.Random;

/**
 *
 * @author FZs
 */
public class Bokszolo {
    public static final Random RANDOM = new Random();
    
    private String nev;
    private int utesErosseg;
    private int eronletiPont = 100;
    private int szerencse;

    
    public Bokszolo(String nev) {
        this.nev = nev;
        this.setUtesErosseg();
        this.setSzerencse();
    }

    @Override
    public String toString() {
        return "Bokszolo{" + "nev=" + nev + ", utesErosseg=" + utesErosseg + ", eronletiPont=" + eronletiPont + ", szerencse=" + szerencse + '}';
    }
    
        
    //<editor-fold defaultstate="collapsed" desc="Getterek, Setterek">
    public String getNev() {
        return nev;
    }
    
    protected void setNev(String nev) {
        this.nev = nev;
    }
    
    public int getUtesErosseg() {
        return utesErosseg;
    }
    
    protected void setUtesErosseg() {
        int ero = RANDOM.nextInt(10)+1;
        this.utesErosseg = ero;
    }
    
    
    
    public int getEronletiPont() {
        return eronletiPont;
    }
    
    public void setEronletiPont(int eronletiPont) {
        this.eronletiPont = eronletiPont;
    }
    
    public int getSzerencse() {
        return szerencse;
    }

    protected void setSzerencse() {
        int esely = RANDOM.nextInt(1000);
        this.szerencse = esely; 
    } 
    
    
//</editor-fold>

    private int utesEro(){
        int ero;
        return ero = RANDOM.nextInt(11)+1;
    }
    
    public boolean kenKülönlegesEro(int utesEro, int utesekSzama){
        int esely = RANDOM.nextInt(100);
        return utesekSzama % 2 == 0 && utesEro < 5 && esely <= 20;
    }
    
    public void ujUtesErosseg(int utesEro, int valtozas){
        this.utesErosseg = utesEro + valtozas;
    }
    
    public boolean rockyKülönlegesEro (int eletero, int valtozo){
        int esely = RANDOM.nextInt(100);
        return eletero > 0 && eletero < 20 && esely <= 29 && valtozo < 1;
    }
   
}
