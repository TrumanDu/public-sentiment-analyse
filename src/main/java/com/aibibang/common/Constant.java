package com.aibibang.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author: Truman.P.Du
 * @since: 2016年12月23日 下午1:42:20
 * @version: v1.0
 * @description:
 */
public class Constant {
	public static String BASICDATATABLE = "basicdata";
	public static String RESULTTABLE = "basicdata";
	//public static String RESULTTABLE = "resulttable";
	public static String BASICDATAFAMILY = "info";
	public static Properties prop = new Properties();
	public static String ruleKey;
	public static int ruleNum;
	public static List<String> rlist;
	
	static {
		InputStreamReader in = null;
		
		try {
			in = new InputStreamReader(Constant.class.getClassLoader().getResourceAsStream("application.properties"), "UTF-8");
			prop.load(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ruleKey = Constant.prop.getProperty("rule.key");
    	ruleNum = Integer.parseInt(Constant.prop.getProperty("rule.num"));
    	
    	
	}
	
	public static boolean isAlert(String keys){
		boolean result = false;
		String []keyArray = keys.split(" ");
		String []ruleArray = ruleKey.split(",");
       
		int sum =0;
		for(String key :keyArray){
			//System.out.println(key);
			for(String rule :ruleArray){
				//System.out.println(rule);
				if(rule.equals(key)){
					sum = sum+1;
				}
				if(sum>=ruleNum){
					result = true;
					break;
				}
			}
		}
		return result;
	}

}
