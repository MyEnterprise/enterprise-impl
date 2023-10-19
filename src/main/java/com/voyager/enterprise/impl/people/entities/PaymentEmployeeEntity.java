package com.voyager.enterprise.impl.people.entities;

import com.voyager.enterprise.economy.entity.Transaction;
import com.voyager.enterprise.impl.economy.entities.TransactionEntity;
import com.voyager.enterprise.impl.plugin.payment.entities.PaymentIdentificationEntity;


public class PaymentEmployeeEntity extends TransactionEntity {
    public PaymentIdentificationEntity paymentIdentification;
}