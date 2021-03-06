
package ohtu;

import javax.swing.JTextField;

public class Erotus implements Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int arvo = 0;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }
    
    @Override
    public void suorita() {
        try {
            this.arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        sovellus.miinus(arvo);
        tuloskentta.setText("" + sovellus.tulos());
    }    

    @Override
    public void peru() {
        sovellus.plus(arvo);
        tuloskentta.setText("" + sovellus.tulos());
    }
}
