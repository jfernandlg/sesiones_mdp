package es.unex.cum.mdp.ef2;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public abstract class Bingo {
	protected int id;
	protected Date fecha;
	protected float recaudacion;
	protected boolean jugado;
	protected HashSet<ICarton> cartones;
	protected ArrayList<Integer> bolasSacadas;
	protected Bolsa b;
	protected int contId = 0;;

	public Bingo(int id, Date fecha, float recaudacion, boolean jugado, HashSet<ICarton> cartones,
			ArrayList<Integer> bolasSacadas, Bolsa b) {
		super();
		this.id = id;
		this.fecha = new Date();
		this.recaudacion = recaudacion;
		this.jugado = jugado;
		this.cartones = new HashSet<>();
		this.bolasSacadas = new ArrayList<>();
		this.b = b;
	}

	public Bingo() {
		this.id = contId++;
		this.fecha = new Date();
		this.recaudacion = 0;
		this.jugado = false;
		this.cartones = new HashSet<>();
		this.bolasSacadas = new ArrayList<>();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getRecaudacion() {
		return recaudacion;
	}

	public void setRecaudacion(float recaudacion) {
		this.recaudacion = recaudacion;
	}

	public boolean isJugado() {
		return jugado;
	}

	public void setJugado(boolean jugado) {
		this.jugado = jugado;
	}

	public HashSet<ICarton> getCartones() {
		return cartones;
	}

	public void setCartones(HashSet<ICarton> cartones) {
		this.cartones = cartones;
	}

	public ArrayList<Integer> getBolasSacadas() {
		return bolasSacadas;
	}

	public void setBolasSacadas(ArrayList<Integer> bolasSacadas) {
		this.bolasSacadas = bolasSacadas;
	}

	public Bolsa getB() {
		return b;
	}

	public void setB(Bolsa b) {
		this.b = b;
	}

	@Override
	public int hashCode() {
		return Objects.hash(b, bolasSacadas, cartones, contId, fecha, id, jugado, recaudacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bingo other = (Bingo) obj;
		return Objects.equals(b, other.b) && Objects.equals(bolasSacadas, other.bolasSacadas)
				&& Objects.equals(cartones, other.cartones) && Objects.equals(fecha, other.fecha) && id == other.id
				&& jugado == other.jugado
				&& Float.floatToIntBits(recaudacion) == Float.floatToIntBits(other.recaudacion);
	}

	@Override
	public String toString() {
		return "Bingo [id=" + id + ", fecha=" + fecha + ", recaudacion=" + recaudacion + ", jugado=" + jugado
				+ ", cartones=" + cartones + ", bolasSacadas=" + bolasSacadas + ", b=" + b + "]";
	}

	public boolean add(ICarton c) {
		return false;
	}

	public ICarton crearCarton(String tipo, Usuario u) {
		tipo="75M";
		if(u.getMonedero()<2.0F) {
			return null;
		}else {
			CartonBuilder cb= new CartonBuilder(tipo);
			return cb.build();
		}
	}
	
	public abstract Reparto jugar(Estadistica[] est);
	
	public abstract Reparto jugar(Estadistica[] estadistica, List<Integer> numeros);
		

}
