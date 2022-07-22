package com.arkadiuszniemiec.dailymusic.database.dao.image;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arkadiuszniemiec.dailymusic.database.repository.ImagesRepository;
import com.arkadiuszniemiec.dailymusic.model.image.Image;

@Component
public class ImageDAOImpl implements ImageDAO {
	@Autowired
	private ImagesRepository repository;
	
	@Override
	public List<Image> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image get(long id) {
		return repository.getReferenceById(id);
	}

	@Override
	public long save(Image data) {
		return repository.save(data).getId();
	}

	@Override
	public void update(long id, Image data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
