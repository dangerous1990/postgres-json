package com.shujuguan.mongo.dao;

import com.shujuguan.entity.data.DataTable;

/**
 * Created by limeng on 18-1-17.
 */
public interface DataTableDao {
    void insert(DataTable dataTable);

    DataTable getByID(String id);
}
