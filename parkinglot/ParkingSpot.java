package parkinglot;

public class ParkingSpot {
	protected VehicleSize size;
	protected Vehicle vehicle;
	public ParkingSpot(VehicleSize size) {
		this.size = size;
	}
	public boolean canPark (Vehicle v) {
		if (vehicle == null) {
			return size.ordinal() >= v.getSize().ordinal();
		}
		return false;
	}
	public void park(Vehicle v) {
		if (canPark(v)) {
			vehicle = v;
		}
	}
	public void unpark() {
		vehicle = null;
	}
}
