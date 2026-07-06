package com.stringwavetech.ecommerce.document;

import com.stringwavetech.ecommerce.model.request.CustomerRequestModel;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = BaseDocument.PREFIX + "customers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CustomerDocument extends BaseDocument {

    private String firstname;
    private String lastname;
    private String email;
    private CustomerRequestModel.AddressModel address;
}
