/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Alrick Telfer <atelfer@advantumpcs.com>
 * Created: Sep 25, 2018
 */

CREATE TABLE _client (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    manager_id BIGINT,
    PRIMARY KEY (id)
) engine = InnoDB;

CREATE TABLE _person (
    id BIGINT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(40),
    middle_name VARCHAR(40),
    last_name VARCHAR(40),

    username VARCHAR(20),
    encrypted_password VARCHAR(2500),

    street_number VARCHAR(15),
    street_name VARCHAR(120),
    city VARCHAR(40),
    country_code VARCHAR(3),
    postal_code VARCHAR(15),

    position_id BIGINT,
    PRIMARY KEY (id)
) engine = InnoDB;

CREATE TABLE _position (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
) engine = InnoDB;

CREATE TABLE _time_sheet (
    id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255),
    client_id BIGINT,
    owner_id BIGINT,
    PRIMARY KEY (id)
) engine = InnoDB;

CREATE TABLE _time_sheet_entry (
    id BIGINT NOT NULL AUTO_INCREMENT,
    comment VARCHAR(255),
    period_date DATE,
    period_end TIME,
    period_start TIME,
    time_sheet_id BIGINT,
    PRIMARY KEY (id)
) engine = InnoDB;

ALTER TABLE _client ADD CONSTRAINT FKk8ih4dd057xrkbshy59ifprxi FOREIGN KEY (manager_id) REFERENCES _person (id);
ALTER TABLE _person ADD CONSTRAINT FKtm2radqa09l9mf74nram5usgi FOREIGN KEY (position_id) REFERENCES _position (id);
ALTER TABLE _time_sheet ADD CONSTRAINT FKci79n3n3q8u0ruq00djngpe5l FOREIGN KEY (client_id) REFERENCES _client (id);
ALTER TABLE _time_sheet ADD CONSTRAINT FKqqarrqnwso2xx59xvjcre3cak FOREIGN KEY (owner_id) REFERENCES _person (id);
ALTER TABLE _time_sheet_entry ADD CONSTRAINT FKsc1ubmunrwwdjkc21ivtwd7j2 FOREIGN KEY (time_sheet_id) REFERENCES _time_sheet (id);

/* INSERT INITIAL DATA */
INSERT INTO `_position` (`name`)
VALUES ("Manager"), ("Employee"), ("Contractor");

INSERT INTO `_person`
(`city`, `country_code`, `postal_code`, `street_name`, `street_number`, `encrypted_password`, `first_name`, `last_name`, `middle_name`, `username`, `position_id`)
VALUES
("Kingston", "JM", "KGN19", "Fairfax Ave", "21A", "$2a$10$hOXxcmUWXsEi72Jle8QLCO0LF5YtUanePKYo0pspT9I41VavZhdoS", /* Password: MyPl@!nP@ssw0rd */
"Thomas", "Finkle", "Jones", "thomas-jo", 1),

("Kingston", "JM", "KGN19", "Fairfax Ave", "21A", "$2a$10$hOXxcmUWXsEi72Jle8QLCO0LF5YtUanePKYo0pspT9I41VavZhdoS", /* Password: MyPl@!nP@ssw0rd */
"Jimmy", "Finkle", "Jones", "jimmy-jo", 1),

("Kingston", "JM", "KGN19", "Fairfax Ave", "21A", "$2a$10$hOXxcmUWXsEi72Jle8QLCO0LF5YtUanePKYo0pspT9I41VavZhdoS", /* Password: MyPl@!nP@ssw0rd */
"Roger", "Finkle", "Jones", "roger-jo", 2);

INSERT INTO `_client` (`name`, `manager_id`) VALUES ("Viva Ltd", 1);
INSERT INTO `_client` (`name`, `manager_id`) VALUES ("Fanta Ltd", 2);
INSERT INTO `_client` (`name`, `manager_id`) VALUES ("Bigga Ltd", 3);

INSERT INTO `vertis_demo`.`_time_sheet` 
    (`title`, `client_id`, `owner_id`)
VALUES 
    ("RQ-11526", 1, 3), ("RQ-11529", 2, 3), ("RQ-11530", 3, 3);

INSERT INTO `vertis_demo`.`_time_sheet_entry`
    (`comment`, `period_date`, `period_end`, `period_start`, `time_sheet_id`)
VALUES 
    ("I did something awesome!", "2018-03-23", "10:30:00", "12:30:00", 1),
    ("I did something else awesome!", "2018-03-23", "13:30:00", "15:30:00", 1);

DROP procedure IF EXISTS `CalculateTotalHoursByClientAndPerson`;
DELIMITER $$
CREATE PROCEDURE `CalculateTotalHoursByClientAndPerson` (
    in client_id bigint, 
    in person_id bigint
)
BEGIN
    SELECT (SUM(TIME_TO_SEC(TIMEDIFF(tse.period_start, tse.period_end))) / 60) / 60 FROM _time_sheet AS ts 
        LEFT JOIN _time_sheet_entry AS tse ON tse.time_sheet_id = ts.id
    WHERE ts.client_id = client_id AND ts.owner_id = person_id;
END$$
DELIMITER ;