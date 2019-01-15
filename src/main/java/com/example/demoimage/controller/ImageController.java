package com.example.demoimage.controller;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JEditorPane;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/santan/test")
public class ImageController {

	@GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<Resource> download(String param) throws IOException {

		HttpHeaders headers = new HttpHeaders(); 
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=compAclar.png");

		byte[] bytes = StreamUtils.copyToByteArray(createImage());
	    ByteArrayResource resource = new ByteArrayResource(bytes);
	    
	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentLength(bytes.length)
	            .body(resource);
	}
	
	
        
	public static InputStream createImage() throws IOException {
		int width = 600, height = 500;
		String html = "<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<style>\r\n" + 
				".col-xs-10 {\r\n" + 
				"    width: 83.33333%;\r\n" + 
				"}\r\n" + 
				".col-xs-offset-1 {\r\n" + 
				"    margin-left: 8.33333%;\r\n" + 
				"}\r\n" + 
				".spacer {\r\n" + 
				"    width: 100%;\r\n" + 
				"    height: 20px;\r\n" + 
				"    display: block;\r\n" + 
				"    clear: both;\r\n" + 
				"}\r\n" + 
				".separator {\r\n" + 
				"    display: block;\r\n" + 
				"    clear: both;\r\n" + 
				"    height: 19px;\r\n" + 
				"    width: 100%;\r\n" + 
				"}\r\n" + 
				".response {\r\n" + 
				"    display: block;\r\n" + 
				"    clear: both;\r\n" + 
				"	font-family: Open Sans, sans-serif;\r\n" + 
				"    border-bottom: 1px solid #878787;\r\n" + 
				"    margin-top: 19px;\r\n" + 
				"    font-size: .875em;\r\n" + 
				"    text-transform: uppercase;\r\n" + 
				"}\r\n" + 
				".response-left {\r\n" + 
				"    float: left;\r\n" + 
				"	font-family: Open Sans, sans-serif;\r\n" + 
				"    text-align: left;\r\n" + 
				"    font-weight: 200;\r\n" + 
				"    width: 42%;\r\n" + 
				"    max-width: 208px;\r\n" + 
				"    color: #4a4a4a;\r\n" + 
				"}\r\n" + 
				".response-right {\r\n" + 
				"    float: right;\r\n" + 
				"	font-family: Open Sans, sans-serif;\r\n" + 
				"    text-align: right;\r\n" + 
				"    font-weight: 600;\r\n" + 
				"    width: 56%;\r\n" + 
				"    color: #4a4a4a;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".response-left-middle {\r\n" + 
				"    float: left;\r\n" + 
				"    text-align: left;\r\n" + 
				"	font-family: Open Sans, sans-serif;\r\n" + 
				"    font-weight: 200;\r\n" + 
				"    width: 65%;\r\n" + 
				"    color: #4a4a4a;\r\n" + 
				"    overflow-wrap: break-word;\r\n" + 
				"    word-wrap: break-word;\r\n" + 
				"    word-break: break-word;\r\n" + 
				"}\r\n" + 
				".response-right-middle {\r\n" + 
				"    float: right;\r\n" + 
				"    text-align: right;\r\n" + 
				"    font-weight: 600;\r\n" + 
				"	font-family: Open Sans, sans-serif;\r\n" + 
				"    width: 35%;\r\n" + 
				"    color: #4a4a4a;\r\n" + 
				"    overflow-wrap: break-word;\r\n" + 
				"    word-wrap: break-word;\r\n" + 
				"    word-break: break-word;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".response-left-long {\r\n" + 
				"    float: left;\r\n" + 
				"    text-align: left;\r\n" + 
				"    font-weight: 200;\r\n" + 
				"	font-family: Open Sans, sans-serif;\r\n" + 
				"    width: 90%;\r\n" + 
				"    color: #4a4a4a;\r\n" + 
				"}\r\n" + 
				".response-right-short {\r\n" + 
				"    float: right;\r\n" + 
				"    text-align: right;\r\n" + 
				"    font-weight: 600;\r\n" + 
				"	font-family: Open Sans, sans-serif;\r\n" + 
				"    width: 10%;\r\n" + 
				"    color: #4a4a4a;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"p {\r\n" + 
				"    text-align: left;\r\n" + 
				"    color: #4a4a4a;\r\n" + 
				"	font-weight: 200;\r\n" + 
				"	font-family: Open Sans, sans-serif;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<div>\r\n" + 
				"    <div class=\"spacer\"></div>\r\n" + 
				"    <div class=\"col-xs-10 col-xs-offset-1\">\r\n" + 
				"      <p style=\"text-align: justify;\">Esta es la informaci&oacute;n para la aclaraci&oacute;n, favor de revisar que sea correcta:</p>\r\n" + 
				"    </div>\r\n" + 
				"	\r\n" + 
				"	<div class=\"col-xs-10 col-xs-offset-1\">\r\n" + 
				"      <div>\r\n" + 
				"        <div class=\"response\">\r\n" + 
				"          <div class=\"response-left-middle\">NETFLIX</div>\r\n" + 
				"          <div class=\"response-right-middle\">900.00 MXN</div>\r\n" + 
				"          <div class=\"separator\"></div>\r\n" + 
				"        </div>\r\n" + 
				"      </div>\r\n" + 
				"    </div>\r\n" + 
				"  \r\n" + 
				"    <div class=\"col-xs-10 col-xs-offset-1\">\r\n" + 
				"\r\n" + 
				"      <div class=\"response\">\r\n" + 
				"        <div class=\"response-left-long\">\r\n" + 
				"          Tarjeta en su poder\r\n" + 
				"        </div>\r\n" + 
				"		<div class=\"response-right-short\">\r\n" + 
				"          No\r\n" + 
				"        </div>\r\n" + 
				"        <div class=\"separator\"></div>\r\n" + 
				"      </div>\r\n" + 
				"	  \r\n" + 
				"	  <div class=\"response\">\r\n" + 
				"        <div class=\"response-left\">\r\n" + 
				"          Ubicaci&oacute;n actual\r\n" + 
				"        </div>\r\n" + 
				"        <div class=\"response-right\">Fuera de la Republica</div>\r\n" + 
				"        <div class=\"separator\"></div>\r\n" + 
				"      </div>\r\n" + 
				"    </div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<table border=\"1\" width=\"100%\">\r\n" + 
				"<tr><td>Foo</td><td>Var</td></tr>\r\n" + 
				"<tr><td>Foo</td><td>Var</td></tr>\r\n" + 
				"<tr><td>Foo</td><td>Var</td></tr>\r\n" + 
				"</table>\r\n" + 
				"</body>\r\n" + 
				"</html>\r\n" + 
				"  ";
		
		
		
//		BufferedImage image = GraphicsEnvironment
//								.getLocalGraphicsEnvironment()
//								.getDefaultScreenDevice()
//								.getDefaultConfiguration()
//								.createCompatibleImage(width, height);
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_INDEXED);
		
		Graphics graphics = image.createGraphics();
		JEditorPane jep = new JEditorPane("text/html", html);
		jep.setSize(width, height);
		jep.print(graphics);

		ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
		ImageIO.write(image, "png", byteArrayOS);
		InputStream is = new ByteArrayInputStream(byteArrayOS.toByteArray());
		
		return is;
	}
	
	
}
