package com.aibibang;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;

import com.aibibang.common.Constant;

/** 
* @author: Truman.P.Du 
* @since: 2016年12月22日 下午9:27:52 
* @version: v1.0
* @description:
*/
public class AnalyseJob extends Configured implements Tool {

	@Override
	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Configuration conf = getConf();

		Job job = Job.getInstance(conf, "AnalyseJob");
		job.setJarByClass(AnalyseJob.class);
		Scan scan = new Scan();
		scan.setCaching(500);        // 1 is the default in Scan, which will be bad for MapReduce jobs
		scan.setCacheBlocks(false);  // don't set to true for MR jobs
		TableMapReduceUtil.initTableMapperJob(Constant.BASICDATATABLE, scan,AnalyseMapper.class, ImmutableBytesWritable.class, Put.class, job);

		TableMapReduceUtil.initTableReducerJob(Constant.BASICDATATABLE, AnalyseReducer.class, job);

		job.waitForCompletion(true);
		if (job.isSuccessful()) {
			return 0;
		} else {
			return 1;
		}
	}

}
