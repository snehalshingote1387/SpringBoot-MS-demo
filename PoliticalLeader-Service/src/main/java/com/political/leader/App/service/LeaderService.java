package com.political.leader.App.service;

import java.util.List;

import com.political.leader.App.CommanUtil.LeaderDetailsResponseDto;
import com.political.leader.App.CommanUtil.StatusDto;
import com.political.leader.App.vo.LeaderAssignTaskDetailsVo;
import com.political.leader.App.vo.LeaderAssignTaskReqVo;
import com.political.leader.App.vo.LeaderAssignTaskRespVo;
import com.political.leader.App.vo.LeaderVO;

public interface LeaderService {

	StatusDto registerLeaderDetails(LeaderVO leaderVO);

	boolean isLeaderExist(Number leaderId);

	StatusDto deleteLeaderById(Number leaderId);

	LeaderAssignTaskRespVo getAssignTaskDetails(Number leaderId);

	LeaderDetailsResponseDto getAllLeadersParty(Number partyId);

	boolean isPartyIdExist(Number partyId);

	LeaderAssignTaskDetailsVo getAllDeveloplemetWorkAssignByleader(LeaderAssignTaskReqVo leaderAssignTaskReqVo);

}
