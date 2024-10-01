package com.meetapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.meetapp.domain.utils.Constant;

@DisplayName("Booking Class Unit Tests")
public class BookingTest {

	private Booking booking;
	private Event event;
	private User user;
	private LocalDateTime bookingDate;

	@BeforeEach
	@DisplayName("Given a Booking with predefined values")
	public void setUp() {
		bookingDate = LocalDateTime.of(2023, 12, 1, 10, 0);
		user = new User(Constant.ID, Constant.NAME, Constant.EMAIL, Constant.ROLE);
		event = new Event(Constant.EVENT_ID, Constant.EVENT_TITLE, Constant.EVENT_DESCRIPTION,
				Constant.EVENT_START_DATE, Constant.EVENT_END_DATE, Constant.EVENT_LOCATION, user);

		booking = new Booking(Constant.BOOKING_ID, event, user, bookingDate, Constant.BOOKING_STATUS,
				Constant.TOTAL_AMOUNT);
	}

	@Nested
	@DisplayName("Constructor Tests")
	class ConstructorTests {

		@Test
		@DisplayName("Should correctly create a Booking object with all parameters")
		public void givenAllArgsConstructorWhenCalledThenCreatesBooking() {
			// when then
			assertThat(booking).extracting("id", "event", "user", "bookingDate", "status", "totalAmount")
					.containsExactly(Constant.BOOKING_ID, event, user, bookingDate, Constant.BOOKING_STATUS,
							Constant.TOTAL_AMOUNT);
		}

		@Test
		@DisplayName("Should correctly create an empty Booking object")
		public void givenNoArgsConstructorWhenCalledThenCreatesEmptyBooking() {
			// given
			Booking emptyBooking = new Booking();

			// when then
			assertThat(emptyBooking).extracting("id", "event", "user", "bookingDate", "status", "totalAmount")
					.containsExactly(null, null, null, null, null, null);
		}
	}

	@Nested
	@DisplayName("Getter and Setter Tests")
	class GettersAndSettersTests {

		@Test
		@DisplayName("Should return and update the correct ID")
		public void givenBookingWhenGetAndSetIdThenWorksCorrectly() {
			// when then
			assertThat(booking.getId()).isEqualTo(Constant.BOOKING_ID);
			booking.setId(Constant.NEW_BOOKING_ID);
			assertThat(booking.getId()).isEqualTo(Constant.NEW_BOOKING_ID);
		}

		@Test
		@DisplayName("Should return and update the correct event")
		public void givenBookingWhenGetAndSetEventThenWorksCorrectly() {
			// when then
			assertThat(booking.getEvent()).isEqualTo(event);
			Event newEvent = new Event(Constant.NEW_EVENT_ID, Constant.NEW_EVENT_TITLE, Constant.NEW_EVENT_DESCRIPTION,
					Constant.EVENT_START_DATE, Constant.EVENT_END_DATE, Constant.NEW_EVENT_LOCATION, user);
			booking.setEvent(newEvent);
			assertThat(booking.getEvent()).isEqualTo(newEvent);
		}

		@Test
		@DisplayName("Should return and update the correct user")
		public void givenBookingWhenGetAndSetUserThenWorksCorrectly() {
			// when then
			assertThat(booking.getUser()).isEqualTo(user);
			User newUser = new User(Constant.NEW_ID, Constant.NEW_NAME, Constant.NEW_EMAIL, Constant.NEW_ROLE);
			booking.setUser(newUser);
			assertThat(booking.getUser()).isEqualTo(newUser);
		}

		@Test
		@DisplayName("Should return and update the correct bookingDate")
		public void givenBookingWhenGetAndSetBookingDateThenWorksCorrectly() {
			// when then
			assertThat(booking.getBookingDate()).isEqualTo(bookingDate);
			LocalDateTime newBookingDate = LocalDateTime.of(2023, 12, 2, 10, 0);
			booking.setBookingDate(newBookingDate);
			assertThat(booking.getBookingDate()).isEqualTo(newBookingDate);
		}

		@Test
		@DisplayName("Should return and update the correct status")
		public void givenBookingWhenGetAndSetStatusThenWorksCorrectly() {
			// when then
			assertThat(booking.getStatus()).isEqualTo(Constant.BOOKING_STATUS);
			booking.setStatus(Constant.NEW_BOOKING_STATUS);
			assertThat(booking.getStatus()).isEqualTo(Constant.NEW_BOOKING_STATUS);
		}

