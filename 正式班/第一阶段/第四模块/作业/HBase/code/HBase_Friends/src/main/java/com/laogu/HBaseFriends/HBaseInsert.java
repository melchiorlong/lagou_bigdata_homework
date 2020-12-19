package com.laogu.HBaseFriends;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tianlong
 */
public class HBaseInsert {

    Configuration conf = null;
    Connection connection = null;

    public static void main(String[] args) {
        try {
            HBaseInsert hBaseInsert = new HBaseInsert();
            hBaseInsert.init();
//            hBaseInsert.createTable();
            hBaseInsert.putData();
            hBaseInsert.release();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 初始化
     */
    private void init() throws IOException {
        // 初始化配置文件 获取配置文件对象
        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "192.168.80.121,192.168.80.122,192.168.80.123");
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        // 通过conf获取到HBase集群的连接
        connection = ConnectionFactory.createConnection(conf);
    }

    /**
     * 创建表
     */
    private void createTable() throws IOException {
        // 获取admin对象
        HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();
        // 创建HTableDescriptor，并命名表名
        HTableDescriptor relationship = new HTableDescriptor(TableName.valueOf("relationship"));
        // 添加列族
        relationship.addFamily(new HColumnDescriptor("friends"));
        // 创建表
        admin.createTable(relationship);
    }

    /**
     * 插入数据
     */
    private void putData() throws IOException {
        // 获取表
        Table relationship = connection.getTable(TableName.valueOf("relationship"));
        List<Put> putList = new ArrayList<>();
        // 创建两个 Put 对象，声明列族，值
        Put put1 = new Put(Bytes.toBytes("uid1"));
        put1.addColumn(Bytes.toBytes("friends"),Bytes.toBytes("uid2"), Bytes.toBytes("uid2"));
        put1.addColumn(Bytes.toBytes("friends"),Bytes.toBytes("uid5"), Bytes.toBytes("uid7"));
        put1.addColumn(Bytes.toBytes("friends"),Bytes.toBytes("uid5"), Bytes.toBytes("uid7"));
        Put put2 = new Put(Bytes.toBytes("uid2"));
        put2.addColumn(Bytes.toBytes("friends"),Bytes.toBytes("uid1"), Bytes.toBytes("uid1"));
        put2.addColumn(Bytes.toBytes("friends"),Bytes.toBytes("uid3"), Bytes.toBytes("uid3"));
        put2.addColumn(Bytes.toBytes("friends"),Bytes.toBytes("uid6"), Bytes.toBytes("uid6"));
        put2.addColumn(Bytes.toBytes("friends"),Bytes.toBytes("uid10"), Bytes.toBytes("uid10"));
        // 将Put对象插入到List中
        putList.add(put1);
        putList.add(put2);
        // 向表中插入Put对象
        relationship.put(putList);
    }

    /**
     * 释放资源
     */
    private void release() throws IOException {
        connection.close();
    }

}
