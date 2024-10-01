package com.meetapp.domain;

import com.meetapp.domain.utils.Constant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Feedback Class Unit Tests")
public class FeedbackTest {

    private Feedback feedback;
    private User user;
    private Event event;

    @BeforeEach
    @DisplayName("Given a Feedback with predefined values")
    public void setUp() {
        user = new User(Constant.ID, Constant.NAME, Constant.EMAIL, Constant.ROLE);
        event = new Event(Constant.EVENT_ID, Constant.EVENT_TITLE, Constant.EVENT_DESCRIPTION,
                Constant.EVENT_START_DATE, Constant.EVENT_END_DATE, Constant.EVENT_LOCATION, user);
        
        feedback = new Feedback(Constant.FEEDBACK_ID, Constant.FEEDBACK_COMMENT, Constant.FEEDBACK_RATING, user, event);
    }

    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {

        @Test
        @DisplayName("Should correctly create a Feedback object with all parameters")
        public void givenAllArgsConstructorWhenCalledThenCreatesFeedback() {
            assertThat(feedback.getId()).isEqualTo(Constant.FEEDBACK_ID);
            assertThat(feedback.getComment()).isEqualTo(Constant.FEEDBACK_COMMENT);
            assertThat(feedback.getRating()).isEqualTo(Constant.FEEDBACK_RATING);
            assertThat(feedback.getUser()).isEqualTo(user);
            assertThat(feedback.getEvent()).isEqualTo(event);
        }

        @Test
        @DisplayName("Should correctly create an empty Feedback object")
        public void givenNoArgsConstructorWhenCalledThenCreatesEmptyFeedback() {
            Feedback emptyFeedback = new Feedback();
            assertThat(emptyFeedback.getId()).isNull();
            assertThat(emptyFeedback.getComment()).isNull();
            assertThat(emptyFeedback.getRating()).isZero();
            assertThat(emptyFeedback.getUser()).isNull();
            assertThat(emptyFeedback.getEvent()).isNull();
        }
    }

    @Nested
    @DisplayName("Getter and Setter Tests")
    class GettersAndSettersTests {

        @Test
        @DisplayName("Should return and update the correct ID")
        public void givenFeedbackWhenGetAndSetIdThenWorksCorrectly() {
            assertThat(feedback.getId()).isEqualTo(Constant.FEEDBACK_ID);
            feedback.setId(Constant.NEW_FEEDBACK_ID);
            assertThat(feedback.getId()).isEqualTo(Constant.NEW_FEEDBACK_ID);
        }

        @Test
        @DisplayName("Should return and update the correct comment")
        public void givenFeedbackWhenGetAndSetCommentThenWorksCorrectly() {
            assertThat(feedback.getComment()).isEqualTo(Constant.FEEDBACK_COMMENT);
            feedback.setComment(Constant.NEW_FEEDBACK_COMMENT);
            assertThat(feedback.getComment()).isEqualTo(Constant.NEW_FEEDBACK_COMMENT);
        }

        @Test
        @DisplayName("Should return and update the correct rating")
        public void givenFeedbackWhenGetAndSetRatingThenWorksCorrectly() {
            assertThat(feedback.getRating()).isEqualTo(Constant.FEEDBACK_RATING);
            feedback.setRating(Constant.NEW_FEEDBACK_RATING);
            assertThat(feedback.getRating()).isEqualTo(Constant.NEW_FEEDBACK_RATING);
        }

        @Test
        @DisplayName("Should return and update the correct user")
        public void givenFeedbackWhenGetAndSetUserThenWorksCorrectly() {
            assertThat(feedback.getUser()).isEqualTo(user);
            User newUser = new User(Constant.NEW_ID, Constant.NEW_NAME, Constant.NEW_EMAIL, Constant.NEW_ROLE);
            feedback.setUser(newUser);
            assertThat(feedback.getUser()).isEqualTo(newUser);
        }

        @Test
        @DisplayName("Should return and update the correct event")
        public void givenFeedbackWhenGetAndSetEventThenWorksCorrectly() {
            assertThat(feedback.getEvent()).isEqualTo(event);
            Event newEvent = new Event(Constant.NEW_EVENT_ID, Constant.NEW_EVENT_TITLE, Constant.NEW_EVENT_DESCRIPTION,
                    Constant.EVENT_START_DATE, Constant.EVENT_END_DATE, Constant.NEW_EVENT_LOCATION, user);
            feedback.setEvent(newEvent);
            assertThat(feedback.getEvent()).isEqualTo(newEvent);
        }
    }

    @Nested
    @DisplayName("Equals Tests")
    class EqualsTests {
        @Test
        @DisplayName("Should return true when comparing the same object")
        public void givenSameFeedbackWhenEqualsThenReturnTrue() {
            assertThat(feedback.equals(feedback)).isTrue();
        }

        @Test
        @DisplayName("Should return false when comparing with null")
        public void givenNullWhenEqualsThenReturnFalse() {
            assertThat(feedback.equals(null)).isFalse();
        }

        @Test
        @DisplayName("Should return false when comparing with different class")
        public void givenDifferentClassWhenEqualsThenReturnFalse() {
            assertThat(feedback.equals("Not a Feedback")).isFalse();
        }

        @Test
        @DisplayName("Should return true when comparing two equal feedbacks")
        public void givenEqualFeedbacksWhenEqualsThenReturnTrue() {
            Feedback anotherFeedback = new Feedback(Constant.FEEDBACK_ID, Constant.FEEDBACK_COMMENT, Constant.FEEDBACK_RATING, user, event);
            assertThat(feedback.equals(anotherFeedback)).isTrue();
        }

