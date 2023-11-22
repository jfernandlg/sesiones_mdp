package es.unex.cum.mdp.ef2;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;


public class Carton75M implements ICarton {
	private int id;
	private Usuario user;
	private float precio;
	private float premio;
	private EstadoCarton estado;
	private CeldaCarton[][] numeros;

	private int numeroFilas;
	private int numeroColumnas;
	private int numeroMaximo;
	private int numeroAciertosBingo;
	private int numeroAciertosLinea;
	private int numEspeciales;
	private int contCantado = 0;
	private int contEspeciales = 0;
	private int contIds = 0;

	public int getNumeroFilas() {
		return numeroFilas;
	}

	public void setNumeroFilas(int numeroFilas) {
		this.numeroFilas = numeroFilas;
	}

	public int getNumeroColumnas() {
		return numeroColumnas;
	}

	public void setNumeroColumnas(int numeroColumnas) {
		this.numeroColumnas = numeroColumnas;
	}

	public int getNumeroMaximo() {
		return numeroMaximo;
	}

	public void setNumeroMaximo(int numeroMaximo) {
		this.numeroMaximo = numeroMaximo;
	}

	public int getNumeroAciertosBingo() {
		return numeroAciertosBingo;
	}

	public void setNumeroAciertosBingo(int numeroAciertosBingo) {
		this.numeroAciertosBingo = numeroAciertosBingo;
	}

	public int getNumeroAciertosLinea() {
		return numeroAciertosLinea;
	}

	public void setNumeroAciertosLinea(int numeroAciertosLinea) {
		this.numeroAciertosLinea = numeroAciertosLinea;
	}

	public int getNumEspeciales() {
		return numEspeciales;
	}

	public void setNumEspeciales(int numEspeciales) {
		this.numEspeciales = numEspeciales;
	}

