/**
 * 
 */
package com.devglan.service;

import java.util.List;

import com.devglan.model.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Integer add( UserDetails userDetails );
	List<UserDetails> getUserDetails();

}
