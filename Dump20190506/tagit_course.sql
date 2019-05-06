-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: tagit
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `course` (
  `course_subject` varchar(4) NOT NULL,
  `course_number` varchar(4) NOT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `course_desc` text,
  PRIMARY KEY (`course_subject`,`course_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('CPSC','1105','First Year Experience for CPSC/IFSC Majors','A survey of the Computer and Information Science majors with coverage of Interpersonal and Team Communication skills, Time Management & Goal Setting, Techniques for Discovering, Organizing & Presenting Information, Self-Initiated Learning, and Overview of Campus-based resources. Activities include service learning projects, field trips, guest speakers, demonstrations, faculty presentations, and social networks. Two hour lab per week. One credit hours.'),('CPSC','1175','Introduction to Computer Science Laboratory','Prerequisite: MATH 1302 or equivalent. Corequesite: CPSC 1375. A laboratory course to accompany CPSC 1375. Introduction to creating, editing, compiling, and executing programs on various platforms and in various application programming environments. Emphasis is on teaching students how to use the local programming environment and their own personal computers to do computer programming. Successful completion of this course requires a grade of C or greater. Two laboratory hours per week. One credit hour.'),('CPSC','1310','Internet Technologies','See IFSC 1310. Internet Technologies.'),('CPSC','1370','Computer Literacy','The fundamental concepts of computing in a personal computer environment. Introduction to hardware and software and system configurations. The focus is on practical problem solving using popular PC application software for word processing, spreadsheets, and databases. This course may not be counted for credit toward a computer science major or minor. Three hours lecture per week. Three credit hours. (ACTS Course Number CPSI 1003)'),('CPSC','1372','RPG Programming ','Prerequisite: CPSC 1375, MGMT 1310, or equivalent. Report Program Generator is a nonprocedural language for data processing. Input, output, arithmetic, comparison, control breaks, arrays, sequential files, direct-access files. This course may not be counted for credit toward a computer science major or minor. Three hours lecture per week. Three credit hours.'),('CPSC','1375','Programming I','Introduction to algorithm development and implementation using control structures, functions, arrays, pointers, and basic object-oriented concepts.'),('CPSC','2376','Programming II','Prerequisite: CPSC 1375. Advanced programming concepts including structures, abstract data types, details of object-oriented concepts including encapsulation and polymorphism in current object-oriented language. Successful completion of this course requires a grade of C or greater. Three hours lecture per week. Three credit hours.'),('CPSC','2377','Introduction to Game Programming','Prerequisites: CPSC 1375, IFSC 2300 SYEN 1302. Advanced programming concepts including structures, abstract data types, recursive techniques, game based hands-on experiences for students to learn and understand details of advanced object-oriented concepts in a current object-oriented language. Successful completion of this course requires a grade of C or greater. Three hours lecture per week. Three credit hours.'),('CPSC','2380','Data Structures and Algorithms','Introduction to machine architecture, detailed study of the PC instruction set and addressing modes. Assembling, linking, executing, and debugging of assembly language programs. Additional topics include keyboard and screen handling, string processing, interrupts, binary and decimal arithmetic.'),('CPSC','2382','Introduction to Computer Systems and Assembly Language','Prerequisite: CPSC 1375 or equivalent. Introduction to machine architecture, detailed study of the PC instruction set and addressing modes. Assembling, linking, executing, and debugging of assembly language programs. Additional topics include keyboard and screen handling, string processing, interrupts, binary and decimal arithmetic. Three hours lecture per week. Three credit hours.'),('CPSC','2391','Cooperative Education','Prerequisites: major in computer science, CPSC 2376 or CPSC 2377, and consent of department chairperson. Designed to complement and extend the classroom learning experience through the application of theoretical concepts in a professional work environment. A minimum of 200 hours of work with a participating employer. The exact number of work hours, activities, and responsibilities are dependent on the nature of the work experience and must be specified in written agreements coordinated with the Office of Cooperative Education. Three credit hours.'),('CPSC','2399','Special Topics','Prerequisite: CPSC 1370, 1375, or equivalent or the consent of the instructor. Introduction to a programming language to be selected from the following list: Visual BASIC, C, ADA, Perl, XML, scripting languages, Internet programming. This course may be repeated with a different language. This course is not accepted for credit in the computer science major or minor. Three hours lecture per week. Three credit hours.'),('CPSC','3370','Net-centric Computing: Systems Concepts','Prerequisites: CPSC 2380 and CPSC 2382. Coverage of systems programming of net-centric computing systems. Hands-on experiences for students to learn how net-centric computing systems work and writing net-centric computing applications. Three hours lecture per week. Three credit hours.'),('CPSC','3371','Net-centric Computing: Language Concepts','Prerequisites: CPSC 2380 and CPSC 2382. Coverage of language design issues for net-centric computing systems. Hands-on experiences for students to learn and understand tradeoffs between applicative needs compared to language design and implementation issues. Three hours lecture per week. Three credit hours.'),('CPSC','3372','System Utilities','Prerequisite: CPSC 2376 or CPSC 2377. Job steps, file identification, program storage, data storage, cataloged procedures, libraries, utility programs. Three hours lecture. Three credit hours.'),('CPSC','3375','Database Concepts I','Prerequisites: CPSC 2380, MATH 2310. In-depth study of data models including E-R, EER, Relational, object relational, and other current models; Data language including relational algebra, relational calculus, SQL, and QBE; Database design including functional dependency and normalization; Database implementation using popular DBMSs; Application development using embedded SQL enhanced by web technology. Three hours lecture per week. Three credit hours.'),('CPSC','3380','Operating System','Buffering, physical input/output, and data management. Loaders, linkage editors, and relocation. Multiprogramming, scheduling resource allocation, and virtual memory. Three hours lecture per week.'),('CPSC','3381','Enterprise COBOL Application Development','Prerequisites: CPSC 2376, CPSC 2377, or consent of the instructor. Accelerated programming in COBOL. Includes organization of COBOL programs, input, output, data manipulations, and tables, file organization, and file access methods. Subprogram, introduction to CICS programming. Three hours lecture per week. Three credit hours.'),('CPSC','3383','Language Structure','Prerequisites: CPSC 2380; MATH 2310. Concepts of syntax and semantics of grammars and languages. Study and comparison of the organization and major constructs of various programming language paradigms, with in-depth study of several specific languages. Implementation and compiler/interpreter-related issues. Three hours lecture. Three credit hours.'),('CPSC','3385','File Structures and Multimedia','Prerequisites: CPSC 2380 and MATH 1452 or equivalent. In-depth study of sequential, indexed, and direct file structure; buffering, indexing; file systems; markup file structures including XML. Modern file representation including image files and sound files; Multimedia technology including CD-ROM, DVDs, and tape storage. Three hours lecture per week. Three credit hours.'),('CPSC','3386','Information Storage and Retrieval','Prerequisites: CPSC 2380, MATH 2310, 1452 or equivalent. The analysis of information content by statistical, syntactic, and logical methods. Search and matching techniques. Automatic retrieval systems, question answering systems. Evaluation of retrieval effectiveness. Three hours lecture per week. Three credit hours.'),('CPSC','3387','Simulation Methods','Introduction to the design and analysis of discrete probabilistic systems using simulation. Basic concepts in modeling and analysis for both continuous and discrete systems are covered. Combined simulation methods, including integrated qualitative/quantitative system modeling. Emphasizes model construction and simulation language.'),('CPSC','3391','Cooperative Education','Prerequisites: major in computer science, completion of the computer science freshman and sophomore core, and consent of department chairperson. Further work experiences to complement and extend the classroom learning experience through the application of theoretical concepts in a professional work environment. A minimum of 200 hours work with a participating employer. The exact number of work hours, activities, and responsibilities are dependent on the nature of the work experience and must be specified in written agreements coordinated with the Office of Cooperative Education. Three credit hours.'),('CPSC','3482','Computer Organization I','Prerequisites: CPSC 2382 and MATH 2310 or equivalents. Computer history and technology. Computer subsystems and components. Instruction Set Architecture. Computer arithmetic, and codes. Hardwired versus microprogrammed control. Memory design. Bus systems and I/O devices. Computer performance. Architecture examples. Three hours lecture and two hours laboratory per week. Four credit hours.'),('CPSC','4360','Computer Security','Prerequisite: CPSC 3380 or consent of instructor. Junior standing or above. Increasing reliance on our computer-based infrastructure elements along with information-driven nature of today’s business require a solid and in depth understanding of security issues pertinent to the systems. The topics include threats, assumptions, assurance, confidentiality, integrity, availability, access control matrix and policies, security models, requirements imposed by policies, protection models, covert channels, formal methods for security, designing and evaluating systems, intrusion detection, auditing and other contemporary issues. Three hours lecture per week. Three credit hours.'),('CPSC','4366','Interactive Computer Graphics and Animation','Prerequisite: MATH 2310 and knowledge of C, C++, or Java programming. This course addresses topics such as introduction to computer graphics and all the details of design of modern graphics architectures. The topics covered include two and three dimensional modeling and transformation, lighting and shading, animation techniques, introduction to OpenGL. Dual-listed in the Graduate Catalog as CPSC 5366. Three hours lecture per week. Three credit hours.'),('CPSC','4367','Mobile Apps Development','Prerequisite: CPSC 2380 or equivalent, with grade of C or greater. Mobile devices are becoming ubiquitous and developers are rushing to build applications for them. In this course, we will be learning how to develop mobile applications for popular mobile platforms. Students will learn skills for creating and deploying real-world mobile applications. Solid skills of programming and application development and good knowledge of software engineering are necessary for successful completion of this course. Dual-listed in the Graduate Catalog as CPSC 5367. Three hours lecture per week. Three credit hours.'),('CPSC','4370','Theory of Computation','Prerequisites: CPSC 3383, MATH 2310. A study of the main areas of theoretical computer science and their hierarchical interconnections. Basic results relating to formal models of computation, with emphasis on grammars and languages, finite automata, Turing machines, and computational complexity. Dual-listed in the Graduate Catalog as CPSC 5370. Three hours lecture per week. Three credit hours.'),('CPSC','4371','Computer Documentation','Prerequisite: Senior standing in computer science and consent of instructor. The design and development of computer system documentation with emphasis on user documentation. Practical experience in writing a user manual using structured design methodology. Discussion of online documentation, hypertext, and emerging documentation technologies. Three hours lecture per week. Three credit hours.'),('CPSC','4372','Object-oriented Programming','Prerequisites: working knowledge of a procedural programming language and UNIX operating system, or consent of the instructor. Concepts of object-oriented analysis, design, and implementation. Object-oriented programming in C++, Smalltalk, Java, and/or another current object-oriented programming language. Dual-listed in the Graduate Catalog as CPSC 5372. Three hours lecture. Three credit hours.'),('CPSC','4373','Fundamentals of Software Engineering','Prerequisites: CPSC 3380, CPSC 3383 or equivalent, and MATH 1452. Requirements definition, analysis and modeling including use cases and use case paths, domain models, state transition diagrams; techniques to increase robustness and avoid disastrous defects; object-oriented architecture and design patterns and specifications in UML; performance impact of design choices; analysis of designs regarding maintainability and testability; security engineering; practical system test and glass-box testing fundamentals; verification of test coverage via decision tables and state transition table . Dual-listed in the Graduate Catalog as CPSC 5373. Three hours lecture per week. Three credit hours.'),('CPSC','4375','Fundamentals of Database Management Systems','Prerequisites: CPSC 3375 or equivalent. Advanced topics related to the design and efficient implementation of modern database management systems. Concurrency and transaction management, database security, query processing, query optimization, physical database storage, and indexing. Dual-listed in the Graduate Catalog as CPSC 5375. Three hours lecture per week. Three credit hours.'),('CPSC','4376','Applied Cryptography','Prerequisites: CPSC 2380, MATH 2310, and STAT 3352 or equivalents. A survey and study of the major cryptographic techniques, algorithms, and implementations, with emphasis on applications to communications and network security. Intended as a practical introduction to the current state-of-the-art of cryptographic usage. Dual-listed in the Graduate Catalog as CPSC 5376. Three hours lecture. Three credit hours.'),('CPSC','4377','Advanced Game Programming','The course will cover implementation of numerous advanced programming techniques: resource management, graphical interfaces, physics, collision detection and resolution, non-player characters, and media integration. The examples and programming assignments make extensive use of multiple external C++ libraries. The class will also cover select theoretical aspects of game programming and development.'),('CPSC','4381','Computer Architecture and Design','Prerequisite: CPSC 3482. Formal description of computer architecture and design, instruction set architectures, processor design of modern computers, pipeline and instruction level parallelism, memory system design, and input and output system design. Dual-listed in the Graduate Catalog as CPSC 5381. Three hours lecture per week. Three credit hours.'),('CPSC','4382','Compiler Construction and Theory ','Prerequisites: CPSC 3383. Fundamental principles of compiler design such as finite state machine and context-free grammar. Compilation techniques include compile and run-time symbol tables, lexical analysis, syntax analysis, semantic analysis, object code generation, error diagnostics, and optimization. Dual-listed in the Graduate Catalog as CPSC 5382. Three hours lecture. Three credit hours.'),('CPSC','4383','Artificial Intelligence','Introduction to machine intelligence. Emphasis upon different paradigms for problem solving such as various state-space search strategies and other approaches. Exposure to one or more key areas such as robotics, logic programming, machine learning, expert systems, planning, neural networks, natural language processing, reasoning, under uncertainty, etc.'),('CPSC','4384','Computer Networks','Prerequisites:CPSC 3380 and CPSC 3482. Introduction to design and analysis of computer networks. Computer communications architecture and protocols, local and wide area networks, IP networks, bridging and routing, Ethernet, wireless LANs, sockets programming, and distributed applications. Dual-listed in the Graduate Catalog as CPSC 5384. Three credit hours.'),('CPSC','4387','Distributed Computing','Prerequisites: CPSC 3380. Network-based client/server computing. Topics include TCP/IP, object-oriented technology, distributed objects and their interfaces, JDBC, remote method invocation, CORBA, and web-based software system architecture. Three credit hours.'),('CPSC','4388','Smart Software Systems','Prerequisite: CPSC 3375, MATH 1452. Study of the concept, design, and implementation of rule-based systems, agent-based systems, reasoning, reasoning under uncertainty; belief systems, explanation systems; knowledge representation, knowledge acquisition, and knowledge discovery; and application of knowledge engineering in web technology. Dual-listed in the Graduate Catalog as CPSC 5388. Three hours lecture per week. Three credit hours.'),('CPSC','4389','E-commerce: Analysis, Design, and Implementation','Prerequisites: CPSC 3383, 3375. E-commerce site analysis and design. Web-based system architecture, client/server computing, network protocols, software engineering for web based systems, computer networks, web-based databases, script languages (Java, VB), XML, ASP, SQL, and DSN. Three credit hours.'),('CPSC','4391','Cooperative Education','Prerequisites: major in computer science, CPSC 3391, and consent of department chairperson. Continuation of CPSC 3391. Work experiences to complement and extend the classroom learning experience through the application of theoretical concepts in a professional work environment. A minimum of 200 hours work with a participating employer. The exact number of work hours, activities, and responsibilities are dependent on the nature of the work experience and must be specified in written agreements coordinated with the Office of Cooperative Education. Three credit hours.'),('CPSC','4392','Capstone Project','Prerequisites: CPSC 4373. Capstone course in which student individually design a software system, document and present their conclusions. Students also develop a detailed undergraduate portfolio for a comprehensive review of their undergraduate work. Project work involves the development of design alternatives, development of an appropriate software architecture, and design and test the implemented system. The software design focuses on addressing overall design goals while understanding constraints of cost, etc. Deliverables and schedule are determined by the instructor. Three credit hours.'),('CPSC','4399','Special Topics','Prerequisite: consent of instructor. Advanced topics in areas of current interest in computer science. Refer to the semester schedule for specific topics offered. Dual-listed in the Graduate Catalog as CPSC 5399. Three hours lecture. Three credit hours.'),('IFSC','1105','First Year Experience for IFSC/CPSC Majors','A survey of the Computer and Information Science majors with coverage of Interpersonal and Team Communication skills, Time Management & Goal Setting, Techniques for Discovering, Organizing & Presenting Information, Self-Initiated Learning, and Overview of Campus-based resources. Activities include service learning projects, field trips, guest speakers, demonstrations, faculty presentations, and social networks. Two hours lab per week. One credit hour.'),('IFSC','1110','Introduction to Ethics','See PHIL 1110. One hour lecture per week. One credit hour.'),('IFSC','1202','Introduction to Object-oriented Technology','Prerequisite: Familiarity with using a desktop computer. An introduction to application development using Visual Studio with an emphasis on understanding graphical user interface design and object oriented technology. Topics covered include programming fundamentals (sequence, decision, and repetition), working with forms and controls, and manipulating user input and elementary database files. This is a laboratory computer-based course with hands-on exercises. Two hours lab per week per credit hour. Two credit hours.'),('IFSC','1310','Internet Technologies','This course is an introduction to Internet client-side technologies and standards-based web development. The course will be divided into sections covering the core components of any web site/page. Core components include Structure, Content, Design (presentation), and Behavior'),('IFSC','2200','Ethics in the Profession','This course is a survey of ethics and its applications to Engineering, Computing and Information Technology Professions. It has the twin objectives of (i) Studying professional code of ethics and the responsibilities that they place on technology professionals (ii) Investigating the background and implications of ethical concerns in the real-world professional environment. Two hours lecture per week. Two credit hours.'),('IFSC','2300','Object-oriented Technology','Prerequisites: IFSC 1202 or equivalent or consent of the instructor. Computer programming in Java. Language used to implement applications that employ objects and demonstrate software development by refinement and inheritance. Topics include data types, control structures, repetitive structures; data structures including arrays, lists, queues, stacks, and trees; recursion and File I/O. Two hours lecture and two hours lab per week. Three credit hours.'),('IFSC','2305','Computer Systems','Prerequisite: IFSC 1202 or equivalent or consent of the instructor. In-depth introduction to the components of a personal computer; topics include number systems, identification and organization of CPU, memory, and peripherals; cache technology; bus technology; upgrading, troubleshooting, and maintaining a personal computer. Incorporates hands-on laboratory experiences. Three hours lecture per week. Three credit hours.'),('IFSC','2315','Information Systems Software','Prerequisites: IFSC 2300 and 2305. Computer operating system concepts including processor and memory management, multiprocessing and multiprogramming, inter-process communication, scheduling, virtual memory, device management, input/output, secondary storage and file management, and protection. Three hours lecture per week. Three credit hours.'),('IFSC','2340','Human Computer Interface','Prerequisites: IFSC 1310 and 2300, or consent of instructor. In-depth study of building user interfaces; user requirements, design, aesthetics, and programming. Three hours lecture per week. Three credit hours.'),('IFSC','3300','Internet Applications','Prerequisite: IFSC 1310 or equivalent, or consent of Instructor. A hands-on course focusing on the technologies and concepts for creating dynamic and interactive web sites with a special emphasis on client-side technologies. Topics will cover techniques such as how to build efficient and dynamic interactive user interfaces, how to interface with data using standardized, portable formats, how to store/validate data and how to make data more accessible to other applications. Three hours lecture. Three credit hours.'),('IFSC','3315','Applied Networking','Prerequisite: IFSC 2300 or equivalent or consent of instructor. This course provides a comprehensive understanding of networks, internet applications, and their underlying hardware architecture and software theories. Topics include network protocols, data communication concepts, packet switching technologies, internet protocols, and network issues such as performance, security, and management. Lab exercises are used to demonstrate how network concepts are implemented in practice. Three lecture hours per week. Three credit hours.'),('IFSC','3320','Database Concepts','Prerequisites: junior standing or consent of the instructor. Offers an introduction to the fundamentals and use of relational databases and focuses on four major topics: ER-diagram, relational algebra, SQL language and Oracle. Three hours lecture. Three credit hours.'),('IFSC','3330','Current Trends in Database Technology','Prerequisite: IFSC 3320 or equivalent or consent of the instructor. Current trends in database design and management emphasizing typical applications in business, medicine, and science. Survey of modern database technologies including object-related database technology, query processing and optimization, transaction processing concepts, concurrency control techniques, database security and authorization, data mining, data warehousing, and web search engine technology. Discussion of database management and distributed database management issues. Three hours lecture. Three credit hours.'),('IFSC','3342','Mobile Web Development','Prerequisite: IFSC 1310 or Instructor Approval. This course will take an in-depth look at modem web technologies used in the creation of standards-based websites for use on desktop and mobile devices. We will evaluate and test many approaches in an effort to establish maintainable work-flows and create highly usable sites using a “Mobile First” design philosophy. In addition, this course will explore various tools for testing, versioning and distributing project assets. 2 Hours Lecture I I Hour Lab. Total 3 Credit Hours.'),('IFSC','3360','System Analysis and Design','Prerequisite: IFSC 2300 or equivalent or consent of the instructor. Fundamental concepts of object-oriented software analysis and design including requirements specification, analysis, and design of software; issues in software reuse, software packaging, and software management. Three hours lecture per week. Three credit hours.'),('IFSC','3391','Junior Cooperative Education I','Prerequisites: Junior standing in information science or completion of the Information Technology Minor. This course may be substituted for a major elective with the consent of the chairperson. Work experience to complement and extend the classroom experience through the application of a student’s academic experiences in a professional information technology environment. A minimum of 200 hours of work with the participating employer is required. The exact number of hours per week, activities, and responsibilities are dependent on the nature of the work experience and must be specified in written agreements coordinated with the Office of Cooperative Education. Three credit hours.'),('IFSC','3392','Junior Cooperative Education II','Prerequisites: Junior standing in information science or completion of the Information Technology Minor. This course is designed as a continuing cooperative learning experience beyond IFSC 3391 and may be substituted for a major elective with the consent of the chairperson. Work experience to complement and extend the classroom experience through the application of a student’s academic experiences in a professional information technology environment. A minimum of 200 hours of work with the participating employer is required. The exact number of hours per week, activities, and responsibilities are dependent on the nature of the work experience and must be specified in written agreements coordinated with the Office of Cooperative Education. Three credit hours.'),('IFSC','4301','Information, Computing, and the Future','Topics on information and computing and their interactions with society. Emphasizes the history and present status of information and computing technologies and their implications for possible future changes in the profession, the field, and society. Includes discussion of change as a factor in personal career preparation, goals, and activities. Topics may vary based on student interest and current events. Cross-listed with TINV 4302. Three hours lecture. Three credit hours.'),('IFSC','4325','Data Mining Concepts and Techniques','Prerequisite: IFSC 3320 or equivalent or consent of the instructor. In-depth, practical coverage of essential data mining topics, including OLAP and data warehousing, data pre-processing, concept description, association rules, classification and prediction, and cluster analysis. Advanced topics include mining object-relational databases, spatial databases, multimedia databases, time-series databases, text databases, the World Wide Web, and applications in several fields. Three hours lecture. Three credit hours.'),('IFSC','4330','Database Security','Prerequisite: IFSC 3330 or equivalent or consent of the instructor. Focus on security issues in databases systems and introduction of how current and future commercial systems may be designed to ensure secrecy and confidentiality. Topics include security models, basic security mechanisms and software, statistical database security, intrusion detection, security models for next generation databases, tested techniques and proven strategies for securing an Oracle environment — from the operating system to the database to the network, and how to implement security using Oracle’s built-in tools. Three hours lecture. Three credit hours.'),('IFSC','4339','Network Security','Prerequisite: IFSC 3315 or CPSC 4384 or SYEN 3332 or MGMT 4310, or consent of instructor. This course provides students with a concise and in-depth overview of security issues in current computer networks. It first gives a brief introduction of cryptographic algorithms and protocols underlying network security applications, including encryption, hash function, public key algorithm, digital signatures, and key exchanges. Then, it focuses on the security issues in current computer networks as well as network security tools and applications. The course will cover network intrusion/detection techniques and systems. Three hours lecture. Three credit hours.'),('IFSC','4345','Information Visualization','Prerequisites: MATH 1451 and IFSC 2300, or consent of the instructor. The design and presentation of information. Use of graphics, animation, sound, visualization software, and hypermedia in helping users understand information. Methods of presenting complex information to enhance comprehension and analysis. Incorporation of visualization techniques into human-computer interfaces. Three hours lecture. Three credit hours.'),('IFSC','4350','Electronic Commerce','Prerequisite: IFSC 1310 or ITEC 3610 or equivalent and junior standing or consent of instructor. Seminar style course designed for student to be able to describe and apply different electronic commerce business models. Understand technologies in electronic commerce, including the Internet and WWW, security systems, electronic payment systems, and intelligent agents. Three hours lecture. Three credit hours.'),('IFSC','4360','Social Computing','Prerequisite: IFSC 1310 and IFSC 2300, or equivalent, or consent of Instructor. A hands-on course focusing on concepts of the social and information networks, Web as graph, models (such as Power law distribution, scale-free models, preferential attachment models, etc.) that simulate behavioral characteristics of these graphs, basic graph theoretical concepts, characteristics of social media and Web 2.0 or the Social Web (such as blogs, microblogging, social friendship networks, social bookmarking, social news, social media sharing, wikis, etc.), understanding and developing API and mashups, issues and challenges in data crawling and web analytics, network data visualization, exposure to information extraction and retrieval concepts aiming at the highly dynamic and noisy nature of social media, harnessing the collective and web intelligence, and basic concepts of cloud computing. Three lecture hours. Three credit hours.'),('IFSC','4376','Applied Cryptography','See CPSC 4376 Applied Cryptography Three credit hours.'),('IFSC','4391','Senior Cooperative Education I','Prerequisites: Senior standing in information science and consent of chairperson if substituted for a major elective. Work experience to complement and extend the classroom experience through the application of a student’s academic experiences in information science in a professional information technology environment. A minimum of 200 hours of work with the participating employer is required. The exact number of hours per week, activities, and responsibilities are dependent on the nature of the work experience and must be specified in written agreements coordinated with the Office of Cooperative Education. Three credit hours.'),('IFSC','4392','Senior Cooperative Education II','Prerequisites: Senior standing in information science and consent of chairperson if substituted for a major elective. This course is designed as a continuing cooperative learning experience beyond IFSC 4391. Work experience to complement and extend the classroom experience through the application of a student’s academic experiences in information science in a professional information technology environment. A minimum of 200 hours of work with the participating employer is required. The exact number of hours per week, activities, and responsibilities are dependent on the nature of the work experience and must be specified in written agreements coordinated with the Office of Cooperative Education. Three credit hours.'),('IFSC','4396','Capstone Project I','Prerequisite: IFSC 3330 and 3360. Capstone course in which student teams do an analysis of a live information system, document and present their conclusions. Projects are chosen at the end of IFSC 3330. Teams coordinate their efforts on a sponsor’s site and make regular report to the instructor. Classroom meetings are held as necessary to conduct orientations and hear presentations. Three credit hours.'),('IFSC','4398','Capstone Project II','Prerequisite: IFSC 4396. Continued capstone course in which student teams pursue the design and implementation of system improvements identified in IFSC 4396. Deliverables and schedule are determined by the instructor. Classroom meetings are held as necessary to conduct orientations and hear presentations. Three credit hours.');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-06 10:06:00