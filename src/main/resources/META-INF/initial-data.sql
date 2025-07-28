INSERT INTO users (
    email, username, password_hash, registration_date, birth_date, gender,
    weight, height, target_weight, imc, goal, physicalActivityLevel,
    strength_training, velocity, salt
) VALUES (
             'admin@example.com', 'admin', 'uVQoLxtZvlhBuamIlWRLGQ==', '2024-01-01', '1995-05-10', 'MALE',
             70, 175, 70, 22.86, 'MAINTAIN_WEIGHT', 'MODERATE',
             TRUE, 'NORMAL', 'randomsalt123'
         );
