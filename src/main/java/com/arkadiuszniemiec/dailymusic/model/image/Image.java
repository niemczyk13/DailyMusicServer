package com.arkadiuszniemiec.dailymusic.model.image;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
@Data
public class Image {
	@Id
    @GeneratedValue
    
    Long id;

    @Lob
    byte[] content;

    String name;
}
