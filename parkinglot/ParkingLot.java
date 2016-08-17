package parkinglot;

import java.util.HashMap;
import java.util.Map;


public class ParkingLot {
	private final Level[] lot;
	private final Map<Vehicle, ParkingSpot> map;
	public ParkingLot(int numOfLevels, int spotsPerLevel) {
		lot = new Level[numOfLevels];
		for (int i = 0; i < numOfLevels; i++) {
			lot[i] = new Level(spotsPerLevel);
		}
		map = new HashMap<Vehicle, ParkingSpot>();
	}
	public boolean hasSpot(Vehicle v) {
		for (int i = 0; i < lot.length; i++) {
			if (lot[i].canPark(v)) {
				return true;
			}
		}
		return false;
	}
	private ParkingSpot findSpot(Vehicle v) {
		for (int i = 0; i < lot.length; i++) {
			if (lot[i].findSpot(v) != null) {
				return lot[i].findSpot(v);
			}
		}
		return null;
	}
	public boolean park(Vehicle v) {
		if (hasSpot(v)) {
			map.put(v, findSpot(v));
			findSpot(v).park(v);
			return true;
		}
		return false;
	}
	public boolean unpark(Vehicle v) {
		if (map.get(v) != null) {
			map.get(v).unpark();
			map.remove(v);
			return true;
		}
		return false;
	}
	public Map<Vehicle, ParkingSpot> getMap() {
		return map;
	}
	public static void main(String[] args) {
		ParkingLot myLot = new ParkingLot(3, 20);
		Vehicle v1 = new Car();
		Vehicle v2 = new Car();
		Vehicle v3 = new Truck();
		myLot.park(v1);
		myLot.park(v2);
		System.out.println(myLot.getMap().toString());
		myLot.park(v3);
		System.out.println(myLot.getMap().toString());
		myLot.unpark(v2);
		System.out.println(myLot.getMap().toString());
	}
}
