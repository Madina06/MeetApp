package com.meetapp.domain;

import com.meetapp.domain.utils.Constant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Event Class Unit Tests")
public class EventTest {

    private Event event;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private User organizer;

    @BeforeEach
    @DisplayName("Given an Event with predefined values")
    public void setUp() {
        startDate = LocalDateTime.of(2023, 12, 1, 10, 0);
        endDate = LocalDateTime.of(2023, 12, 1, 12, 0);
        organizer = new User(Constant.ID, Constant.NAME, Constant.EMAIL, Constant.ROLE);

        event = new Event(Constant.EVENT_ID, Constant.EVENT_TITLE, Constant.EVENT_DESCRIPTION,
                startDate, endDate, Constant.EVENT_LOCATION, organizer);
    }

    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {

        @Test
        @DisplayName("Should correctly create an Event object with all parameters")
        public void givenAllArgsConstructorWhenCalledThenCreatesEvent() {
            // given when then
            assertThat(event.getId()).isEqualTo(Constant.EVENT_ID);
            assertThat(event.getTitle()).isEqualTo(Constant.EVENT_TITLE);
            assertThat(event.getDescription()).isEqualTo(Constant.EVENT_DESCRIPTION);
            assertThat(event.getStartDate()).isEqualTo(startDate);
            assertThat(event.getEndDate()).isEqualTo(endDate);
            assertThat(event.getLocation()).isEqualTo(Constant.EVENT_LOCATION);
            assertThat(event.getOrganizer()).isEqualTo(organizer);
        }

        @Test
        @DisplayName("Should correctly create an empty Event object")
        public void givenNoArgsConstructorWhenCalledThenCreatesEmptyEvent() {
            // given
            Event emptyEvent = new Event();

            // when then
            assertThat(emptyEvent.getId()).isNull();
            assertThat(emptyEvent.getTitle()).isNull();
            assertThat(emptyEvent.getDescription()).isNull();
            assertThat(emptyEvent.getStartDate()).isNull();
            assertThat(emptyEvent.getEndDate()).isNull();
            assertThat(emptyEvent.getLocation()).isNull();
            assertThat(emptyEvent.getOrganizer()).isNull();
        }
    }

    @Nested
    @DisplayName("Getter and Setter Tests")
    class GettersAndSettersTests {

        @Test
        @DisplayName("Should return and update the correct ID")
        public void givenEventWhenGetAndSetIdThenWorksCorrectly() {
            // given when then
            assertThat(event.getId()).isEqualTo(Constant.EVENT_ID);

            event.setId(Constant.NEW_EVENT_ID);
            assertThat(event.getId()).isEqualTo(Constant.NEW_EVENT_ID);
        }

        @Test
        @DisplayName("Should return and update the correct title")
        public void givenEventWhenGetAndSetTitleThenWorksCorrectly() {
            // given when then
            assertThat(event.getTitle()).isEqualTo(Constant.EVENT_TITLE);

            event.setTitle(Constant.NEW_EVENT_TITLE);
            assertThat(event.getTitle()).isEqualTo(Constant.NEW_EVENT_TITLE);
        }

        @Test
        @DisplayName("Should return and update the correct description")
        public void givenEventWhenGetAndSetDescriptionThenWorksCorrectly() {
            // given when then
            assertThat(event.getDescription()).isEqualTo(Constant.EVENT_DESCRIPTION);

            event.setDescription(Constant.NEW_EVENT_DESCRIPTION);
            assertThat(event.getDescription()).isEqualTo(Constant.NEW_EVENT_DESCRIPTION);
        }

        @Test
        @DisplayName("Should return and update the correct startDate")
        public void givenEventWhenGetAndSetStartDateThenWorksCorrectly() {
            // given when then
            assertThat(event.getStartDate()).isEqualTo(startDate);

            LocalDateTime newStartDate = LocalDateTime.of(2023, 12, 2, 9, 0);
            event.setStartDate(newStartDate);
            assertThat(event.getStartDate()).isEqualTo(newStartDate);
        }

        @Test
        @DisplayName("Should return and update the correct endDate")
        public void givenEventWhenGetAndSetEndDateThenWorksCorrectly() {
            // given when then
            assertThat(event.getEndDate()).isEqualTo(endDate);

            LocalDateTime newEndDate = LocalDateTime.of(2023, 12, 2, 11, 0);
            event.setEndDate(newEndDate);
            assertThat(event.getEndDate()).isEqualTo(newEndDate);
        }

