/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `techedge` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `techedge`;

CREATE TABLE IF NOT EXISTS `class` (
  `classno` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `s_time` time DEFAULT NULL,
  `e_time` time DEFAULT NULL,
  `details` text,
  `subject_subno` int NOT NULL,
  `class_type_id` int NOT NULL,
  PRIMARY KEY (`classno`),
  KEY `fk_class_subject1_idx` (`subject_subno`),
  KEY `fk_class_class_type1_idx` (`class_type_id`),
  CONSTRAINT `fk_class_class_type1` FOREIGN KEY (`class_type_id`) REFERENCES `class_type` (`id`),
  CONSTRAINT `fk_class_subject1` FOREIGN KEY (`subject_subno`) REFERENCES `subject` (`subno`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;

INSERT INTO `class` (`classno`, `name`, `date`, `s_time`, `e_time`, `details`, `subject_subno`, `class_type_id`) VALUES
	(1, 'ET Theory 01', '2024-08-05', '22:12:30', '22:12:32', 'aa', 1, 1),
	(2, 'SFT Theory 01', '2024-08-04', '22:13:57', '22:13:57', 'a', 2, 1),
	(3, 'ET Revesion 01', '2024-08-03', '22:14:44', '22:14:45', 'a', 4, 2),
	(4, 'AI Day 01', '2024-08-04', '22:24:55', '22:24:57', 'dsad', 7, 2),
	(5, 'ICT Day 01', '2024-08-04', '22:38:43', '22:38:44', NULL, 3, 1),
	(6, 'ET Boost Paper Discussion', '2024-08-05', '14:12:52', '18:12:52', '', 1, 1),
	(7, 'SFT Full Day', '2024-08-07', '12:57:32', '14:57:32', '', 2, 2),
	(8, 'Power', '2024-08-05', '14:59:13', '14:59:13', '', 2, 1),
	(9, 'ET Practical', '2024-08-09', '17:44:48', '17:44:48', '', 1, 1),
	(10, 'SFT paper class 2', '2024-08-11', '18:50:22', '18:50:40', 'Meraj Lakvindu is inviting you to a scheduled Zoom meeting.\n\nJoin Zoom Meeting\nhttps://us05web.zoom.us/j/3954573360?pwd=alGF8FqLlHdmV8G9ZU1Uex8lnkVNFJ.1\n\nMeeting ID: 395 457 3360\nPasscode: SQS8ezA', 2, 1),
	(11, 'ET practical 2', '2024-08-12', '18:41:03', '19:43:00', '', 1, 2),
	(12, 'test', '2024-08-18', '05:15:43', '09:15:43', 'dsf f dfs', 1, 1);

CREATE TABLE IF NOT EXISTS `class_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `c_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

INSERT INTO `class_type` (`id`, `c_type`) VALUES
	(1, 'ONLINE'),
	(2, 'PHYSICAL');

CREATE TABLE IF NOT EXISTS `gender` (
  `id` int NOT NULL AUTO_INCREMENT,
  `g_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

INSERT INTO `gender` (`id`, `g_name`) VALUES
	(1, 'Male'),
	(2, 'Female');

CREATE TABLE IF NOT EXISTS `login_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_login_details_user1_idx` (`user_id`),
  CONSTRAINT `fk_login_details_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;

INSERT INTO `login_details` (`id`, `user_name`, `password`, `user_id`) VALUES
	(1, 'kaviya', '12345', 1),
	(2, 'meraj', '12345', 2),
	(3, '200512345678', '0761221234', 3),
	(4, 'imadu', '12345', 4),
	(5, 'akila', '12345', 8),
	(6, '200663490431', '0712312311', 10),
	(7, '200567890984', '0701234567', 11),
	(8, '200556755675', '0762323232', 12),
	(9, '123112121212', '0712121121', 13),
	(10, '200512121212', '0767654323', 14);

CREATE TABLE IF NOT EXISTS `payment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int NOT NULL,
  `subject_subno` int NOT NULL,
  `month` varchar(45) DEFAULT NULL,
  `p_status_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_payment_subject1_idx` (`subject_subno`),
  KEY `fk_payment_p_status1_idx` (`p_status_id`),
  KEY `fk_payment_student1_idx` (`student_id`),
  CONSTRAINT `fk_payment_p_status1` FOREIGN KEY (`p_status_id`) REFERENCES `p_status` (`id`),
  CONSTRAINT `fk_payment_student1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `fk_payment_subject1` FOREIGN KEY (`subject_subno`) REFERENCES `subject` (`subno`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb3;

INSERT INTO `payment` (`id`, `student_id`, `subject_subno`, `month`, `p_status_id`) VALUES
	(34, 2, 2, 'August', 1),
	(35, 5, 2, 'August', 1),
	(38, 8, 1, 'August', 1),
	(50, 1, 1, 'June', 1);

CREATE TABLE IF NOT EXISTS `p_status` (
  `id` int NOT NULL,
  `p_status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

INSERT INTO `p_status` (`id`, `p_status`) VALUES
	(1, 'Payed'),
	(2, 'Pending');

CREATE TABLE IF NOT EXISTS `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `subject_subno` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_has_subject_subject2_idx` (`subject_subno`),
  KEY `fk_user_has_subject_user2_idx` (`user_id`),
  CONSTRAINT `fk_user_has_subject_subject2` FOREIGN KEY (`subject_subno`) REFERENCES `subject` (`subno`),
  CONSTRAINT `fk_user_has_subject_user2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;

INSERT INTO `student` (`id`, `user_id`, `subject_subno`) VALUES
	(1, 1, 1),
	(2, 1, 2),
	(4, 2, 1),
	(5, 2, 2),
	(6, 2, 3),
	(8, 7, 1),
	(10, 12, 3),
	(12, 7, 3),
	(13, 7, 2),
	(14, 13, 3),
	(15, 13, 1);

CREATE TABLE IF NOT EXISTS `subject` (
  `subno` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `subject_cat_id` int NOT NULL,
  `subject_status_id` int NOT NULL,
  PRIMARY KEY (`subno`),
  KEY `fk_subject_subject_cat1_idx` (`subject_cat_id`),
  KEY `fk_subject_subject_status1_idx` (`subject_status_id`),
  CONSTRAINT `fk_subject_subject_cat1` FOREIGN KEY (`subject_cat_id`) REFERENCES `subject_cat` (`id`),
  CONSTRAINT `fk_subject_subject_status1` FOREIGN KEY (`subject_status_id`) REFERENCES `subject_status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;

INSERT INTO `subject` (`subno`, `name`, `price`, `subject_cat_id`, `subject_status_id`) VALUES
	(1, 'ET', 3000, 1, 1),
	(2, 'SFT', 3000, 1, 1),
	(3, 'ICT', 3000, 1, 1),
	(4, 'ET', 3000, 2, 1),
	(5, 'SFT', 3000, 2, 1),
	(6, 'ICT', 3000, 2, 1),
	(7, 'AI Course', 20000, 4, 1);

CREATE TABLE IF NOT EXISTS `subject_cat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;

INSERT INTO `subject_cat` (`id`, `cat_name`) VALUES
	(1, '2024 A/L'),
	(2, '2025 A/L'),
	(3, '2026 A/L'),
	(4, 'ICT Other Courses 2024'),
	(5, 'Auto Mobile 2024'),
	(6, 'Robotics 2024'),
	(7, 'Electronic 2024'),
	(8, 'test'),
	(9, 'ICT 2020');

CREATE TABLE IF NOT EXISTS `subject_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `s_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

INSERT INTO `subject_status` (`id`, `s_status`) VALUES
	(1, 'Active'),
	(2, 'Deactive'),
	(3, 'Expired');

CREATE TABLE IF NOT EXISTS `teacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `subject_subno` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_has_subject_subject1_idx` (`subject_subno`),
  KEY `fk_user_has_subject_user1_idx` (`user_id`),
  CONSTRAINT `fk_user_has_subject_subject1` FOREIGN KEY (`subject_subno`) REFERENCES `subject` (`subno`),
  CONSTRAINT `fk_user_has_subject_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;

INSERT INTO `teacher` (`id`, `user_id`, `subject_subno`) VALUES
	(4, 6, 7),
	(6, 4, 1),
	(7, 4, 2),
	(9, 10, 4),
	(10, 3, 3),
	(15, 3, 5);

CREATE TABLE IF NOT EXISTS `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nic` varchar(13) NOT NULL,
  `email` varchar(60) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` text NOT NULL,
  `gender_id` int NOT NULL,
  `user_Type_id` int NOT NULL,
  `user_status_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_user_Type_idx` (`user_Type_id`),
  KEY `fk_user_gender1_idx` (`gender_id`),
  KEY `fk_user_user_status1_idx` (`user_status_id`),
  CONSTRAINT `fk_user_gender1` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`),
  CONSTRAINT `fk_user_user_status1` FOREIGN KEY (`user_status_id`) REFERENCES `user_status` (`id`),
  CONSTRAINT `fk_user_user_Type` FOREIGN KEY (`user_Type_id`) REFERENCES `user_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;

INSERT INTO `user` (`id`, `nic`, `email`, `mobile`, `name`, `address`, `gender_id`, `user_Type_id`, `user_status_id`) VALUES
	(1, '200556432432', 'kaviya@gmail.com', '0761222322', 'Kavishka Devinda', 'fgfh fdg efg dfgfdgsdfg dfsg fdsgs fgfdsg', 1, 1, 1),
	(2, '200534534534', 'supun@gmail.com', '0761234322', 'Supun Chanaka', 'Kandy', 1, 1, 1),
	(3, '200512345678', 'meraj@gmail.com', '0761221234', 'Meraj Lakvindu', 'Kandy', 1, 2, 1),
	(4, '200556349043', 'imadu@gmail.com', '0761222322', 'Imadu Nimneth', 'Awissawella', 1, 2, 1),
	(5, '200551234043', 'rashmi@gmail.com', '0761245678', 'Merajge Rashmi', 'Rathnapura', 2, 2, 2),
	(6, '200556345678', 'damitha@gmail.com', '0761245232', 'Damitha Sulochana', 'Japan', 1, 2, 1),
	(7, '200556349043', 'pramudi@gmail.com', '0761234567', 'Pramudi Manesha', 'Japan', 2, 1, 1),
	(8, '200556349043', 'imadu@gmail.com', '0761222322', 'Imadu Nimneth', 'Kohehari', 1, 3, 1),
	(10, '200663490431', 'chalaka@gmail.com', '0712312311', 'Chalaka Vijaya', '', 1, 2, 1),
	(11, '200567890984', 'wenura@gmail.com', '0701234567', 'Wenura Navod', '', 1, 2, 1),
	(12, '200556755675', 'sahan@gmail.com', '0762323232', 'Sahan Rohith', '', 1, 1, 1),
	(13, '123112121212', 'test@gmail.com', '0712121121', 'test12345', '', 2, 1, 1),
	(14, '200512121212', 'tes@gmail.com', '0767654323', 'Test', '', 1, 1, 1);

CREATE TABLE IF NOT EXISTS `user_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `u_status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

INSERT INTO `user_status` (`id`, `u_status`) VALUES
	(1, 'Active'),
	(2, 'Deactive');

CREATE TABLE IF NOT EXISTS `user_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

INSERT INTO `user_type` (`id`, `type`) VALUES
	(1, 'Student'),
	(2, 'Teacher'),
	(3, 'Admin');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
