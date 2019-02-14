
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

   
    
    @Override
    public String toString() {
        return "Bokszolo{" + "nev=" + nev + ", utesErosseg=" + utesErosseg + ", eronletiPont=" + eronletiPont + '}';
    }

    
    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getUtesErosseg() {
        return utesErosseg;
    }

    public void setUtesErosseg(int utesErosseg) {
        this.utesErosseg = utesErosseg;
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

    
    
    public String utesFajta(int utesErosseg){
        return (utesErosseg % 2 == 0) ? "bal horog" : "jobb egyenes";   
    }
    
    public int utesEro(){
        int ero;
        Random rd = new Random();
        return ero = rd.nextInt(10);
    }
            
    public int kenKülönlegesEro(int utesEro, int utesekSzama){
        int eredmeny;
        Random rd = new Random();
        int esely = rd.nextInt(100)/20;
        if ((utesekSzama % == 0) && (utesEro < 5) && (esely > 20)) {
            return eredmeny = 1;
        }
        return eredmeny = 0;
    }
    
}

