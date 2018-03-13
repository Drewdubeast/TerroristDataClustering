

public class Country {
	
	private String name;
	private int ID;
	
	public int[] attackCounts = new int[7];
	public int[] targCounts = new int[21];
	public int[] weapCounts = new int[12];
	
	
	//Count Attributes
	public int cAttackAssassin = 0; //0
	public int cAttackHostage = 0; //1
	public int cAttackBomb = 0; //etc
	public int cAttackFacility = 0;
	public int cAttackAssault = 0;
	public int cAttackHijack = 0;
	public int cAttackUnknown = 0;
	
	public int cTargCitizen = 0;
	public int cTargGovernment = 0;
	public int cTargMedia = 0;
	public int cTargPolice = 0;
	public int cTargUtilities = 0;
	public int cTargMilitary = 0;
	public int cTargAir = 0;
	public int cTargBusiness = 0;
	public int cTargEdu = 0;
	public int cTargPoliticalParty = 0;
	public int cTargUnknown = 0;
	public int cTargTransport = 0;
	public int cTargTourists = 0;
	public int cTargNGO = 0;
	public int cTargTele = 0;
	public int cTargFoodWater = 0;
	public int cTargTerrorists = 0;
	public int cTargOther = 0;
	public int cTargMaritime = 0;
	public int cTargAbortion = 0;
	public int cTargReligion = 0;
	
	public int cWeapUnknown = 0;
	public int cWeapBomb = 0;
	public int cWeapIncendiary = 0;
	public int cWeapFirearms = 0;
	public int cWeapChemical = 0;
	public int cWeapFake = 0;
	public int cWeapMelee = 0;
	public int cWeapSabotage = 0;
	public int cWeapVehicle = 0;
	public int cWeapRadiological = 0;
	public int cWeapOther = 0;
	public int cWeapBiological = 0;

	
	public Country(String name, int ID) {
		this.name = name;
		this.ID = ID;
	}
	public String getName() {
		return name;
	}
	public int getID() {
		return ID;
	}
	public void update() {
		attackCounts[0] = cAttackAssassin; //0
		attackCounts[1] = cAttackHostage; //1
		attackCounts[2] = cAttackBomb; //etc
		attackCounts[3] = cAttackFacility;
		attackCounts[4] = cAttackAssault;
		attackCounts[5] = cAttackHijack;
		attackCounts[6] = cAttackUnknown;
		
		targCounts[0] = cTargCitizen;
		targCounts[1] = cTargGovernment;
		targCounts[2] = cTargMedia;
		targCounts[3] = cTargPolice;
		targCounts[4] = cTargUtilities;
		targCounts[5] = cTargMilitary;
		targCounts[6] = cTargAir;
		targCounts[7] = cTargBusiness;
		targCounts[8] = cTargEdu;
		targCounts[9] = cTargPoliticalParty;
		targCounts[10] = cTargUnknown;
		targCounts[11] = cTargTransport;
		targCounts[12] = cTargTourists;
		targCounts[13] = cTargNGO;
		targCounts[14] = cTargTele;
		targCounts[15] = cTargFoodWater;
		targCounts[16] = cTargTerrorists;
		targCounts[17] = cTargOther;
		targCounts[18] = cTargMaritime;
		targCounts[19] = cTargAbortion;
		targCounts[20] = cTargReligion;
		
		weapCounts[0] = cWeapUnknown;
		weapCounts[1] = cWeapBomb;
		weapCounts[2] = cWeapIncendiary;
		weapCounts[3] = cWeapFirearms;
		weapCounts[4] = cWeapChemical;
		weapCounts[5] = cWeapFake;
		weapCounts[6] = cWeapMelee;
		weapCounts[7] = cWeapSabotage;
		weapCounts[8] = cWeapVehicle;
		weapCounts[9] = cWeapRadiological;
		weapCounts[10] = cWeapOther;
		weapCounts[11] = cWeapBiological;
	}
	public String maxAttack() {
		int max = findMaxAttack();

		String strMax = null;
		
		switch(max) {
		case 0:
			strMax = "Assassination";
			break;
		case 1:
			strMax = "Hostage Taking";
			break;
		case 2:
			strMax = "Bombing";
			break;
		case 3:
			strMax = "Facility Attack";
			break;
		case 4:
			strMax = "Assaulting";
			break;
		case 5: 
			strMax = "Hijacking";
			break;
		case 6:
			strMax = "Unknown";
			break;
		default:
			break;
		}
		return strMax;
	}
	private int findMaxAttack(){
		update();
		int max = 0;
		for(int i = 0; i < attackCounts.length; i++)
		{
			if (attackCounts[i] >= attackCounts[max])
			{
				max = i;
			}
		}
		return max;
	}

