package com.lagou.SortCount;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author Administrator
 */
public class SortCountMapper extends Mapper<LongWritable, Text, NumBean, NullWritable> {
    /**
     * 声明全局变量
     */
    NumBean numBean = new NumBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 获取一行文本内容
        String str = value.toString();
        // 写入numBean中
        numBean.setSerial(1L);
        numBean.setNum(Long.parseLong(str));
        // Mapper输出
        context.write(numBean, NullWritable.get());
    }
}
