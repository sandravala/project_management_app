package com.pm.finalproject.users;


import com.pm.finalproject.users.model.Role;
import com.pm.finalproject.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

//    @Query("SELECT r FROM Role r JOIN FETCH r.users WHERE r.name = :name")
@Query("SELECT r FROM Role r WHERE r.name = :name")
    Optional<Role> findByName(@Param("name")String name);
}
