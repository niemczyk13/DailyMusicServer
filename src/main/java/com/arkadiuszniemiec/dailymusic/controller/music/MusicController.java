package com.arkadiuszniemiec.dailymusic.controller.music;

import java.io.IOException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.arkadiuszniemiec.dailymusic.TestRepository;
import com.arkadiuszniemiec.dailymusic.controller.music.dto.AddMusicDto;
import com.arkadiuszniemiec.dailymusic.database.dao.image.ImageDAOImpl;
import com.arkadiuszniemiec.dailymusic.database.dao.music.MusicDAOImpl;
import com.arkadiuszniemiec.dailymusic.database.repository.MusicRepository;
import com.arkadiuszniemiec.dailymusic.model.image.Image;
import com.arkadiuszniemiec.dailymusic.model.music.Music;
import com.arkadiuszniemiec.dailymusic.model.music.media.MediaLink;
import com.arkadiuszniemiec.dailymusic.web.util.RestPreconditions;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@RestController
@RequestMapping("/musics")
public class MusicController {
	@Autowired
	MusicDAOImpl musicDAOImpl;
	@Autowired
	ImageDAOImpl imageDAOImpl;
	@Autowired
	ModelMapper modelMapper;
	
	@PostMapping(consumes = {"multipart/form-data"})
	@ResponseStatus(HttpStatus.CREATED)
	public Music createMusic(
			@ModelAttribute AddMusicDto musicDto) throws IOException {
		System.out.println(musicDto);
		Music music = modelMapper.map(musicDto, Music.class);
		if (musicDto.getImage().getContentType().startsWith("image")) {
			Image image = getImageFromFile(musicDto.getImage());
			imageDAOImpl.save(image);
			music.setImage(image);
		}
		musicDAOImpl.save(music);
		
		return music;
	}

	private Image getImageFromFile(MultipartFile file) throws IOException {
		Image image = new Image();
		image.setContent(file.getBytes());
		image.setName(file.getOriginalFilename());
		return image;
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
