# postgres-json

[TOC]

# PostgreSQL/MongoDB性能对比测试方案

# 一、测试内容

本次测试内容主要测试MongoDB/PostgreSQL,在性能方面对比，包括插入性能与查询性能
# 二、测试目标

1. 测试PostgreSQL在使用文档类型这方面的性能，是否满足数据观业务需求。
2. 为数据观后台架构升级提供理论依据
# 三、测试方法

本次采用apache的开源测试工具jmeter，采用数据观业务数据DataTable通过http协议post方式发送数据到server服务，server服务通过jdbc接口存储到数据库中。
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

## server服务

cpu 4核 16G

## PostgreSQL

cpu 4核 8G

## Mongodb
cpu 4核 8G
# 五、系统部署

# 六、测试结果分析
