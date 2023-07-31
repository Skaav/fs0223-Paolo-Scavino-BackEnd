package Model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Prenotazioni")

public class Prenotazioni {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private LocalDate dataPrenotazione;

	    @ManyToOne
	    private Postazione postazione;

	    @ManyToOne
	    private Utente utente;
	    
}
