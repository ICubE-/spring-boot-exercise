package com.icube.exercise.spring.boot.services;

import com.icube.exercise.spring.boot.entities.Address;
import com.icube.exercise.spring.boot.entities.User;
import com.icube.exercise.spring.boot.repositories.AddressRepository;
import com.icube.exercise.spring.boot.repositories.ProfileRepository;
import com.icube.exercise.spring.boot.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final EntityManager entityManager;
    private final AddressRepository addressRepository;

    @Transactional
    public void showEntityStates() {
        var user = User.builder()
                .name("Jeho")
                .email("jeho.yeon@example.com")
                .password("password")
                .build();

        if (entityManager.contains(user)) {
            System.out.println("Persistent");
        } else {
            System.out.println("Transient / Detached");
        }

        userRepository.save(user);

        if (entityManager.contains(user)) {
            System.out.println("Persistent");
        } else {
            System.out.println("Transient / Detached");
        }
    }

    @Transactional
    public void showRelatedEntities() {
        var address = addressRepository.findById(1L).orElseThrow();
        System.out.println(address.getStreet());
        System.out.println(address.getUser().getEmail());
    }

    public void persistRelated() {
        var user = User.builder()
                .name("Jeho")
                .email("jeho.yeon@example.com")
                .password("password")
                .build();
        var address = Address.builder()
                .street("street")
                .city("city")
                .state("state")
                .zip("zip")
                .build();

        user.addAddress(address);

        userRepository.save(user);
        addressRepository.save(address);
    }
}
