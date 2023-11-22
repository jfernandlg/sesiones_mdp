package es.unex.cum.mdp.ef2;

import java.util.Objects;

public class Reparto {
	private int numLineas;
	private int numBingo;
	private int numEspeciales;
	private float repartoEspeciales;
	private float repartoLinea;
	private float repartoBingo;
	private float caja;
	private float recaudacion;
	
	
	public int getNumLineas() {
		return numLineas;
	}

	public void setNumLineas(int numLineas) {
		this.numLineas = numLineas;
	}

	public int getNumBingo() {
		return numBingo;
	}

	public void setNumBingo(int numBingo) {
		this.numBingo = numBingo;
	}

	public int getNumEspeciales() {
		return numEspeciales;
	}

	public void setNumEspeciales(int numEspeciales) {
		this.numEspeciales = numEspeciales;
	}

	public float getRepartoEspeciales() {
		return repartoEspeciales;
	}

	public void setRepartoEspeciales(float repartoEspeciales) {
		this.repartoEspeciales = repartoEspeciales;
	}

	public float getRepartoLinea() {
		return repartoLinea;
	}

	public void setRepartoLinea(float repartoLinea) {
		this.repartoLinea = repartoLinea;
	}

	public float getRepartoBingo() {
		return repartoBingo;
	}

	public void setRepartoBingo(float repartoBingo) {
		this.repartoBingo = repartoBingo;
	}

	public float getCaja() {
		return caja;
	}

	public void setCaja(float caja) {
		this.caja = caja;
	}

	public float getRecaudacion() {
		return recaudacion;
	}

	public void setRecaudacion(float recaudacion) {
		this.recaudacion = recaudacion;
	}

	
	@Override
	public String toString() {
		return "Reparto [numLineas=" + numLineas + ", numBingo=" + numBingo + ", numEspeciales=" + numEspeciales
				+ ", repartoEspeciales=" + repartoEspeciales + ", repartoLinea=" + repartoLinea + ", repartoBingo="
				+ repartoBingo + ", caja=" + caja + ", recaudacion=" + recaudacion + "]";
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(caja, numBingo, numEspeciales, numLineas, recaudacion, repartoBingo, repartoEspeciales,
				repartoLinea);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reparto other = (Reparto) obj;
		return Float.floatToIntBits(caja) == Float.floatToIntBits(other.caja) && numBingo == other.numBingo
				&& numEspeciales == other.numEspeciales && numLineas == other.numLineas
				&& Float.floatToIntBits(recaudacion) == Float.floatToIntBits(other.recaudacion)
				&& Float.floatToIntBits(repartoBingo) == Float.floatToIntBits(other.repartoBingo)
				&& Float.floatToIntBits(repartoEspeciales) == Float.floatToIntBits(other.repartoEspeciales)
				&& Float.floatToIntBits(repartoLinea) == Float.floatToIntBits(other.repartoLinea);
	}

	public Reparto(int numLineas, int numBingo, int numEspeciales, float repartoEspeciales, float repartoLinea,
			float repartoBingo, float caja, float recaudacion) {
		super();
		this.numLineas = numLineas;
		this.numBingo = numBingo;
		this.numEspeciales = numEspeciales;
		this.repartoEspeciales = repartoEspeciales;
		this.repartoLinea = repartoLinea;
		this.repartoBingo = repartoBingo;
		this.caja = caja;
		this.recaudacion = recaudacion;
	}

	public Reparto() {
		this.numLineas = 0;
		this.numBingo = 0;
		this.numEspeciales = 0;
		this.repartoEspeciales = 0;
		this.repartoLinea = 0;
		this.repartoBingo = 0;
		this.caja = 0;
		this.recaudacion = 0;
	}
	
	
	
}
