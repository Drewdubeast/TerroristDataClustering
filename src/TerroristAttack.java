
public class TerroristAttack {
	
	public int year;
	public int country;
	public int region;
	public int attackType;
	public int targType;
	public int targSubType;
	public int weapType;
	public double lat;
	public double lon;
	
	
	public String countryText;
	public String regionText;
	public String attackTypeText;
	public String targTypeText;
	public String targSubTypeText;
	public String weapTypeText;
	public String gName;

	public TerroristAttack(int year, int country, int region, int attackType, int targType, int targSubType, int weapType, double lat, double lon,
			String countryText, String regionText, String attackTypeText, String targTypeText, String targSubTypeText, String weapTypeText, String gName){
		this.year = year;
		this.country = country;
		this.region = region;
		this.attackType = attackType;
		this.targType = targType;
		this.targSubType = targSubType;
		this.weapType = weapType;
		this.lat = lat;
		this.lon = lon;
		
		this.countryText = countryText;
		this.regionText = regionText;
		this.attackTypeText = attackTypeText;
		this.targTypeText = targTypeText;
		this.targSubTypeText = targSubTypeText;
		this.weapTypeText = weapTypeText;
		this.gName = gName;
	}
	public String toString() {
		String s = "";
		s = 		"------TERRORIST ATTACK-------\n"
				+ "Year: " + year + "\n"
				+ "Country: " + country + "\n"
				+ "Region: " + region + "\n"
				+ "Attack Type: " + attackType + "\n"
				+ "Target Type: " + targType + "\n"
				+ "Target Sub Type: " + targSubType + "\n"
				+ "Weapon Type: " + weapType + "\n"
				+ "Latitude: " + lat + "\n"
				+ "Longitude: " + lon + "\n"
				+ "Country Name: " + countryText + "\n"
				+ "Region Name: " + regionText + "\n"
				+ "Attack Type Name: " + attackTypeText + "\n"
				+ "Target Type Name: " + targTypeText + "\n"
				+ "Target Sub Type Name: " + targSubTypeText + "\n"
				+ "Weapon Type Name: " + weapTypeText + "\n"
				+ "Group Name: " + gName + "\n";	
		return s;
	}
}
