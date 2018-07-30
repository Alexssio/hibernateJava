package it.clariter.model.ristorante;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "piatto")
public class Piatto 
{

	private int id;
	private String descrizione;
	private int prezzo;
	
	
	public Piatto(int id, String descrizione, int prezzo) 
	{
		this.id = id;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}
	
	public Piatto () { }
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = true, length = 11)
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	@Column (name = "descrizione", nullable = true, length = 45)
	public String getDescrizione() 
	{
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) 
	{
		this.descrizione = descrizione;
	}
	
	@Column (name = "prezzo", nullable = true, length = 11)
	public int getPrezzo() 
	{
		return prezzo;
	}

	public void setPrezzo(int prezzo) 
	{
		this.prezzo = prezzo;
	}
}
