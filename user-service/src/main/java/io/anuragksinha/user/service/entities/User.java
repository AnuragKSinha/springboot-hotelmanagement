package io.anuragksinha.user.service.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {
	@Id
	@Column(name="ID")
	private String userId;
	@Column(name="Name")
	private String name;
	@Column(name="Email")
	private String emailId;
	// Transient means it will not be stored in DB
	@Transient
	private List<Rating> ratings;

}
