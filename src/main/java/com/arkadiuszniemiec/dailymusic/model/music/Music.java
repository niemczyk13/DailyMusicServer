package com.arkadiuszniemiec.dailymusic.model.music;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.arkadiuszniemiec.dailymusic.model.music.media.MediaLink;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Music {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String musicBrainzId;
	private String title;
	private Date dateRecordingSong;
	private String album;
	@OneToMany
	private List<MediaLink> mediaLinks;
	public long getId() {
		return id;
	}
	public void update(Music data) {
		// TODO Auto-generated method stub
		
	}
}
