package com.jk.jkprintify.repo;

import com.jk.jkprintify.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    // You can add custom query methods here if needed
}