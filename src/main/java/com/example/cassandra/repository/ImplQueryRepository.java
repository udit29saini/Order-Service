package com.example.cassandra.repository;

import com.example.cassandra.CassandraApplication;
import com.example.cassandra.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ImplQueryRepository implements QueryRepository {

    @Autowired
    private CassandraOperations cassandraTemplate;

    @Override
    public List<Order> findByBA(String queryParam) {
        return cassandraTemplate.select(Query.query(Criteria.where("billingaddress").is(queryParam)).withAllowFiltering(), Order.class);
    }

    @Override
    public List<Order> findByA(String queryParam) {
        return cassandraTemplate.select(Query.query(Criteria.where("shippingaddress").is(queryParam)).withAllowFiltering(), Order.class);
    }

    @Override
    public List<Order> findByName(String queryParam) {
        return cassandraTemplate.select(Query.query(Criteria.where("nameofcustomer").is(queryParam)).withAllowFiltering(), Order.class);
    }

    @Override
    public List<Order> findByPA(boolean queryParam) {
        return cassandraTemplate.select(Query.query(Criteria.where("paymentstatus").is(queryParam)).withAllowFiltering(), Order.class);
    }
}
