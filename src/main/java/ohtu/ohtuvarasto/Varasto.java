package ohtu.ohtuvarasto;

public class Varasto {

    // --- piilotettu tietorakenteen toteutus: ---
    private double tilavuus;  // paljonko varastoon mahtuu,  > 0
    private double saldo;     // paljonko varastossa on nyt, >= 0

    // --- konstruktorit: ---
    public Varasto(double tilavuus) {  // tilavuus on annettava
        this(tilavuus, 0.0);
    }

    public Varasto(double tilavuus, double alkuSaldo) { // kuormitetaan
        this.tilavuus = tilavuus > 0.0 ? tilavuus : 0.0;
        
        this.saldo = 0.0;
        lisaaVarastoon(alkuSaldo);
    }

    // --- ottavat aksessorit eli getterit: ---
    public double getSaldo() {
        return saldo;
    }

    public double getTilavuus() {
        return tilavuus;
    }

    public double paljonkoMahtuu() {  // huom: ominaisuus voidaan myös laskea
        return tilavuus - saldo;        //  ei tarvita erillistä kenttää vielaTilaa tms.
    }

    // --- asettavat aksessorit eli setterit: ---
    public void lisaaVarastoon(double maara) {
        if (maara < 0) {
            return;
        }
        
        if (maara <= paljonkoMahtuu()) {
            saldo = saldo + maara;
        } else {
            saldo = tilavuus;
        }
    }

    public double otaVarastosta(double maara) {
        if (maara < 0)  {
            return 0.0;
        }
        
        if (maara > saldo) {          // annetaan mitä voidaan
            double kaikkiMitaVoidaan = saldo;
            saldo = 0.0;               // ja tyhjäksi menee
            return kaikkiMitaVoidaan;  // poistutaan saman tien
        }
        
        // jos tänne päästään, kaikki pyydetty voidaan antaa
        saldo = saldo - maara;  // vähennetään annettava saldosta
        return maara;
    }

    // --- Merkkijonoesitys Varasto-oliolle: ----
    public String toString() {
        return ("saldo = " + saldo + ", vielä tilaa " + paljonkoMahtuu());
    }
}
