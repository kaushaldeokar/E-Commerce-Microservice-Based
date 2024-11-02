package com.kaushald.ecommerce.customer;

import java.util.List;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//The @RequiredArgsConstructor annotation from Lombok generates a constructor with required arguments for a class, specifically for all final fields and any fields that are marked with @NonNull. This is particularly useful in Spring controller classes, where you often want to inject dependencies through constructor injection.

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService service;//require dependency injection

  @PostMapping
  public ResponseEntity<String> createCustomer(
      @RequestBody @Valid CustomerRequest request
  ) {
    return ResponseEntity.ok(this.service.createCustomer(request));
  }

  @PutMapping
  public ResponseEntity<Void> updateCustomer(
      @RequestBody @Valid CustomerRequest request
  ) {
    this.service.updateCustomer(request);
    return ResponseEntity.accepted().build();
  }

  @GetMapping
  public ResponseEntity<List<CustomerResponse>> findAll() {
    return ResponseEntity.ok(this.service.findAllCustomers());
  }

  @GetMapping("/exists/{customer-id}")
  public ResponseEntity<Boolean> existsById(
      @PathVariable("customer-id") String customerId
  ) {
    return ResponseEntity.ok(this.service.existsById(customerId));
  }

  @GetMapping("/{customer-id}")
  public ResponseEntity<CustomerResponse> findById(
      @PathVariable("customer-id") String customerId
  ) {
    return ResponseEntity.ok(this.service.findById(customerId));
  }

  @DeleteMapping("/{customer-id}")
  public ResponseEntity<Void> delete(
      @PathVariable("customer-id") String customerId
  ) {
    this.service.deleteCustomer(customerId);
    return ResponseEntity.accepted().build();
  }

}
