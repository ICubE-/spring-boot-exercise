package com.icube.exercise.spring.boot.services;

import com.icube.exercise.spring.boot.entities.Address;
import com.icube.exercise.spring.boot.entities.Category;
import com.icube.exercise.spring.boot.entities.Product;
import com.icube.exercise.spring.boot.entities.User;
import com.icube.exercise.spring.boot.repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final EntityManager entityManager;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

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
    }

    @Transactional
    public void deleteRelated() {
//        userRepository.deleteById(3L);

        var user = userRepository.findById(5L).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
    }

    @Transactional
    public void manageProducts() {
//        var product = Product.builder()
//                .name("Product")
//                .description("Description")
//                .price(BigDecimal.valueOf(1.23))
//                .build();
//        var category = new Category("Category");
//        product.setCategory(category);
//        productRepository.save(product);


//        var category = categoryRepository.findById((byte) 1).orElseThrow();
//        var product = Product.builder()
//                .name("Product 2")
//                .description("Description 2")
//                .price(BigDecimal.valueOf(4.56))
//                .category(category)
//                .build();
//        productRepository.save(product);


//        var user = userRepository.findById(4L).orElseThrow();
//        var products = productRepository.findAll();
//        for (Product product : products) {
//            user.getWishlist().add(product);
//        }
//        userRepository.save(user);


        productRepository.deleteById(1L);
    }

    @Transactional
    public void updateProductPrices() {
        productRepository.updatePriceByCategory(BigDecimal.valueOf(10), (byte) 1);
    }

    public void fetchProducts() {
        var products = productRepository.findByCategory(new Category((byte) 1));
        products.forEach(System.out::println);
    }

    @Transactional
    public void fetchUser() {
        var user = userRepository.findByEmail("jeho.yeon@example.org").orElseThrow();
        System.out.println(user);
    }

    @Transactional
    public void fetchUsers() {
        var users = userRepository.findAllWithAddresses();
        users.forEach(u -> {
            System.out.println(u);
            u.getAddresses().forEach(System.out::println);
        });
    }
}
