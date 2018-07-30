package it.clariter.model.daoimpl;

import java.util.ArrayList;
import java.util.List;

import it.clariter.model.dao.ProdottoDao;
import it.clariter.model.prodotto.Prodotto;

public class ProdottoDAOImpl implements ProdottoDao {

	List<Prodotto> prodotti = new ArrayList<Prodotto>();

	public ProdottoDAOImpl() {
		prodotti = new ArrayList<Prodotto>();
		prodotti.add(new Prodotto(0, "mela", "frutta", 21));
		prodotti.add(new Prodotto(1, "pera", "frutta", 10));
	}

	@Override
	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	@Override
	public Prodotto getProdotto(Integer p) {
		return prodotti.get(p.intValue());
	}

	@Override
	public void updateProdotto(Prodotto p) {
		prodotti.get(p.getId()).setNome(p.getNome());
	}

	@Override
	public void removeProdotto(Integer i) {
		prodotti.remove(i.intValue());
		// System.out.println("Prodotto: ".concat(p.getNome().concat(" Descrizione:
		// ".concat(p.getDescrizione().concat(" Costo:
		// ".concat(Integer.toString(p.getCosto()))
	}

	@Override
	public Prodotto addProdotto(Prodotto p) {
		// TODO Auto-generated method stub
		return null;
	}
}
