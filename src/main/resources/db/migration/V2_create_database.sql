CREATE TABLE user (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255),
                      socialSecurityNumber VARCHAR(255),
);
)
CREATE TABLE account (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         accountNumber INT,
                         currentBalance INT
                             foreign key(userId) references user(id) );