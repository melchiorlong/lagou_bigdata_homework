package com.lagou.SortCount;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author Administrator
 */
public class SortCountReducer extends Reducer<NumBean, NullWritable, NumBean, NullWritable> {
    /**
     * 声明一个记录序号的全局变量
     */
    private Long serial = 0L;

    @Override
    protected void reduce(NumBean key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        // 遍历value 因要将需要增加1
        for (NullWritable value : values) {
            // 序号+1
            serial += 1;
            // 更新numBean中序号值
            key.setSerial(serial);
            // Reducer输出
            context.write(key, value);
        }
    }
}
