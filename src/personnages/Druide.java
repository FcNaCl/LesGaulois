package personnages;
import java.util.Random;
import histoire.Druide;

public class Druide {
	private static String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " � " + effetPotionMax + ".");
	}
	
	public String getNom() {
		return nom;
	}
	
	public static void parler(String texte) {
		System.out.println(prendreParole()+ "<< " + texte + ">>");
	}
	
	private static int preparerPotion(Druide druide) {
		Random random = new Random();
		int forcePotionLocale = random.nextInt(druide.effetPotionMax-druide.effetPotionMin)+druide.effetPotionMin ;
		if (forcePotionLocale > 7) {
			 parler("J'ai pr�par� une super potion de force " + forcePotionLocale);
		 } else {
			 parler("Je n'ai pas trouv� tous les ingr�dients, ma potion est seulement de force " + forcePotionLocale);
		 }
		return forcePotionLocale;
	}
	
	private static String prendreParole() {
		return "Le druite " + nom + " : ";
	}

	 public static void main(String[] args) {
		 Druide panoramix = new Druide("Panoramix", 5, 10);
		 panoramix.forcePotion = preparerPotion(panoramix);
		 
	 }
}
