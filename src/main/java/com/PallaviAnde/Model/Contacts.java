package com.PallaviAnde.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
	@NotEmpty
	@Size(min =4 ,max=40,message="Name must be min of 4 char and max 40 char!!!")
	private String contactName;
	
	@Column(name="Contact_Number")
	@NotEmpty
	@Size(min=10,max=10,message="It must be 10 digit")
	private String contactNumber;
	
	@Column(name="Contact_Email")
	@NotEmpty
	@Email(message="Email Address is not valid !!!")
	@Pattern(regexp="[a-zA-Z][a-zA-Z0-9-.]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+")
	private String contactEmail;
	
	@Column(name="Active_Switch",nullable=false,length=1)
	private Character activeSwitch;
	
	@Column(name="Create_Date",updatable=false)
	@CreationTimestamp
	private LocalDate createDate;
	
	@Column(name="Update_Date",insertable=false)
	@UpdateTimestamp
	private LocalDate updateDate;
}
