package com.chen.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tw.Evan.model.dto.GameDTO;

@Service
@Transactional
public class CompetitionService {
	
	@Autowired
	private CompetitionDao cptd;
	
	public List<CompetitionBean> addData(CompetitionBean cptb) {
		 cptd.addData(cptb);
		 return cptd.findAllData();
	}
	
	public CompetitionBean findDataById(int competitionId){
		return cptd.findDataById(competitionId);
	}
	
	public List<CompetitionBean> findDataByName(String name){
		return cptd.findDataByName(name);
	}
	
	public List<CompetitionBean> findAllData() {
		return cptd.findAllData();
	}
	
	public List<CompetitionBean> updateData(CompetitionBean cptb){
		cptd.updateData(cptb);
		return cptd.findAllData();
	}
	
	public List<CompetitionBean> deleteData(int competitionId){
		 cptd.deleteData(competitionId);
		 return cptd.findAllData();
	}
	
	public List<GameDTO> findAllGame(){
		return cptd.findAllGame();
	}
}
