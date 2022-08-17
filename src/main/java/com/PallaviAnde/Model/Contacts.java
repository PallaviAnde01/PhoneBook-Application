package com.PallaviAnde.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="Contact_Details")
@Getter
@Setter
@NoArgsConstructor
public class Contacts {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Contact_Id")
	private Integer contactId;
	
	@Column(name="Contact_Name")
	private String contactName;
	
	@Column(name="Contact_Number")
	private String contactNumber;
	
	@Column(name="Contact_Email")
	private String contactEmail;
	
	@Column(name="Active_Switch")
	private Character activeSwitch;
	
	@Column(name="Create_Date")
	private LocalDate createDate;
	
	@Column(name="Update_Date")
	private LocalDate updateDate;
}
