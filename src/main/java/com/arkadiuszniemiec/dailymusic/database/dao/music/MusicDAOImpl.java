package com.arkadiuszniemiec.dailymusic.database.dao.music;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arkadiuszniemiec.dailymusic.database.repository.MusicRepository;
import com.arkadiuszniemiec.dailymusic.model.music.Music;

@Component
public class MusicDAOImpl implements MusicDAO {
	@Autowired
	private MusicRepository repository;

	@Override
	public List<Music> list() {
		return repository.findAll();
	}

	@Override
	public Music get(long id) {
		Music music = null;
//		try {
			music = repository.getReferenceById(id);
//		} catch (EntityNotFoundException e) {
//			music = null;
//		}
		return music;
	}

	@Override
	public long save(Music data) {
		return repository.save(data).getId();
	}

	@Override
	public void update(long id, Music data) {
		Music m = repository.getReferenceById(id);
		m.update(data);
		repository.save(m);
	}

	@Override
	public void delete(long id) 	{
		repository.deleteById(id);
	}

}
