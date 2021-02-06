package com.example.flightsercher.Repository;

import com.example.flightsercher.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository< Role, Integer> {

    public Role findByRole(String role);
}
