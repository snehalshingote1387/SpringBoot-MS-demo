package com.political.leader.App.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.political.leader.App.CommanUtil.LeaderDetailsResponseDto;
import com.political.leader.App.CommanUtil.LeaderUtil;
import com.political.leader.App.CommanUtil.StatusDto;
import com.political.leader.App.entity.PoliticalLeaderEntity;
import com.political.leader.App.repository.PoliticalLeaderRepository;
import com.political.leader.App.service.LeaderService;
import com.political.leader.App.vo.LeaderAssignTaskDetailsVo;
import com.political.leader.App.vo.LeaderAssignTaskReqVo;
import com.political.leader.App.vo.LeaderAssignTaskRespVo;
import com.political.leader.App.vo.LeaderDevelipementTaskReqResp;
import com.political.leader.App.vo.LeaderTaskAssignReqRespVo;
import com.political.leader.App.vo.LeaderVO;
import com.political.leader.App.vo.PartyRequectVO;

@Service
public class LeaderServiceImpl implements LeaderService{

	@Autowired
	private PoliticalLeaderRepository  politicalLeaderRepository;
	
	@Autowired
	private RestTemplate rt;
	
	@Override
	public StatusDto registerLeaderDetails(LeaderVO leaderVO) {
		StatusDto statusDto=new StatusDto();
		PartyRequectVO partyReqVo=new PartyRequectVO();
		partyReqVo.setPartyId(leaderVO.getPartyId());
		partyReqVo.setStatusVo(statusDto);
		try {
		PartyRequectVO status=this.rt.postForObject("http://Party-Service/party/getParty", partyReqVo,PartyRequectVO.class);
		if(status.getStatusVo().getIsSuccess() && status.getStatusVo().getStatusCode()==200 ) {
		PoliticalLeaderEntity politicalLeaderEntity=new PoliticalLeaderEntity();
		politicalLeaderEntity.setLeaderId(leaderVO.getLeaderId());
		politicalLeaderEntity.setPartyId(leaderVO.getPartyId());
		politicalLeaderEntity.setLeaderName(leaderVO.getLeaderName());
		politicalLeaderEntity.setLeaderState(leaderVO.getLeaderState());
		politicalLeaderEntity=politicalLeaderRepository.save(politicalLeaderEntity);
		statusDto=LeaderUtil.getStatusDetails(200,true,"Leader Registred Successfully","");
		}else {
		statusDto=status.getStatusVo();
		}
		}catch(Exception ex) {
			
		}
		return statusDto;
	}

	@Override
	public boolean isLeaderExist(Number leaderId) {
	return politicalLeaderRepository.existsById(Integer.parseInt(leaderId.toString()));
		}

	@Override
	public StatusDto deleteLeaderById(Number leaderId) {
		StatusDto status=new StatusDto();
		try {
			politicalLeaderRepository.deleteById(Integer.parseInt(leaderId.toString()));
			status=LeaderUtil.getStatusDetails(200,true,"Leader Details Deleted SuccessFully","");
		}catch(Exception Ex) {
			status=LeaderUtil.getStatusDetails(500,false,"Leader Details Deleted Fail due to Internal Server Issue","");
		}
		return status;
	}

	@Override
	public LeaderAssignTaskRespVo getAssignTaskDetails(Number leaderId) {
		LeaderTaskAssignReqRespVo reqResp=new LeaderTaskAssignReqRespVo();
		LeaderAssignTaskRespVo resp=new LeaderAssignTaskRespVo();
		reqResp.setPartyId(Integer.parseInt(leaderId.toString()));
		try {
		 reqResp=this.rt.postForObject("http://Developement-Service/developement/getLeaderAssignTask", reqResp,LeaderTaskAssignReqRespVo.class);
		if(reqResp.getStatus().getIsSuccess() &&reqResp.getStatus().getStatusCode()==200 ) {
			resp.setAssignTaskListVo(reqResp.getAssignTaskListVo());
		
			Optional<PoliticalLeaderEntity> leadDeyails=politicalLeaderRepository.findById(Integer.parseInt(leaderId.toString()));
		    if(leadDeyails.isPresent()) {
		    LeaderVO leadVo=new LeaderVO();	
		    leadVo.setLeaderId(leadDeyails.get().getLeaderId());
		    leadVo.setPartyId(leadDeyails.get().getPartyId());
		    leadVo.setLeaderName(leadDeyails.get().getLeaderName());
		    leadVo.setLeaderState(leadDeyails.get().getLeaderState());
		    resp.setLeaderVO(leadVo);
		    }
		}
		}catch(Exception ex) {
			
		}
		return resp;
	}

	@Override
	public LeaderDetailsResponseDto getAllLeadersParty(Number partyId) {
		 List<PoliticalLeaderEntity> leaderList=politicalLeaderRepository.getAllLeadersByParty(Integer.parseInt(partyId.toString()));
		 List<LeaderVO> leadList=new ArrayList<>();
		 StatusDto status=new StatusDto();
		 LeaderDetailsResponseDto leadListVo=new LeaderDetailsResponseDto();
		 leaderList.forEach(lead->{
			 LeaderVO ldVo=new LeaderVO();	
			 ldVo.setLeaderId(lead.getLeaderId());
			 ldVo.setPartyId(lead.getPartyId());
			 ldVo.setLeaderName(lead.getLeaderName());
			 ldVo.setLeaderState(lead.getLeaderState());
			 leadList.add(ldVo);
		 });
		 status=LeaderUtil.getStatusDetails(200,true,"Leader Details Fetched Successfully","");
		 leadListVo.setStatus(status);
		 leadListVo.setLeadVoList(leadList);
		 
		 return leadListVo;
	}

	@Override
	public boolean isPartyIdExist(Number partyId) {
	   List<PoliticalLeaderEntity> leaderList=politicalLeaderRepository.getAllLeadersByParty(Integer.parseInt(partyId.toString()));
		boolean flag;
	   if(leaderList.size()>0) {
		   flag=true;	
		}else {
		   flag=false;		
		}
	   return flag;
	}

	@Override
	public LeaderAssignTaskDetailsVo getAllDeveloplemetWorkAssignByleader(LeaderAssignTaskReqVo leaderAssignTaskReqVo) {
		LeaderAssignTaskDetailsVo leadAssignTaskVo=new LeaderAssignTaskDetailsVo();
		LeaderDevelipementTaskReqResp reqResp=new LeaderDevelipementTaskReqResp();
		reqResp.setLeaderAssignTaskReqVo(leaderAssignTaskReqVo);
		try {
		 reqResp=this.rt.postForObject("http://Developement-Service/developement/getLeaderDeveloplemetTask", reqResp,LeaderDevelipementTaskReqResp.class);
		 if(reqResp.getLeaderDevelopementList().size()>0) {
		 leadAssignTaskVo.setListDevVo(reqResp.getLeaderDevelopementList());
		 leadAssignTaskVo.setFlag(true);
		 }else {
		 leadAssignTaskVo.setListDevVo(reqResp.getLeaderDevelopementList());
		 leadAssignTaskVo.setFlag(false); 
		 }
		}catch(Exception ex) {
			
		}
		return leadAssignTaskVo;
	
	}
	

}
