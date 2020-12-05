package com.maik.APITemplate.services;

import com.maik.APITemplate.exceptions.ResourceNotFoundException;
import com.maik.APITemplate.models.User;
import com.maik.APITemplate.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired private UserRepository userRepository;


    public Page<User> getAllUsers(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public User getUserById(Long id) throws ResourceNotFoundException {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) throws ResourceNotFoundException {
        User usertoRemove = this.getUserById(id);
        userRepository.delete(usertoRemove);


    }
}
