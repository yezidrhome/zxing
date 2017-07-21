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

//ʶ���ά������
public class ReadQRCode {

	public static void main(String[] args) {
		try {
			
			MultiFormatReader formatReader = new MultiFormatReader();

			// �˴���Ҫ��ǰ���ɵĶ�ά��ͼƬ
			File file = new File("D://code/img.png");
			// ʶ���ά��Ϊһ��ͼƬ
			BufferedImage image = ImageIO.read(file);

			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
					new BufferedImageLuminanceSource(image)));

			// �����ά��Ĳ���
			HashMap hints = new HashMap();
			// �����ʽ
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");

			Result result = formatReader.decode(binaryBitmap, hints);
			
			System.out.println("�������Ϊ��"+result.toString());
			System.out.println("��ά��ĸ�ʽ��"+result.getBarcodeFormat());
			System.out.println("��ά����ı����ݣ�"+result.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
