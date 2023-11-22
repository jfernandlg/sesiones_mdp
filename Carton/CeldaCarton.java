package es.unex.cum.mdp.ef2.Carton;

import java.util.Objects;

public class CeldaCarton extends Celda {

	private int fila;
	private int columna;
	private boolean especial;
	private String RutaImagen;
	private String RutaReverso;
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	public boolean getEspecial() {
		return especial;
	}
	public void setEspecial(boolean especial) {
		this.especial = especial;
	}
	public String getRutaImagen() {
		return RutaImagen;
	}
	public void setRutaImagen(String rutaImagen) {
		RutaImagen = rutaImagen;
	}
	public String getRutaReverso() {
		return RutaReverso;
	}
	public void setRutaReverso(String rutaReverso) {
		RutaReverso = rutaReverso;
	}
	
	public CeldaCarton(int numero, int estado, int fila, int columna) {
		super(numero,estado);
		this.fila = fila;
		this.columna = columna;
	}
	
	public CeldaCarton(int numero, int estado) {
		super(numero, estado);
		this.fila=0;
		this.columna=0;
		this.especial=false;
		this.RutaImagen="";
		this.RutaReverso="";
	}
	@Override
	public String toString() {
		return "CeldaCarton [fila=" + fila + ", columna=" + columna + ", especial=" + especial + ", RutaImagen="
				+ RutaImagen + ", RutaReverso=" + RutaReverso + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(RutaImagen, RutaReverso, columna, especial, fila);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CeldaCarton other = (CeldaCarton) obj;
		return Objects.equals(RutaImagen, other.RutaImagen) && Objects.equals(RutaReverso, other.RutaReverso)
				&& columna == other.columna && especial == other.especial && fila == other.fila;
	}
	
	
	
	
	
	
}
