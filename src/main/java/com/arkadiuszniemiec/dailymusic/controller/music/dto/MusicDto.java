package com.arkadiuszniemiec.dailymusic.controller.music.dto;

import java.util.Date;

public record MusicDto(
		String title,
		Date dateRecordingSong,
		String album) {

}
