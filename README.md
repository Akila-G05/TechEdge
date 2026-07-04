# TechEdge - Educational Institute Management System

A comprehensive desktop application for managing tuition centers and educational institutes. Built with **Java Swing**, **MySQL**, and **JasperReports**, TechEdge provides robust tools for student enrollment, teacher management, class scheduling, payment tracking, and automated PDF report generation.

## 📋 Features

### Core Management Functions
- **Student Management** - Register, update, and manage student information and enrollments
- **Teacher Management** - Manage teacher profiles and subject assignments
- **Subject Management** - Create and manage subjects with pricing and status tracking
- **Class Scheduling** - Schedule and organize online and physical classes with detailed information
- **Payment Processing** - Track student payments, manage payment status, and generate payment reports
- **User Authentication** - Role-based login system for Students, Teachers, and Administrators

### Advanced Capabilities
- **PDF Report Generation** - Automatic report generation using JasperReports
- **Dashboard Analytics** - Role-specific dashboards for different user types:
  - Admin Dashboard - System-wide overview and management
  - Student Dashboard - Personal enrollment and payment tracking
  - Teacher Dashboard - Class and student management
- **Data Persistence** - MySQL database with comprehensive schema for reliable data storage
- **Modern UI** - FlatLaf theme integration for contemporary user experience

## 🏗️ Project Structure

```
TechEdge/
├── src/lk/akila/techedge/
│   ├── gui/                    # Main GUI windows (Splash, SignIn, Dashboards)
│   ├── pannel/                 # UI panels for different features
│   │   ├── AdminDashboardPanel
│   │   ├── AdminStudentManagementPanel
│   │   ├── AdminTeacherManagementPanel
│   │   ├── AdminSubjectManagementPanel
│   │   ├── AdminPaymentManagementPanel
│   │   ├── StudentDashboardPanel
│   │   ├── StudentClassesPanel
│   │   ├── StudentPaymentPanel
│   │   └── StudentProfilePanel
│   ├── dialog/                 # Dialog windows for CRUD operations
│   │   ├── RegisterStudentDialog
│   │   ├── RegisterTeacherDialog
│   │   ├── ClassDialog
│   │   ├── SubjectDialog
│   │   ├── PaymentDialog
│   │   └── UpdateStudentDialog/UpdateTeacherDialog
│   ├── component/              # Custom UI components
│   │   ├── Background
│   │   ├── RoundButton
│   │   ├── RoundTextField
│   │   └── RoundPasswordField
│   ├── connection/             # Database connectivity
│   │   └── MySQL.java          # MySQL JDBC connection management
│   └── report/                 # JasperReports templates
│       ├── techedge.jasper
│       └── techedge2.jasper
├── techedge.sql               # Database schema and sample data
├── build.xml                  # Apache Ant build configuration
├── manifest.mf                # JAR manifest file
└── .gitignore                 # Git ignore patterns
```

## 💻 How to Run

### Prerequisites
- **Java Development Kit (JDK)** - Version 8 or higher
- **MySQL Server** - Version 5.7 or higher
- **Apache Ant** - For building the project (or use IDE like NetBeans)
- **JDBC Driver** - MySQL Connector/J

### Step 1: Database Setup
```bash
# Import the SQL schema
mysql -u root -p < techedge.sql

# Or manually:
# 1. Open MySQL client
# 2. Run: source path/to/techedge.sql
```

### Step 2: Configure Database Connection
Edit `src/lk/akila/techedge/connection/MySQL.java`:
```java
private static final String user = "root";              // Your MySQL username
private static final String password = "akila@2005";    // Your MySQL password
private static final String DB_name = "techedge";       // Database name
```

### Step 3: Build the Project
```bash
# Using Ant
ant clean
ant build

# Or using an IDE (NetBeans recommended)
# Open the project and click Run
```

### Step 4: Run the Application
```bash
# Execute the JAR file
java -jar dist/TechEdge.jar

# Or use IDE's Run command
```

## 🔐 Default Credentials

The database includes sample users for testing:

| Username | Password | Role |
|----------|----------|------|
| kaviya | 12345 | Student |
| meraj | 12345 | Teacher |
| akila | 12345 | Admin |
| imadu | 12345 | Teacher |
| 200512345678 | 0761221234 | Teacher |

