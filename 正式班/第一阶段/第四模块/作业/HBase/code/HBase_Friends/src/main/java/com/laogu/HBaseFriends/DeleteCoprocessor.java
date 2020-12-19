package com.laogu.HBaseFriends;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.coprocessor.BaseRegionObserver;
import org.apache.hadoop.hbase.coprocessor.ObserverContext;
import org.apache.hadoop.hbase.coprocessor.RegionCoprocessorEnvironment;
import org.apache.hadoop.hbase.regionserver.wal.WALEdit;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.CollectionUtils;

import java.io.IOException;
import java.util.List;

/**
 * @author Tianlong
 */
public class DeleteCoprocessor extends BaseRegionObserver {

    @Override
    public void postDelete(ObserverContext<RegionCoprocessorEnvironment> e, Delete delete, WALEdit edit, Durability durability) throws IOException {
        // 获取表
        Table relationship = e.getEnvironment().getTable(TableName.valueOf("relationship"));
        // 通过delete获取uid1中的好友uid2的值
        List<Cell> friends = delete.getFamilyCellMap().get(Bytes.toBytes("friends"));
        if (CollectionUtils.isEmpty(friends)) {
            relationship.close();
            return;
        }
        Cell cell = friends.get(0);
        // uid2的列族中删除uid1
        // 经查源码 该方法过期 使用CellUtil中方法
        // Delete delete1 = new Delete(cell.getRow());
        Delete delete1 = new Delete(CellUtil.cloneQualifier(cell));
        delete1.addColumn(Bytes.toBytes("friends"), CellUtil.cloneRow(cell));
        relationship.delete(delete1);
        // 关闭资源
        relationship.close();
    }
}
