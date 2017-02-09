package com.aibibang.common;

import org.fnlp.ml.types.Dictionary;
import org.fnlp.nlp.cn.tag.CWSTagger;


public class ChineseWordSegmentation {
	/**
	 * 主程序
	 * @param args 
	 * @throws IOException 
	 * @throws  
	 */
	public static  String Segmentation(String str3) throws Exception {
		//使用不严格的词典
		
		CWSTagger tag3 = new CWSTagger("/data/bigdata/models/seg.m", new Dictionary("/data/bigdata/models/dict.txt",true));
		
		//尽量满足词典，比如词典中有“成立”“成立了”和“了”, 会使用Viterbi决定更合理的输出
		System.out.println("\n使用不严格的词典的分词：");
		
		String s3 = tag3.tag(str3);
		System.out.println(s3);
		return s3;
		

	}
	public static void main(String[] args) {
		
		try {
			ChineseWordSegmentation.Segmentation("数据挖掘是什么？");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
