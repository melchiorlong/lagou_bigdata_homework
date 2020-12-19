#!/bin/sh

echo 'import data from hdfs。。。'

currDate=`date +%Y%m%d`

/opt/lagou/servers/hive-2.3.7/bin/hive -e "USE homework;LOAD DATA INPATH '/home/azkaban_data/user_clicks/$currDate/*' OVERWRITE INTO TABLE user_clicks PARTITION (dt='$currDate')"
