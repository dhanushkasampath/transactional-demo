package com.learn.transactional_demo.repository;

import com.learn.transactional_demo.entity.Address;
import com.learn.transactional_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
