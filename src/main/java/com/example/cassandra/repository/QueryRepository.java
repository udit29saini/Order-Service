package com.example.cassandra.repository;

import com.example.cassandra.model.Order;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface QueryRepository {
    List<Order> findByBA(String queryParam);

    List<Order> findByA(String queryParam);

    List<Order> findByName(String queryParam);

    List<Order> findByPA(boolean queryParam);

    List<Order> findByDate(LocalDate date);
}
