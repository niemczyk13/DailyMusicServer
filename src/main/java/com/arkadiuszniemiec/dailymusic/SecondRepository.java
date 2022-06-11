package com.arkadiuszniemiec.dailymusic;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arkadiuszniemiec.dailymusic.model.music.Music;

interface SecondRepository extends JpaRepository<Music, Integer> {

}
