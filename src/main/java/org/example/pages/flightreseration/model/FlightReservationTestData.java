package org.example.pages.flightreseration.model;

public record FlightReservationTestData(String firstName,
                                        String lastName,
                                        String password,
                                        String email,
                                        String street,
                                        String city,
                                        String zip,
                                        String passengerCount,
                                        String expectedPrice) {
}
