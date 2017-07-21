	package com.yezi.zxing;
	
	import java.io.File;
	import java.nio.file.Path;
	import java.util.HashMap;
	
	import javax.swing.plaf.multi.MultiButtonUI;
	
	import com.google.zxing.BarcodeFormat;
	import com.google.zxing.EncodeHintType;
	import com.google.zxing.MultiFormatWriter;
	import com.google.zxing.WriterException;
	import com.google.zxing.client.j2se.MatrixToImageWriter;
	import com.google.zxing.common.BitMatrix;
	import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
	
	//生成二维码
	public class CreateQRCode {
		
		public static void main(String[] args) {
			//生成二维码图片的宽高定义
			int width =300;
			int height =300;
			//生成图片的格式
			String format="png";
			//二维码的内容
			String content = "www.google.com";
			//定义二维码的参数
			HashMap hints = new HashMap();
			//编码格式
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			//纠错等级(此处M为中等)
			hints.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.M);
			//图片的边距默认是5
			hints.put(EncodeHintType.MARGIN,2);
			//生成二维码
			try {
				/**
				 * content:二维码内容
				 * BarcodeFormat.QR_CODE:二维码格式
				 * width:图片宽度
				 * height:图片高度
				 * hints:二维码的参数
				 */
				BitMatrix bitMatrix = new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE,width,height,hints);
				
				//生成图片到一个路径下,code目录必须是存在的
				Path file = new File("D://code/img.png").toPath();
				MatrixToImageWriter.writeToPath(bitMatrix, format, file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
