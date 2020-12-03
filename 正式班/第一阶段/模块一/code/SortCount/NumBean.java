package com.lagou.SortCount;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author Administrator
 * 将输出字段 序号以及数字封装
 */
public class NumBean implements WritableComparable<NumBean> {

    private Long serial;
    private Long num;

    /**
     * 重写compareTo方法
     * @param o
     * @return
     */
    @Override
    public int compareTo(NumBean o) {
        if (this.num > o.getNum()){
            // 正序排列
            return 1;
        } else if (this.num < o.getNum()){
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * 序列化
     * @param out
     * @throws IOException
     */
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeLong(serial);
        out.writeLong(num);
    }

    /**
     * 反序列化
     * @param in
     * @throws IOException
     */
    @Override
    public void readFields(DataInput in) throws IOException {
        this.serial = in.readLong();
        this.num = in.readLong();
    }

    public NumBean() {
    }

    public NumBean(Long num, Long serial) {
        this.serial = serial;
        this.num = num;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Long getSerial() {
        return serial;
    }

    public void setSerial(Long serial) {
        this.serial = serial;
    }

    /**
     * 重写toString()，并且用制表符分隔
     * @return
     */
    @Override
    public String toString() {
        return serial + "\t" + num;
    }
}
