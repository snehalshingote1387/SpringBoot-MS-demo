package com.political.party.App.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.political.party.App.entity.PartyEntity;

public interface PartyRepository extends JpaRepository<PartyEntity, Integer>{

}
