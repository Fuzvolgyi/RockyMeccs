
import java.util.Random;

/**
 *
 * @author FZs
 */
public class Bokszolo {
    private String nev;
    private int utesErosseg;
    private int eronletiPont = 100;
    private int utesekSzama = 0;
    private int szerencse;

    @Override
    public String toString() {
        return "Bokszolo{" + "nev=" + nev + ", utesErosseg=" + utesErosseg + ", eronletiPont=" + eronletiPont + '}';
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getterek, Setterek">
    public String getNev() {
        return nev;
    }
    
    public void setNev(String nev) {
        this.nev = nev;
    }
    
    public int getUtesErosseg() {
        return utesErosseg;
    }
    
    public void setUtesErosseg() {
        Random rd = new Random();
        int ero = rd.nextInt(10)+1;
        this.utesErosseg = ero;
    }
    
    public int getEronletiPont() {
        return eronletiPont;
    }
    
    public void setEronletiPont(int eronletiPont) {
        this.eronletiPont = eronletiPont;
    }
    
    public int getUtesekSzama() {
        return utesekSzama;
    }
    
    public void setUtesekSzama(int utesekSzama) {
        this.utesekSzama = utesekSzama;
    }
    public int getSzerencse() {
        return szerencse;
    }

    public void setSzerencse() {
        Random rd = new Random();
        int esely = rd.nextInt(1000);
        this.szerencse = esely; 
    } 
    
    
//</editor-fold>

    public int utesEro(){
        int ero;
        Random rd = new Random();
        return ero = rd.nextInt(10);
    }
    
    public boolean kenKülönlegesEro(int utesEro, int utesekSzama){
        Random rd = new Random();
        int esely = rd.nextInt(100);
        return utesekSzama % 2 == 0 && utesEro < 5 && esely > 20;
    }
    
    public boolean rockyKülönlegesEro (int eletero, int valtozo){
        Random rd = new Random();
        int esely = rd.nextInt(100);
        return eletero < 20 && esely <= 30 && valtozo < 1;
    }
    
}
