
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5; // aloitustalukon koko
    public final static int OLETUSKASVATUS = 5;  // luotava uusi taulukko on näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukujono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    

    public IntJoukko() {
        this.lukujono = new int[KAPASITEETTI];
        this.alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        this.lukujono = new int[kapasiteetti<0?KAPASITEETTI:kapasiteetti];
        this.kasvatuskoko = OLETUSKASVATUS;
        this.alkioidenLkm = 0;
        
    }  
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        this.lukujono = new int[kapasiteetti<0?KAPASITEETTI:kapasiteetti]; 
        this.kasvatuskoko = kasvatuskoko<0?OLETUSKASVATUS:kasvatuskoko;
        this.alkioidenLkm = 0;
    }

    public void lisaa(int luku) {
        if (kuuluu(luku) < 0) {
            lukujono[alkioidenLkm++] = luku;
            if (alkioidenLkm == lukujono.length) {
                int[] uusiJono = new int[alkioidenLkm + kasvatuskoko];
                kopioiJono(lukujono, uusiJono);
                lukujono = uusiJono;
            }
        }
    }

    public int kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                return i;
            }
        }
        return -1;
    }

    public void poista(int luku) {
        int kohta = kuuluu(luku);
        if (kohta != -1) {
            alkioidenLkm--;
            for (int j = kohta; j < alkioidenLkm; j++) {
                lukujono[j] = lukujono[j + 1];
            }
        }
    }

    private void kopioiJono(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);
    }

    public int getKoko() {
        return alkioidenLkm;
    }
    
    public int getAlkio(int index) {
        return this.lukujono[index];
    }


    @Override
    public String toString() {   
        String tuotos = "{";
        for (int i = 0; i < alkioidenLkm; i++) {
            tuotos += lukujono[i];
            tuotos += i < alkioidenLkm - 1 ? ", " : "";
        }
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        System.arraycopy(lukujono, 0, taulu, 0, taulu.length);
        return taulu;
    } 

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int i = 0; i < a.getKoko(); i++) {
            x.lisaa(a.getAlkio(i));
        }
        for (int i = 0; i < b.getKoko(); i++) {
            x.lisaa(b.getAlkio(i));
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        for (int i = 0; i < a.getKoko(); i++) {
            for (int j = 0; j < b.getKoko(); j++) {
                if (a.getAlkio(i) == b.getAlkio(i)) {
                    y.lisaa(a.getAlkio(i));
                }
            }
        }
        return y;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        for (int i = 0; i < a.getKoko(); i++) {
            z.lisaa(a.getAlkio(i));
        }
        for (int i = 0; i < b.getKoko(); i++) {
            z.poista(i);
        }
        return z;
    }        
}