package com.klid.user.repository;

import com.klid.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ivan Kaptue
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
