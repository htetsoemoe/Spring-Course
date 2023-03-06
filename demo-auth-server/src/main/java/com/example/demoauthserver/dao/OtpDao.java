package com.example.demoauthserver.dao;

import com.example.demoauthserver.ds.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpDao extends JpaRepository<Otp, String> {

    Optional<Otp> findOtpByUsername(String username);
}
