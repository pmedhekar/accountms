package com.learning.accounts.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.learning.accounts.config.AccountsServiceConfig;
import com.learning.accounts.model.Account;
import com.learning.accounts.model.Customer;
import com.learning.accounts.model.Properties;
import com.learning.accounts.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AccountsController {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private AccountsServiceConfig accountsServiceConfig;

    @PostMapping("/myAccount")
    public Account getAccountDetails(@RequestBody Customer customer){
        Account account = accountsRepository.findByCustomerId(customer.getCustomerId());
                if (account != null) {
                    return account;
                }else {
                    return null;
                }
    }

    @GetMapping("/accounts/properties")
    public String getPropertyDetails() throws JsonProcessingException {

        Properties properties = new Properties(accountsServiceConfig.getMsg(),accountsServiceConfig.getBuildVersion(),
                accountsServiceConfig.getMailDetails(),accountsServiceConfig.getActiveBranches());

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();


        String jsonString = objectWriter.writeValueAsString(properties);
        return jsonString;
    }
}
