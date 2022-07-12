package com.arkadiuszniemiec.dailymusic.model.music.description;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.arkadiuszniemiec.dailymusic.model.employee.Employee;
import com.arkadiuszniemiec.dailymusic.model.music.Music;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
//@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MusicDescription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne//(fetch = FetchType.LAZY)
//	@EqualsAndHashCode.Exclude
//	@ToString.Exclude
//	@JsonBackReference
//	@JoinColumn(name = "MUSIC_ID", referencedColumnName = "ID")
//	@JsonView
	private Music music;
	@Embedded
	private Description description; 
//	@OneToMany
//	private Employee author;
//	@OneToMany
//	private Employee translateAuthor;
	
	public MusicDescription(Music music) {
		this.music = music;
		this.music.getMusicDescriptions().add(this);
	}
}