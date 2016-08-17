package parkinglot;

import java.util.ArrayList;
import java.util.List;

public class Level {
	private final List<ParkingSpot> level;
	public Level (int num) {
		level = new ArrayList<ParkingSpot>(num);
		for (int i = 0; i < num; i++) {
			if (i <= (int) 0.2 * num) {
				level.add(new ParkingSpot(VehicleSize.Large));
			} else {
				level.add(new ParkingSpot(VehicleSize.Compact));
			}
		}
	}
	public boolean canPark(Vehicle v) {
		for (ParkingSpot s : level) {
			if (s.canPark(v)) {
				return true;
			}
		}
		return false;
	}
	public ParkingSpot findSpot(Vehicle v) {
		for (ParkingSpot s : level) {
			if (s.canPark(v)) {
				return s;
			}
		}
		return null;
	}
	public boolean park(Vehicle v) {
		for (ParkingSpot s : level) {
			if (s.canPark(v)) {
				s.park(v);
				return true;
			}
		}
		return false;
	}
	public boolean unpark(Vehicle v) {
		for (ParkingSpot s : level) {
			if (s.vehicle == v) {
				s.unpark();
				return true;
			}
		}
		return false;
	}
}