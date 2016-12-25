package com.aibibang;

import java.io.IOException;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.mapreduce.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aibibang.common.Constant;

/** 
* @author: Truman.P.Du 
* @since: 2016年12月22日 下午9:24:01 
* @version: v1.0
* @description:
*/
public class AnalyseMapper extends TableMapper<ImmutableBytesWritable,Put> {
	private static final Logger logger = LoggerFactory.getLogger(AnalyseMapper.class);

	@Override
	protected void setup(Mapper<ImmutableBytesWritable, Result, ImmutableBytesWritable, Put>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		super.setup(context);
	}
	
	@Override
	protected void map(ImmutableBytesWritable key, Result value,
			Mapper<ImmutableBytesWritable, Result, ImmutableBytesWritable, Put>.Context context) throws IOException,
			InterruptedException {
		logger.error("获得到rowkey:" + new String(value.getRow()));
		System.out.println("获得到rowkey:" + new String(value.getRow())); 
        for (Cell cell : value.rawCells()) { 
            System.out.println("列：" + new String(CellUtil.cloneQualifier(cell)) + "====值:" + new String(CellUtil.cloneValue(cell))); 
        } 
        Put put = new Put(value.getRow());
        put.addColumn(Bytes.toBytes(Constant.BASICDATAFAMILY), Bytes.toBytes("topicTitle"), Bytes.toBytes("aaaaa"));
		context.write(key, put);
	}
	
}
