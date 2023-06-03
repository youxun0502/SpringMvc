package tw.Evan.controller;


import tw.Evan.model.dto.GameDTO;
import tw.Evan.service.IGameService;
import tw.Evan.service.impl.GameService;
import tw.Evan.util.saveFile;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class GameAdminController {

//	---------------------呼叫首頁----------------------
	@GetMapping("/DashHome.controller")
	public String callHome() {
		return "GameDashBoardHome";
	}
//	--------------------注入--------------------------
	@Autowired
	private IGameService gService;
	@Autowired
	private GameDTO gameDTO ;
	
//	-------------------全部遊戲
	@PostMapping("/getAllgames.controller")
	@ResponseBody
	public List<GameDTO> GetAllGamesInfos() {
		List<GameDTO> gamesInfos = gService.getAllGameInfo();
		System.out.println(gamesInfos);
		return gamesInfos;
	}
	
//	------------------新建遊戲
	@PostMapping("/create.controller")
	public String createGame(@RequestParam Map<String,Object> formData,@RequestParam("GamePicPath") MultipartFile file,HttpServletRequest request) {
		gService.insertGameInfo(getInfoFromRequest(formData,file,request));
		return "GameDashBoardHome";
	} 

//	-----------------查找名字
	@ResponseBody
	@GetMapping("/serchName.controller")
	public boolean SearchUserName(@RequestParam Map<String,Object> formData) throws IOException {
		String userName = (String)formData.get("username");
		boolean flag = gService.SearchUserByName(userName);
		return flag;
	}
	
//	----------------刪除遊戲
	@PostMapping("/delete.controller")
	public String deleteGame(@RequestParam Map<String,Object> formData) throws IOException {
		int id = Integer.parseInt((String)formData.get("id"));
		gService.deleteGame(id);
		return "GameDashBoardHome";
	}
	
//	---------------更新遊戲
	@PostMapping("/update.controller")
	public String updateUserName(@RequestParam Map<String,Object> formData,@RequestParam("GamePicPath") MultipartFile file,HttpServletRequest request) throws IOException{
		gService.updateGameInfo(getInfoFromRequest(formData,file,request));
		return "GameDashBoardHome";
	}

//	--------------以名字查詢遊戲
	@ResponseBody
	@PostMapping("/searchLikeName.controller")
	public List<GameDTO> SearchLikeName(@RequestParam Map<String,Object> formData) {
		List<GameDTO> gamesInfos = gService.SearchLikeName((String)formData.get("gameName"));
		System.out.println(gamesInfos);
		return gamesInfos;

	}
	
//	--------------更新、創建區
	private GameDTO getInfoFromRequest(Map<String, Object> formData, MultipartFile file, HttpServletRequest request) {

		//圖片資料處理-------------------------------------------------
		String locName =(String) formData.get("GamePicPathL");
		String virLoc = request.getServletContext().getRealPath("/WEB-INF/resources/img");
		String loc =new saveFile().saveFileMVC(file,virLoc,locName);

		//Id 處理-------------------------------------
		if(formData.get("GameId") != null)gameDTO.setGameId(Integer.parseInt((String)formData.get("GameId")));

		//資料處理---------------------------------------------
		gameDTO.setGameName((String)formData.get("GameName"));
		gameDTO.setPrice(Float.parseFloat((String)formData.get("Price")));
		gameDTO.setCreateDate(Date.valueOf((String)formData.get("CreateDate")));
		gameDTO.setGameIntroduce((String)formData.get("GameIntroduce"));
		gameDTO.setGamePicPath(loc);
		gameDTO.setBuyerCount(Integer.parseInt((String)formData.get("BuyerCount")));
		gameDTO.setStatus(Integer.parseInt((String)formData.get("Status")));
		System.out.println(gameDTO);
		return gameDTO;
	}

}
