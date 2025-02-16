package com.teamz.customer.repository;


import com.teamz.customer.entity.ForgotPassword;
import com.teamz.customer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ForgotPasswordRepository extends JpaRepository<ForgotPassword, Integer> {

    @Query("select fp from ForgotPassword fp where fp.otp = ?1 and fp.user = ?2")
    Optional<ForgotPassword> findByOtpAndUser(Integer otp, User user);

    @Query("select fp from ForgotPassword fp where fp.user = ?1")
    Optional<ForgotPassword> FindByUser(User user);

    void flush();
}

