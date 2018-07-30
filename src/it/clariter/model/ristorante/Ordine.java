package it.clariter.model.ristorante;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ordine")
public class Ordine 
{
	private int id;
	private Tavolo tavolo;
	private int quantita;
	private String stato;
	private Piatto piatto;
		

	public Ordine(int id, Tavolo tavolo,  int quantita, String stato, Piatto piatto) {
		this.id = id;
		this.tavolo = tavolo;
		this.quantita = quantita;
		this.stato = stato;
		this.piatto = piatto;
	}
	
	public Ordine() {	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "tavolo_id")
	public Tavolo getTavolo() {
		return tavolo;
	}
	
	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}
	
	@Column(name = "quantita", nullable = true, length = 11)
	public int getQuantita() {
		return quantita;
	}
	
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	@Column(name = "stato", nullable = true, length = 45)
	public String getStato() {
		return stato;
	}
	
	public void setStato(String stato) {
		this.stato = stato;
	}
	
	@OneToOne
	public Piatto getPiatto() {
		return piatto;
	}

	public void setPiatto(Piatto piatto) {
		this.piatto = piatto;
	}
}
