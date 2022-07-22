package com.arkadiuszniemiec.dailymusic.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.arkadiuszniemiec.dailymusic.controller.music.dto.AddMusicDto;
import com.arkadiuszniemiec.dailymusic.model.music.Music;

@Configuration
@EnableWebMvc
public class WebConfig {
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<AddMusicDto, Music>() {
			@Override
			protected void configure() {
				map().setTitle(source.getTitle());
				map().setDateRecordingSong(source.getDateRecordingSong());
				map().setAlbum(source.getAlbum());
			}
		});
		return modelMapper;
	}
}
