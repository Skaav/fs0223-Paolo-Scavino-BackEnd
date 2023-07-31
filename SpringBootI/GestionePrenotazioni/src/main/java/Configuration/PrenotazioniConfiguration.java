package Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import Model.Edificio;
import Model.Postazione;
import Model.Prenotazioni;
import Model.Utente;


@Configuration
@PropertySource("classpath:application.properties")
public class PrenotazioniConfiguration {

    @Bean("edificio")
    @Scope("prototype")
    public Edificio edificio() {
        return new Edificio();
    }

    @Bean("postazione")
    @Scope("prototype")
    public Postazione postazione() {
        return new Postazione();
    }

    @Bean("prenotazioni")
    @Scope("prototype")
    public Prenotazioni prenotazione() {
        return new Prenotazioni();
    }

    @Bean("utente")
    @Scope("prototype")
    public Utente utente() {
        return new Utente();
    }


}