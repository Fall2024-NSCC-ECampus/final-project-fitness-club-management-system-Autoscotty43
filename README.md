# **Fitness Club Management Web App**

This project is a **Fitness Club Management System** built using **Spring Boot**, **Hibernate**, and a **MySQL database**. The system simplifies gym operations by managing members, trainers, and attendance records, while ensuring user authentication and data integrity.

---

## **Features**

### **Admin**
- **Login**: Admin can log in using credentials.
- **Add Member**: Register new gym members.
- **Delete Member**: Remove members who have left.
- **Add Trainer**: Add trainers to the system.
- **Delete Trainer**: Remove trainers.
- **Modify Data**: Update member details and trainer shifts.

### **Member**
- **Login**: Access personal accounts using credentials.
- **View Schedule**: Check assigned workout schedules.

### **Trainer**
- **Login**: Authenticate using trainer credentials.
- **Mark Attendance**: Record member attendance.
- **View Schedule**: Check personal training schedules.

---

## **Technologies Used**

- **Backend**: Spring Boot, Hibernate
- **Frontend**: Thymeleaf (optional)
- **Database**: MySQL
- **API Testing**: Postman

---

## **Setup Instructions**

### **Prerequisites**
- Java 17 or higher
- Maven
- MySQL Server
- Postman (optional for API testing)

### **Installation**

1. Clone the repository:
    ```bash
    git clone https://github.com/YourUsername/FitnessClubManagementWebApp.git
    cd FitnessClubManagementWebApp
    ```

2. Configure the database:
    - Open the `src/main/resources/application.properties` file.
    - Set up your MySQL credentials:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/fitness_club
      spring.datasource.username=your_mysql_username
      spring.datasource.password=your_mysql_password
      ```

3. Build and run the application:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

4. Access the app:
    - Open your browser and go to `http://localhost:8080`.

---

## **API Endpoints**

### **Admin Endpoints**
- Add Member: `POST /admin/members`
- Delete Member: `DELETE /admin/members/{id}`
- Add Trainer: `POST /admin/trainers`
- Delete Trainer: `DELETE /admin/trainers/{id}`

### **Member Endpoints**
- Login: `POST /members/login`
- View Schedule: `GET /members/{id}/schedule`

### **Trainer Endpoints**
- Login: `POST /trainers/login`
- Mark Attendance: `POST /attendance/mark`
- View Schedule: `GET /trainers/{id}/schedule`

---

## **Database Schema**

### **Tables**
- `admins`: Stores admin credentials.
- `members`: Stores member details.
- `trainers`: Stores trainer details.
- `attendance`: Tracks attendance records.

### **Relationships**
- `attendance.member_id` → `members.id`
- `attendance.trainer_id` → `trainers.id`

---

## **Testing with Postman**

1. Import the Postman collection provided in the `postman` directory.
2. Use the endpoints with sample payloads:
    - **Mark Attendance**:
      ```json
      {
        "trainerId": 1,
        "memberId": 2,
        "isPresent": true
      }
      ```

---

## **Future Enhancements**
- Integration with external scheduling APIs.
- Enhanced reporting for attendance and member activity.
- Mobile app for easier access.

---

## **Contributors**
- **Jared Scott**  
  Student at NSCC, IT Programming

---

## **License**
This project is licensed under the MIT License. See the `LICENSE` file for details.

---

## **Contact**
For any queries or support, feel free to reach out:
- **GitHub**: [Autoscotty43](https://github.com/Autoscotty43)
