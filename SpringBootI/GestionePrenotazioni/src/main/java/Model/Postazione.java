package Model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Postazione")

public class Postazione {
	  
	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(unique = true)
	    private String codice;

	    private String descrizione;

	    @Enumerated(EnumType.STRING)
	    private TipoPostazione tipo;

	    private int numeroMassimoOccupanti;

	    @ManyToOne
	    private Edificio edificio;

}
