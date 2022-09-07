package com.political.leader.App.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.political.leader.App.entity.PoliticalLeaderEntity;


public interface PoliticalLeaderRepository extends JpaRepository<PoliticalLeaderEntity, Integer>{

	
	@Query("SELECT l FROM LeaderEntity l where l.partyId=?1 ")
	List<PoliticalLeaderEntity> getAllLeadersByParty(int partyId);

}
