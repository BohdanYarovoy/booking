INSERT INTO B_ROOM (NUMBER, HOTEL_FLOOR, PRICE, TOTAL_PRICE, ROOM_CAPACITY, TIME_FOR_PAY, BOOKED_FROM, BOOKED_TO, TYPE, STATUS, DESCRIPTION, CURRENT_GUEST_COUNT)
VALUES
    -- Статус "FREE"
    (1, 1, 100.0, 0, 2, NULL, NULL, NULL, 'STANDART', 'FREE', 'A cozy and comfortable room with a double bed, perfect for two guests.', 0),
    (2, 1, 150.0, 0, 3, NULL, NULL, NULL, 'SUPERIOR', 'FREE', 'A spacious room with a king-size bed and extra space for comfort.', 0),
    (3, 1, 200.0, 0, 2, NULL, NULL, NULL, 'DELUX', 'FREE', 'A luxurious room with a beautiful view, perfect for a romantic getaway.', 0),
    (4, 1, 250.0, 0, 4, NULL, NULL, NULL, 'STANDART', 'FREE', 'A premium room offering extra amenities and a larger area for business travelers.', 0),
    (5, 1, 300.0, 0, 2, NULL, NULL, NULL, 'SUITE', 'FREE', 'A luxurious suite with separate living and sleeping areas, ideal for long stays.', 0),
    (6, 1, 120.0, 0, 2, NULL, NULL, NULL, 'STANDART', 'FREE', 'A budget-friendly room with essential features, suitable for short visits.', 0),
    (7, 1, 170.0, 0, 3, NULL, NULL, NULL, 'SUPERIOR', 'FREE', 'A well-appointed room with extra space and comfortable furnishings.', 0),
    (8, 1, 220.0, 0, 2, NULL, NULL, NULL, 'DELUX', 'FREE', 'A stylish and modern room with elegant decor, perfect for a special occasion.', 0),
    (9, 1, 280.0, 0, 4, NULL, NULL, NULL, 'STANDART', 'FREE', 'A spacious room with top-tier amenities, designed for corporate guests.', 0),
    (10, 1, 330.0, 0, 2, NULL, NULL, NULL, 'SUITE', 'FREE', 'An exquisite suite with luxurious furnishings and a great city view.', 0),
    (11, 2, 110.0, 0, 2, NULL, NULL, NULL, 'STANDART', 'FREE', 'A simple and affordable room for a short stay, with essential amenities.', 0),
    (12, 2, 160.0, 0, 3, NULL, NULL, NULL, 'SUPERIOR', 'FREE', 'A spacious room with additional seating and modern features.', 0),
    (13, 2, 210.0, 0, 2, NULL, NULL, NULL, 'DELUX', 'FREE', 'A luxurious room with high-end furniture and a stylish atmosphere.', 0),
    (14, 2, 270.0, 0, 4, NULL, NULL, NULL, 'STANDART', 'FREE', 'An executive room designed for business professionals, with plenty of space and amenities.', 0),
    (15, 2, 320.0, 0, 2, NULL, NULL, NULL, 'SUITE', 'FREE', 'A premium suite with large living and sleeping areas, offering utmost comfort.', 0),

    -- Статус "BOOKED"
    (16, 1, 100.0, 0, 2, '2024-12-01', '2024-12-01', '2024-12-10', 'STANDART', 'BOOKED', 'A cozy and comfortable room with a double bed, perfect for two guests.', 1),
    (17, 1, 170.0, 0, 3, '2024-12-02', '2024-12-02', '2024-12-14', 'SUPERIOR', 'BOOKED', 'A well-appointed room with extra space and comfortable furnishings.', 1),
    (18, 1, 200.0, 0, 2, '2024-12-03', '2024-12-03', '2024-12-12', 'DELUX', 'BOOKED', 'A luxurious room with a beautiful view, perfect for a romantic getaway.', 1),
    (19, 2, 180.0, 0, 3, '2024-12-04', '2024-12-04', '2024-12-13', 'SUPERIOR', 'BOOKED', 'A spacious room with a king-size bed and additional space for relaxation.', 1),
    (20, 2, 250.0, 0, 4, '2024-12-06', '2024-12-06', '2024-12-15', 'EXECUTIVE', 'BOOKED', 'A spacious room with top-tier amenities, designed for corporate guests.', 1),
    (21, 3, 350.0, 0, 2, '2024-12-07', '2024-12-07', '2024-12-20', 'SUITE', 'BOOKED', 'A luxurious suite with separate living and sleeping areas, ideal for long stays.', 1),

    -- Статус "UNAVAILABLE"
    (22, 3, 220.0, 0, 2, NULL, NULL, NULL, 'DELUX', 'UNAVAILABLE', 'A deluxe room featuring luxury bedding, elegant design, and a peaceful ambiance.', 0),
    (23, 3, 240.0, 0, 2, NULL, NULL, NULL, 'DELUX', 'UNAVAILABLE', 'A premium room offering high-end finishes and a relaxing atmosphere.', 0),
    (24, 2, 190.0, 0, 2, NULL, NULL, NULL, 'STANDART', 'UNAVAILABLE', 'A simple and affordable room for a short stay, with essential amenities.', 0),
    (25, 1, 270.0, 0, 3, NULL, NULL, NULL, 'SUPERIOR', 'UNAVAILABLE', 'A spacious room with additional seating and modern features.', 0),
    (26, 4, 320.0, 0, 4, NULL, NULL, NULL, 'SUITE', 'UNAVAILABLE', 'An executive room designed for business professionals, with plenty of space and amenities.', 0),

    -- Статус "PROCESS"
    (27, 1, 280.0, 0, 4, NULL, '2024-12-09', '2024-12-22', 'SUITE', 'PROCESS', 'A spacious room with top-tier amenities, designed for corporate guests.', 4),
    (28, 1, 330.0, 0, 2, NULL, '2024-12-10', '2024-12-20', 'SUITE', 'PROCESS', 'An exquisite suite with luxurious furnishings and a great city view.', 2),
    (29, 2, 170.0, 0, 2, NULL, '2024-12-10', '2024-12-15', 'SUPERIOR', 'PROCESS', 'A spacious room with additional seating and modern features.', 1);


INSERT INTO B_USER(USERNAME, FIRSTNAME, LASTNAME, EMAIL, PHONE, PASSWORD, ROLE, ROOM_ID)
VALUES ('manager123', 'Iryna', 'Kravchenko', 'manager@gmail.com', '+380923336567',
        '$2a$12$5.snrBVaklamu3xzI/csJO4R.RCMBgfcqGwYyIS04eNBZCXIBjxJe', 'MANAGER', 27),
       ('user123', 'Vasyl', 'Sukhomlynsky', 'vasyl@gmail.com', '+380660543233',
        '$2a$12$9vaJFGLPI/H0U4cp5KXGYOaGveouGrgOPdu5EfZruZkWFrdUZyH9G', 'USER', 28),
       ('zelensky123', 'Volodymyr', 'Zelenskyy', 'Zelenskyy@gmail.com', '+380986767898',
        '$2a$12$UuS05h2FCNGa9aDg2vm/TOUb/lZABsgGpYqCnYz9fj6rXFZPpZJ8K', 'USER', 29);

    ---  LOGIN          PASSWORD
    ---  manager123     manager         MANAGER
    ---  user123        mypassword      USER
    ---  zelensky123    slavaukraine    USER

