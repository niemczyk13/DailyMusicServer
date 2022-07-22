package com.arkadiuszniemiec.dailymusic.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arkadiuszniemiec.dailymusic.model.image.Image;

public interface ImagesRepository extends JpaRepository<Image, Long> {

}
