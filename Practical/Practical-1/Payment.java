public record Payment(
    PaymentId paymentId,
    BookingId bookingId,
    Money amount,
    boolean successful
) {

    public Payment {
        if (paymentId == null || bookingId == null || amount == null)
            throw new IllegalArgumentException("Invalid payment details");
    }
}