package com.li.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.li.model.BonusItem;
import com.li.model.BonusItemService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes(names = {"formId"})
public class BonusItemController {
	
	@Autowired
	private BonusItemService bService;
	
	@RequestMapping(path = "/bonusitemmain")
	public String bonuscontrollermain(){
		System.out.println("main!!!!");
		return "BonusMain";
	}
	
	@RequestMapping(path = "/bonusitem.searchall", method = {RequestMethod.GET, RequestMethod.POST})
	public String bonuscontrollersearchall(Model m){
		List<BonusItem> result = bService.SearchAll();
		m.addAttribute("bonusitems", result);
		return "GetAllItems";
	}
	
	@RequestMapping(path = "/bonusitem.insert", method = {RequestMethod.GET, RequestMethod.POST})
	public String bonuscontrollerinsert(@ModelAttribute BonusItem bitem,Model m,@RequestParam("bonusimg2")MultipartFile mf,HttpServletRequest request) throws IllegalStateException, IOException, ServletException{
		
		String fileName = Pictures(mf,request.getServletContext().getRealPath("/WEB-INF/resources/img/"));
		if(fileName!=null && fileName.length()!=0) {
			bitem.setBonusimg(fileName);
		}
		bService.Insert(bitem);
		return "redirect:bonusitem.searchall";
	}
	
	
	public String Pictures(MultipartFile mf,String saveDir) throws IllegalStateException, IOException {
		String fileName = mf.getOriginalFilename();
		
		File saveFilePath = new File(saveDir, fileName);
		
		mf.transferTo(saveFilePath);
		
		return fileName;
		
		
	}
	
	@RequestMapping(path = "/bonusitem.search", method = {RequestMethod.GET, RequestMethod.POST})
	public String bonuscontrollersearch(Model m,@RequestParam("bonussearch")String str){
		List<BonusItem> result = bService.Search(str);
		m.addAttribute("bonusitems", result);
		return "GetAllItems";
	}
	@RequestMapping(path = "/bonusitem.delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String bonuscontrollerdelete(Model m,@RequestParam("removeId")int del){
		bService.Delete(del);
		return "redirect:bonusitem.searchall";
	}
	@RequestMapping(path = "/bonusitem.update", method = {RequestMethod.GET, RequestMethod.POST})
	public String bonuscontrollerupdate(Model m,@RequestParam("changeId")int changeId){
		m.addAttribute("bonusitem", bService.SearchOne(changeId));
		return "UpdateBonusData";
	}
	@RequestMapping(path = "/bonusitem.updatedata", method = {RequestMethod.GET, RequestMethod.POST})
	public String bonuscontrollerupdatedata(Model m,@ModelAttribute BonusItem bitem,@RequestParam("bonusId")int bonusId){
//		System.out.println(bonusId+" "+bitem.getBonusid()+" "+bitem.getBonusname()+" "+bitem.getBonusprice()+" "+bitem.getBonusdes()+" "+bitem.getBonusimg());
		bService.Update(bonusId, bitem);
		return "redirect:bonusitem.searchall";
	}
	
	
}
	