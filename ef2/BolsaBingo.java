package es.unex.cum.mdp.ef2;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BolsaBingo implements Bolsa {

	private Queue<Integer> bolsa;
	private int numMaxBolas;

	public int getNumMaxBolas() {
		return numMaxBolas;
	}

	public void setNumMaxBolas(int numMaxBolas) {
		this.numMaxBolas = numMaxBolas;
	}

	public void setBolsa(Queue<Integer> bolsa) {
		this.bolsa = bolsa;
	}

	public BolsaBingo(int numMaxBolas) {
		super();
		this.bolsa = new LinkedList<Integer>();
		for(int i=1;i<75;i++) {
			addNumero(i);
		}
		this.numMaxBolas = numMaxBolas;
	}

	public BolsaBingo() {
		this.bolsa = new LinkedList<Integer>();
		this.numMaxBolas = 75;
	}

	@Override
	public void addNumero(int bola) {
		if(bola<1 || bola>75) {
			return;
		}
		boolean enc=false;
		Iterator<Integer>it=bolsa.iterator();
		while(it.hasNext()) {
			Integer auxB=(Integer)it.next();
			if (auxB.equals(bola)) {
				enc=true;
				
			}
		}
		if (!enc)
			bolsa.offer(bola);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bolsa, numMaxBolas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BolsaBingo other = (BolsaBingo) obj;
		return Objects.equals(bolsa, other.bolsa) && numMaxBolas == other.numMaxBolas;
	}

	@Override
	public String toString() {
		return "BolsaBingo [bolsa=" + bolsa + ", numMaxBolas=" + numMaxBolas + "]";
	}

	@Override
	public Queue<Integer> getBolsa() {
		return this.bolsa;
	}

	@Override
	public void ordenar() {
		// TODO Auto-generated method stub
		Collections.sort((LinkedList)bolsa);
	}

	@Override
	public void desordenar() {
		// TODO Auto-generated method stub
		Collections.shuffle((LinkedList)bolsa);
	}

	@Override
	public int getTotalBolas() {
		return bolsa.size();
	}

	@Override
	public boolean bolsaVacia() {
		return bolsa.isEmpty();
			
	}

	@Override
	public Object sacarBola() {
		return bolsa.poll();
	}

	@Override
	public Object mostrarPrimero() {
		return bolsa.peek();
	}

}
