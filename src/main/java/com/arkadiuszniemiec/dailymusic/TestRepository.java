package com.arkadiuszniemiec.dailymusic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arkadiuszniemiec.dailymusic.model.music.Music;

@Repository
public class TestRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Music> getAll() {
		
		return jdbcTemplate.query("SELECT * FROM music", BeanPropertyRowMapper.newInstance(Music.class));
	}
}
