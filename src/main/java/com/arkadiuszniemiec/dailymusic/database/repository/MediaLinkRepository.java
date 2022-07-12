package com.arkadiuszniemiec.dailymusic.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arkadiuszniemiec.dailymusic.model.music.media.MediaLink;

public interface MediaLinkRepository extends JpaRepository<MediaLink, Long> {

}
