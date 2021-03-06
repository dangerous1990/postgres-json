package com.shujuguan.mongo.dao;

import com.shujuguan.entity.data.DataTable;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by limeng on 18-1-17.
 */
@Service
public class DataTableDaoImpl extends BasicDAO<DataTable, String> implements DataTableDao {
    @Autowired
    protected DataTableDaoImpl(Datastore ds) {
        super(ds);
    }

    @Override
    public void insert(DataTable dataTable) {
        super.save(dataTable);
    }

    @Override
    public DataTable getByID(String id) {
        return this.get(id);
    }

}
