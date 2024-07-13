package com.addasoftwares.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.addasoftwares.dscatalog.entities.PasswordRecover;

@Repository
public interface PasswordRecoverRepository  extends JpaRepository<PasswordRecover, Long>{

	
}
