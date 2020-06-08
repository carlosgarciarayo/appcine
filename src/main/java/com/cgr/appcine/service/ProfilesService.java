package com.cgr.appcine.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cgr.appcine.controller.UserController;
import com.cgr.appcine.model.Profiles;
import com.cgr.appcine.repository.ProfilesRepository;

@Service
public class ProfilesService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


	@Autowired
	ProfilesRepository profilesRepository;

	public List<Profiles> findAll() {

		return profilesRepository.findAll();

	}

	public Profiles saveProfile(Profiles profiles) {

		return profilesRepository.save(profiles);

	}

	public void deleteProfile(int id) {

		profilesRepository.deleteById(id);

	}

	public Page<Profiles> buscarTodas(Pageable page) {

		return profilesRepository.findAll(page);

	}

	public Profiles findById(int id) {

		return profilesRepository.findById(id);

	}

}
