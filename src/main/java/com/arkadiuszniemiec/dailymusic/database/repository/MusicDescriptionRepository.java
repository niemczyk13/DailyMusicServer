package com.arkadiuszniemiec.dailymusic.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arkadiuszniemiec.dailymusic.model.music.description.MusicDescription;

public interface MusicDescriptionRepository extends JpaRepository<MusicDescription, Long> {

}
