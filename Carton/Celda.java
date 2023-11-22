package es.unex.cum.mdp.ef2.Carton;

import java.util.Objects;

public class Celda {

	protected int numero;
	protected int estado;
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Celda [numero=" + numero + ", estado=" + estado + "]";
	}
	
	public Celda(int numero, int estado) {
		super();
		this.numero = numero;
		this.estado = estado;
	}
	
	public Celda() {
		super();
		this.numero=0;
		this.estado=0;
	}
	@Override
	public int hashCode() {
		return Objects.hash(estado, numero);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Celda other = (Celda) obj;
		return estado == other.estado && numero == other.numero;
	}
	
	
	
	
	
}
