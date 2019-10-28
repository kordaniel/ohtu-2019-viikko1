package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoKayttokelvottomanVarastonNollaTilavuudella() {
        //rikottu testi
        Varasto v = new Varasto(0.0);
        //assertEquals(0, v.getTilavuus(), vertailuTarkkuus);
        assertEquals(2, v.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriLuoKayttokelvottomanVarastonNegTilavuudella() {
        Varasto v = new Varasto(-0.01);
        assertEquals(0, v.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void kuormitettKonstruktoriLuoKayttokelvottomanVarastonNollaTilavuudella() {
        Varasto v = new Varasto(0.0, 0.0);
        assertEquals(0, v.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void kuormitettuKonstruktoriLuoKayttokelvottomanVarastonNegTilavuudella() {
        Varasto v = new Varasto(-0.01, 0.0);
        assertEquals(0, v.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void uudellaVarastollaNollaSaldoKunAlkuSaldoNeg() {
        Varasto v = new Varasto(10, -0.5);
        assertEquals(0, v.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void uudellaVarastollaMaksimiSaldoKunAlkuSaldoYliTilavuuden() {
        Varasto v = new Varasto(10, 10.7);
        assertEquals(10, v.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaAlkusaldo() {
        Varasto v = new Varasto(8, 6);
        assertEquals(6, v.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenLisaysEiMuutaSaldoa() {
        varasto.lisaaVarastoon(-1);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void lisaysYliTilavuudenTayttaaVaraston() {
        varasto.lisaaVarastoon(11);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void negatiivistaEiVoiOttaa() {
        varasto.lisaaVarastoon(7);
        double saatuMaara = varasto.otaVarastosta(-1);
        
        assertEquals(0, saatuMaara, vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenOttoEiMuutaSaldoa() {
        varasto.lisaaVarastoon(4);
        varasto.otaVarastosta(-2);
        
        assertEquals(4, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void suuriOttoTyhjentaaVaraston() {
        varasto.lisaaVarastoon(10);
        varasto.otaVarastosta(150);
        
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void suuriOttoPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(9);
        double saatuMaara = varasto.otaVarastosta(500);
        
        assertEquals(9, saatuMaara, vertailuTarkkuus);
    }
    
    @Test
    public void toStringToimiiOikein() {
        varasto.lisaaVarastoon(3);
        String kuvaus = varasto.toString();
        
        assertEquals(kuvaus, "saldo = 3.0, vielä tilaa 7.0");
    }
}