public class WaypointDemo {

    public static void main(String[] args) {

        Waypoint waypoint = new Waypoint();

        // Step 1: Register customer

        Customer customer = new Customer(
            new CustomerId(101),
            "Ramya"
        );

        waypoint.registerCustomer(customer);

        System.out.println("Customer registered successfully.");

        // Step 2: Add parking spots

        ParkingSpot spot1 = new ParkingSpot(
            new ParkingSpotId(201),
            "Bachupally"
        );

        ParkingSpot spot2 = new ParkingSpot(
            new ParkingSpotId(202),
            "Nizampet"
        );

        waypoint.addParkingSpot(spot1);
        waypoint.addParkingSpot(spot2);

        System.out.println("Parking spots added successfully.");

        // Step 3: Register vehicle

        waypoint.registerVehicle("TS09AB1234");

        System.out.println("Vehicle registered successfully.");

        // Step 4: Display parking availability

        System.out.println("\n----- PARKING AVAILABILITY -----");

        for (ParkingSpotView view : waypoint.getParkingSpots()) {

            System.out.println("Spot ID: " + view.spotId().value());
            System.out.println("Location: " + view.location());
            System.out.println("Status: " + view.status());

            System.out.println("---------------------------");
        }

        // Step 5: Book parking spot

        System.out.println("\n----- BOOKING PARKING -----");

        Booking booking = waypoint.reserve(
            new CustomerId(101),
            new ParkingSpotId(201),
            "TS09AB1234",
            2,
            new Money(5000, "INR")
        );

        System.out.println("Booking ID: " + booking.getBookingId().value());
        System.out.println("Total Fare: " + booking.getFare());

        System.out.println(
            "Payment Status: " + booking.getPayment().successful()
        );

        System.out.println("Booking Status: " + booking.getStatus());

        // Step 6: Try duplicate booking

        System.out.println("\n----- TRYING DUPLICATE BOOKING -----");

        try {

            waypoint.reserve(
                new CustomerId(101),
                new ParkingSpotId(201),
                "TS09AB1234",
                1,
                new Money(5000, "INR")
            );

        } catch (IllegalStateException exception) {

            System.out.println("Booking failed: " + exception.getMessage());
        }

        // Step 7: Cancel booking

        System.out.println("\n----- CANCELLING BOOKING -----");

        waypoint.cancelBooking(booking.getBookingId());

        System.out.println(
            "Booking Status After Cancellation: " + booking.getStatus()
        );

        // Step 8: Display parking availability

        System.out.println("\n----- PARKING AVAILABILITY AFTER CANCELLATION -----");

        for (ParkingSpotView view : waypoint.getParkingSpots()) {

            System.out.println("Spot ID: " + view.spotId().value());
            System.out.println("Location: " + view.location());
            System.out.println("Status: " + view.status());

            System.out.println("---------------------------");
        }

        // Step 9: Display all bookings

        waypoint.displayBookings();
    }
}