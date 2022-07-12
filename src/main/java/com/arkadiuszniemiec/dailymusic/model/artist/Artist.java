package com.arkadiuszniemiec.dailymusic.model.artist;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@ManyToOne(cascade =  CascadeType.ALL)
	private Country country;
	@OneToMany(cascade =  CascadeType.ALL)
	private Set<ArtistDescription> artistDescriptions = new HashSet<>();
	@ManyToOne
	private ArtistType artistType;
}