        @Test
        @DisplayName("Should return and update the correct location")
        public void givenEventWhenGetAndSetLocationThenWorksCorrectly() {
            // given when then
            assertThat(event.getLocation()).isEqualTo(Constant.EVENT_LOCATION);

            event.setLocation(Constant.NEW_EVENT_LOCATION);
            assertThat(event.getLocation()).isEqualTo(Constant.NEW_EVENT_LOCATION);
        }

        @Test
        @DisplayName("Should return and update the correct organizer")
        public void givenEventWhenGetAndSetOrganizerThenWorksCorrectly() {
            // given when then
            assertThat(event.getOrganizer()).isEqualTo(organizer);

            User newOrganizer = new User(Constant.NEW_ID, Constant.NEW_NAME, Constant.NEW_EMAIL, Constant.NEW_ROLE);
            event.setOrganizer(newOrganizer);
            assertThat(event.getOrganizer()).isEqualTo(newOrganizer);
        }
    }

    @Nested
    @DisplayName("Equals and HashCode Tests")
    class EqualsAndHashCodeTests {
    	
    	@Test
    	@DisplayName("Should return false when comparing two events with different startDates where one is null")
    	public void givenNullStartDateWhenEqualsThenReturnFalse() {
    	    // given
    	    Event eventWithNullStartDate = new Event(Constant.EVENT_ID, Constant.EVENT_TITLE, Constant.EVENT_DESCRIPTION,
    	            null, endDate, Constant.EVENT_LOCATION, organizer);

    	    // when then
    	    assertThat(event.equals(eventWithNullStartDate)).isFalse();
    	}

    	@Test
    	@DisplayName("Should return different hashcodes for events with null fields")
    	public void givenNullFieldsWhenHashCodeThenReturnDifferentHash() {
    	    // given
    	    Event eventWithNullStartDate = new Event(Constant.EVENT_ID, Constant.EVENT_TITLE, Constant.EVENT_DESCRIPTION,
    	            null, endDate, Constant.EVENT_LOCATION, organizer);

    	    // when then
    	    assertThat(event.hashCode()).isNotEqualTo(eventWithNullStartDate.hashCode());
    	}


        @Test
        @DisplayName("Should return true when comparing the same object")
        public void givenSameEventWhenEqualsThenReturnTrue() {
            // given when then
            assertThat(event.equals(event)).isTrue();
        }

        @Test
        @DisplayName("Should return false when comparing with null")
        public void givenNullWhenEqualsThenReturnFalse() {
            // given when then
            assertThat(event.equals(null)).isFalse();
        }

        @Test
        @DisplayName("Should return false when comparing with an object of a different class")
        public void givenDifferentClassWhenEqualsThenReturnFalse() {
            // given when then
            assertThat(event.equals("Some String")).isFalse();
        }

        @Test
        @DisplayName("Should return true when comparing two events with the same values")
        public void givenSimilarEventsWhenEqualsThenReturnTrue() {
            // given
            Event event2 = new Event(Constant.EVENT_ID, Constant.EVENT_TITLE, Constant.EVENT_DESCRIPTION,
                    startDate, endDate, Constant.EVENT_LOCATION, organizer);

            // when then
            assertThat(event.equals(event2)).isTrue();
        }

        @Test
        @DisplayName("Should return different hashcodes for two events with different values")
        public void givenDifferentEventsWhenHashCodeThenReturnDifferentHash() {
            // given
            Event event2 = new Event(Constant.NEW_EVENT_ID, Constant.NEW_EVENT_TITLE, Constant.NEW_EVENT_DESCRIPTION,
                    startDate, endDate, Constant.NEW_EVENT_LOCATION, organizer);

            // when then
            assertThat(event.hashCode()).isNotEqualTo(event2.hashCode());
        }
    }

    @Nested
    @DisplayName("ToString Method Tests")
    class ToStringTests {

        @Test
        @DisplayName("Should return a properly formatted string representation of the Event object")
        public void givenEventWhenToStringThenReturnsCorrectString() {
            // given
            String expectedString = "Event [id=" + Constant.EVENT_ID + ", title=" + Constant.EVENT_TITLE
                    + ", description=" + Constant.EVENT_DESCRIPTION + ", startDate=" + startDate + ", endDate="
                    + endDate + ", location=" + Constant.EVENT_LOCATION + ", organizer=" + organizer + "]";

            // when then
            assertThat(event.toString()).isEqualTo(expectedString);
        }
    }
}