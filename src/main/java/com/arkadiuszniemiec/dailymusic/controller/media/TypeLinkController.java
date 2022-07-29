package com.arkadiuszniemiec.dailymusic.controller.media;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.arkadiuszniemiec.dailymusic.database.dao.music.media.TypeLinkDAOImpl;
import com.arkadiuszniemiec.dailymusic.model.music.media.TypeLink;

@RestController
@RequestMapping("/links/types")
public class TypeLinkController {
	@Autowired
	private TypeLinkDAOImpl typeLinkDAOImpl;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<TypeLink> getTypeLinks() {
		return typeLinkDAOImpl.list();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public List<TypeLink> setTypeLinks(@RequestBody List<TypeLink> typeLinks) {
		for (TypeLink typeLink : typeLinks) {
			typeLinkDAOImpl.save(typeLink);
		}
		return typeLinks;
	}
}
