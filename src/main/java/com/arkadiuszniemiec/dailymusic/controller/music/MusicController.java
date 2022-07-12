package com.arkadiuszniemiec.dailymusic.controller.music;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.arkadiuszniemiec.dailymusic.TestRepository;
import com.arkadiuszniemiec.dailymusic.database.dao.music.MusicDAOImpl;
import com.arkadiuszniemiec.dailymusic.database.repository.MusicRepository;
import com.arkadiuszniemiec.dailymusic.model.music.Music;
import com.arkadiuszniemiec.dailymusic.model.music.media.MediaLink;
import com.arkadiuszniemiec.dailymusic.web.util.RestPreconditions;

@RestController
@RequestMapping("/musics")
public class MusicController {
	@Autowired
	MusicDAOImpl musicDAOImpl;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Music createMusic(@RequestBody Music music) {
		musicDAOImpl.save(music);
		return music;
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Music getMusic(@PathVariable("id") Long id) {
		Music music = RestPreconditions.checkFound(musicDAOImpl.get(id));
		return music;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Music> getMusics() {
		List<Music> musics = musicDAOImpl.list();
		return musics;
	}
}
