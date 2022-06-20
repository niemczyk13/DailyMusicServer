package com.arkadiuszniemiec.dailymusic.model.music.description;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Description {
	private String title;
	private String introduction;
	private String extension;
	private String ending;
	private String bibliography;
}
