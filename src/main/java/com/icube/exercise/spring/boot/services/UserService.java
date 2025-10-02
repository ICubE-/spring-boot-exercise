package com.icube.exercise.spring.boot.services;

import com.icube.exercise.spring.boot.entities.Address;
import com.icube.exercise.spring.boot.entities.Product;
import com.icube.exercise.spring.boot.entities.User;
import com.icube.exercise.spring.boot.repositories.*;
import com.icube.exercise.spring.boot.repositories.specifications.ProductSpec;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
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

    @Transactional
    public void fetchProducts() {
        var products = productRepository.findProducts(BigDecimal.valueOf(1), BigDecimal.valueOf(15));
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

    @Transactional
    public void fetchProfiles() {
        var userSummaries = userRepository.findLoyalUsers(2);
        userSummaries.forEach(us -> {
            System.out.println("ID: " + us.getId());
            System.out.println("email: " + us.getEmail());
        });
    }

    public void fetchProductsByExample() {
        var product = new Product();
        product.setName("product");

        var matcher = ExampleMatcher.matching()
                .withIncludeNullValues()
                .withIgnorePaths("id", "description")
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        var example = Example.of(product, matcher);
        var products = productRepository.findAll(example);
        products.forEach(System.out::println);
    }

    public void fetchProductsByCriteria() {
        var products = productRepository.findProductsByCriteria("prod", BigDecimal.valueOf(1), null);
        products.forEach(System.out::println);
    }

    public void fetchProductsBySpecifications(String name, BigDecimal minPrice, BigDecimal maxPrice) {
        Specification<Product> spec = Specification.unrestricted();

        if (name != null) {
            spec = spec.and(ProductSpec.hasName(name));
        }
        if (minPrice != null) {
            spec = spec.and(ProductSpec.hasPriceGreaterThanOrEqualTo(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpec.hasPriceLessThanOrEqualTo(maxPrice));
        }

        var products = productRepository.findAll(spec);
        products.forEach(System.out::println);
    }

    public void fetchSortedProducts() {
        var sort = Sort.by("name").and(Sort.by("price").descending());
        var products = productRepository.findAll(sort);
        products.forEach(System.out::println);
    }

    public void fetchPaginatedProducts(int pageNumber, int size) {
        PageRequest pageRequest = PageRequest.of(pageNumber, size);
        Page<Product> page = productRepository.findAll(pageRequest);

        var products = page.getContent();
        products.forEach(System.out::println);

        var totalPages = page.getTotalPages();
        var totalElements = page.getTotalElements();
        System.out.println("Total pages: " + totalPages);
        System.out.println("Total elements: " + totalElements);
    }
}
