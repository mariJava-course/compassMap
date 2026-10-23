package com.example.demo.service;

import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerProfileService {

    @Autowired
    private CustomerProfileRepository customerProfileRepository;
    // we are using here DEPENDENCE INJECTION
    
    public Iterable<CustomerProfile> getAllCustomerProfiles() {
        return customerProfileRepository.findAll();
    }

    public CustomerProfile createCustomerProfile (CustomerProfile customerProfile){
        // SET ID customerProfile to UUID
        customerProfile.setId(UUID.randomUUID().toString());

        // call repository to use SAVE operation to save data to h2 db
        CustomerProfile createdCustomerProfile = customerProfileRepository.save(customerProfile);
        System.out.println("Service created customerProfile: " +  createdCustomerProfile);
        return createdCustomerProfile;
    }

    public void deleteCustomerProfile (String id){
        customerProfileRepository.deleteById(id);

    }

    public CustomerProfile getCustomerProfileById(String id){

        Optional<CustomerProfile> foundCustomerProfile = customerProfileRepository.findById(id);

        return foundCustomerProfile.orElse(null);
    }

    public Iterable<CustomerProfile> saveAll(Iterable<CustomerProfile> customerProfiles) {
        return customerProfileRepository.saveAll(customerProfiles);
    }

    public void deleteAllCustomerProfiles() {
        customerProfileRepository.deleteAll();
    }

    public long countCustomerProfiles() {
        return customerProfileRepository.count();
    }

    public CustomerProfile updateCustomerProfile(CustomerProfile incoming) {
        if (incoming.getId() == null) {
            return null;
        }
        CustomerProfile existing = getCustomerProfileById(incoming.getId());
        if (existing == null) {
            return null;
        }
        // merge only non-null fields from incoming (partial update semantics)
        if (incoming.getCodeProfile() != null) {
            existing.setCodeProfile(incoming.getCodeProfile());
        }
        if (incoming.getName() != null) {
            existing.setName(incoming.getName());
        }
        if (incoming.getDescription() != null) {
            existing.setDescription(incoming.getDescription());
        }
        if (incoming.getGoal() != null) {
            existing.setGoal(incoming.getGoal());
        }

        return customerProfileRepository.save(existing);
    }
}