	public Carton75M() {
		super();
		this.id = ++contIds;
		this.user = new Usuario();
		this.precio = 0;
		this.premio = 0;
		this.numeroFilas = 5;
		this.numeroColumnas = 5;
		this.estado = estado.NADA;

		this.numeros = new CeldaCarton[numeroFilas][numeroColumnas];
		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < numeros[i].length; j++) {
				numeros[i][j] = new CeldaCarton(0, 0, i, j);
			}
		}
		this.numEspeciales = 2;
		this.numeroMaximo = 75;
		this.numeroAciertosBingo = 20;
		this.numeroAciertosLinea = 4;
		this.contCantado = 0;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(numeros);
		result = prime * result + Objects.hash(estado, id, numEspeciales, numeroAciertosBingo, numeroAciertosLinea,
				numeroColumnas, numeroFilas, numeroMaximo, precio, premio, user);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carton75M other = (Carton75M) obj;
		return estado == other.estado && id == other.id && numEspeciales == other.numEspeciales
				&& numeroAciertosBingo == other.numeroAciertosBingo && numeroAciertosLinea == other.numeroAciertosLinea
				&& numeroColumnas == other.numeroColumnas && numeroFilas == other.numeroFilas
				&& numeroMaximo == other.numeroMaximo && Arrays.deepEquals(numeros, other.numeros)
				&& Float.floatToIntBits(precio) == Float.floatToIntBits(other.precio)
				&& Float.floatToIntBits(premio) == Float.floatToIntBits(other.premio)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Carton75M [id=" + id + ", user=" + user + ", precio=" + precio + ", premio=" + premio + ", estado="
				+ estado + ", numeros=" + Arrays.toString(numeros) + ", numeroFilas=" + numeroFilas
				+ ", numeroColumnas=" + numeroColumnas + ", numeroMaximo=" + numeroMaximo + ", numeroAciertosBingo="
				+ numeroAciertosBingo + ", numeroAciertosLinea=" + numeroAciertosLinea + ", numEspeciales="
				+ numEspeciales + "]";
	}

	@Override
	public EstadoCarton getEstado() {
		return estado;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public void setEstado(EstadoCarton estado) {
		this.estado = estado;
	}

	@Override
	public int getAciertos() {
		int aciertos = 0;
		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < numeros.length; i++) {
				if (numeros[i][j].getEstado() == 2) {
					aciertos++;
				}
			}
		}
		return aciertos;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public Usuario getUser() {
		return user;
	}

	@Override
	public boolean comprobarLinea() {

		int cont = 0;
		for (int i = 0; i < numeros.length; i++) {
			cont = 0;
			for (int j = 0; j < numeros[i].length; j++) {
				if (numeros[i][j].getEstado() == 2 && i != j) {
					cont++;
				}
			}
			if (cont == 4) {
				if (estado == EstadoCarton.NADA) {
					this.setEstado(EstadoCarton.LINEA);
					return true;
				} else if (estado == EstadoCarton.ESPECIAL) {
					this.setEstado(EstadoCarton.ESPECIAL_LINEA);
					return true;
				}
				return true;
			}

		}

		return false;

	}

	@Override
	public boolean comprobarLinea(int fila) {
		for (int j = 0; j < numeros.length; j++) {
			if (numeros[fila][j].getEstado() == 2 && fila != j) {
				this.setEstado(EstadoCarton.LINEA);
				return true;
			}

		}
		return false;
	}

	@Override
	public boolean recibirNumero(int numero) {
		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < numeros[i].length; j++) {
				if (numeros[i][j].getNumero() == numero) {
					numeros[i][j].setEstado(2);
					contCantado++;
					return true;
				}

			}
		}
		return false;
	}

	@Override
	public boolean comprobarBingo() {
		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < numeros[i].length; j++) {
			}
		}
		if (contCantado == 20) {
			if (this.estado == EstadoCarton.NADA) {
				this.setEstado(EstadoCarton.BINGO);
				return true;
			} else if (this.estado == EstadoCarton.ESPECIAL) {
				this.setEstado(EstadoCarton.ESPECIAL_BINGO);
				return true;
			} else if (this.estado == EstadoCarton.LINEA) {
				this.setEstado(EstadoCarton.LINEA_BINGO);
				return true;
			} else if (this.estado == EstadoCarton.ESPECIAL_LINEA) {
				this.setEstado(EstadoCarton.ESPECIAL_LINEA_BINGO);
				return true;
			}

		}
		return false;
	}

	@Override
	public boolean comprobarEspeciales() {

		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < numeros[i].length; j++) {
				if (numeros[i][j].getEspecial() == true && numeros[i][j].getEstado() == 2) {
					contEspeciales++;
				}
			}
		}

		if (contEspeciales == numEspeciales) {
			if (this.estado == EstadoCarton.NADA) {
				this.setEstado(EstadoCarton.ESPECIAL);
				return true;
			} else if (this.estado == EstadoCarton.LINEA) {
				this.setEstado(EstadoCarton.ESPECIAL_LINEA);
				return true;
			} else if (this.estado == EstadoCarton.BINGO) {
				this.setEstado(EstadoCarton.ESPECIAL_BINGO);
				return true;
			} else if (this.estado == EstadoCarton.ESPECIAL_BINGO) {
				this.setEstado(EstadoCarton.ESPECIAL_LINEA_BINGO);
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean repartir() {
		int aleatorio = 0;
		int contNumeros = 0;
		boolean completado = false;
		Random r = new Random();
		boolean[] noRepetido = new boolean[75];
		int j = 0;
		while (!completado) {
			for (int i = 0; i < numeros.length; i++) {
				aleatorio = r.nextInt(15) + 1 + (j * 15);
				while (noRepetido[aleatorio - 1] == true) {
					aleatorio = r.nextInt(15) + 1 + (j * 15);

				}
				if (i != j) {
					numeros[i][j] = new CeldaCarton(aleatorio, 1, i, j);
					noRepetido[aleatorio - 1] = true;
					contNumeros++;
				}
			}
			j++;
			if (contNumeros == 20) {
				completado = true;
			}
		}
		for (int i = 0; i < numeros.length; i++) {
			System.out.println(" ");
			for (int y = 0; y < numeros[i].length; y++) {
				System.out.print(" ");
				System.out.print(numeros[i][y].getNumero());
			}
		}
		return true;
	}

	@Override
	public boolean addNumero(CeldaCarton c) {
		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < numeros[i].length; j++) {
				if (numeros[i][j] != null && numeros[i][j].getNumero() == c.getNumero()) {
					return false;
				}
			}
		}
		numeros[c.getFila()][c.getColumna()] = c;

		return false;
	}

	@Override
	public boolean addEspecial(int num) {
		int cont = 0;
		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < numeros[i].length; j++) {
				if (numeros[i][j].getNumero() == num && cont <= numEspeciales) {
					numeros[i][j].setEspecial(true);
					cont++;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public float getPrecio() {
		return precio;
	}

	@Override
	public void setPremio(float valor) {
		this.premio = valor;
	}

	@Override
	public float getPremio() {
		return premio;
	}

	@Override
	public CeldaCarton[][] getNumeros() {
		return numeros;
	}

	public void setNumeros(CeldaCarton[][] numeros) {
		this.numeros = numeros;
	}

}
