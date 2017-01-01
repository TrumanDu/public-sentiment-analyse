package com.aibibang;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.util.ToolRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class StartApp {
	private static Logger logger = LoggerFactory.getLogger(StartApp.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf = HBaseConfiguration.create();
		System.setProperty("hadoop.home.dir", "D:/hadoop");
		//System.setProperty("HADOOP_USER_NAME", "");
		logger.info("---------------------------------------------");
		conf.set("mapreduce.framework.name", "yarn");
		conf.set("mapreduce.app-submission.cross-platform", "true");
		conf.set("yarn.resourcemanager.address", "192.168.0.105:8032");
		conf.set("yarn.resourcemanager.scheduler.address", "192.168.0.105:8030");
		conf.set("fs.defaultFS", "hdfs://192.168.0.105:8020");
		conf.set("mapred.jar",
				"D://workspace//public-sentiment-analyse//target//public-sentiment-analyse-0.0.1-SNAPSHOT-jar-with-dependencies.jar");
		conf.set("hbase.zookeeper.quorum", "lab1,lab2,lab3");
		conf.set("hbase.zookeeper.property.clientPort", "2181");
		conf.set("hbase.cluster.distributed", "true");
		try {
			int response = ToolRunner.run(conf, new AnalyseJob(), args);
			if (response == 0) {
				logger.info("Job  successed.....");
			} else {
				logger.info("Job  failed.....");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
