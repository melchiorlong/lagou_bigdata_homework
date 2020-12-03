package com.lagou.SortCount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @author Administrator
 */
public class SortCountDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        // 因本地环境问题导致需要在Driver中手工指定Hadoop环境变量
        System.setProperty("hadoop.home.dir", "I:/hadoop-2.9.2");
        // 新建Configuration对象
        // 并根据该Configuration创建Job
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration, "SortCountDriver");

        // 设置jar中本地路径
        job.setJarByClass(SortCountDriver.class);
        // 指定Mapper类
        job.setMapperClass(SortCountMapper.class);
        // 指定Reducer类
        job.setReducerClass(SortCountReducer.class);
        // 指定Mapper输出key类
        job.setMapOutputKeyClass(NumBean.class);
        // 指定Mapper输出value类
        job.setMapOutputValueClass(NullWritable.class);
        // 指定最后输出key类
        job.setOutputKeyClass(NumBean.class);
        // 指定最后输出value类
        job.setOutputValueClass(NullWritable.class);
        // 指定文件读取路径
        FileInputFormat.setInputPaths(job, new Path("I:\\拉钩Hadoop\\正式班\\大数据正式班第一阶段模块一\\模块一\\作业\\数据源"));
        // 指定结果输出路径
        FileOutputFormat.setOutputPath(job, new Path("I:/拉钩Hadoop/正式班/大数据正式班第一阶段模块一/模块一/作业/数据源/result/"));
        // 提交任务
        boolean result = job.waitForCompletion(true);
        // 判断是否正常执行
        System.exit(result ? 0 : 1);
    }

}
