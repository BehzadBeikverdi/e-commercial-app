-- =========================
-- CATEGORIES
-- =========================

INSERT INTO product__category (id, row_version, created, updated, name, description)
VALUES
    ('11111111-1111-1111-1111-111111111111', 0, NOW(), NOW(), 'Electronics', 'Phones, laptops, gadgets'),
    ('22222222-2222-2222-2222-222222222222', 0, NOW(), NOW(), 'Books', 'Technical and non-technical books'),
    ('33333333-3333-3333-3333-333333333333', 0, NOW(), NOW(), 'Clothing', 'Men and women fashion'),
    ('44444444-4444-4444-4444-444444444444', 0, NOW(), NOW(), 'Home', 'Home and kitchen products');



-- =========================
-- PRODUCTS
-- =========================

INSERT INTO product__product (
    id, row_version, created, updated,
    name, description, available_quantity, price, category_id
)
VALUES

-- Electronics
('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 0, NOW(), NOW(),
 'Laptop Pro 15', 'High-end performance laptop', 15, 1500.00,
 '11111111-1111-1111-1111-111111111111'),

('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb', 0, NOW(), NOW(),
 'iPhone 15', 'Latest smartphone model', 30, 999.99,
 '11111111-1111-1111-1111-111111111111'),

('cccccccc-cccc-cccc-cccc-cccccccccccc', 0, NOW(), NOW(),
 'Wireless Headphones', 'Noise cancelling headphones', 40, 199.99,
 '11111111-1111-1111-1111-111111111111'),

-- Books
('dddddddd-dddd-dddd-dddd-dddddddddddd', 0, NOW(), NOW(),
 'Spring Boot in Action', 'Backend development guide', 50, 45.00,
 '22222222-2222-2222-2222-222222222222'),

('eeeeeeee-eeee-eeee-eeee-eeeeeeeeeeee', 0, NOW(), NOW(),
 'Clean Code', 'Software engineering principles', 60, 35.00,
 '22222222-2222-2222-2222-222222222222'),

-- Clothing
('ffffffff-ffff-ffff-ffff-ffffffffffff', 0, NOW(), NOW(),
 'T-Shirt Basic', 'Cotton everyday t-shirt', 120, 12.99,
 '33333333-3333-3333-3333-333333333333'),

-- Home
('99999999-9999-9999-9999-999999999999', 0, NOW(), NOW(),
 'Coffee Maker', 'Automatic coffee machine', 20, 89.99,
 '44444444-4444-4444-4444-444444444444');