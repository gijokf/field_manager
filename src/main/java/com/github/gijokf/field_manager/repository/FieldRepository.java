package com.github.gijokf.field_manager.repository;

import com.github.gijokf.field_manager.model.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FieldRepository extends JpaRepository<Field, Long> {
    @Query(value = "SELECT * FROM cdt_field WHERE cd_id_farm = ?1", nativeQuery = true)
    List<Field> findByFarmCdId(Long cd_id_farm);
}