package com.arkadiuszniemiec.dailymusic.database.dao.music.media;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arkadiuszniemiec.dailymusic.database.repository.TypeLinkRepository;
import com.arkadiuszniemiec.dailymusic.model.music.media.TypeLink;

@Component
public class TypeLinkDAOImpl implements TypeLinkDAO {
	@Autowired
	private TypeLinkRepository repository;

	@Override
	public List<TypeLink> list() {
		return repository.findAll();
	}

	@Override
	public TypeLink get(long id) {
		return repository.getReferenceById(id);
	}

	@Override
	public long save(TypeLink data) {
		return repository.save(data).getId();
	}

	@Override
	public void update(long id, TypeLink data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
