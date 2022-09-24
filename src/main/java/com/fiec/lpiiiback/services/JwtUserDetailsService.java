package com.fiec.lpiiiback.services;

import com.fiec.lpiiiback.models.entities.User;

public interface JwtUserDetailsService {
    User loadByEmail(String email);
}
