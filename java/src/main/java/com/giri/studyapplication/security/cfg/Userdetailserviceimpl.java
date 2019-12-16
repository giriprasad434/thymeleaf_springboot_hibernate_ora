package com.giri.studyapplication.security.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.giri.studyapplication.repositoryCfg.materialDAO.User;
import com.giri.studyapplication.repositoryCfg.materialDAO.UserRepository;
@Service
public class Userdetailserviceimpl implements UserDetailsService {

   @Autowired
   UserRepository userrepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	//  userrepository.save(new User(1, "giri", new BCryptPasswordEncoder().encode("giri"), "ROLE_GIRI,ROLE_HARI", 'Y', 'Y', 'Y', 'Y'));
	//	System.out.println(new BCryptPasswordEncoder().encode("giri"));
		
		return new UserDetailimpl(userrepository.findByUname(username));
		 
	}

}
