package com.arkadiuszniemiec.dailymusic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arkadiuszniemiec.dailymusic.database.dao.music.MusicDAOImpl;
import com.arkadiuszniemiec.dailymusic.database.dao.music.description.MusicDescriptionDAOImpl;
import com.arkadiuszniemiec.dailymusic.model.music.Music;
import com.arkadiuszniemiec.dailymusic.model.music.description.MusicDescription;

@RestController
public class MusicDescriptionController {
	@Autowired
	private MusicDescriptionDAOImpl dao;
	
	@Autowired
	private MusicDAOImpl musicDAOImpl;
	
	@PostMapping("/musics/{id}/descriptions")
	public ResponseEntity<MusicDescription> createDescription(
			@RequestBody MusicDescription musicDescription,
			@PathVariable Long id) {
		Music music = musicDAOImpl.get(id);
		//music.setMusicDescriptions(musicDescription);

		musicDescription.setMusic(music);
		//musicDAOImpl.update(music.getId(), music);
		dao.save(musicDescription);
		return ResponseEntity.status(HttpStatus.CREATED).body(musicDescription);
	}
}
