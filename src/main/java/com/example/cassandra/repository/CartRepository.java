package com.example.cassandra.repository;

import com.example.cassandra.model.Cart;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends CassandraRepository<Cart,Integer> {
}
