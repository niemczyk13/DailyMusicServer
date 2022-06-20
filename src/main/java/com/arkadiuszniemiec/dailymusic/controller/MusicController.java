package com.arkadiuszniemiec.dailymusic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arkadiuszniemiec.dailymusic.TestRepository;
import com.arkadiuszniemiec.dailymusic.database.dao.music.MusicDAOImpl;
import com.arkadiuszniemiec.dailymusic.database.repository.MusicRepository;
import com.arkadiuszniemiec.dailymusic.model.music.Music;
import com.arkadiuszniemiec.dailymusic.model.music.media.MediaLink;

@RestController
public class MusicController {
	@Autowired
	MusicDAOImpl musicDAOImpl;
	
	@PostMapping("/musics")
	public ResponseEntity<Music> createMusic(@RequestBody Music music) {
		musicDAOImpl.save(music);
		return ResponseEntity.status(HttpStatus.CREATED).body(music);
	}

	@GetMapping("/musics/{id}")
	public ResponseEntity<Music> getMusic(@PathVariable("id") Long id) {
		Music music = musicDAOImpl.get(id);
		System.out.println(music.getAlbum());
		return ResponseEntity.status(HttpStatus.OK).body(music);
	}
	
	@GetMapping("/musics")
	public ResponseEntity<List<Music>> getMusics() {
		List<Music> musics = musicDAOImpl.list();
		return ResponseEntity.status(HttpStatus.OK).body(musics);
	}
}
