package com.kaushald.ecommerce.payment;

import com.kaushald.ecommerce.customer.CustomerResponse;
import com.kaushald.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
    BigDecimal amount,
    PaymentMethod paymentMethod,
    Integer orderId,
    String orderReference,
    CustomerResponse customer
) {
}
