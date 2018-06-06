[TOC]

# PostgreSQL/MongoDB性能对比测试方案

# 一、测试内容

本次测试内容主要测试MongoDB/PostgreSQL,在性能方面对比，包括插入性能与查询性能
# 二、测试目标

1. 测试PostgreSQL在使用文档类型这方面的性能
# 三、测试方法

本次采用apache的开源测试工具jmeter，采用数据结构DataTable通过http协议post方式发送数据到server服务，server服务通过jdbc接口存储到数据库中。
## 3.1 数据准备

  24列的数据字段，设有数据权限的dataTable数据
  
```
```


## 3.2 场景


|数据量|	MongoDB|	PostgreSQL(json)|	PostgreSQL(jsonb)|	PostgreSQL(json/jsonb)|
|---|---|---|----|-----|
|5w插入平均响应时间||||
|10w插入平均响应时间||||			
|20w插入平均响应时间|||	|			
|5w查询平均响应时间|||	|			
|10w查询平均响应时间|||	|			
|20w查询平均响应时间|||	|

## 3.3 PostgreSQL 建表语句

### 3.3.1 json
```
CREATE TABLE datatable (
    displayType            varchar(100),
    sourceType         varchar(500),           
    dataSize         bigint,           
    dataConfig            json,        
    chartIds              json,
    suggestChartIds            json,
    status   varchar(20),
    dbTableName  varchar(200),
    columns  json,
    revisions  json,
    enableAuth  boolean,
    asyncDataTable json,
    description varchar(500),
    appMetaDataProperties json,
    userId varchar(20),
    ownerId varchar(20),
    name varchar(200),
    version int,
    deleted int,
    id varchar(40),
    accesses json,
    groupAccesses json,
    accessList json,
    groupAccessList json,
    tags json,
    copyFrom varchar(100),
    receiveFrom varchar(100),
    creatorId varchar(100),
    categoryId varchar(100)
);
```
### 3.3.2 jsonb
```
CREATE TABLE datatable (
    displayType            varchar(100),
    sourceType         varchar(200),           
    dataSize         bigint,           
    dataConfig            jsonb,        
    chartIds              jsonb,
    suggestChartIds            jsonb,
    status   varchar(20),
    dbTableName  varchar(200),
    columns  jsonb,
    revisions  jsonb,
    enableAuth  boolean,
    asyncDataTable jsonb,
    description varchar(500),
    appMetaDataProperties jsonb,
    userId varchar(20),
    ownerId varchar(20),
    name varchar(200),
    version int,
    deleted int,
    id varchar(40),
    accesses jsonb,
    groupAccesses jsonb,
    accessList jsonb,
    groupAccessList jsonb,
    tags jsonb,
    copyFrom varchar(100),
    receiveFrom varchar(100),
    creatorId varchar(100),
    categoryId varchar(100)
);
```
### 3.3.3 json/jsonb
```
CREATE TABLE datatable (
    displayType            varchar(100),
    sourceType         varchar(200),           
    dataSize         bigint,           
    dataConfig            json,        
    chartIds              json,
    suggestChartIds            json,
    status   varchar(20),
    dbTableName  varchar(200),
    columns  json,
    revisions  json,
    enableAuth  boolean,
    asyncDataTable json,
    description varchar(300),
    appMetaDataProperties json,
    userId varchar(20),
    ownerId varchar(20),
    name varchar(200),
    version int,
    deleted int,
    id varchar(40),
    accesses json,
    groupAccesses json,
    accessList jsonb,
    groupAccessList jsonb,
    tags json,
    copyFrom varchar(100),
    receiveFrom varchar(100),
    creatorId varchar(100),
    categoryId varchar(100)
);
```

# 四、测试环境

减小因为配置而影响测试结果，数据库都使用docker环境同样的环境部署

## server tomcat 服务

* cpu 4核 16G

## PostgreSQL-9.6.6

* cpu 4核 8G

* docker-compose.yml
```aidl
# version : '3.3'
# services:
db:
  image: /development/postgres:9.6.6
    # restart: always
    #    always
  environment:
    - POSTGRES_PASSWORD:postgres
    - POSTGRES_USER:postgres
  volumes:
    - /usr/data/pgdata:/var/lib/postgresql/data
  ports:
    - 5432:5432
```

## MongoDB-3.2
* cpu 4核 8G
* docker-compose.yml
```aidl
mongo:
  restart: always
  image: mongo:3.2
  ports:
    - 27017:27017
  volumes:
    - /opt/data/mongo:/data/db
```

# 五、系统部署

# 六、测试结果分析
## JMeter 聚合报告
|label|# Samples	|Average|	Median|	90% Line|	95% Line|	99% Line|	Min|	Max|
|---|----       |----   |-----    |   -----|------			|------|-----|-----		|
|mongo| 100000|		9|	8|		12|		15|	23	|5|	5126|
|json-jsonb|100000|		7|	7|		10|		12|	16	|4|	567|
|json|100000|		8|	8|		11|		12|	17	|4|	142|
|jsonb|100000|		8|	8|		12|		14|	18	|4|	136|
|json|200000|		7|	7|		10|		12|	19	|4|	3712|
|mongo|200000|		8|	8|		10|		11|	16	|4|	4731|
|jsonb|200000|		9|	8|		12|		14|	23	|4|	3879|
|json-jsonb|200000|		8|	7|		11|		12|	20	|4|	3898|
|json|50000|		8|	7|		10|		13|	24	|4|	3390|
|mongo|50000|		8|	8|		10|		11|	15	|4|	1537|
|jsonb|50000|		10|	8|		13|		16|	40	|4|	3391|
|json-jsonb|50000|		8|	7|		11|		13|	24	|4|	3332|
|jsonget|100000|		6|	7|		8|		9|	11	|3|	94|
|mongoget|100000|		9|	7|		9|		10|	14	|4|	5884|
|jsonget|50000|		6|	7|		8|		9|	11	|3|	69|
|mongoget|50000|		7|	7|		10|		10|	12	|4|	69|
|josnget|200000|		6|	6|		8|		9|	10	|3|	140|
|mongodbget|200000|		12|	8|		15|		25|	59	|4|	7150|
## jprofile 监控
# json 
![json](/images/json.png)
# jsonb 
![jsonb](/images/jsonb.png)
# json-jsonb 
![json-jsonb](/images/json-jsonb.png)
# mongo 
![mongo](/images/mongo.png)
## JMeter 响应报告
# 查询
![query](/images/query.png)
# 插入
![insert](/images/insert.png)

# 七、测试结果总结
1. 在插入方面PostgreSQL json 与 MongoDB性能相近
2. 在插入方面PostgreSQL jsonb 比MongoDB 慢20%左右
3. 查询方面，小于10W数据量，PostgreSQL比MongoDBk快15%,,20W数据的数据查询数据比PostgreSQL比MongoDB快3~4倍
4. PostgreSQL 在稳定性方面要比MongoDB高，MongoDB偶尔会出现抖动