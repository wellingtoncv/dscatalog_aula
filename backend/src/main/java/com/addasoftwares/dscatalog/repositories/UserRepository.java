package com.addasoftwares.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.addasoftwares.dscatalog.entities.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

}
