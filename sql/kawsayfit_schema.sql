CREATE TABLE users (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       username VARCHAR(100) NOT NULL,
                       password_hash VARCHAR(255) NOT NULL,
                       registration_date DATE,
                       birth_date DATE,
                       gender ENUM('MALE', 'FEMALE'),
                       weight DOUBLE NOT NULL,
                       height DOUBLE NOT NULL,
                       target_weight DOUBLE NOT NULL,
                       imc DOUBLE NOT NULL,
                       goal ENUM('LOSE_WEIGHT', 'MAINTAIN_WEIGHT', 'GAIN_WEIGHT'),
                       physicalActivityLevel ENUM('SEDENTARY', 'LIGHT', 'MODERATE', 'ACTIVE', 'VERY_ACTIVE'),
                       strength_training BOOLEAN NOT NULL,
                       velocity VARCHAR(50),
                       salt VARCHAR(255) NOT NULL
);
