package com.political.leader.App.vo;

import java.util.List;

import com.political.leader.App.CommanUtil.StatusDto;


public class LeaderTaskAssignReqRespVo {

	private Integer partyId;
	
	 private List<AssignTaskVo> assignTaskListVo;
	 
	 private LeaderVO leaderVO;
	 
	 private StatusDto status;

	public StatusDto getStatus() {
		return status;
	}

	public void setStatus(StatusDto status) {
		this.status = status;
	}

	public Integer getPartyId() {
		return partyId;
	}

	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}

	public List<AssignTaskVo> getAssignTaskListVo() {
		return assignTaskListVo;
	}

	public void setAssignTaskListVo(List<AssignTaskVo> assignTaskListVo) {
		this.assignTaskListVo = assignTaskListVo;
	}

	public LeaderVO getLeaderVO() {
		return leaderVO;
	}

	public void setLeaderVO(LeaderVO leaderVO) {
		this.leaderVO = leaderVO;
	}
	 
	 

}
