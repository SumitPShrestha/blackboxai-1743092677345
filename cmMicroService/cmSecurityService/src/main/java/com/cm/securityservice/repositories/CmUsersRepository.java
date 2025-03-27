package com.cm.securityservice.repositories;

import com.cm.securityservice.models.CmUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CmUsersRepository extends JpaRepository<CmUser, Long> {
    CmUser findByUsername(String username);
}
