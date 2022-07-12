package com.arkadiuszniemiec.dailymusic.database.dao.music.media;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arkadiuszniemiec.dailymusic.database.repository.MediaLinkRepository;
import com.arkadiuszniemiec.dailymusic.model.music.media.MediaLink;

@Component
public class MediaLinkDAOImpl implements MediaLinkDAO{
	@Autowired
	MediaLinkRepository repository;

	@Override
	public List<MediaLink> list() {
		return repository.findAll();
	}

	@Override
	public MediaLink get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long save(MediaLink data) {
		return repository.save(data).getId();
	}

	@Override
	public void update(long id, MediaLink data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