> ⚠️ **Security Note**: Change all default passwords in production. Credentials are stored in the `login_details` table.

## 📊 Database Schema

### Core Tables
- **user** - Central user information (NIC, email, mobile, address, gender)
- **user_type** - User roles (Student, Teacher, Admin)
- **user_status** - User status (Active, Deactive)
- **login_details** - Authentication credentials (username, password)

### Academic Tables
- **subject** - Subject information with pricing
- **subject_cat** - Subject categories (A/L years, courses)
- **subject_status** - Subject status (Active, Deactive, Expired)
- **class** - Class schedules and details
- **class_type** - Class format (Online, Physical)

### Management Tables
- **student** - Student enrollment records
- **teacher** - Teacher assignments
- **payment** - Payment tracking
- **p_status** - Payment status (Payed, Pending)
- **gender** - Gender reference data

## 🛠️ Technology Stack

| Component | Technology |
|-----------|-----------|
| **Language** | Java 8+ |
| **GUI Framework** | Java Swing |
| **Database** | MySQL 5.7+ |
| **JDBC Driver** | MySQL Connector/J |
| **Reporting** | JasperReports |
| **UI Theme** | FlatLaf (Material Theme UI Lite) |
| **Build Tool** | Apache Ant |
| **IDE** | NetBeans (Recommended) |

## 📖 Usage Guide

### For Students
1. **Login** - Sign in with your credentials
2. **View Dashboard** - See enrolled subjects and payment status
3. **View Classes** - Check scheduled classes for your subjects
4. **Track Payments** - View payment history and pending amounts
5. **Edit Profile** - Update your personal information

### For Teachers
1. **Login** - Access teacher credentials
2. **View Dashboard** - Monitor assigned classes and students
3. **Manage Classes** - Create and view class schedules
4. **Track Payments** - View student payment status for your subjects

### For Administrators
1. **Login** - Use admin credentials
2. **Student Management** - Register, update, and manage students
3. **Teacher Management** - Register and manage teachers
4. **Subject Management** - Create subjects, manage categories and status
5. **Class Management** - Schedule and organize classes
6. **Payment Management** - Track and update payment status
7. **Generate Reports** - Export data to PDF using JasperReports

## 🚀 Key Features Explanation

### Role-Based Access Control
- Each user role (Student, Teacher, Admin) has specific dashboards and functionalities
- Secure login system prevents unauthorized access

### Subject Categories & Pricing
- Supports multiple subject categories (A/L years, specialized courses)
- Dynamic pricing management for subjects
- Status tracking (Active, Deactive, Expired)

### Class Management
- Schedule classes as Online or Physical
- Store class details, timing, and location information
- Track class attendance and student participation

### Payment System
- Track student payments for each subject and month
- Two payment statuses: Payed and Pending
- Generate payment reports for administrative purposes

### Report Generation
- Automated PDF report generation using JasperReports
- Multiple report templates for different data views
- Export functionality for printing and archival

## 🐛 Known Issues & Limitations
- Database credentials are hardcoded (should use configuration file in production)
- No encryption for passwords (use hashing in production)
- Limited offline functionality (requires active database connection)

## 📝 Configuration

### Customizing Database Connection
If you need to change the database host, port, or credentials:

1. Edit `src/lk/akila/techedge/connection/MySQL.java`
2. Modify the connection string and credentials
3. Rebuild the project

## 🤝 Contributing

Contributions are welcome! Please:
1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request

## 📄 License

This project is open-source and available under a permissive license.

## 👤 Author

**Akila Gayan** - Project Creator and Developer

## 🔗 Related Resources

- [Java Swing Documentation](https://docs.oracle.com/javase/tutorial/uiswing/)
- [MySQL JDBC Connector](https://dev.mysql.com/downloads/connector/j/)
- [JasperReports Library](https://community.jaspersoft.com/)
- [FlatLaf Look and Feel](https://www.formdev.com/flatlaf/)

## 💬 Support

For issues, questions, or suggestions:
1. Check existing issues on GitHub
2. Create a new issue with detailed description
3. Include error messages and stack traces if applicable

---

**Last Updated**: June 2024  
**Repository**: https://github.com/Akila-G05/TechEdge  
**Status**: Active Development
