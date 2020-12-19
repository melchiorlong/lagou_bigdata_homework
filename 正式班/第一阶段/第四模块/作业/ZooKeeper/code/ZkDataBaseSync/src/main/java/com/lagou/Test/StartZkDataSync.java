package com.lagou.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author Tianlong
 */
public class StartZkDataSync {

    private ZkClient zkClient;
    private DataSource dataSource;

    public static void main(String[] args) {
        try {
            StartZkDataSync startZkDataSync = new StartZkDataSync();
            // 初始化ZK
            startZkDataSync.initZK();
            // 获取ZK中databaseConfig并创建DataSource
            startZkDataSync.DBConfig();
            // 测试修改
            startZkDataSync.testChange();
            // 将任务持久化
            Thread.sleep(Integer.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化ZK
     */
    private void initZK() {
        // 获取ZK
        zkClient = new ZkClient("192.168.80.121:2181");
        // 自定义序列化类
        zkClient.setZkSerializer(new ZkDatabaseSerializer());
        // 若没有文件则创建
        boolean exists = zkClient.exists("/databaseConfig");
        if (!exists){
            zkClient.createPersistent("/databaseConfig","{\"driverClassName\":\"com.mysql.jdbc.Driver\",\"url\":\"jdbc:mysql://192.168.80.123:3306/azkaban?useSSL=false&amp;useUnicode=true&amp;characterEncoding=utf8\",\"username\":\"root\",\"password\":\"12345678\"}");
        }
        // 声明一个DataChange监听
        zkClient.subscribeDataChanges("/databaseConfig", new IZkDataListener() {
            // 修改事件监听
            @Override
            public void handleDataChange(String path, Object data) throws Exception {
                System.out.println(path + " has changed....");
                System.out.println("New data = " + data);
                DBConfig();
            }
            // 删除事件监听
            @Override
            public void handleDataDeleted(String path) throws Exception {
                System.out.println(path + " has deleted!!!");
            }
        });
    }

    /**
     * 获取ZK中databaseConfig并创建DataSource
     */
    private void DBConfig() throws Exception {
        Map configMap = getConfigMap();
        updateDataSource(configMap);
        testSQL();
    }

    /**
    * 更新DataSource
     */
    private void updateDataSource(Map configMap) throws Exception {
        dataSource = DruidDataSourceFactory.createDataSource(configMap);
    }

    /**
     *  获取databaseConfig中的data,返回Map格式
     */
    private Map getConfigMap() throws Exception {
        // 获取databaseConfig中的data
        Object data = zkClient.readData("/databaseConfig");
        // 转为JSON
        JSONObject propertiesJSON = JSON.parseObject(data.toString());
        // 返回Map
        return propertiesJSON.toJavaObject(Map.class);
    }

    /**
    * 测试修改
     */
    private void testChange() throws InterruptedException, SQLException {
        // 更新节点的数据 删除节点 验证监听器是否正常运行
        Object readData = zkClient.readData("/databaseConfig");
        System.out.println("readData = " + readData);
        zkClient.writeData("/databaseConfig", "{\"driverClassName\": \"com.mysql.jdbc.Driver\",\"url\":\"jdbc:mysql://192.168.80.123:3306/hivemetadata?useSSL=false&amp;useUnicode=true&amp;characterEncoding=utf8\",\"username\":\"root\",\"password\":\"12345678\"}");
        Thread.sleep(1000);
        zkClient.delete("/databaseConfig");
    }

    /**
     * 测试执行的SQL
     */
    private void testSQL() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("show tables ");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String databasesStr = resultSet.getString(1);
            System.out.println(databasesStr);
        }
    }

}
