package qa.free.tools.selenium.toolkit.demo.phptravels.enums;

public enum Trip {
	ONE_WAY,
	ROUND_TRIP;
	
	@Override
	public String toString() {
		return this.toString().toLowerCase().replace("_", "-");
	}
	
}