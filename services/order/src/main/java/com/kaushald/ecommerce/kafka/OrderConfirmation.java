package com.kaushald.ecommerce.kafka;

import com.kaushald.ecommerce.customer.CustomerResponse;
import com.kaushald.ecommerce.order.PaymentMethod;
import com.kaushald.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation (
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}
