package it.clariter.model.prodotto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "prodotto")
public class Prodotto 
{
	private int id;
	private String nome;
	private String descrizione;
	private int costo;

	public Prodotto(int id, String nome, String descrizione, int costo) 
	{
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.costo = costo;
	}
	
	public Prodotto() 
	{	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	@Column(name = "nome", nullable = true, length = 45)
	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	@Column(name = "descrizione", nullable = true, length = 45)
	public String getDescrizione() 
	{
		return descrizione;
	}

	public void setDescrizione(String descrizione) 
	{
		this.descrizione = descrizione;
	}

	@Column(name = "costo", nullable = true, length = 11)
	public int getCosto() 
	{
		return costo;
	}

	public void setCosto(int costo) 
	{
		this.costo = costo;
	}
}
