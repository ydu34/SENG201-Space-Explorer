package main;

public class Planet {
	private String name;
	private boolean transporterDiscovery = true;
	private SpaceOutpost outpost;
	
	public Planet(String name, SpaceOutpost outpost) {
		this.name = name;
		this.outpost = outpost;
	}
	
	public String toString() {
		return name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isTransporterDiscovery() {
		return transporterDiscovery;
	}
	public void setTransporterDiscovery(boolean transporterDiscovery) {
		this.transporterDiscovery = transporterDiscovery;
	}
	public SpaceOutpost getOutpost() {
		return outpost;
	}
	public void setOutpost(SpaceOutpost outpost) {
		this.outpost = outpost;
	}
	
	
}