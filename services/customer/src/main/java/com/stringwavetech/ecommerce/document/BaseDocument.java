package com.stringwavetech.ecommerce.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseDocument implements Serializable {

    protected static final String PREFIX = "customer__";

    @Id
    private String id;

    @Version
    private Long version;

    @CreatedDate
    @Field("created")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Field("updated")
    private LocalDateTime updatedDate;
}