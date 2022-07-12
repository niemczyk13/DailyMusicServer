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

import com.arkadiuszniemiec.dailymusic.database.dao.music.MusicDAOImpl;
import com.arkadiuszniemiec.dailymusic.database.dao.music.media.MediaLinkDAOImpl;
import com.arkadiuszniemiec.dailymusic.database.dao.music.media.TypeLinkDAOImpl;
import com.arkadiuszniemiec.dailymusic.model.music.Music;
import com.arkadiuszniemiec.dailymusic.model.music.media.MediaLink;
import com.arkadiuszniemiec.dailymusic.model.music.media.TypeLink;

@RestController
public class MediaLinksController {
	@Autowired
	private MusicDAOImpl musicDAOImpl;
	
	@Autowired
	private MediaLinkDAOImpl mediaLinkDAOImpl;
	
	@Autowired
	private TypeLinkDAOImpl typeLinkDAOImpl;
	
	@PostMapping("/musics/{id}/medialinks")
	public ResponseEntity<MediaLink> createMediaLink(
			@RequestBody MediaLink mediaLink,
			@PathVariable Long id) {
		Music music = musicDAOImpl.get(id);
		music.setMediaLink(mediaLink);
		
		mediaLink.setMusic(music);
		mediaLinkDAOImpl.save(mediaLink);
		return ResponseEntity.status(HttpStatus.CREATED).body(mediaLink);
	}
	
	@GetMapping("/medialinks")
	public ResponseEntity<List<MediaLink>> getMediaLinks() {
		return ResponseEntity.status(HttpStatus.OK).body(mediaLinkDAOImpl.list());
	}
	
	@PostMapping("/typelinks")
	public ResponseEntity<TypeLink> createTypeLink(@RequestBody TypeLink typeLink) {
		typeLinkDAOImpl.save(typeLink);
		return ResponseEntity.status(HttpStatus.CREATED).body(typeLink);
	}
}
