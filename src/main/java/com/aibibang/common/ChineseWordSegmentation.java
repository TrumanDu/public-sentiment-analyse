package com.aibibang.common;

import java.io.IOException;

import org.fnlp.ml.types.Dictionary;
import org.fnlp.nlp.cn.tag.CWSTagger;


public class ChineseWordSegmentation {
	/**
	 * 主程序
	 * @param args 
	 * @throws IOException 
	 * @throws  
	 */
	public static CWSTagger tag3;
	static{
		try {
			tag3 = new CWSTagger("/data/bigdata/models/seg.m", new Dictionary("/data/bigdata/models/dict.txt",true));
			//tag3 = new CWSTagger("E:\\git\\GitHub\\public-sentiment-analyse\\models\\seg.m", new Dictionary("E:\\git\\GitHub\\public-sentiment-analyse\\models\\dict.txt",true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static  String Segmentation(String str3) throws Exception {
		//使用不严格的词典
		
		//CWSTagger tag3 = new CWSTagger("/data/bigdata/models/seg.m", new Dictionary("/data/bigdata/models/dict.txt",true));
		//CWSTagger tag3 = new CWSTagger("E:\\git\\GitHub\\public-sentiment-analyse\\models\\seg.m", new Dictionary("E:\\git\\GitHub\\public-sentiment-analyse\\models\\dict.txt",true));
		//尽量满足词典，比如词典中有“成立”“成立了”和“了”, 会使用Viterbi决定更合理的输出
		String s3 = tag3.tag(str3);
		System.out.println(s3);
		return s3;
		

	}
	public static void main(String[] args) {
		
		try {
			long start = System.currentTimeMillis();
			//String test ="新疆恐怖分子 终于找到新疆恐怖分子基地:中国军队立马动手了";
			String test ="新疆地区出现恐怖分子杀人事件";
			String result = ChineseWordSegmentation.Segmentation(test);
			String test2 ="新疆恐怖分子 终于找到新疆恐怖分子基地:中国军队立马动手了";
			String result2 = ChineseWordSegmentation.Segmentation(test2);
			System.out.println(System.currentTimeMillis()-start);
			System.out.println(Constant.isAlert(result));
			System.out.println(System.currentTimeMillis()-start);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
