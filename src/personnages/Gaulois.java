package personnages;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
//	public void setNom(String nom) {
//		this.nom = nom;
//	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	public static void main(String[] args) {
		// TODO faire la fonction de test pour la classe Gaulois
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);
		System.out.println(asterix.prendreParole());
		asterix.parler("Oui");
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}

	/*private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}*/
	

	private String prendreParole() { 
		return "Le gaulois " + nom + " : ";  
	} 
	
	/*public void frapper (Romain romain) {
		System.out.println(nom + "envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(force/3);
	}*/
	
	public void frapper(Romain romain) { 
		System.out.println(nom  +  "  envoie  un  grand  coup  dans  la mâchoire de " + romain.getNom()); 
		Equipement[]  tropheesLocal  =  romain.recevoirCoup((force  /  3)  * effetPotion); 
		for  (int  i  =  0;  tropheesLocal  !=  null  &&  i  <  tropheesLocal.length;  i++, nbTrophees++) { 
			this.trophees[nbTrophees] = tropheesLocal[i]; 
		} 
		return;
	}
}

