package com.RegisterLogin.Entity;

import java.util.Calendar;
import java.util.Date;

import jakarta.persistence.ForeignKey;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class VerificationToken {
	private static final int EXPIRY_TIME = 10;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String token;
	Date expiryTime;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id", 
	nullable = false,
	foreignKey = @ForeignKey(name = "FK_USER_VERIFY_TOKEN"))
	User user;

	public VerificationToken(User user, String token) {
		super();
		this.token = token;
		this.expiryTime = calculateExpTime(EXPIRY_TIME);
		this.user = user;
	}

	public VerificationToken(String token) {
		super();
		this.token = token;
		this.expiryTime = calculateExpTime(EXPIRY_TIME);
	}
	
	private Date calculateExpTime(int expTime) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(new Date().getTime());
		cal.add(Calendar.MINUTE, expTime);
		return new Date(cal.getTime().getTime());
	}

	
	
	
}
