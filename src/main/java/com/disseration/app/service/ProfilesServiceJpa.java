package com.disseration.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disseration.app.model.Profile;
import com.disseration.app.repository.ProfilesRepository;

@Service
public class ProfilesServiceJpa implements IProfilesService {
	
	@Autowired
	private ProfilesRepository profilesRepository;

	@Override
	public List<Profile> searchAllProfiles() {
		return profilesRepository.findAll();
	}

}
