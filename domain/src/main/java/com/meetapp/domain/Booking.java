package com.meetapp.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bookings")
public class Booking {
	@Id
	private Long id;
	private Event event;
	private User user;
	private LocalDateTime bookingDate;
	private String status;
	private BigDecimal totalAmount;

	public Booking() {
	}

	public Booking(Long id, Event event, User user, LocalDateTime bookingDate, String status, BigDecimal totalAmount) {
		this.id = id;
		this.event = event;
		this.user = user;
		this.bookingDate = bookingDate;
		this.status = status;
		this.totalAmount = totalAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingDate, event, id, status, totalAmount, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return Objects.equals(bookingDate, other.bookingDate) && Objects.equals(event, other.event)
				&& Objects.equals(id, other.id) && Objects.equals(status, other.status)
				&& Objects.equals(totalAmount, other.totalAmount) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", event=" + event + ", user=" + user + ", bookingDate=" + bookingDate
				+ ", status=" + status + ", totalAmount=" + totalAmount + "]";
	}

}
