package it.clariter.model.ristorante;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.VisitorSupport;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PiattoMain implements InterfaceOrdini {
	
	static Session session = null;
	static Transaction t = null;
	
	
	public static void main(String[] args) {
		setup();
		
		Tavolo mioTavolo = (Tavolo) session.get(Tavolo.class, 3);
		
		for (Ordine t : mioTavolo.getOrdini()) 
		{
			System.out.println(t.getPiatto().getDescrizione());
		}
		
		close();
	}

	private static void setup() {
		Configuration configuration = new Configuration();
		configuration.configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		t = session.beginTransaction();
	}
	
	private static void close() {
		t.commit();
		session.close();
	}

	@Override
	public void inserisciOrdine(Piatto p) {
		setup();
		session.save(p);
		t.commit();
		close();
	}

	@Override
	public void modificaOrdine(Piatto p) {
		setup();
		
		
		close();
	}

	@Override
	public void cancellaOrdine(Piatto p) 
	{
		setup();
		session.delete(p);
		t.commit();
		close();
	}

	@Override
	public void visualizzaOrdini() 
	{
		setup();
		Query selectOrdini = session.createQuery("FROM it.clariter.model.ristorante.Ordine");
		
		List<Ordine> ordini = new ArrayList<Ordine>();
		ordini = selectOrdini.list();
		
		for (Ordine ordine : ordini)
		{
			System.out.println("\nID: ".concat(Integer.toString(ordine.getId())));
			
			System.out.println("Piatto: ".concat(ordine.getPiatto().getDescrizione()));
			System.out.println("Quantità: ".concat(Integer.toString(ordine.getQuantita())));
			System.out.println("Prezzo: ".concat(Integer.toString(ordine.getPiatto().getPrezzo())));
			System.out.println("Stato: ".concat(ordine.getStato()));		
		}		
		close();
	}

	@Override
	public void stampaCostoOrdini(int i) 
	{
		int somma = 0;
		setup();
		Query selectOrdini = session.createQuery("FROM it.clariter.model.ristorante.Ordine");
		
		List<Ordine> ordini = new ArrayList<Ordine>();
		ordini = selectOrdini.list();
		
		for (Ordine ordine : ordini)
		{
			System.out.println("\nID: ".concat(Integer.toString(ordine.getId())));
			//System.out.println("N° Tavolo: ".concat(Integer.toString(ordine.getTavolo())));
			System.out.println("Quantità: ".concat(Integer.toString(ordine.getQuantita())));
			System.out.println("Stato: ".concat(ordine.getStato()));
			somma += ordine.getPiatto().getPrezzo() * ordine.getQuantita();
		}
			
		System.out.println("La somma totale dei costi dei piatti per le quantita' e': ".concat(Integer.toString(somma)));
		close();
	}
}
