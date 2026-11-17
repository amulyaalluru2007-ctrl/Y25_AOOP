public record ParkingSpotView(
    ParkingSpotId spotId,
    String location,
    SpotStatus status,
    String vehicleNumber
) {}