package com.arkadiuszniemiec.dailymusic.model.music;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.arkadiuszniemiec.dailymusic.model.music.description.MusicDescription;
import com.arkadiuszniemiec.dailymusic.model.music.media.MediaLink;
import com.arkadiuszniemiec.dailymusic.model.music.media.MediaLinks;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Music {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String musicBrainzId;
	private String title;
	private Date dateRecordingSong;
	private String album;
	//private MediaLinks mediaLinks;
	private Date creationDate;
	private Date modificationDate;
	@OneToMany(mappedBy = "music")//(cascade = CascadeType.ALL)
	//@JoinColumn//(name = "music")
	private List<MusicDescription> musicDescriptions;
	@ManyToMany
	private List<MusicType> musicTypes;

	public void update(Music data) {
		// TODO Auto-generated method stub
	}

	public void setMusicDescriptions(MusicDescription musicDescription) {
		//if (musicDescriptions == null) musicDescriptions = new ArrayList<>();
		musicDescriptions.add(musicDescription);
		musicDescription.setMusic(this);
	}

}
