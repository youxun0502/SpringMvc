package com.ni.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ni.model.GameItem;
import com.ni.model.IGameItemService;

import jakarta.servlet.http.HttpServletRequest;
import tw.Evan.model.dto.GameDTO;

@Controller
public class GameItemControllerS {

	@GetMapping("/gameitem.controller")
	public String processMainAction() {
		return "ItemMain";
	}
	
	@Autowired
	@Qualifier(value = "gameItemService")
	private IGameItemService itemService;
	
	@GetMapping("/allGameItem")
	public String getAllData(Model m) {
		m.addAttribute("items", itemService.getAllData());
		System.out.println(m);
		return "ItemDataTable";
	}
	
	@PostMapping("/getGameItemByName")
	public String getDataByName(@RequestParam("itemName") String itemName, Model m) {
		m.addAttribute("items", itemService.getDataByName(itemName));
		System.out.println(m);
		return "ItemDataTable";
	}
	
	@PostMapping("/getGameItemById")
	public String getDataById(@RequestParam("itemId") int itemId, Model m) {
		m.addAttribute("item", itemService.getDataById(itemId));
		m.addAttribute("games", itemService.getGame());
		System.out.println(m);
		return "ItemUpdateData";
	}
	
	@PostMapping("/gameItemUpdate")
	public String update(@ModelAttribute GameItem item, @ModelAttribute GameDTO game, @RequestParam("myImg") MultipartFile mf, HttpServletRequest request, Model m) throws IllegalStateException, IOException {
		if(mf != null && !mf.isEmpty()) {
			String realPath = request.getServletContext().getRealPath("/WEB-INF/resources/img/");
			String fileName = saveImg(mf, realPath);
			if(fileName != null && fileName.length() != 0) {
				item.setItemImg(fileName);
			} else {
				System.out.println(item.getItemImg());
			}
		}
		item.setGameDTO(game);
		item.setUpdateTime(new Date());
		m.addAttribute("items", itemService.update(item));
		System.out.println(m);
		return "redirect:allGameItem";
	}
	
	@PostMapping("/newGameItem")
	public String newItem(Model m) {
		m.addAttribute("games", itemService.getGame());
		m.addAttribute("item", new GameItem());
		return "ItemInsert";
	}
	
	@PostMapping("/gameItemInsert")
	public String insert(@ModelAttribute("item") GameItem item, @RequestParam("gameName") String gameName, @RequestParam("myImg") MultipartFile mf, Model m, HttpServletRequest request) throws IllegalStateException, IOException {
		if(mf != null && !mf.isEmpty()) {
			String realPath = request.getServletContext().getRealPath("/WEB-INF/resources/img/");
			String fileName = saveImg(mf, realPath);
			if(fileName != null && fileName.length() != 0) {
				item.setItemImg(fileName);
			} 
		} 
		item.setCreateTime(new Date());
		m.addAttribute("item", itemService.insert(item));
		System.out.println(m);
		return "redirect:allGameItem";
	}
	
	@PostMapping("/gameItemDelete")
	public String delete(@RequestParam("itemId") int itemId) {
		itemService.delete(itemId);
		System.out.println(itemId);
		return "redirect:allGameItem";
	}
	
	public String saveImg(MultipartFile mf, String saveDir) throws IllegalStateException, IOException {
		String fileName = mf.getOriginalFilename();
		File saveFilePath = new File(saveDir, fileName);
		mf.transferTo(saveFilePath);
		System.out.println(saveFilePath);
		return fileName;
	}
}
