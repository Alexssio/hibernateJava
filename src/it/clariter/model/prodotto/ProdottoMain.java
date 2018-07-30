package it.clariter.model.prodotto;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProdottoMain 
{

	public static void main(String[] args) 
	{
		/*ProdottoDao prodotto = new ProdottoDAOImpl();

		System.out.println("Stampa tutti gli oggetti :");
		for (Prodotto p : prodotto.getProdotti()) {
			System.out.println("ID: ".concat(Integer.toString(p.getId())));
			System.out.println("Nome: ".concat(p.getNome()));
			System.out.println("Descrizione: ".concat(p.getDescrizione()));
			System.out.println("Costo: ".concat(Integer.toString(p.getCosto())));
		}*/
		
		Session session= null;
		Configuration configuration = new Configuration();
		configuration.configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		//Prodotto p = (Prodotto) session.get(Prodotto.class, 1);
		//System.out.println(p.getNome());
		
		
		Query q = session.createQuery("FROM it.clariter.model.prodotto.Prodotto " + 
		"WHERE descrizione LIKE '%bibita%'");
		
		List<Prodotto> prodotti = new ArrayList<Prodotto>();
		prodotti = q.list();
		
		for (Prodotto prodotto : prodotti) 
		{
			System.out.println("\nNome prodotto: ".concat(prodotto.getNome()));
			System.out.println("Descrizione prodotto: ".concat(prodotto.getDescrizione()));
			System.out.println("ID prodotto: ".concat(Integer.toString(prodotto.getId())));
			System.out.println("Costo prodotto: ".concat(Integer.toString(prodotto.getCosto())));
		}
	
		
		t.commit();
		session.close();
	}
	
	
}
