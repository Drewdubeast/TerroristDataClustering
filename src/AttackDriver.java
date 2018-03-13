import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

	
public class AttackDriver {

	public static void main(String[] args) {
				
		String fileName = "drewTerror.txt";
		
		TerroristAttack curr;
		Country currCountry;
		
		String currArray[];
		
		HashMap<String,ArrayList<String>> attackMap = new HashMap<String,ArrayList<String>>();
		HashMap<String,ArrayList<String>> targetMap = new HashMap<String,ArrayList<String>>();
		HashMap<String,ArrayList<String>> weapMap = new HashMap<String,ArrayList<String>>();
		
		
		
		String line = null;
		
		ArrayList<TerroristAttack> attacks = new ArrayList<TerroristAttack>();
		Country[] countries = new Country[606];
		for (int i = 0; i<606; i++) {
			countries[i] = null;
		}
		
		try {
		    // FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);
		
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while((line = bufferedReader.readLine()) != null) {
			    		try {
			    			currArray = line.split(",");
			    			
			    			for (int i = 0; i<currArray.length; i++) {
			    				if (currArray[i].equals("*"))
			    					currArray[i] = "0";
			    			}
			    			
			    			curr = new TerroristAttack(
			    					//integers
			    					Integer.parseInt(currArray[0]), //year
			    					Integer.parseInt(currArray[1]), //Country
			    					Integer.parseInt(currArray[2]), //Region
			    					Integer.parseInt(currArray[3]), //Attack Type
			    					Integer.parseInt(currArray[4]), //Target Type
			    					Integer.parseInt(currArray[5]), //Target Sub Type
			    					Integer.parseInt(currArray[6]), //Weapon Type
			    					Double.parseDouble(currArray[7]), //Latitude
			    					Double.parseDouble(currArray[8]), //Longitude
			    					
			    					//Strings
			    					currArray[9], //Country Name
			    					currArray[10], //Region Name
			    					currArray[11], //Attack Type Name
			    					currArray[12], //Target Type Name
			    					currArray[13], //Target Sub Type Name
			    					currArray[14], //Weapon Type Name
			    					currArray[15]); //Group Name
			    			
			    			//Add countries to the list
			    			int countryID = Integer.parseInt(currArray[1]);
			    			String countryName = currArray[9];
			    			
			    			attacks.add(curr);
			    			
			    			
			    			
			    			//check if the country is in the countries ArrayList, if not,
			    			//adds it at the index of the country's ID
			    			if(countries[countryID] == null) {
			    				currCountry = new Country(countryName, countryID);
			    				countries[countryID] = currCountry;
			    			}
			    			
			    		} catch (NumberFormatException e) {
			    			System.out.println("Number format exception on line" + line);
			    		}
			    }
		// Always close files.
		    bufferedReader.close();         
		}
		catch(FileNotFoundException ex) {
		    System.out.println(
		        "Unable to open file '" + 
		    fileName + "'");                
		}
		catch(IOException ex) {
		    System.out.println(
		        "Error reading file '" 
		    + fileName + "'");                  
		}

		/***
		 * Now, we are going to go through and do data analysis on our countries
		 */
		for(int i = 0; i<attacks.size(); i++) {
			
			Country thisCountry = countries[attacks.get(i).country];
			
			int attack = attacks.get(i).attackType;
			int targ = attacks.get(i).targType;
			int weap = attacks.get(i).weapType;

			
			switch(attack) {
			case 1:
				countries[attacks.get(i).country].cAttackAssassin++;
				break;
			case 2:
				countries[attacks.get(i).country].cAttackAssault++;
				break;
			case 3:
				countries[attacks.get(i).country].cAttackBomb++;
				break;
			case 4:
				countries[attacks.get(i).country].cAttackHijack++;
				break;
			case 5:
				countries[attacks.get(i).country].cAttackHostage++;
				break;
			case 6: 
				countries[attacks.get(i).country].cAttackHostage++;
				break;
			case 7:
				countries[attacks.get(i).country].cAttackFacility++;
				break;
			case 8:
				countries[attacks.get(i).country].cAttackAssault++;
				break;
			case 9: 
				countries[attacks.get(i).country].cAttackUnknown++;
				break;
			default:
				break;
			}
			
			switch (targ) {
			case 1:
				countries[attacks.get(i).country].cTargBusiness++;
				break;
			case 2:
				countries[attacks.get(i).country].cTargGovernment++;
				break;
			case 3:
				countries[attacks.get(i).country].cTargPolice++;
				break;
			case 4:
				countries[attacks.get(i).country].cTargMilitary++;
				break;
			case 5:
				countries[attacks.get(i).country].cTargAbortion++;
				break;
			case 6:
				countries[attacks.get(i).country].cTargAir++;
				break;
			case 7:
				countries[attacks.get(i).country].cTargGovernment++;
				break;
			case 8:
				countries[attacks.get(i).country].cTargEdu++;
				break;
			case 9:
				countries[attacks.get(i).country].cTargFoodWater++;
				break;
			case 10:
				countries[attacks.get(i).country].cTargMedia++;
				break;
			case 11:
				countries[attacks.get(i).country].cTargMaritime++;
				break;
			case 12:
				countries[attacks.get(i).country].cTargNGO++;
				break;
			case 13:
				countries[attacks.get(i).country].cTargOther++;
				break;
			case 14:
				countries[attacks.get(i).country].cTargCitizen++;
				break;
			case 15:
				countries[attacks.get(i).country].cTargReligion++;
				break;
			case 16:
				countries[attacks.get(i).country].cTargTele++;
				break;
			case 17:
				countries[attacks.get(i).country].cTargTerrorists++;
				break;
			case 18:
				countries[attacks.get(i).country].cTargTourists++;
				break;
			case 19:
				countries[attacks.get(i).country].cTargTransport++;
				break;
			case 20:
				countries[attacks.get(i).country].cTargUnknown++;
				break;
			case 21:
				countries[attacks.get(i).country].cTargUtilities++;
				break;
			case 22:
				countries[attacks.get(i).country].cTargPoliticalParty++;
				break;	
			default:
				break;
			}
			switch(weap) {
			case 1:
				countries[attacks.get(i).country].cWeapBiological++;
				break;
			case 2:
				countries[attacks.get(i).country].cWeapChemical++;
				break;
			case 3:
				countries[attacks.get(i).country].cWeapRadiological++;
				break;
			case 4:
				break;
			case 5:
				countries[attacks.get(i).country].cWeapFirearms++;
				break;
			case 6:
				countries[attacks.get(i).country].cWeapBomb++;
				break;
			case 7:
				countries[attacks.get(i).country].cWeapFake++;
				break;
			case 8:
				countries[attacks.get(i).country].cWeapIncendiary++;
				break;
			case 9:
				countries[attacks.get(i).country].cWeapMelee++;
				break;
			case 10:
				countries[attacks.get(i).country].cWeapVehicle++;
				break;
			case 11:
				countries[attacks.get(i).country].cWeapSabotage++;
				break;
			case 12:
				countries[attacks.get(i).country].cWeapOther++;
				break;
			case 13:
				countries[attacks.get(i).country].cWeapUnknown++;
				break;
			default:
				break;
			}
			
			//set the new array into the old spot
			countries[attacks.get(i).country] = thisCountry;
			
		}


		
		
		for(int i = 0; i<countries.length;i++) {
			
			/*
			 * ATTACK TYPES
			 */
			
			//Assassination
			if (countries[i] != null && countries[i].maxAttack().equalsIgnoreCase("Assassination")) {
				if (!(attackMap.containsKey("Assassination"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					attackMap.put("Assassination", list);
				}
				else {
					attackMap.get("Assassination").add(countries[i].getName());
				}
			}
			//Hostage Taking
			else if (countries[i] != null && countries[i].maxAttack().equalsIgnoreCase("Hostage Taking")) {
				
				if (!(attackMap.containsKey("Hostage Taking"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					attackMap.put("Hostage Taking", list);
				}
				else {
					attackMap.get("Hostage Taking").add(countries[i].getName());
				}
			}
			
			//Bombing
			else if (countries[i] != null && countries[i].maxAttack().equalsIgnoreCase("Bombing")) {
				
				if (!(attackMap.containsKey("Bombing"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					attackMap.put("Bombing", list);
				}
				else {
					attackMap.get("Bombing").add(countries[i].getName());
				}
			}
			
			//Facility Attacks
			else if (countries[i] != null && countries[i].maxAttack().equalsIgnoreCase("Facility Attack")) {
				
				if (!(attackMap.containsKey("Facility Attack"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					attackMap.put("Facility Attack", list);
				}
				else {
					attackMap.get("Facility Attack").add(countries[i].getName());
				}
			}
				
			//Assaulting
			else if (countries[i] != null && countries[i].maxAttack().equalsIgnoreCase("Assaulting")) {
				if (!(attackMap.containsKey("Assaulting"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					attackMap.put("Assaulting", list);
				}
				else {
					attackMap.get("Assaulting").add(countries[i].getName());
				}
			}
			
			//Hijacking
			else if (countries[i] != null && countries[i].maxAttack().equalsIgnoreCase("Hijacking")) {
				
				if (!(attackMap.containsKey("Hijacking"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					attackMap.put("Hijacking", list);
				}
				else {
					attackMap.get("Hijacking").add(countries[i].getName());
				}
			}
			
			//Unknown
			else if (countries[i] != null && countries[i].maxAttack().equalsIgnoreCase("Unknown")) {
				
				if (!(attackMap.containsKey("Unknown"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					attackMap.put("Unknown", list);
				}
				else {
					attackMap.get("Unknown").add(countries[i].getName());
				}
			} 
			/*
			 * TARGET TYPES
			 */
			
			//Assassination
			if (countries[i] != null && countries[i].maxTarg().equalsIgnoreCase("Citizens")) {
				if (!(targetMap.containsKey("Citizens"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					targetMap.put("Citizens", list);
				}
				else {
					targetMap.get("Citizens").add(countries[i].getName());
				}
			}
			//Hostage Taking
			else if (countries[i] != null && countries[i].maxTarg().equalsIgnoreCase("Government")) {
				
				if (!(targetMap.containsKey("Government"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					targetMap.put("Government", list);
				}
				else {
					targetMap.get("Government").add(countries[i].getName());
				}
			}
			
			//Bombing
			else if (countries[i] != null && countries[i].maxTarg().equalsIgnoreCase("Media")) {
				
				if (!(targetMap.containsKey("Media"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					targetMap.put("Media", list);
				}
				else {
					targetMap.get("Media").add(countries[i].getName());
				}
			}
			
			//Facility Attacks
			else if (countries[i] != null && countries[i].maxTarg().equalsIgnoreCase("Police")) {
				
				if (!(targetMap.containsKey("Police"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					targetMap.put("Police", list);
				}
				else {
					targetMap.get("Police").add(countries[i].getName());
				}
			}
				
			//Assaulting
			else if (countries[i] != null && countries[i].maxTarg().equalsIgnoreCase("Utilities")) {
				if (!(targetMap.containsKey("Utilities"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					targetMap.put("Utilities", list);
				}
				else {
					targetMap.get("Utilities").add(countries[i].getName());
				}
			}
			
			//Hijacking
			else if (countries[i] != null && countries[i].maxTarg().equalsIgnoreCase("Military")) {
				
				if (!(targetMap.containsKey("Military"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					targetMap.put("Military", list);
				}
				else {
					targetMap.get("Military").add(countries[i].getName());
				}
			}
			
			//Unknown
			else if (countries[i] != null && countries[i].maxTarg().equalsIgnoreCase("Air")) {
				
				if (!(targetMap.containsKey("Air"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					targetMap.put("Air", list);
				}
				else {
					targetMap.get("Air").add(countries[i].getName());
				}
			} 
			
			//Assassination
			else if (countries[i] != null && countries[i].maxTarg().equalsIgnoreCase("Business")) {
				if (!(targetMap.containsKey("Business"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					targetMap.put("Business", list);
				}
				else {
					targetMap.get("Business").add(countries[i].getName());
				}
			}
			//Hostage Taking
			else if (countries[i] != null && countries[i].maxTarg().equalsIgnoreCase("Education")) {
				
				if (!(targetMap.containsKey("Education"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					targetMap.put("Education", list);
				}
				else {
					targetMap.get("Education").add(countries[i].getName());
				}
			}
			
			//Bombing
			else if (countries[i] != null && countries[i].maxTarg().equalsIgnoreCase("Political Party")) {
				
				if (!(targetMap.containsKey("Politcal Party"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					targetMap.put("Politcal Party", list);
				}
				else {
					targetMap.get("Politcal Party").add(countries[i].getName());
				}
			}
			
			//Facility Attacks
			else if (countries[i] != null && countries[i].maxTarg().equalsIgnoreCase("Unknown")) {
				
				if (!(targetMap.containsKey("Unknown"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					targetMap.put("Unknown", list);
				}
				else {
					targetMap.get("Unknown").add(countries[i].getName());
				}
			}
				
			//Assaulting
			else if (countries[i] != null && countries[i].maxTarg().equalsIgnoreCase("Transport")) {
				if (!(targetMap.containsKey("Transport"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					targetMap.put("Transport", list);
				}
				else {
					targetMap.get("Transport").add(countries[i].getName());
				}
			}
			
			//Hijacking
			else if (countries[i] != null && countries[i].maxTarg().equalsIgnoreCase("Tourists")) {
				
				if (!(targetMap.containsKey("Tourists"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					targetMap.put("Tourists", list);
				}
				else {
					targetMap.get("Tourists").add(countries[i].getName());
				}
			}
			
			//Unknown
			else if (countries[i] != null && countries[i].maxTarg().equalsIgnoreCase("NGO")) {
				
				if (!(targetMap.containsKey("NGO"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					targetMap.put("NGO", list);
				}
				else {
					targetMap.get("NGO").add(countries[i].getName());
				}
			} 
			else if (countries[i] != null && countries[i].maxTarg().equalsIgnoreCase("Telecommunications")) {
				if (!(targetMap.containsKey("Telecommunications"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					targetMap.put("Telecommunications", list);
				}
				else {
					targetMap.get("Telecommunications").add(countries[i].getName());
				}
			}
			//Hostage Taking
			else if (countries[i] != null && countries[i].maxTarg().equalsIgnoreCase("Food or Water")) {
				
				if (!(targetMap.containsKey("Food or Water"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					targetMap.put("Food or Water", list);
				}
				else {
					targetMap.get("Food or Water").add(countries[i].getName());
				}
			}
			
			//Bombing
			else if (countries[i] != null && countries[i].maxTarg().equalsIgnoreCase("Terrorists")) {
				
				if (!(targetMap.containsKey("Terrorists"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					targetMap.put("Terrorists", list);
				}
				else {
					targetMap.get("Terrorists").add(countries[i].getName());
				}
			}
			
			//Facility Attacks
			else if (countries[i] != null && countries[i].maxTarg().equalsIgnoreCase("Other")) {
				
				if (!(targetMap.containsKey("Other"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					targetMap.put("Other", list);
				}
				else {
					targetMap.get("Other").add(countries[i].getName());
				}
			}
				
			//Assaulting
			else if (countries[i] != null && countries[i].maxTarg().equalsIgnoreCase("Maritime")) {
				if (!(targetMap.containsKey("Maritime"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					targetMap.put("Maritime", list);
				}
				else {
					targetMap.get("Maritime").add(countries[i].getName());
				}
			}
			
			//Hijacking
			else if (countries[i] != null && countries[i].maxTarg().equalsIgnoreCase("Abortion")) {
				
				if (!(targetMap.containsKey("Abortion"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					targetMap.put("Abortion", list);
				}
				else {
					targetMap.get("Abortion").add(countries[i].getName());
				}
			}
			
			//Unknown
			else if (countries[i] != null && countries[i].maxTarg().equalsIgnoreCase("Religion")) {
				
				if (!(targetMap.containsKey("Religion"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					targetMap.put("Religion", list);
				}
				else {
					targetMap.get("Religion").add(countries[i].getName());
				}
			} 
			
			/*
			 * WEAPON TYPES
			 */
			
			if (countries[i] != null && countries[i].maxWeapon().equalsIgnoreCase("Unknown")) {
				
				if (!(weapMap.containsKey("Unknown"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					weapMap.put("Unknown", list);
				}
				else {
					weapMap.get("Unknown").add(countries[i].getName());
				}
			} 
			else if (countries[i] != null && countries[i].maxWeapon().equalsIgnoreCase("Bombs")) {
				
				if (!(weapMap.containsKey("Bombs"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					weapMap.put("Bombs", list);
				}
				else {
					weapMap.get("Bombs").add(countries[i].getName());
				}
			} 
			else if (countries[i] != null && countries[i].maxWeapon().equalsIgnoreCase("Incendiary")) {
				
				if (!(weapMap.containsKey("Incendiary"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					weapMap.put("Incendiary", list);
				}
				else {
					weapMap.get("Incendiary").add(countries[i].getName());
				}
			} 
			else if (countries[i] != null && countries[i].maxWeapon().equalsIgnoreCase("Firearms")) {
				
				if (!(weapMap.containsKey("Firearms"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					weapMap.put("Firearms", list);
				}
				else {
					weapMap.get("Firearms").add(countries[i].getName());
				}
			} 
			else if (countries[i] != null && countries[i].maxWeapon().equalsIgnoreCase("Chemical Weapons")) {
				
				if (!(weapMap.containsKey("Chemical Weapons"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					weapMap.put("Chemical Weapons", list);
				}
				else {
					weapMap.get("Chemical Weapons").add(countries[i].getName());
				}
			} 
			else if (countries[i] != null && countries[i].maxWeapon().equalsIgnoreCase("Fake Weapons")) {
				
				if (!(weapMap.containsKey("Fake Weapons"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					weapMap.put("Fake Weapons", list);
				}
				else {
					weapMap.get("Fake Weapons").add(countries[i].getName());
				}
			} 
			else if (countries[i] != null && countries[i].maxWeapon().equalsIgnoreCase("Melee Weapons")) {
				
				if (!(weapMap.containsKey("Melee Weapons"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					weapMap.put("Melee Weapons", list);
				}
				else {
					weapMap.get("Melee Weapons").add(countries[i].getName());
				}
			} 
			else if (countries[i] != null && countries[i].maxWeapon().equalsIgnoreCase("Sabotages")) {
				
				if (!(weapMap.containsKey("Sabotages"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					weapMap.put("Sabotages", list);
				}
				else {
					weapMap.get("Sabotages").add(countries[i].getName());
				}
			} 
			else if (countries[i] != null && countries[i].maxWeapon().equalsIgnoreCase("Vehicles")) {
				
				if (!(weapMap.containsKey("Vehicles"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					weapMap.put("Vehicles", list);
				}
				else {
					weapMap.get("Vehicles").add(countries[i].getName());
				}
			} 
			else if (countries[i] != null && countries[i].maxWeapon().equalsIgnoreCase("Radiological Weapons")) {
				
				if (!(weapMap.containsKey("Radiological Weapons"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					weapMap.put("Radiological Weapons", list);
				}
				else {
					weapMap.get("Radiological Weapons").add(countries[i].getName());
				}
			} 
			else if (countries[i] != null && countries[i].maxWeapon().equalsIgnoreCase("Other")) {
				
				if (!(weapMap.containsKey("Other"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					weapMap.put("Other", list);
				}
				else {
					weapMap.get("Other").add(countries[i].getName());
				}
			} 
			else if (countries[i] != null && countries[i].maxWeapon().equalsIgnoreCase("Biological Weapons")) {
				
				if (!(weapMap.containsKey("Biological Weapons"))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(countries[i].getName());
					weapMap.put("Biological Weapons", list);
				}
				else {
					weapMap.get("Biological Weapons").add(countries[i].getName());
				}
			} 
		}
		
		/*
		 * Print the clusters
		 */
		
		System.out.println("___________Attack Clusters___________ \n");
		
		for(String j : attackMap.keySet())
		{
			System.out.print(j.toUpperCase() + ": ");
			System.out.println(attackMap.get(j));
		}
		System.out.println("\n\n___________Target Type Clusters___________ \n");
		
		for(String j : targetMap.keySet())
		{
			System.out.print(j.toUpperCase() + ": ");
			System.out.println(targetMap.get(j));
		}
		System.out.println("\n\n___________Weapon Type Clusters___________ \n");
		
		for(String j : weapMap.keySet())
		{
			System.out.print(j.toUpperCase() + ": ");
			System.out.println(weapMap.get(j));
		}
		System.out.println(weapMap);
		
	}
}
