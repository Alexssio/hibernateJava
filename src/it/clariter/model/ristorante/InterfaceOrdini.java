package it.clariter.model.ristorante;

public interface InterfaceOrdini 
{
	public void inserisciOrdine(Piatto p);
	public void modificaOrdine(Piatto p);
	public void cancellaOrdine(Piatto p);
	public void visualizzaOrdini();
	public void stampaCostoOrdini(int i);
}
