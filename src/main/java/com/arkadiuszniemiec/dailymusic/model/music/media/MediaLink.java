package com.arkadiuszniemiec.dailymusic.model.music.media;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.arkadiuszniemiec.dailymusic.model.music.Music;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MediaLink {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String url;
	@ManyToOne
	private Music music;
	@OneToOne
	@JoinColumn(name = "type_link_id", referencedColumnName = "id")
	private TypeLink typeLink;
	
	public MediaLink(Music music) {
		this.music = music;
		this.music.getMediaLinks().add(this);
	}
}
