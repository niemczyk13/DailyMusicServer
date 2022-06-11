package com.arkadiuszniemiec.dailymusic.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arkadiuszniemiec.dailymusic.model.music.Music;

public interface MusicRepository extends JpaRepository<Music, Long> {

}
