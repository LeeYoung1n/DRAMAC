package com.dramac.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class PhotoController {

//	@RequestMapping(value = "/photouploadForm", method = RequestMethod.GET)
//	public String uploadForm() {
//		return "Photo/photouploadForm";
//	}
//	
//	@RequestMapping(value = "/photouploadFormAction", method = RequestMethod.POST)
//	public void uploadFormPost(MultipartFile[] uploadFile) {
//		
//				String uploadFolder = "E:\\drama_upload";
//
//				for (MultipartFile multipartFile : uploadFile) {
//					System.out.println(multipartFile.getOriginalFilename());
//					System.out.println(multipartFile.getSize());
//
//					File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
//
//					try {
//						multipartFile.transferTo(saveFile);
//					} catch (Exception e) {
//						System.out.println(e.getMessage());
//					}
//
//				}
//	}
	
	private String getFolder() {
		
		Date date = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String str = sdf.format(date);
		
		return str.replace("-", "\\");
	}

	
	
	@RequestMapping(value = "/photoUpload", method = RequestMethod.GET)
	public String uploadAjax() {
		return "Photo/photoUpload";
	}
	
	@RequestMapping(value = "/photoUploadAction", method = RequestMethod.POST)
	public void photouploadAjaxPost(MultipartFile[] uploadFile) {
		
		String uploadFolder = "E:\\drama_upload";
		
		 File uploadPath = new File(uploadFolder, getFolder());
		 
		 if(uploadPath.exists()==false) {
			 uploadPath.mkdirs();
		 }
		
		for (MultipartFile multipartFile : uploadFile) {
			System.out.println(multipartFile.getOriginalFilename());
			System.out.println(multipartFile.getSize());
			
			UUID uuid = UUID.randomUUID();
			System.out.println(uuid.toString());
			
			File saveFile = new File(uploadPath, uuid.toString()+"_"+multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile);
				
				if(checkImageType(saveFile)) {
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_"+uuid.toString()+"_"+multipartFile.getOriginalFilename()));
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail,150,150);
					thumbnail.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
	}
	
	private boolean checkImageType(File file) {
		 
		try {
			String contentType = Files.probeContentType(file.toPath());
			System.out.println("contentType=" + contentType);
			 
			return contentType.startsWith("image");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	


}
