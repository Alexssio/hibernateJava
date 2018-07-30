package it.clariter.model.ristorante;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tavolo")
public class Tavolo 
{

	private int id;
	private List<Ordine> ordini;
	private String nome;
	
	
	public Tavolo(int id, List<Ordine> ordini, String nome) {
		this.id = id;
		this.ordini = ordini;
		this.nome = nome;
	}
	
	public Tavolo () { }
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "tavolo_id")
	public List<Ordine> getOrdini() {
		return ordini;
	}
	
	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}
	
	@Column(name = "nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
