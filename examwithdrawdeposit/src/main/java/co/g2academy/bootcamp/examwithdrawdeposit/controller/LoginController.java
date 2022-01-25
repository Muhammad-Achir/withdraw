/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.g2academy.bootcamp.examwithdrawdeposit.controller;

import co.g2academy.bootcamp.examwithdrawdeposit.entity.Person;
import co.g2academy.bootcamp.examwithdrawdeposit.entity.PersonDetail;
import co.g2academy.bootcamp.examwithdrawdeposit.repository.PersonDetailRepository;
import co.g2academy.bootcamp.examwithdrawdeposit.security.JwtTokenUtil;
import co.g2academy.bootcamp.examwithdrawdeposit.security.JwtUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import co.g2academy.bootcamp.examwithdrawdeposit.repository.PersonRepository;
import co.g2academy.bootcamp.examwithdrawdeposit.response.LoginPostResponse;
import java.util.List;

/**
 *
 * @author King Engine
 */
@RestController
public class LoginController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailService userDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PersonDetailRepository personDetailRepository;

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/login")
    public ResponseEntity<LoginPostResponse> login(@RequestBody Person login)
            throws Exception {
        authenticate(login.getName(), login.getPassword());
        UserDetails userDetails = userDetailService.loadUserByUsername(login.getName());
        String token = jwtTokenUtil.generateToken(userDetails);

        Integer balance = 0;
        Iterable<Person> person = personRepository.findAll();
        for (Person pr : person) {
            if (pr.getName().equals(login.getName())) {

                Iterable<PersonDetail> personDetail = personDetailRepository.findAll();
                for (PersonDetail p : personDetail) {
                    if (p.getPerson().equals(pr)) {
                        balance = p.getBalance();
                        System.out.println("balance " + balance);
                    }
                }
            }
        }
//        Integer balance = personDetail.getBalance();

        LoginPostResponse loginPostResponse = new LoginPostResponse();
        loginPostResponse.setName(login.getName());
        loginPostResponse.setBalance(balance);
        loginPostResponse.setToken(token);
//        loginPostResponse.setName("asd");
//        loginPostResponse.setBalance(232);
//        loginPostResponse.setToken(token);

        return ResponseEntity.ok(loginPostResponse);
    }

    private void authenticate(String userName, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLE", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIAL", e);
        }

    }
}
