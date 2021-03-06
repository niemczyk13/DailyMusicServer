package com.arkadiuszniemiec.dailymusic.database.dao.music.description;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arkadiuszniemiec.dailymusic.database.repository.MusicDescriptionRepository;
import com.arkadiuszniemiec.dailymusic.model.music.description.MusicDescription;

@Component
public class MusicDescriptionDAOImpl implements MusicDescriptionDAO {
	@Autowired
	private MusicDescriptionRepository repository;

	@Override
	public List<MusicDescription> list() {
		return repository.findAll();
	}

	@Override
	public MusicDescription get(long id) {
		// TODO Auto-generated method stub
		return repository.getReferenceById(id);
	}

	@Override
	public long save(MusicDescription data) {
		return repository.save(data).getId();
//		return 0L;
	}

	@Override
	public void update(long id, MusicDescription data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
