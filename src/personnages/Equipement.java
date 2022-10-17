package personnages;

public enum Equipement {
	BOUCLIER("Bouclier"), CASQUE("Casque");
	private String nom;
	
	Equipement(String nom){
		this.nom = nom;
	}
	@Override
	public String toString() {
		return nom;
	}
}
