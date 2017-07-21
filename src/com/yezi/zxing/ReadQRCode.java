package com.yezi.zxing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

//识别二维码内容
public class ReadQRCode {

	public static void main(String[] args) {
		try {
			
			MultiFormatReader formatReader = new MultiFormatReader();

			// 此处需要提前生成的二维码图片
			File file = new File("D://code/img.png");
			// 识别二维码为一个图片
			BufferedImage image = ImageIO.read(file);

			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
					new BufferedImageLuminanceSource(image)));

			// 定义二维码的参数
			HashMap hints = new HashMap();
			// 编码格式
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");

			Result result = formatReader.decode(binaryBitmap, hints);
			
			System.out.println("解析结果为："+result.toString());
			System.out.println("二维码的格式："+result.getBarcodeFormat());
			System.out.println("二维码的文本内容："+result.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
