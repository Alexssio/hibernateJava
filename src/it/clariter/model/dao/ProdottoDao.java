package it.clariter.model.dao;

import java.util.List;
import it.clariter.model.prodotto.Prodotto;

public interface ProdottoDao 
{
	public List<Prodotto> getProdotti();

	public Prodotto getProdotto(Integer id);
	
	public Prodotto addProdotto(Prodotto p);

	public void updateProdotto(Prodotto p);

	public void removeProdotto(Integer i);
}
