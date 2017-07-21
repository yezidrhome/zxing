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
	
	//���ɶ�ά��
	public class CreateQRCode {
		
		public static void main(String[] args) {
			//���ɶ�ά��ͼƬ�Ŀ�߶���
			int width =300;
			int height =300;
			//����ͼƬ�ĸ�ʽ
			String format="png";
			//��ά�������
			String content = "www.google.com";
			//�����ά��Ĳ���
			HashMap hints = new HashMap();
			//�����ʽ
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			//����ȼ�(�˴�MΪ�е�)
			hints.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.M);
			//ͼƬ�ı߾�Ĭ����5
			hints.put(EncodeHintType.MARGIN,2);
			//���ɶ�ά��
			try {
				/**
				 * content:��ά������
				 * BarcodeFormat.QR_CODE:��ά���ʽ
				 * width:ͼƬ���
				 * height:ͼƬ�߶�
				 * hints:��ά��Ĳ���
				 */
				BitMatrix bitMatrix = new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE,width,height,hints);
				
				//����ͼƬ��һ��·����,codeĿ¼�����Ǵ��ڵ�
				Path file = new File("D://code/img.png").toPath();
				MatrixToImageWriter.writeToPath(bitMatrix, format, file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
