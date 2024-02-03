package com.rest.ujjval.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.rest.ujjval.model.Customer;
@Repository
@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer, Serializable> {

}