		@Test
		@DisplayName("Should return and update the correct totalAmount")
		public void givenBookingWhenGetAndSetTotalAmountThenWorksCorrectly() {
			// when then
			assertThat(booking.getTotalAmount()).isEqualTo(Constant.TOTAL_AMOUNT);
			BigDecimal newTotalAmount = BigDecimal.valueOf(150.00);
			booking.setTotalAmount(newTotalAmount);
			assertThat(booking.getTotalAmount()).isEqualTo(newTotalAmount);
		}
	}

	@Nested
	@DisplayName("Equals and HashCode Tests")
	class EqualsAndHashCodeTests {
		@Test
		@DisplayName("Should return true when comparing the same object")
		public void givenSameBookingWhenEqualsThenReturnTrue() {
			// when then
			assertThat(booking.equals(booking)).isTrue();
		}

		@Test
		@DisplayName("Should return false when comparing with null")
		public void givenNullWhenEqualsThenReturnFalse() {
			// when then
			assertThat(booking.equals(null)).isFalse();
		}

		@Test
		@DisplayName("Should return false when comparing with an object of a different class")
		public void givenDifferentClassWhenEqualsThenReturnFalse() {
			// when then
			assertThat(booking.equals("Some String")).isFalse();
		}

		@Test
		@DisplayName("Should return true when comparing two bookings with the same values")
		public void givenSimilarBookingsWhenEqualsThenReturnTrue() {
			// given
			Booking booking2 = new Booking(Constant.BOOKING_ID, event, user, bookingDate, Constant.BOOKING_STATUS,
					Constant.TOTAL_AMOUNT);
			// when then
			assertThat(booking.equals(booking2)).isTrue();
		}

		@Test
		@DisplayName("Should return false when comparing bookings with different events")
		public void givenDifferentEventsWhenEqualsThenReturnFalse() {
			// given
			Event differentEvent = new Event(Constant.NEW_EVENT_ID, Constant.NEW_EVENT_TITLE,
					Constant.NEW_EVENT_DESCRIPTION, Constant.EVENT_START_DATE, Constant.EVENT_END_DATE,
					Constant.NEW_EVENT_LOCATION, user);
			Booking booking2 = new Booking(Constant.BOOKING_ID, differentEvent, user, bookingDate,
					Constant.BOOKING_STATUS, Constant.TOTAL_AMOUNT);
			// when then
			assertThat(booking.equals(booking2)).isFalse();
		}

		@Test
		@DisplayName("Should return false when comparing bookings with different users")
		public void givenDifferentUsersWhenEqualsThenReturnFalse() {
			// given
			User differentUser = new User(Constant.NEW_ID, Constant.NEW_NAME, Constant.NEW_EMAIL, Constant.NEW_ROLE);
			Booking booking2 = new Booking(Constant.BOOKING_ID, event, differentUser, bookingDate,
					Constant.BOOKING_STATUS, Constant.TOTAL_AMOUNT);
			// when then
			assertThat(booking.equals(booking2)).isFalse();
		}

		@Test
		@DisplayName("Should return different hashcodes for two bookings with different values")
		public void givenDifferentBookingsWhenHashCodeThenReturnDifferentHash() {
			// given
			Booking booking2 = new Booking(Constant.NEW_BOOKING_ID, event, user, bookingDate,
					Constant.NEW_BOOKING_STATUS, Constant.NEW_TOTAL_AMOUNT);
			// when then
			assertThat(booking.hashCode()).isNotEqualTo(booking2.hashCode());
		}
	}

	@Nested
	@DisplayName("ToString Method Tests")
	class ToStringTests {

		@Test
		@DisplayName("Should return a properly formatted string representation of the Booking object")
		public void givenBookingWhenToStringThenReturnsCorrectString() {
			// given
			String expectedString = "Booking [id=" + Constant.BOOKING_ID + ", event=" + event + ", user=" + user
					+ ", bookingDate=" + bookingDate + ", status=" + Constant.BOOKING_STATUS + ", totalAmount="
					+ Constant.TOTAL_AMOUNT + "]";
			// when then
			assertThat(booking.toString()).isEqualTo(expectedString);
		}
	}
}
