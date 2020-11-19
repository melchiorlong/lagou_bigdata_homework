create database springmvc_db;

create table dept
(
    deptId       integer auto_increment primary key,
    deptName     nvarchar(30),
    supervisorId integer,
    phone        nvarchar(20),
    mail         nvarchar(40)
);

create table position
(
    positionId   integer auto_increment primary key,
    positionName nvarchar(30),
    deptId       integer,
    isSupervisor boolean,
    foreign key (deptId) references dept (deptId)
);

create table person
(
    personId   integer auto_increment primary key,
    personName nvarchar(30),
    positionId integer,
    phone      nvarchar(20),
    foreign key (positionId) references position (positionId)
);


create table customer
(
    customerId        integer auto_increment primary key,
    customerName      nvarchar(30),
    accountBankNumber nvarchar(20),
    phone             nvarchar(20),
    address           nvarchar(100),
    managerId         integer,
    foreign key (managerId) references person (personId)
);

# 客户经理 客户交往记录时需要记录事件发生的  日期、地点、概要和详细信息，还可以填写一个备注信息 【关系模型设计】
create table records
(
    recordsId    integer auto_increment primary key,
    customerId   integer,
    happenedDate datetime,
    location     nvarchar(255),
    description  nvarchar(255),
    details      nvarchar(255),
    managerId    integer,
    foreign key (customerId) references customer (customerId),
    foreign key (managerId) references person (personId)
);
