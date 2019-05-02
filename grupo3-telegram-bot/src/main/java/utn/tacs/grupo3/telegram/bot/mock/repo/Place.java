package utn.tacs.grupo3.telegram.bot.mock.repo;

public class Place {
	
	private String name;
	private String desc;
	private Float lat;
	private Float longit;
	
	
	public Place(String name, String desc, Float lat, Float longit) {
		super();
		this.name = name;
		this.desc = desc;
		this.lat = lat;
		this.longit = longit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Float getLat() {
		return lat;
	}
	public void setLat(Float lat) {
		this.lat = lat;
	}
	public Float getLongit() {
		return longit;
	}
	public void setLongit(Float longit) {
		this.longit = longit;
	}
}
