# 插入部门表数据
insert into dept values (null, '市场部', 1, '400-400-4008','lagou@163.com');
insert into dept values (null, '销售部', 2, '400-400-4002','laggou@163.com');

# 插入职位表数据
# 产品经理、销售经理、 客户经理
insert into position values (null, '产品经理', 1, 1);
insert into position values (null, '销售经理', 2, 1);
insert into position values (null, '客户经理', 2, 0);

# 插入员工表数据
insert into person values (null, '张三', 1, '13111111111');
insert into person values (null, '李四', 2, '13222222222');
insert into person values (null, '王五', 3, '13333333333');
insert into person values (null, '张飞', 3, '13444444444');
insert into person values (null, '李逵', 3, '13555555555');
insert into person values (null, '地雷', 3, '13666666666');


# 插入客户表信息
insert into customer values (null, '客户A', '622511111111111','15111111111','东城区', 3);
insert into customer values (null, '客户B', '622522222222222','15222222222','东城区', 3);
insert into customer values (null, '客户C', '622533333333333','15333333333','东城区', 4);
insert into customer values (null, '客户D', '622544444444444','15444444444','东城区', 5);
insert into customer values (null, '客户E', '622555555555555','15555555555','东城区', 6);
insert into customer values (null, '客户F', '622566666666666','15666666666','东城区', 6);


# 插入记录表信息
insert into records values(null, 1, '2020-01-01', '星巴克', '概述A','详情A',3);
insert into records values(null, 2, '2020-02-01', '星巴克1', '概述A1','详情A1',3);
insert into records values(null, 2, '2020-03-01', '星巴克2', '概述A2','详情A2',4);
insert into records values(null, 3, '2020-04-01', '星巴克3', '概述A3','详情A3',5);
insert into records values(null, 4, '2020-05-01', '星巴克4', '概述A4','详情A4',6);
insert into records values(null, 5, '2020-06-01', '星巴克5', '概述A5','详情A5',6);