	public String maxTarg() {
		int max = findMaxTarg();
		//System.out.println("Max index for TARGET is: " + max);
		String strMax = null;
		
		switch (max) {
		case 0:
			strMax = "Citizens";
			break;
		case 1:
			strMax = "Government";
			break;
		case 2:
			strMax = "Media";
			break;
		case 3:
			strMax = "Police";
			break;
		case 4:
			strMax = "Utilities";
			break;
		case 5:
			strMax = "Military";
			break;
		case 6:
			strMax = "Air";
			break;
		case 7:
			strMax = "Business";
			break;
		case 8:
			strMax = "Education";
			break;
		case 9:
			strMax = "Political Party";
			break;
		case 10:
			strMax = "Unknown";
			break;
		case 11:
			strMax = "Transport";
			break;
		case 12:
			strMax = "Tourists";
			break;
		case 13:
			strMax = "NGO"; //non-government organization
			break;
		case 14:
			strMax = "Telecommunications";
			break;
		case 15:
			strMax = "Food or Water";
			break;
		case 16:
			strMax = "Terrorists";
			break;
		case 17:
			strMax = "Other";
			break;
		case 18:
			strMax = "Maritime";
			break;
		case 19:
			strMax = "Abortion";
			break;
		case 20:
			strMax = "Religion";
			break;
		default:
			break;
		}
		return strMax;
		
	}
	private int findMaxTarg() {
		update();
		int i, max = 0;
		for(i = 0; i < targCounts.length; i++)
		{
			if (targCounts[i] > targCounts[max])
			{
				max = i;
			}
		}
		return max;
	}
	public String maxWeapon() {
		int max = findMaxWeap();
		//System.out.println("Max index for WEAPON is: " + max);

		String strMax = null;
		
		switch(max) {
		case 0:
			strMax = "Unknown";
			break;
		case 1:
			strMax = "Bombs";
			break;
		case 2:
			strMax = "Incendiary";
			break;
		case 3:
			strMax = "Firearms";
			break;
		case 4:
			strMax = "Chemical Weapons";
			break;
		case 5:
			strMax = "Fake Weapons";
			break;
		case 6:
			strMax = "Melee Weapons";
			break;
		case 7:
			strMax = "Sabotages";
			break;
		case 8:
			strMax = "Vehicles";
			break;
		case 9:
			strMax = "Radiological Weapons";
			break;
		case 10:
			strMax = "Other";
			break;
		case 11:
			strMax = "Biological Weapons";
			break;
		default:
			break;
		}
		return strMax;
	}
	private int findMaxWeap() {
		update();
		int max = 0;
		for(int i = 0; i < weapCounts.length; i++)
		{
			if (weapCounts[i] >= weapCounts[max])
			{
				max = i;
			}
		}
		return max;
	}
	public String toString() {
		update();
		String s = "\n============Country============\n"
				+ "Name: " + name + "\n"
				+ "ID: " + ID + "\nMax Attack Type: " + maxAttack() 
				+ "\nMax Target Type: " + maxTarg() + "\nMax Weapon: "
				+ maxWeapon() + "\n";
		//System.out.println(Arrays.toString(attackCounts));
		//System.out.println(Arrays.toString(targCounts));
		//System.out.println(Arrays.toString(weapCounts));
		return s;
	}
}
