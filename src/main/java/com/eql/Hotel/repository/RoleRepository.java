package com.eql.Hotel.repository;

import com.eql.Hotel.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {
    Role findByName(String name);
}
