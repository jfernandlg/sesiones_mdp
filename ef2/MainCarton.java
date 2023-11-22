package es.unex.cum.mdp.ef2;

public class MainCarton {
	public static void main(String[] args) {
		CartonBuilder cb = new CartonBuilder("75M");
		ICarton c = cb.withId(1)
				.withUser(new Usuario())
				.build(); //75H o 75M
		System.out.println(c.toString());
	}
}
