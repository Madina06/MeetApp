package com.meetapp.domain;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "feedbacks")
public class Feedback {
	@Id
	private Long id;
	private String comment;
	private int rating;
	private User user;
	private Event event;

	public Feedback() {
	}

	public Feedback(Long id, String comment, int rating, User user, Event event) {
		this.id = id;
		this.comment = comment;
		this.rating = rating;
		this.user = user;
		this.event = event;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Feedback feedback = (Feedback) obj;
		return rating == feedback.rating && Objects.equals(id, feedback.id) && Objects.equals(comment, feedback.comment)
				&& Objects.equals(user, feedback.user) && Objects.equals(event, feedback.event);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, comment, rating, user, event);
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", comment=" + comment + ", rating=" + rating + ", user=" + user + ", event="
				+ event + "]";
	}

}
