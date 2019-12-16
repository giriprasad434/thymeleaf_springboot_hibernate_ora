package com.giri.studyapplication.repositoryCfg.materialDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends JpaRepository<User, Long>{
 
	public User findByUname(String uname) ;
}
