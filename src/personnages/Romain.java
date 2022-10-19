package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		assert force >= 0 : "Valeur de force négative.";
		this.nom = nom;
		this.force = force;
	}
	
	public int getForce() {
		return force;
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
	
	public void sEquiper(Equipement equip) {
		switch(nbEquipement) 
		{
		case 2 : 
			System.out.println("Le soldat " + this.getNom() + " est déjà bien protégé !");
			break;
		case 0 : 
			setEquipement(equip);
			break;
		case 1 : 
			if (this.equipements[0].toString() == equip.toString()) {
				System.out.println("Le soldat " + this.getNom() + " possède déjà un " + equip.toString());
				break;
			} 
			else {
				setEquipement(equip);
				break;
			}
		}
	}
	
	public void setEquipement(Equipement equip) {
		this.equipements[this.nbEquipement] = equip;
		this.nbEquipement++;
		System.out.println("Le soldat " + this.getNom() +" s'équipe d'un " + equip.toString());
	}
	/*
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
		*/

	private void setEquipements(Equipement[] equipements) {
		this.equipements = equipements;
	}

	public Equipement[] recevoirCoup(int forceCoup) { 
		Equipement[] equipementEjecte = null; 
		// précondition 
		assert force > 0; 
		int oldForce = force; 
		 
		forceCoup = calculResistanceEquipement(forceCoup); 
		 
		force -= forceCoup; 
	if (force > 0) { 
		parler("Aïe"); 
	} else { 
			equipementEjecte = ejecterEquipement(); 
		parler("J'abandonne..."); 
		} 
		if (force == 0) { 
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("j'abandonne...");
		}
	// post condition la force à diminuer
	//assert force < oldForce;
	return equipementEjecte;
	}
	

	private int calculResistanceEquipement(int forceCoup) { 
		String texte = "Ma force est  de " + this.force + ", et la force du coup est de " + forceCoup; 
		int resistanceEquipement = 0; 
		if (nbEquipement != 0) { 
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de "; 
			for (int i = 0; i < nbEquipement; i++) { 
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) { 
					resistanceEquipement += 8; 
				} else { 
					System.out.println("Equipement casque"); 
					resistanceEquipement += 5; 
				}  
			} 
			texte += resistanceEquipement + "!"; 
		} 
		parler(texte); 
		forceCoup -= resistanceEquipement; 
		if (forceCoup < 0) {
			return 0;
		} else {
		return forceCoup;
		} 
	}
	

	private Equipement[] ejecterEquipement() { 
		Equipement[] equipementEjecte = new Equipement[nbEquipement]; 
		System.out.println("L'équipement  de  "  +  nom  +  " s'envole sous la force du coup."); 
		int nbEquipementEjecte = 0; 
		for (int i = 0; i < nbEquipement; i++) { 
			if (equipements[i] != null) { 
				equipementEjecte[nbEquipementEjecte]  = 
				equipements[i]; 
				nbEquipementEjecte++; 
				equipements[i] = null; 
			}
		} 
		return equipementEjecte; 
	}
	
	public static void main (String[] args) {
		Romain julius = new Romain("Julius", 5);
		julius.sEquiper(Equipement.BOUCLIER);
		julius.parler("Non");
		julius.recevoirCoup(9);
		
	}
}
