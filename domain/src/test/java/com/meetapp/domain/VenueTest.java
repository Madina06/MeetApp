package com.meetapp.domain;

import com.meetapp.domain.utils.Constant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Venue Class Unit Tests")
public class VenueTest {

	private Venue venue;

	@BeforeEach
	@DisplayName("Given a Venue with predefined values")
	public void setUp() {
		venue = new Venue(Constant.VENUE_ID, Constant.VENUE_NAME, Constant.VENUE_ADDRESS, Constant.VENUE_CAPACITY);
	}

	@Nested
	@DisplayName("Constructor Tests")
	class ConstructorTests {

		@Test
		@DisplayName("Should correctly create a Venue object with all parameters")
		public void givenAllArgsConstructorWhenCalledThenCreatesVenue() {
			// given when then
			assertThat(venue.getId()).isEqualTo(Constant.VENUE_ID);
			assertThat(venue.getName()).isEqualTo(Constant.VENUE_NAME);
			assertThat(venue.getAddress()).isEqualTo(Constant.VENUE_ADDRESS);
			assertThat(venue.getCapacity()).isEqualTo(Constant.VENUE_CAPACITY);
		}

		@Test
		@DisplayName("Should correctly create an empty Venue object")
		public void givenNoArgsConstructorWhenCalledThenCreatesEmptyVenue() {
			// given
			Venue emptyVenue = new Venue();

			// when then
			assertThat(emptyVenue.getId()).isNull();
			assertThat(emptyVenue.getName()).isNull();
			assertThat(emptyVenue.getAddress()).isNull();
			assertThat(emptyVenue.getCapacity()).isEqualTo(0);
		}
	}

	@Nested
	@DisplayName("Getter and Setter Tests")
	class GettersAndSettersTests {

		@Test
		@DisplayName("Should return and update the correct ID")
		public void givenVenueWhenGetAndSetIdThenWorksCorrectly() {
			// given when then
			assertThat(venue.getId()).isEqualTo(Constant.VENUE_ID);

			venue.setId(Constant.NEW_VENUE_ID);
			assertThat(venue.getId()).isEqualTo(Constant.NEW_VENUE_ID);
		}

		@Test
		@DisplayName("Should return and update the correct name")
		public void givenVenueWhenGetAndSetNameThenWorksCorrectly() {
			// given when then
			assertThat(venue.getName()).isEqualTo(Constant.VENUE_NAME);

			venue.setName(Constant.NEW_VENUE_NAME);
			assertThat(venue.getName()).isEqualTo(Constant.NEW_VENUE_NAME);
		}

		@Test
		@DisplayName("Should return and update the correct address")
		public void givenVenueWhenGetAndSetAddressThenWorksCorrectly() {
			// given when then
			assertThat(venue.getAddress()).isEqualTo(Constant.VENUE_ADDRESS);

			venue.setAddress(Constant.NEW_VENUE_ADDRESS);
			assertThat(venue.getAddress()).isEqualTo(Constant.NEW_VENUE_ADDRESS);
		}

		@Test
		@DisplayName("Should return and update the correct capacity")
		public void givenVenueWhenGetAndSetCapacityThenWorksCorrectly() {
			// given when then
			assertThat(venue.getCapacity()).isEqualTo(Constant.VENUE_CAPACITY);

			venue.setCapacity(Constant.NEW_VENUE_CAPACITY);
			assertThat(venue.getCapacity()).isEqualTo(Constant.NEW_VENUE_CAPACITY);
		}
	}

	@Nested
	@DisplayName("Equals and HashCode Tests")
	class EqualsAndHashCodeTests {
		@Test
		@DisplayName("Should return true when comparing the same object")
		public void givenSameVenueWhenEqualsThenReturnTrue() {
			// given when then
			assertThat(venue.equals(venue)).isTrue();
		}

		@Test
		@DisplayName("Should return false when comparing with null")
		public void givenNullWhenEqualsThenReturnFalse() {
			// given when then
			assertThat(venue.equals(null)).isFalse();
		}

		@Test
		@DisplayName("Should return false when comparing with an object of a different class")
		public void givenDifferentClassWhenEqualsThenReturnFalse() {
			// given when then
			assertThat(venue.equals("Some String")).isFalse();
		}

		@Test
		@DisplayName("Should return true when comparing two venues with the same values")
		public void givenSimilarVenuesWhenEqualsThenReturnTrue() {
			// given
			Venue venue2 = new Venue(Constant.VENUE_ID, Constant.VENUE_NAME, Constant.VENUE_ADDRESS,
					Constant.VENUE_CAPACITY);

			// when then
			assertThat(venue.equals(venue2)).isTrue();
		}

		@Test
		@DisplayName("Should return false when comparing two venues with different IDs")
		public void givenDifferentIdsWhenEqualsThenReturnFalse() {
			// given
			Venue venue2 = new Venue(Constant.NEW_VENUE_ID, Constant.VENUE_NAME, Constant.VENUE_ADDRESS,
					Constant.VENUE_CAPACITY);

			// when then
			assertThat(venue.equals(venue2)).isFalse();
		}

		@Test
		@DisplayName("Should return false when comparing two venues with different names")
		public void givenDifferentNamesWhenEqualsThenReturnFalse() {
			// given
			Venue venue2 = new Venue(Constant.VENUE_ID, Constant.NEW_VENUE_NAME, Constant.VENUE_ADDRESS,
					Constant.VENUE_CAPACITY);

			// when then
			assertThat(venue.equals(venue2)).isFalse();
		}

		@Test
		@DisplayName("Should return false when comparing two venues with different addresses")
		public void givenDifferentAddressesWhenEqualsThenReturnFalse() {
			// given
			Venue venue2 = new Venue(Constant.VENUE_ID, Constant.VENUE_NAME, Constant.NEW_VENUE_ADDRESS,
					Constant.VENUE_CAPACITY);

			// when then
			assertThat(venue.equals(venue2)).isFalse();
		}

		@Test
		@DisplayName("Should return false when comparing two venues with different capacities")
		public void givenDifferentCapacitiesWhenEqualsThenReturnFalse() {
			// given
			Venue venue2 = new Venue(Constant.VENUE_ID, Constant.VENUE_NAME, Constant.VENUE_ADDRESS,
					Constant.NEW_VENUE_CAPACITY);

			// when then
			assertThat(venue.equals(venue2)).isFalse();
		}

		@Test
		@DisplayName("Should return different hashcodes for two venues with different values")
		public void givenDifferentVenuesWhenHashCodeThenReturnDifferentHash() {
			// given
			Venue venue2 = new Venue(Constant.NEW_VENUE_ID, Constant.NEW_VENUE_NAME, Constant.NEW_VENUE_ADDRESS,
					Constant.NEW_VENUE_CAPACITY);

			// when then
			assertThat(venue.hashCode()).isNotEqualTo(venue2.hashCode());
		}
	}

	@Nested
	@DisplayName("ToString Method Tests")
	class ToStringTests {

		@Test
		@DisplayName("Should return a properly formatted string representation of the Venue object")
		public void givenVenueWhenToStringThenReturnsCorrectString() {
			// given
			String expectedString = "Venue [id=" + Constant.VENUE_ID + ", name=" + Constant.VENUE_NAME + ", address="
					+ Constant.VENUE_ADDRESS + ", capacity=" + Constant.VENUE_CAPACITY + "]";

			// when then
			assertThat(venue.toString()).isEqualTo(expectedString);
		}
	}
}
