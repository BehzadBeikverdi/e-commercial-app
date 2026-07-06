CREATE TABLE product__category (
                                   id UUID PRIMARY KEY,
                                   row_version INT NOT NULL,
                                   created TIMESTAMP NOT NULL,
                                   updated TIMESTAMP NOT NULL,

                                   name VARCHAR(255),
                                   description VARCHAR(255)
);

CREATE TABLE product__product (
                                  id UUID PRIMARY KEY,
                                  row_version INT NOT NULL,
                                  created TIMESTAMP NOT NULL,
                                  updated TIMESTAMP NOT NULL,

                                  name VARCHAR(255),
                                  description VARCHAR(255),
                                  available_quantity DOUBLE PRECISION,
                                  price DECIMAL(19, 2),

                                  category_id UUID,

                                  CONSTRAINT fk_product_category
                                      FOREIGN KEY (category_id)
                                          REFERENCES product__category (id)
                                          ON DELETE SET NULL
);