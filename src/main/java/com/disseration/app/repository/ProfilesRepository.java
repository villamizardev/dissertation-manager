package com.disseration.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.disseration.app.model.Profile;

public interface ProfilesRepository extends JpaRepository<Profile, Integer> {
}
