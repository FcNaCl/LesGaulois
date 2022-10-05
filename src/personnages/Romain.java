package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		assert force >= 0 : "Valeur de force négative.";
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert force >= 0 : "La force du romain est négative.";
		int forceInit = force;
		force -= forceCoup;
		assert forceInit > force : "La force du romain n'a pas diminuée";
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
	public static void main (String[] args) {
		Romain julius = new Romain("Julius", 5);
		System.out.println(julius.prendreParole());
		julius.parler("Non");
		julius.recevoirCoup(9);
	}
}
