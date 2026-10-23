package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customerprofiles")
public class CustomerProfileRestController {

    @Autowired
    private CustomerProfileService customerProfileService;


    //----------------------------- GET -----------------------------

    @GetMapping("/all")
    public Iterable<CustomerProfile> getAllProfiles() {
        // call service to get all customersProfile and return them
        Iterable<CustomerProfile> customerProfiles =  customerProfileService.getAllCustomerProfiles();
        System.out.println("Service getAllCustomerProfiles: " + customerProfiles);
        return customerProfiles;
    }

    //----------------------------- DELETE -----------------------------

    @DeleteMapping("/byId")
    public void deleteById(String id) {
        // to do

    }

    // ----------------------------- CREATE -----------------------------

    @PostMapping("/create")
    public CustomerProfile createProfile(CustomerProfile customerProfile) {
        CustomerProfile newProfile = customerProfileService.createCustomerProfile(customerProfile);
        System.out.println("Service createCustomer: " + newProfile);
        return newProfile;
    }

    @PostMapping("/all")
    public void createAllProfiles(Iterable<CustomerProfile> customerProfiles) {
        // to do

    }

    //----------------------------- UPDATE -----------------------------

    @PutMapping("/byId")
    public void updateById(CustomerProfile customerProfile) {
        // to do

    }





}
