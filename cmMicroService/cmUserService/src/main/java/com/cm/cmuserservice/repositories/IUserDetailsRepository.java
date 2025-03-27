package com.cm.cmuserservice.repositories;

import com.cm.cmuserservice.models.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDetailsRepository extends JpaRepository<UserDetails,Long> {
}
