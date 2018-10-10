package com.prepsa.movieinformation.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ImageUtil {

	public static final String FILE_UPLOAD_PATH = "F:/imageupload";

	private static final int DEFAULT_BUFFER_SIZE = 1024;

	public static String writeImageToFile(CommonsMultipartFile file) {
		String imageUrl = FILE_UPLOAD_PATH + file.getOriginalFilename();

		try {
			OutputStream out = new BufferedOutputStream(new FileOutputStream(imageUrl));
			byte[] bytes = file.getBytes();
			out.write(bytes);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return imageUrl;

	}

	public static void displayImage(int id, String imageUrl, HttpServletRequest request, HttpServletResponse response) {
		File file = new File(imageUrl);

		BufferedInputStream in = null;
		BufferedOutputStream out = null;

		try {
			in = new BufferedInputStream(new FileInputStream(file), DEFAULT_BUFFER_SIZE);
			out = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);
			byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
