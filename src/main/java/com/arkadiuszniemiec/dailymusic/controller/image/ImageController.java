package com.arkadiuszniemiec.dailymusic.controller.image;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.arkadiuszniemiec.dailymusic.database.dao.image.ImageDAOImpl;
import com.arkadiuszniemiec.dailymusic.model.image.Image;

@RestController
@RequestMapping("/images")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ImageController {
	@Autowired
	private ImageDAOImpl imageDAOImpl;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Image createImage(@RequestParam MultipartFile file) {
		System.out.println(file);
		Image image = new Image();
		try {
			byte[] byteArray = file.getBytes();
			
			image.setContent(byteArray);
			image.setName(file.getOriginalFilename());
			imageDAOImpl.save(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Image getImage(@PathVariable Long id) {
			
		return imageDAOImpl.get(id);
	}
}
