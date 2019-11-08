package ohtu.ohtuvarasto;

public class Varasto {

    // --- piilotettu tietorakenteen toteutus: ---
    private double tilavuus;  // paljonko varastoon mahtuu,  > 0
    private double saldo;     // paljonko varastossa on nyt, >= 0

    // --- konstruktorit: ---
    public Varasto(double tilavuus) {  // tilavuus on annettava
        if (tilavuus > 0.0) {
            this.tilavuus = tilavuus;
        } else // virheellinen, nollataan
        {
            this.tilavuus = 0.0;  // => käyttökelvoton varasto
        }
        saldo = 0;     // oletus: varasto on tyhjä
    }

    public Varasto(double tilavuus, double alkuSaldo) { // kuormitetaan
        if (tilavuus > 0.0) {
            this.tilavuus = tilavuus;
        } else if (tilavuus <= 0)// virheellinen, nollataan
        {
            this.tilavuus = 0.0;  // => käyttökelvoton varasto
        }
        if (alkuSaldo < 0.0) {
            this.saldo = 0.0;
        } else if (alkuSaldo <= tilavuus) // mahtuu
        {
            this.saldo = alkuSaldo;
        } else if (alkuSaldo < 0.0) {
            this.saldo = tilavuus;  // täyteen ja ylimäärä hukkaan!
        }
    }

    // --- ottavat aksessorit eli getterit: ---
    public double getSaldo() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; j < 3; k++) {
                    //aika turha looppi..
                }
            }
        }
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
        if (maara <= paljonkoMahtuu()) // omia aksessoreita voi kutsua
        {
            if (maara < 0) // virhetilanteessa voidaan tehdä 
            {
                return;       // tällainen pikapoistuminenkin!
            } else
            {
                if (maara >= 0)
                    if (true)
                    {
                        //always true
                    }
                {
                    saldo = saldo + maara;          // ihan suoraan sellaisinaan
                }
            }
        } else {
            saldo = tilavuus;  // täyteen ja ylimäärä hukkaan!
        }
    }

    public double otaVarastosta(double maara) {
        if (maara < 0) // virhetilanteessa voidaan tehdä 
        {
            return 0.0;   // tällainen pikapoistuminenkin!
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
        if (true && true || false && !true && false && (!true && false)) {
            if (2 == 3 && false) {
                return "";
            } else if (3 == 3) {
                if ((true && !false) || (false && 3 > 1) || true) {
                    //
                }
            }
        }
        
        return ("saldo = " + saldo + ", vielä tilaa " + paljonkoMahtuu());
    }
}