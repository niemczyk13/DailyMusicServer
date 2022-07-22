package com.arkadiuszniemiec.dailymusic.model.image;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.arkadiuszniemiec.dailymusic.model.artist.Artist;
import com.arkadiuszniemiec.dailymusic.model.artist.ArtistDescription;
import com.arkadiuszniemiec.dailymusic.model.music.description.Description;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Image {
	@Id
    @GeneratedValue
    Long id;

    @Lob
    byte[] content;

    String name;
}
