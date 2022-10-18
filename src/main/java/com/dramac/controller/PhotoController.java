package com.dramac.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.dramac.model.PhotoAttachVO;

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
//					System.out.println(multipartFile.getOriginalfileName());
//					System.out.println(multipartFile.getSize());
//
//					File saveFile = new File(uploadFolder, multipartFile.getOriginalfileName());
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
	public String photoUpload() {
		return "Photo/photoUpload";
	}
	
	@RequestMapping(value = "/photoUploadAction", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<PhotoAttachVO>> photoUploadPost(MultipartFile[] uploadFile) {
		
		ArrayList<PhotoAttachVO> list = new ArrayList<>();
		
		String uploadFolder = "E:\\drama_upload";
		
		 File uploadPath = new File(uploadFolder, getFolder());
		 
		 if(uploadPath.exists()==false) {
			 uploadPath.mkdirs();
		 }
		
		for (MultipartFile multipartFile : uploadFile) {
			
			PhotoAttachVO pavo = new PhotoAttachVO();
			
			System.out.println(multipartFile.getOriginalFilename());
			System.out.println(multipartFile.getSize());
			
			UUID uuid = UUID.randomUUID();
			System.out.println(uuid.toString());
			
			 
			pavo.setUploadPath(getFolder());	 
			pavo.setFileName(multipartFile.getOriginalFilename());
			pavo.setUuid(uuid.toString());
			
			File saveFile = new File(uploadPath, uuid.toString()+"_"+multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile);
				
				if(checkImageType(saveFile)) {
					
					pavo.setImage(true);
					
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_"+uuid.toString()+"_"+multipartFile.getOriginalFilename()));
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail,150,150);
					
					thumbnail.close();
				}
				
				list.add(pavo);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
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
	
	@RequestMapping(value = "/photoDisplay", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getFile(String fileName) {
		System.out.println(fileName);

		File file = new File("E:\\drama_upload\\" + fileName);

		ResponseEntity<byte[]> result = null;

		HttpHeaders headers = new HttpHeaders();

		try {
			headers.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	


}
