package com.arkadiuszniemiec.dailymusic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arkadiuszniemiec.dailymusic.TestRepository;
import com.arkadiuszniemiec.dailymusic.database.dao.music.MusicDAOImpl;
import com.arkadiuszniemiec.dailymusic.database.repository.MusicRepository;
import com.arkadiuszniemiec.dailymusic.model.music.Music;

@RestController
public class TestController {
	@Autowired
	MusicDAOImpl musicDAOImpl;
	
	//@Autowired
	
	
	@GetMapping("/test")
	public List<Music> test() {
		return musicDAOImpl.list();
	}
}
