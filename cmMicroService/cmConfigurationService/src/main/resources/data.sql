DROP TABLE IF EXISTS Menu ;
CREATE TABLE Menu (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- Assuming AUTO_INCREMENT for MySQL, or SERIAL for PostgreSQL
                      display_name VARCHAR(255) NOT NULL,
                      description TEXT,
                      url VARCHAR(255),
                      parent_menu BIGINT,
                      FOREIGN KEY (parent_menu) REFERENCES Menu(id)  -- Self-referencing foreign key
);
-- Inserting root menu items (those without a parent)
INSERT INTO Menu (display_name, description, url, parent_menu)
VALUES ('Home', 'Main homepage', '/home', NULL);
INSERT INTO Menu (display_name, description, url, parent_menu)
VALUES ('About Us', 'About our company', '/about', NULL);
INSERT INTO Menu (display_name, description, url, parent_menu)
VALUES ('Contact', 'Contact information', '/contact', NULL);

-- Inserting submenu items (those with a parent)
INSERT INTO Menu (display_name, description, url, parent_menu)
VALUES ('Team', 'Our team', '/about/team', (SELECT id FROM Menu WHERE display_name = 'About Us')),
       ('Careers', 'Job opportunities', '/about/careers', (SELECT id FROM Menu WHERE display_name = 'About Us'));
