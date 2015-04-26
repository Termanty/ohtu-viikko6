package com.mycompany.webkauppa.ohjaus;

import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;

public class Komentotehdas {
    
    public void ostoksenLisaysKoriin(Ostoskori ostoskori, long tuoteId) {
        Komento k = new OstoksenLisaysKoriin(ostoskori, tuoteId);
        k.suorita();
    }
    
    public void ostoksenPoistoKorista(Ostoskori ostoskori, long tuoteId) {
        Komento k = new OstoksenPoistoKorista(ostoskori, tuoteId);
        k.suorita();
    }
    
    public boolean ostoksenSuoritus(String nimi, String osoite, String luottokorttinumero, Ostoskori kori){
        Komento k = new OstoksenSuoritus(nimi, osoite, luottokorttinumero, kori);
        return k.suorita();
    }
    
}
