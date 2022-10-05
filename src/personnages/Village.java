package personnages;


public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		this.villageois[this.nbVillageois] = gaulois;
		this.nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int place) {
		return this.villageois[place];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans " + getNom() + " du chef " + chef.getNom() + "vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}
	
	public static void main(String args[]) {
		Village village = new Village("Village des Irréductibles", 30);
		//Gaulois gaulois = village.trouverHabitant(30);
		// nbvmax = 30 ici, donc on peut aller de 0 à 29 dans le tableau village or avec 30 on déborde.
		Chef abraracourcix = new Chef("Abraracourcix", 6, 1, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix", 6);
		village.ajouterHabitant(asterix);
		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
		/*
		 * Gaulois gaulois = village.trouverHabitant(1);
		 * System.out.println(gaulois);
		 * 
		 * On obtient "null", car Asterix est à la place 0.
		 */
	}
}
