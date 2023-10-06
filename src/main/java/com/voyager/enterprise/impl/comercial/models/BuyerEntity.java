package com.voyager.enterprise.impl.comercial.models;

import java.util.UUID;

import io.ebean.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BuyerEntity extends Model{
    @Id
    private UUID id;

}
