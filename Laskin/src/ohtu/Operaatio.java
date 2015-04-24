
package ohtu;

import javax.swing.JTextField;


public abstract class Operaatio {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    JTextField syotekentta;

    public Operaatio(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }
}
