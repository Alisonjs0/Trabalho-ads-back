package com.example.Repository;

import com.example.Entity.UnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<UnitEntity, Long> {
}
