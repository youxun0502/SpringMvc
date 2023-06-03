package com.chen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chen.model.CompetitionBean;
import com.chen.model.CompetitionService;
import tw.Evan.model.dto.GameDTO;

@Controller
public class EventController {
	
	@GetMapping("/EventMain")
	public String processEventMain() {
		return "EventMain";
	}
	
	@Autowired
	private CompetitionService compService;
	
	//查詢全部
	@PostMapping("/AllCompetition")
	public String AllCompetition(@RequestParam("allCompetition")String allCompetition, Model m) {
		
		if(allCompetition != null) {
			List<CompetitionBean> events = compService.findAllData();
			m.addAttribute("events", events);
		}
		return "EventDataTable";
	}
	
	//查詢單筆
	@PostMapping("/OneCompetition")
	public String OneCompetition(@RequestParam("eventId")int id, Model m) {
		
		CompetitionBean event = compService.findDataById(id);
		m.addAttribute("event", event);
		
		return "UpdateEvent";
	}
	
	//載入新增頁面
	@PostMapping("/InsertPage")
	public String processInsert(@RequestParam("create")String create, Model m) {
		
		if(create != null) {
			List<GameDTO> games = compService.findAllGame();
			m.addAttribute("games", games);
		}
		return "InsertEvent";
	}
	
	//新增資料
	@PostMapping("/InsertCompetition")
	public String InsertCompetition(@RequestParam("gameId")int gameId, @RequestParam("name")String name, @RequestParam("mode")String mode, @RequestParam("desc")String desc
			, @RequestParam("startDate")String startDate, @RequestParam("endDate")String endDate, @RequestParam("location")String location
			, @RequestParam("prize")int prize, @RequestParam("quotaLimited")int quotaLimited, @RequestParam("deadline")String deadline
			, Model m) {
		
		CompetitionBean cptb = new CompetitionBean();
		cptb.setGameId(gameId);
		cptb.setName(name);
		cptb.setMode(mode);
		cptb.setDescription(desc);
		cptb.setStartDate(startDate);
		cptb.setEndDate(endDate);
		cptb.setLocation(location);
		cptb.setPrize(prize);
		cptb.setQuotaLimited(quotaLimited);
		cptb.setDeadline(deadline);
		
		List<CompetitionBean> events = compService.addData(cptb);
		m.addAttribute("events", events);
		
		return "EventDataTable";
	}
	
	//更新資料
	@PostMapping("/UpdateCompetition")
	public String UpdateCompetition(@RequestParam("id")int id, @RequestParam("name")String name, @RequestParam("mode")String mode
			, @RequestParam("startDate")String startDate, @RequestParam("endDate")String endDate, @RequestParam("location")String location
			, @RequestParam("prize")int prize, @RequestParam("quotaLimited")int quotaLimited, @RequestParam("deadline")String deadline
			, Model m) {
		
		CompetitionBean cptb = new CompetitionBean();
		cptb.setCompetitionId(id);
		cptb.setName(name);
		cptb.setMode(mode);
		cptb.setStartDate(startDate);
		cptb.setEndDate(endDate);
		cptb.setLocation(location);
		cptb.setPrize(prize);
		cptb.setQuotaLimited(quotaLimited);
		cptb.setDeadline(deadline);
		
		List<CompetitionBean> events = compService.updateData(cptb);
		m.addAttribute("events", events);
		
		return "EventDataTable";
	}
	
	//搜尋資料
	@PostMapping("/SearchCompetition")
	public String SearchCompetition(@RequestParam("gameName")String name, Model m) {
		
		List<CompetitionBean> events = compService.findDataByName(name);
		m.addAttribute("events", events);
		
		return "EventDataTable";
	}
	
	//刪除資料
	@PostMapping("/DeleteCompetition")
	public String DeleteCompetition(@RequestParam("eventId")int id, Model m) {
		List<CompetitionBean> events = compService.deleteData(id);
		m.addAttribute("events", events);
		
		return "EventDataTable";
	}
}
