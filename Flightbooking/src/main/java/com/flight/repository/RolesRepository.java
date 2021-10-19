package com.flight.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.entities.*;

public interface RolesRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByRoleName(Roles role);
}
