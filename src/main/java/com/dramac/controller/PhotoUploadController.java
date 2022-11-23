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
public class PhotoUploadController {


	private String getFolder() {
		
		Date date = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String str = sdf.format(date);
		
		return str.replace("-", "\\");
	}

	
	
	@RequestMapping(value = "/photoUpload", method = RequestMethod.GET)
	public void photoUpload(MultipartFile[] uploadFile) {
		
	}
	
	@RequestMapping(value = "/photoUploadAction", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<PhotoAttachVO>> photoUploadPost(MultipartFile[] uploadFile) {
		
		ArrayList<PhotoAttachVO> list = new ArrayList<>();
		//폴더 경로
		String uploadFolder = "D:\\01-STUDY\\DRAMAC_Upload";
		
		 File pht_uploadPath = new File(uploadFolder, getFolder());
		 
		 if(pht_uploadPath.exists()==false) {
			 pht_uploadPath.mkdirs();
		 }
		
		for (MultipartFile multipartFile : uploadFile) {
			
			PhotoAttachVO pavo = new PhotoAttachVO();
			
			System.out.println("파일명="+multipartFile.getOriginalFilename());
			System.out.println("파일사이즈="+multipartFile.getSize());
			
			UUID uuid = UUID.randomUUID();
			System.out.println("UUID="+uuid.toString());
			
			 
			pavo.setPht_uploadPath(getFolder());
			pavo.setPht_fileName(multipartFile.getOriginalFilename());
			pavo.setPht_uuid(uuid.toString());
			
			File saveFile = new File(pht_uploadPath, uuid.toString()+"_"+multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile);
				
				if(checkImageType(saveFile)) {
					
					pavo.setPht_image(true);
					
					FileOutputStream thumbnail = new FileOutputStream(new File(pht_uploadPath,"s_"+uuid.toString()+"_"+multipartFile.getOriginalFilename()));
					
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
	public ResponseEntity<byte[]> getFile(String pht_fileName) {
		System.out.println(pht_fileName);

		File file = new File("D:\\01-STUDY\\DRAMAC_Upload\\" + pht_fileName);

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
