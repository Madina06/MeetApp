package com.meetapp.domain;

import com.meetapp.domain.utils.Constant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("User Class Unit Tests")
public class UserTest {

    private User user;

    @BeforeEach
    @DisplayName("Given a User with predefined values")
    public void setUp() {
        user = new User(Constant.ID, Constant.NAME, Constant.EMAIL, Constant.ROLE);
    }

    @Nested
    @DisplayName("User Constructor Tests")
    class ConstructorsTests {

        @Test
        @DisplayName("Should correctly create a User object with all parameters")
        public void givenAllArgsConstructorWhenCalledThenCreatesUser() {
            // given
            User newUser = new User(Constant.NEW_ID, Constant.NEW_NAME, Constant.NEW_EMAIL, Constant.NEW_ROLE);

            // when
            Long id = newUser.getId();
            String name = newUser.getName();
            String email = newUser.getEmail();
            String role = newUser.getRole();

            // then
            assertThat(id).isEqualTo(Constant.NEW_ID);
            assertThat(name).isEqualTo(Constant.NEW_NAME);
            assertThat(email).isEqualTo(Constant.NEW_EMAIL);
            assertThat(role).isEqualTo(Constant.NEW_ROLE);
        }
        
        @Test
        @DisplayName("Should correctly create an empty User object")
        public void givenNoArgsConstructorWhenCalledThenCreatesEmptyUser() {
            // given
            User emptyUser = new User();

            // when/then
            assertThat(emptyUser.getId()).isNull();
            assertThat(emptyUser.getName()).isNull();
            assertThat(emptyUser.getEmail()).isNull();
            assertThat(emptyUser.getRole()).isNull();
        }
    }

    @Nested
    @DisplayName("Getter and Setter Tests")
    class GettersAndSettersTests {

        @Test
        @DisplayName("Should return the correct ID")
        public void givenUserWhenGetIdThenReturnsCorrectId() {
            // when
            Long actualId = user.getId();

            // then
            assertThat(actualId).isEqualTo(Constant.ID);
        }

        @Test
        @DisplayName("Should update and return the correct ID")
        public void givenUserWhenSetIdThenIdIsUpdated() {
            // given
            user.setId(Constant.NEW_ID);

            // when
            Long actualId = user.getId();

            // then
            assertThat(actualId).isEqualTo(Constant.NEW_ID);
        }

        @Test
        @DisplayName("Should return the correct name")
        public void givenUserWhenGetNameThenReturnsCorrectName() {
            // when
            String actualName = user.getName();

            // then
            assertThat(actualName).isEqualTo(Constant.NAME);
        }

        @Test
        @DisplayName("Should update and return the correct name")
        public void givenUserWhenSetNameThenNameIsUpdated() {
            // given
            user.setName(Constant.NEW_NAME);

            // when
            String actualName = user.getName();

            // then
            assertThat(actualName).isEqualTo(Constant.NEW_NAME);
        }

        @Test
        @DisplayName("Should return the correct email")
        public void givenUserWhenGetEmailThenReturnsCorrectEmail() {
            // when
            String actualEmail = user.getEmail();

            // then
            assertThat(actualEmail).isEqualTo(Constant.EMAIL);
        }

        @Test
        @DisplayName("Should update and return the correct email")
        public void givenUserWhenSetEmailThenEmailIsUpdated() {
            // given
            user.setEmail(Constant.NEW_EMAIL);

            // when
            String actualEmail = user.getEmail();

            // then
            assertThat(actualEmail).isEqualTo(Constant.NEW_EMAIL);
        }

        @Test
        @DisplayName("Should return the correct role")
        public void givenUserWhenGetRoleThenReturnsCorrectRole() {
            // when
            String actualRole = user.getRole();

            // then
            assertThat(actualRole).isEqualTo(Constant.ROLE);
        }

        @Test
        @DisplayName("Should update and return the correct role")
        public void givenUserWhenSetRoleThenRoleIsUpdated() {
            // given
            user.setRole(Constant.NEW_ROLE);

            // when
            String actualRole = user.getRole();

            // then
            assertThat(actualRole).isEqualTo(Constant.NEW_ROLE);
        }
    }

    @Nested
    @DisplayName("Equals and HashCode Tests")
    class EqualsAndHashCodeTests {

        @Test
        @DisplayName("Should return true when comparing the same object")
        public void givenSameUserWhenEqualsThenReturnTrue() {
            // when
            boolean result = user.equals(user);

            // then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("Should return false when comparing with null")
        public void givenNullWhenEqualsThenReturnFalse() {
            // when
            boolean result = user.equals(null);

            // then
            assertThat(result).isFalse();
        }

        @Test
        @DisplayName("Should return false when comparing with an object of a different class")
        public void givenDifferentClassWhenEqualsThenReturnFalse() {
            // when
            boolean result = user.equals("Some String");

            // then
            assertThat(result).isFalse();
        }

        @Test
        @DisplayName("Should return true when comparing two users with the same values")
        public void givenSimilarUsersWhenEqualsThenReturnTrue() {
            // given
            User user2 = new User(Constant.ID, Constant.NAME, Constant.EMAIL, Constant.ROLE);

            // when
            boolean result = user.equals(user2);

            // then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("Should return false when comparing two users with different emails")
        public void givenDifferentEmailsWhenEqualsThenReturnFalse() {
            // given
            User user2 = new User(Constant.ID, Constant.NAME, Constant.NEW_EMAIL, Constant.ROLE);

            // when
            boolean result = user.equals(user2);

            // then
            assertThat(result).isFalse();
        }

        @Test
        @DisplayName("Should return different hashcodes for two users with different values")
        public void givenDifferentUsersWhenHashCodeThenReturnDifferentHash() {
            // given
            User user2 = new User(Constant.NEW_ID, Constant.NEW_NAME, Constant.NEW_EMAIL, Constant.NEW_ROLE);

            // when
            int userHash = user.hashCode();
            int user2Hash = user2.hashCode();

            // then
            assertThat(userHash).isNotEqualTo(user2Hash);
        }
    }

    @Nested
    @DisplayName("ToString Method Tests")
    class ToStringTests {

        @Test
        @DisplayName("Should return a properly formatted string representation of the User object")
        public void givenUserWhenToStringThenReturnsCorrectString() {
            // given
            String expectedString = "User [id=" + Constant.ID + ", name=" + Constant.NAME
                    + ", email=" + Constant.EMAIL + ", role=" + Constant.ROLE + "]";

            // when
            String actualString = user.toString();

            // then
            assertThat(actualString).isEqualTo(expectedString);
        }
    }
}
