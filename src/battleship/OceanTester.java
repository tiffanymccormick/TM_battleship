package battleship;
//https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Run-JAR-file-example-windows-linux-ubuntu

//https://www.toddlahman.com/import-org-junit-cannot-resolved-eclipse/

public class OceanTester {
	public static void main(String[] args) {
		// Ocean size
		Ocean ocean = new Ocean();
		System.out.println("Test default Ocean:");
		if (ocean.size() != 0) {
			System.out.println("Ocean # of boats test failed. Expected size: 0, Actual size: " + ocean.size());
		} else {
			System.out.println("Ocean # of boats test passed. Ocean size is 0.");
		}

		// Place boat - Valid placement
		System.out.println("\nTest valid Boat placement:");
		try {
			ocean.placeBoat("Aircraft Carrier", "horizontal", new Position(0, 0));

			if (ocean.size() != 1) {
				System.out.println(
						"Place boat test failed. Expected size after placement: 1, Actual size: " + ocean.size());
			} else {
				System.out.println("Place boat - Valid placement test passed.");

			}
		} catch (Exception e) {
			System.out.println("Place boat - Valid placement test failed: " + e.getMessage());
		}

		// Place boat - Out of bounds
		System.out.println("\nTest out of bounds boat placement:");
		try {
			ocean.placeBoat("battleship", "horizontal", new Position(10, 0));
			System.out.println("Place boat - Out of bounds test failed.  Exception expected.");
		} catch (Exception e) {
			System.out.println("Place boat - Out of bounds test passed: " + e.getMessage());
		}

		// Place boat - Overlap
		System.out.println("\nIf the boat overlaps");
		try {
			ocean.placeBoat("Destroyer", "vertical", new Position(0, 0));
			System.out.println("Place boat - Overlap test failed. Expected exception.");
		} catch (Exception e) {
			System.out.println("Place boat - Overlap test passed: " + e.getMessage());
		}

		// Shoot at - Hit
		System.out.println("\nIf the boat gets hit");
		try {
			ocean.shootAt(new Position(0, 0));
			if (!ocean.hit(new Position(0, 0))) {
				System.out.println("Shoot at - Hit test failed. Expected position to be hit.");
			} else {
				System.out.println("Shoot at - Hit test passed.");
			}
		} catch (Exception e) {
			System.out.println("Shoot at - Hit test failed: " + e.getMessage());
		}
		// Shoot at - Miss
		System.out.println("\nShoot at but missed");
		try {
			if (ocean.hit(new Position(1, 0))) {
				System.out.println("Shoot at - Miss test failed. Expected position to be miss.");
			} else {
				System.out.println("Shoot at - Miss test passed.");
			}
		} catch (Exception e) {
			System.out.println("Shoot at - Miss test failed: " + e.getMessage());
		}

		// Boat initial - Hit
		System.out.println("\nTest if the inital is returned when the boat is hit:");
		try {
			char initial = ocean.boatInitial(new Position(0, 0));

			if (initial != 'A') {
				System.out.println("Boat initial - Hit test failed. Expected initial: C, Actual initial: " + initial);
			} else {
				System.out.println("Boat initial: " + initial + " - Hit test passed.");
			}
		} catch (Exception e) {
			System.out.println("Boat initial - Hit test failed: " + e.getMessage());
		}

		// Test case 8: Boat initial - Miss
		System.out.println("\nNo initial returned due to miss:");
		try {
			char initial = ocean.boatInitial(new Position(1, 0));
			if (initial != ' ') {
				System.out.println(
						"Boat initial - Miss test failed. Expected initial: \' \', Actual initial: " + initial);
			} else {
				System.out.println("Boat initial: " + initial + " - Miss test passed.");
			}
		} catch (Exception e) {
			System.out.println("Boat initial - Miss test failed: " + e.getMessage());
		}

		// Test case 9: Boat name - Hit
		System.out.println("\nReturn name of boat being hit if successful:");
		try {
			String name = ocean.boatName(new Position(0, 0));
			if (!name.equals("Aircraft Carrier")) {
				System.out
						.println("Boat name - Hit test failed. Expected name: Aircraft Carrier, Actual name: " + name);
			} else {
				System.out.println("Boat name: " + name + " - Hit test passed.");
			}
		} catch (Exception e) {
			System.out.println("Boat name - Hit test failed: " + e.getMessage());
		}

		// Boat name - Miss
		System.out.println("\nNo initial returned due to miss:");
		try {
			String name = ocean.boatName(new Position(1, 0));
			if (!name.equals("")) {
				System.out.println("Boat name - Miss test failed. Expected name: , Actual name: " + name);
			} else {
				System.out.println("Boat name - Miss test passed.");
			}
		} catch (Exception e) {
			System.out.println("Boat name - Miss test failed: " + e.getMessage());
		}

		// Sunk - Not sunk
		System.out.println("\nIf not sunk:");
		try {
			if (ocean.sunk(new Position(0, 0))) {
				System.out.println("Sunk - Not sunk test failed. Expected carrier to not be sunk.");
			} else {
				System.out.println("Sunk - Not sunk test passed.");
			}
		} catch (Exception e) {
			System.out.println("Sunk - Not sunk test failed: " + e.getMessage());
		}

		// Sunk - Sunk
		System.out.println("\nSunk test passed	:");
		try {
			ocean.shootAt(new Position(0, 1));
			ocean.shootAt(new Position(0, 2));
			ocean.shootAt(new Position(0, 3));
			ocean.shootAt(new Position(0, 4));
			System.out.println(ocean.toString());
			if (!ocean.sunk(new Position(0, 0))) {
				System.out.println("Sunk - Sunk test failed. Expected carrier to be sunk.");
			} else {
				System.out.println("Sunk - Sunk test passed. Aircraft Carrier sunk");
			}
		} catch (Exception e) {
			System.out.println("Sunk - Sunk test failed: " + e.getMessage());
		}

		// Test case 13: All sunk - Not all sunk
		System.out.println("\nIf not all the boats on the board were sunk:");
		try {
			ocean.placeBoat("Destroyer", "vertical", new Position(5, 0));
			if (ocean.allSunk()) {
				System.out.println("All sunk - Not all sunk test failed. Expected not all boats to be sunk.");
			} else {
				System.out.println("All sunk - Not all sunk test passed.");
			}
		} catch (Exception e) {
			System.out.println("All sunk - Not all sunk test failed: " + e.getMessage());
		}

		// Test case 14: All sunk - All sunk
		System.out.println("\nIf all the boats on the board were sunk:");
		try {
			// Hit Aircraft Carrier
			ocean.shootAt(new Position(2, 0));
			ocean.shootAt(new Position(2, 1));
			ocean.shootAt(new Position(2, 2));
			ocean.shootAt(new Position(2, 3));
			ocean.shootAt(new Position(2, 4));

			// Hit Destroyer
			ocean.shootAt(new Position(5, 0));
			ocean.shootAt(new Position(6, 0));
			if (!ocean.allSunk()) {

				System.out.println("All sunk - All sunk test failed. Expected all boats to be sunk.");
			} else {
				System.out.println("All sunk - All sunk test passed.");
			}
		} catch (Exception e) {

			//System.out.println("All sunk - All sunk test failed: " + e.getMessage());
		}


		System.out.println("\nRandomly Place Boats:");
		Ocean o = new Ocean();

        try {
            o.placeAllBoats();
	
            System.out.println("All boats placed successfully!");
        } catch (Exception e) {
            System.out.println("An error occurred while placing boats: " + e.getMessage());
        }
        
	}
}
