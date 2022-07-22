package com.arkadiuszniemiec.dailymusic.model.music;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.arkadiuszniemiec.dailymusic.model.image.Image;
import com.arkadiuszniemiec.dailymusic.model.music.description.MusicDescription;
import com.arkadiuszniemiec.dailymusic.model.music.media.MediaLink;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Music {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String musicBrainzId;
	private String title;
	private Date dateRecordingSong;
	private String album;
	private Date creationDate;
	private Date modificationDate;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "music")
	private Set<MusicDescription> musicDescriptions = new HashSet<>();
	@OneToMany(cascade = CascadeType.ALL)
	private Set<MediaLink> mediaLinks = new HashSet<>();
	@ManyToMany
	private Set<MusicType> musicTypes = new HashSet<>();
	@OneToOne(cascade = CascadeType.ALL)
	private Image image;

	public void setMusicDescription(MusicDescription musicDescription) {
		musicDescriptions.add(musicDescription);
		musicDescription.setMusic(this);
	}
	
	public void setMediaLink(MediaLink mediaLink) {
		mediaLinks.add(mediaLink);
		mediaLink.setMusic(this);
	}

	public void setMusicType(MusicType musicType) {
		musicTypes.add(musicType);
		musicType.setMusic(this);
	}

	public void update(Music data) {
		// TODO Auto-generated method stub
		
	}
}
