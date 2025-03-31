# EzyBank Portal API

## Overview

EzyBank Portal is a comprehensive banking API that provides a wide range of financial services for users, including account management, fund transfers, transactions, and user authentication.

## Features

- User Registration and Authentication
- Account Management
- Fund Transfers
- Cash Withdrawals and Deposits
- Transaction History
- Secure PIN Management
- Password Reset Functionality
- Email Notifications for Important Transactions

## Technologies Used

### Core Technologies
- Spring Boot 3.3.1
- Java 17
- Spring Security
- Spring Data JPA
- Spring Web
- Spring Validation
- Spring Cache (Caffeine)

### Authentication & Security
- JWT (JSON Web Token)
- Spring Security
- Password Encryption

### Database
- PostgreSQL (Default database)
- JPA/Hibernate

### Additional Libraries
- Lombok (Boilerplate code reduction)
- MapStruct (Object Mapping)
- LibPhoneNumber (Phone number validation)
- JavaFaker (Test data generation)
- GreenMail (Email testing)

### Documentation & Monitoring
- SpringDoc OpenAPI (Swagger)
- Spring Actuator

### Serialization
- Jackson JSON
- JAXB (XML Binding)

## Database Configuration

The project is configured to use **PostgreSQL** by default. However, you can easily switch to other databases by modifying the `application.properties` file:

```properties
# PostgreSQL Configuration (Default)
spring.datasource.url=jdbc:postgresql://localhost:5432/ezybank
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# MySQL Example (Alternative)
# spring.datasource.url=jdbc:mysql://localhost:3306/ezybank
# spring.datasource.username=root
# spring.datasource.password=yourpassword
# spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

## SMTP Configuration (Email Notifications)

EzyBank uses SMTP to send email notifications for password resets, transactions, and other important alerts.

```properties
# SMTP Configuration
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

### How to Get Your SMTP Password (App Password for Gmail)
1. Go to [Google Account Security](https://myaccount.google.com/security)
2. Enable **2-Step Verification** if not already enabled.
3. Under "Signing in to Google," click **App Passwords**.
4. Select "Mail" as the app and "Custom" as the device name (e.g., "EzyBank API").
5. Click "Generate" and copy the provided app password.
6. Use this app password in `spring.mail.password` instead of your actual Gmail password.

## Endpoints

### Authentication Endpoints
- User Registration: `/api/users/register`
- User Login: `/api/users/login`
- User Logout: `/api/users/logout`
- Password Reset: `/api/auth/password-reset/...`

### Account Endpoints
- Check PIN Status: `/api/account/pin/check`
- Create/Update PIN: `/api/account/pin/create`, `/api/account/pin/update`
- Withdraw Cash: `/api/account/withdraw`
- Deposit Cash: `/api/account/deposit`
- Fund Transfer: `/api/account/fund-transfer`
- View Transactions: `/api/account/transactions`
- Account Details: `/api/dashboard/account`

## Authentication

The API uses Bearer Token authentication. Users must obtain a JWT token during login and include it in the Authorization header for protected endpoints.

## Error Handling

The API implements global exception handling for:
- Not Found Scenarios
- Unauthorized Access
- Insufficient Balance

## Getting Started

### Prerequisites
- Java 17
- Maven
- PostgreSQL Database

### Installation

1. Clone the repository
```bash
git clone https://github.com/ch-sai-sumanth/ezybank.git
```

2. Navigate to the project directory
```bash
cd ezybank
```

3. Build the project
```bash
mvn clean install
```

4. Run the application
```bash
mvn spring-boot:run
```

## API Documentation

For detailed API endpoint specifications, request/response formats, and status codes, refer to the full API documentation. Swagger UI is available at `/swagger-ui.html`.

## Security Considerations

- Always use HTTPS in production
- Keep JWT tokens secure
- Implement additional security measures as needed

## Monitoring

The application includes Spring Actuator for health checks and monitoring. Access endpoints like `/actuator/health` to check application status.

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Contact

Sai Sumanth - saisumanth0531@gmail.com

Project Link: [https://github.com/ch-sai-sumanth/ezybank](https://github.com/ch-sai-sumanth/ezybank)
