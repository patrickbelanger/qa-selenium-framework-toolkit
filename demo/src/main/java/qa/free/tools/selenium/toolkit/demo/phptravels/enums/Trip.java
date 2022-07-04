package qa.free.tools.selenium.toolkit.demo.phptravels.enums;

public enum Trip {
	ONE_WAY("one-way"),
	ROUND_TRIP("round-trip");
	
	private String value;
	
	private Trip(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
}