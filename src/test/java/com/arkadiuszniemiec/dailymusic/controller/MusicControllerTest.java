package com.arkadiuszniemiec.dailymusic.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@AutoConfigureMockMvc
class MusicControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void testCreateMusic() {
//		this.mockMvc.perform(post("/musics").params(new MultiValueMap<String, String> {
//			
//		}))
		fail("Not yet implemented");
	}

	@Test
	void testGetMusic() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMusics() {
		fail("Not yet implemented");
	}

}
