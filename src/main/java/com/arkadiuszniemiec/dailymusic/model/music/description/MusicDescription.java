package com.arkadiuszniemiec.dailymusic.model.music.description;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.arkadiuszniemiec.dailymusic.model.employee.Employee;
import com.arkadiuszniemiec.dailymusic.model.music.Music;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MusicDescription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne//(fetch = FetchType.LAZY)//(cascade = CascadeType.ALL)
	private Music music;
	@Embedded
	private Description description; 
//	@OneToMany
//	private Employee author;
//	@OneToMany
//	private Employee translateAuthor;
}