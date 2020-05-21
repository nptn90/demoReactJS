package com.example.demo.shedlock;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="shedlock")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShedLockEntity {
	
	@Id
	String name;
	
	@Column(name = "lock_until")
	@Temporal(TemporalType.TIMESTAMP)
	Date lockUntil;
	
	@Column(name = "locked_at")
	@Temporal(TemporalType.TIMESTAMP)
	Date lockAt;
	
	@Column(name = "locked_by")
	String lockedBy;
}
