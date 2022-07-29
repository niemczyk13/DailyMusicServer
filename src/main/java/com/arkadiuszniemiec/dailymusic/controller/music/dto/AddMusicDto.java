package com.arkadiuszniemiec.dailymusic.controller.music.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMusicDto {
	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateRecordingSong;
	private String album;
	private MultipartFile image;
	private List<String> musicTypes;
	private List<String> mediaLinks;
	private List<Long> typeLinkIds;
}
