package tw.Evan.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.Part;

public class saveFile {

	public String saveFileMVC(MultipartFile part, String virLoc, String locName) {
		try {
			String fileName = part.getOriginalFilename();
			System.out.println("fileName:"+fileName);
			
			File saveFilePath = new File(virLoc,fileName);
//			byte[] b = part.getBytes();
			part.transferTo(saveFilePath);
			
			return fileName;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return locName;
		}
		
	}
}
