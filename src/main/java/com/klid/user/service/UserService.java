package com.klid.user.service;

import com.klid.user.entity.User;
import com.klid.user.model.Department;
import com.klid.user.model.UserDepartment;
import com.klid.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Ivan Kaptue
 */
@Slf4j
@Service
public class UserService {

    private static final String DEPARTMENT_SERVICE_URL = "http://DEPARTMENT-SERVICE/departments/%s";

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public User save(User user) {
        log.info("UserService save user {}", user);
        return userRepository.save(user);
    }

    public UserDepartment getUserWithDepartment(Long userId) {
        log.info("UserService getUserWithDepartment {}", userId);
        var user = userRepository.findById(userId).orElseThrow();
        var department = restTemplate.getForObject(String.format(DEPARTMENT_SERVICE_URL, user.getDepartmentId()), Department.class);
        return new UserDepartment(user, department);
    }
}
