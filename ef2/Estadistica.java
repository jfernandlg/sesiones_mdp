package es.unex.cum.mdp.ef2;

import java.util.Objects;

public class Estadistica {
	private int numero;
	private int numSacado;
	private int numEspecial;
	private int numLinea;
	private int numBingo;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getNumSacado() {
		return numSacado;
	}
	public void setNumSacado(int numSacado) {
		this.numSacado = numSacado;
	}
	public int getNumEspecial() {
		return numEspecial;
	}
	public void setNumEspecial(int numEspecial) {
		this.numEspecial = numEspecial;
	}
	public int getNumLinea() {
		return numLinea;
	}
	public void setNumLinea(int numLinea) {
		this.numLinea = numLinea;
	}
	public int getNumBingo() {
		return numBingo;
	}
	public void setNumBingo(int numBingo) {
		this.numBingo = numBingo;
	}
	
	public Estadistica(int numero) {
		this.numero = numero;
	}
	
	
	public Estadistica() {
		this.numero = 0;
		this.numSacado = 0;
		this.numEspecial = 0;
		this.numLinea = 0;
		this.numBingo = 0;
	}
	@Override
	public String toString() {
		return "Estadistica [numero=" + numero + ", numSacado=" + numSacado + ", numEspecial=" + numEspecial
				+ ", numLinea=" + numLinea + ", numBingo=" + numBingo + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(numBingo, numEspecial, numLinea, numSacado, numero);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estadistica other = (Estadistica) obj;
		return numBingo == other.numBingo && numEspecial == other.numEspecial && numLinea == other.numLinea
				&& numSacado == other.numSacado && numero == other.numero;
	}
	
	
	
	
	
	
}
