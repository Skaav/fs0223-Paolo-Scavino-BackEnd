package Class;

import javax.persistence.*;

@Entity
@DiscriminatorValue("rivista")
public class Rivista extends ElementoCatalogo {
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
}
