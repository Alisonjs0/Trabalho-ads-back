package com.example.Repository;

import com.example.Entity.ExtinguisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtinguisherRepository extends JpaRepository<ExtinguisherEntity, Long> {
}
