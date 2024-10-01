package com.meetapp.domain.utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Constant {
	private Constant() {
	}

	public static final String USERNAME = "username";
	public static final String EMAIL = "email";
	public static final String ROLE = "role";
	public static final String NAME = "Madina Kuldeeva";
	public static final Long ID = 1000000L;
	public static final Long NEW_ID = 1000001L;
	public static final String NEW_NAME = "John Doe";
	public static final String NEW_EMAIL = "john.doe@example.com";
	public static final String NEW_ROLE = "user";

	// Event constants
	public static final Long EVENT_ID = 1L;
	public static final String EVENT_TITLE = "Conference";
	public static final String EVENT_DESCRIPTION = "Annual Conference";
	public static final Long NEW_EVENT_ID = 2L;
	public static final String NEW_EVENT_TITLE = "Workshop";
	public static final String NEW_EVENT_DESCRIPTION = "Technical Workshop";
	public static final String EVENT_LOCATION = "Main Hall";
	public static final String NEW_EVENT_LOCATION = "Room 101";
	public static final LocalDateTime EVENT_START_DATE = LocalDateTime.now();
	public static final LocalDateTime EVENT_END_DATE = LocalDateTime.now().plusHours(1);

	// Venue constants
	public static final Long VENUE_ID = 1000000L;
	public static final Long NEW_VENUE_ID = 1000001L;
	public static final String VENUE_NAME = "Main Hall";
	public static final String NEW_VENUE_NAME = "Conference Room";
	public static final String VENUE_ADDRESS = "123 Main St, Cityville";
	public static final String NEW_VENUE_ADDRESS = "456 Conference Ave, Townburg";
	public static final int VENUE_CAPACITY = 500;
	public static final int NEW_VENUE_CAPACITY = 300;

	// Feedback constants
	public static final Long FEEDBACK_ID = 1000000L;
	public static final Long NEW_FEEDBACK_ID = 1000001L;
	public static final int FEEDBACK_RATING = 5;
	public static final int NEW_FEEDBACK_RATING = 4;
	public static final String FEEDBACK_COMMENT = "Very interesting event!";
	public static final String NEW_FEEDBACK_COMMENT = "Very boring event!";

	// Booking constants
	public static final Long BOOKING_ID = 200L;
	public static final Long NEW_BOOKING_ID = 201L;
	public static final String BOOKING_STATUS = "Confirmed";
	public static final String NEW_BOOKING_STATUS = "Cancelled";
	public static final BigDecimal TOTAL_AMOUNT = BigDecimal.valueOf(100.00);
	public static final BigDecimal NEW_TOTAL_AMOUNT = BigDecimal.valueOf(150.00);
}
