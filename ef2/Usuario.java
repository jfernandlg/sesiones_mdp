package es.unex.cum.mdp.ef2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Usuario {
	protected String nick;
	protected String nombre;
	protected String password;
	protected float monedero;
	protected int numBingos;
	protected int numLineas;
	protected int numEspeciales;
	protected List<ICarton> cartones;
	protected Queue<Carton75M> cartonesHist;
	protected List<Movimiento> historico;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public float getMonedero() {
		return monedero;
	}

	public void setMonedero(float monedero) {
		this.monedero = monedero;
	}

	public int getNumBingos() {
		return numBingos;
	}

	public void setNumBingos(int numBingos) {
		this.numBingos = numBingos;
	}

	public int getNumLineas() {
		return numLineas;
	}

	public void setNumLineas(int numLineas) {
		this.numLineas = numLineas;
	}

	public int getNumEspeciales() {
		return numEspeciales;
	}

	public void setNumEspeciales(int numEspeciales) {
		this.numEspeciales = numEspeciales;
	}

	public List<ICarton> getCartones() {
		return cartones;
	}

	public void setCartones(List<ICarton> cartones) {
		this.cartones = cartones;
	}

	public Queue<Carton75M> getCartonesHist() {
		return this.cartonesHist;
	}

	public void setCartonesHist(Queue<Carton75M> cartonesHist) {
		this.cartonesHist = cartonesHist;
	}

	public Usuario(String nick, String nombre, String password, float monedero) {
		super();
		this.nick = nick;
		this.nombre = nombre;
		this.password = password;
		this.monedero = monedero;
		this.cartones = new LinkedList<ICarton>();
		this.cartonesHist = new LinkedList<Carton75M>();
	}

	public Usuario() {
		super();
		this.nick = "";
		this.nombre = "";
		this.password = "";
		this.monedero = 0;
		this.numBingos = 0;
		this.numLineas = 0;
		this.numEspeciales = 0;
		this.cartones = new LinkedList<ICarton>();
		this.cartonesHist = new LinkedList<Carton75M>();

	}

	@Override
	public String toString() {
		return "Usuario [nick=" + nick + ", nombre=" + nombre + ", password=" + password + ", monedero=" + monedero
				+ ", numBingos=" + numBingos + ", numLineas=" + numLineas + ", numEspeciales=" + numEspeciales
				+ ", cartones=" + cartones + ", cartonesList=" + cartonesHist + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartones, cartonesHist, monedero, nick, nombre, numBingos, numEspeciales, numLineas,
				password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cartones, other.cartones) && Objects.equals(cartonesHist, other.cartonesHist)
				&& Float.floatToIntBits(monedero) == Float.floatToIntBits(other.monedero)
				&& Objects.equals(nick, other.nick) && Objects.equals(nombre, other.nombre)
				&& numBingos == other.numBingos && numEspeciales == other.numEspeciales && numLineas == other.numLineas
				&& Objects.equals(password, other.password);
	}

	public List<Movimiento> getHistorico() {
		
		return null;
	}
	
	public boolean addCarton(Carton75M c) {
		cartones.add(c);
		return true;
	}
	
	public boolean addCartonHistorico(Carton75M c) {
		cartonesHist.offer(c);
		return true;
	}

	public boolean addMovimiento(Movimiento m) {
		if(m.getValor()<=0) {
			return false;
		}else {
			historico.add(m);
			m.setMonederoActual(m.getMonederoActual()+m.getValor());
			return true;
		}
	}
}
