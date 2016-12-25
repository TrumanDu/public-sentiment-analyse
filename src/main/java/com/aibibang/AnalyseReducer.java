package com.aibibang;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableReducer;

/** 
* @author: Truman.P.Du 
* @since: 2016年12月23日 下午2:02:10 
* @version: v1.0
* @description:
*/
public class AnalyseReducer extends TableReducer<ImmutableBytesWritable, Put, ImmutableBytesWritable> {
	@Override
	protected void reduce(ImmutableBytesWritable arg0, Iterable<Put> value,
			Context context) throws IOException,
			InterruptedException {
		// TODO Auto-generated method stub
		for (Iterator iter = value.iterator(); iter.hasNext();) {
			Put put = (Put) iter.next();
			context.write(null, (Mutation) put);
		}		  
		
	}

}