        @Test
        @DisplayName("Should return false when comparing feedbacks with different ratings")
        public void givenDifferentRatingsWhenEqualsThenReturnFalse() {
            Feedback differentFeedback = new Feedback(Constant.FEEDBACK_ID, Constant.FEEDBACK_COMMENT, Constant.NEW_FEEDBACK_RATING, user, event);
            assertThat(feedback.equals(differentFeedback)).isFalse();
        }

        @Test
        @DisplayName("Should return false when comparing feedbacks with different users")
        public void givenDifferentUsersWhenEqualsThenReturnFalse() {
            User differentUser = new User(Constant.NEW_ID, Constant.NEW_NAME, Constant.NEW_EMAIL, Constant.NEW_ROLE);
            Feedback differentFeedback = new Feedback(Constant.FEEDBACK_ID, Constant.FEEDBACK_COMMENT, Constant.FEEDBACK_RATING, differentUser, event);
            assertThat(feedback.equals(differentFeedback)).isFalse();
        }

        @Test
        @DisplayName("Should return false when comparing feedbacks with different events")
        public void givenDifferentEventsWhenEqualsThenReturnFalse() {
            Event differentEvent = new Event(Constant.NEW_EVENT_ID, Constant.NEW_EVENT_TITLE, Constant.NEW_EVENT_DESCRIPTION,
                    Constant.EVENT_START_DATE, Constant.EVENT_END_DATE, Constant.NEW_EVENT_LOCATION, user);
            Feedback differentFeedback = new Feedback(Constant.FEEDBACK_ID, Constant.FEEDBACK_COMMENT, Constant.FEEDBACK_RATING, user, differentEvent);
            assertThat(feedback.equals(differentFeedback)).isFalse();
        }

        @Test
        @DisplayName("Should return false when comparing feedbacks with different comments")
        public void givenDifferentCommentsWhenEqualsThenReturnFalse() {
            Feedback differentFeedback = new Feedback(Constant.FEEDBACK_ID, Constant.NEW_FEEDBACK_COMMENT, Constant.FEEDBACK_RATING, user, event);
            assertThat(feedback.equals(differentFeedback)).isFalse();
        }
        
        @Test
        @DisplayName("Should return false when comparing feedbacks with different IDs")
        public void givenDifferentIdsWhenEqualsThenReturnFalse() {
            Feedback differentFeedback = new Feedback(Constant.NEW_FEEDBACK_ID, Constant.FEEDBACK_COMMENT, Constant.FEEDBACK_RATING, user, event);
            assertThat(feedback.equals(differentFeedback)).isFalse();
        }
    }

    @Nested
    @DisplayName("HashCode Tests")
    class HashCodeTests {
        @Test
        @DisplayName("Should return same hash code for equal feedbacks")
        public void givenEqualFeedbacksWhenHashCodeThenReturnSameHash() {
            Feedback anotherFeedback = new Feedback(Constant.FEEDBACK_ID, Constant.FEEDBACK_COMMENT, Constant.FEEDBACK_RATING, user, event);
            assertThat(feedback.hashCode()).isEqualTo(anotherFeedback.hashCode());
        }

        @Test
        @DisplayName("Should return different hash codes for different feedbacks")
        public void givenDifferentFeedbacksWhenHashCodeThenReturnDifferentHash() {
            Feedback differentFeedback = new Feedback(Constant.FEEDBACK_ID, Constant.FEEDBACK_COMMENT, Constant.NEW_FEEDBACK_RATING, user, event);
            assertThat(feedback.hashCode()).isNotEqualTo(differentFeedback.hashCode());
        }
        
        @Test
        @DisplayName("Should return different hash codes for feedbacks with different comments")
        public void givenDifferentCommentsWhenHashCodeThenReturnDifferentHash() {
            Feedback differentFeedback = new Feedback(Constant.FEEDBACK_ID, Constant.NEW_FEEDBACK_COMMENT, Constant.FEEDBACK_RATING, user, event);
            assertThat(feedback.hashCode()).isNotEqualTo(differentFeedback.hashCode());
        }
        
        @Test
        @DisplayName("Should return different hash codes for feedbacks with different users")
        public void givenDifferentUsersWhenHashCodeThenReturnDifferentHash() {
            User differentUser = new User(Constant.NEW_ID, Constant.NEW_NAME, Constant.NEW_EMAIL, Constant.NEW_ROLE);
            Feedback differentFeedback = new Feedback(Constant.FEEDBACK_ID, Constant.FEEDBACK_COMMENT, Constant.FEEDBACK_RATING, differentUser, event);
            assertThat(feedback.hashCode()).isNotEqualTo(differentFeedback.hashCode());
        }
    }

    @Nested
    @DisplayName("ToString Method Tests")
    class ToStringTests {
        @Test
        @DisplayName("Should return a properly formatted string representation of the Feedback object")
        public void givenFeedbackWhenToStringThenReturnsCorrectString() {
            String expectedString = "Feedback [id=" + Constant.FEEDBACK_ID + ", comment=" + Constant.FEEDBACK_COMMENT 
                    + ", rating=" + Constant.FEEDBACK_RATING + ", user=" + user + ", event=" + event + "]";
            assertThat(feedback.toString()).isEqualTo(expectedString);
        }
    }
}
