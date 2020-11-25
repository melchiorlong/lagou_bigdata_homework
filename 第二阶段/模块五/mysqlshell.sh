#!/bin/sh
mysql -uroot -p123 visualization</tmp/position_info_v2_DataStructure.sql
ls /tmp/data |while read line
do
mysql -uroot -p123 visualization</tmp/data/$line
echo "导入文件$line 完成......."
done
