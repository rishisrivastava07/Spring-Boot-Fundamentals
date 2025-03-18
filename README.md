# On Journal Application

## Overview
The **On Journal Application** is a web-based journal management system built using **Spring Boot**. It provides role-based access control, secure authentication, and a structured API for managing journal entries. The application follows best practices in software development, including **ORM, transactional properties, and unit/integration testing**.

## Tech Stack
- **Backend:** Spring Boot, Java, Maven
- **Security:** Spring Security (HTTP Basic Authentication & Authorization)
- **Database:** MongoDB Atlas, MongoDB
- **Testing:** Mockito, SpringBootTest
- **Tools:** IntelliJ IDEA, Postman

## Features
- **User and Admin Roles**
  - Users can create, read, update, and delete journal entries.
  - Admins have additional privileges for managing user access.
- **Authentication & Authorization**
  - Secured endpoints with **Spring Security**
  - Uses **Session Cookies** and customized authorization mechanisms
- **Database Integration**
  - Utilizes **MongoDB Atlas** for cloud storage
  - Implements **ORM & Transactional properties** for smooth data operations
- **Testing**
  - Unit testing with **Mockito**
  - Integration testing using **SpringBootTest**
- **API Development & Testing**
  - APIs are tested using **Postman**
  - Well-structured RESTful endpoints

## Installation & Setup
### Prerequisites
Ensure you have the following installed:
- Java (JDK 17 or later)
- IntelliJ IDEA (or any preferred IDE)
- Maven
- MongoDB (local or MongoDB Atlas account)

### Steps to Run the Project
1. **Clone the repository:**
   ```sh
   git clone https://github.com/rishisrivastava07/Spring-Boot-Fundamentals.git
   cd Spring-Boot-Fundamentals.git
   ```
2. **Configure MongoDB Atlas**
   - Update `application.properties` or `application.yml` with your MongoDB credentials.
3. **Build and run the application:**
   ```sh
   \mvnw clean install
   \mvnw spring-boot:run
   ```
4. **Access APIs via Postman**
   - Use **Postman** or any API client to interact with the backend.
   - Example endpoints:
     - `DELETE localhost:8080/journalv2/id/_id` - Delete a journal entry
     - `GET localhost:8080/journalv2` - Retrieve a journal entry
     - `POST localhost:8080/journalv2` - Create a journal entry

## API Authentication
- **User Authentication:** HTTP Basic Authentication
- **Roles:** 
  - `USER`: Can manage their own journal entries.
  - `ADMIN`: Has full control over all entries and users.

## Testing
Run unit and integration tests using:
```sh
\mvnw test
```

## Future Enhancements
- Implement JWT-based authentication.
- Add a frontend using React.js or Angular.
- Enhance UI/UX for better usability.
- Implement additional analytics and reporting features.

## Contributing
If you'd like to contribute:
1. Fork the repository
2. Create a feature branch (`git checkout -b feature-name`)
3. Commit your changes (`git commit -m 'Add new feature'`)
4. Push to the branch (`git push origin feature-name`)
5. Open a Pull Request

## License
This project is licensed under the **MIT License**.

## Contact
For any questions or suggestions, reach out via:
- Email: [your.email@example.com](mailto:rishisrivastava@gmail.com)
- GitHub: [yourgithubrepo](https://github.com/rishisrivastava07/)

---
🚀 **Happy Coding!**
