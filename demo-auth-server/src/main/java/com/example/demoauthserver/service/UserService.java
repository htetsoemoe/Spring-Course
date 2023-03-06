package com.example.demoauthserver.service;

import com.example.demoauthserver.dao.OtpDao;
import com.example.demoauthserver.dao.UserDao;
import com.example.demoauthserver.ds.Otp;
import com.example.demoauthserver.ds.User;
import com.example.demoauthserver.util.GenerateCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDao userDao;
    @Autowired
    private OtpDao otpDao;

    // add user
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    // renewOtp
    //@Transactional
    public void renewOtp(User u) {
        String code = GenerateCodeUtil.generateCode();

        Optional<Otp> userOtp = otpDao.findOtpByUsername(u.getUsername());

        // userOtp is managed state entity
        if (userOtp.isPresent()) {
            Otp otp = userOtp.get();//get user's otp code
            otp.setUsername(otp.getUsername());
            otp.setCode(code);// renew otp code
            otpDao.saveAndFlush(otp);//update method
        } else { // there's no otp code, create otp code and save in DB
            Otp otp = new Otp();
            otp.setUsername(u.getUsername());
            otp.setCode(code);

            // there's no otp code, save in DB
            otpDao.save(otp);
        }
    }

    // auth
    public void auth(User user) {
        Optional<User> o = userDao.findUserByUsername(user.getUsername());

        if (o.isPresent()) {
            User u = o.get();
            if (passwordEncoder.matches(user.getPassword(), u.getPassword())) {
                renewOtp(u);
            } else {
                throw new BadCredentialsException("Bad Credentials");
            }
        }
    }

    // check
    public boolean check(Otp otpToValidate) {
        Optional<Otp> userOtp = otpDao.findOtpByUsername(otpToValidate.getUsername());
        if (userOtp.isPresent()) {
            Otp otp = userOtp.get();
            if (otpToValidate.getCode().equals(otp.getCode())) {
                return true;
            }
        }
        return false;
    }

}
