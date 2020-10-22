package com.userdetails.pact;

import com.userdetails.demo.UserDetailsApplication;
import org.springframework.boot.test.context.SpringBootTest;

@Runwith(SpringRestPactRunner.class)
@@SpringBootTest(classes = UserDetailsApplication.class, properties = {"spring.profiles.active=test", "spring.cloud.config.enabled=false"}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@PactFolder("pacts")
public class PactTest {
}
