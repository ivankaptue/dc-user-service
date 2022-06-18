package com.klid.user.model;

import com.klid.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ivan Kaptue
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDepartment {
    private User user;
    private Department department;
}
