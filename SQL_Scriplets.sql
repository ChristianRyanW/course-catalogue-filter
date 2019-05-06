-- SQL Script file to pull from for backend

-- Replace my email address with a variable containing an email address of a user to retrieve all courses they have saved to their account. Single quotes are required.
SELECT SAVES.course_subject, SAVES.course_number, COURSE.course_name, COURSE.course_desc
FROM SAVES, COURSE
WHERE SAVES.user_email = 'rweeks2010@hotmail.com' AND SAVES.course_subject=COURSE.course_subject AND SAVES.course_number=COURSE.course_number;

select course_desc
FROM COURSE;

-- This is to save a course to a user account. Replace the strings with variables as before
INSERT INTO SAVES VALUES('MATH', '4400', 'bob@bob.bob');

-- This is to delete a course from the user's saved course list. Replace the strings with the variables.
DELETE
FROM SAVES
WHERE course_subject='MATH' AND course_number='4400' AND user_email='bob@bob.bob';

-- This is to get all courses with a certain tag. Replace the string "AI" with the desired tag value (probably in variable form)
SELECT HASQUALITY.course_subject, HASQUALITY.course_number, COURSE.course_name
FROM HASQUALITY, COURSE
WHERE HASQUALITY.tag_name = 'AI' AND HASQUALITY.course_subject=COURSE.course_subject AND HASQUALITY.course_number=COURSE.course_number;

-- This is to get all courses that have tags matching those selected by the user
SELECT course_subject, course_number, count(*)
FROM HASQUALITY
WHERE HASQUALITY.tag_name = 'AI' OR HASQUALITY.tag_name='Assembly Language' OR HASQUALITY.tag_name='Software' OR HASQUALITY.tag_name='Games'
Group By course_subject, course_number;

SELECT course_subject, course_number, count(*)
FROM HASQUALITY
WHERE HASQUALITY.tag_name = 'AI' OR HASQUALITY.tag_name='Programming' OR HASQUALITY.tag_name='Games'
Group By course_subject, course_number
order by count(*) DESC;

SELECT HASQUALITY.course_subject, HASQUALITY.course_number, COURSE.course_name, COURSE.course_desc, count(*)
FROM HASQUALITY, COURSE
WHERE (HASQUALITY.tag_name = 'AI' OR HASQUALITY.tag_name='Programming' OR HASQUALITY.tag_name='Games') AND HASQUALITY.course_subject=COURSE.course_subject AND HASQUALITY.course_number=COURSE.course_number
Group By HASQUALITY.course_subject, HASQUALITY.course_number
order by count(*) DESC;

-- This is to get all the tags associated with a course
SELECT HASQUALITY.tag_name
FROM HASQUALITY
WHERE HASQUALITY.course_subject='CPSC' AND HASQUALITY.course_number='4377';

select * from tag;

-- This is to get all of the courses that have tags that the user has saved and their count
SELECT DISTINCT HASQUALITY.course_subject, HASQUALITY.course_number, COURSE.course_name, COURSE.course_desc, getCourseTagCount(HASQUALITY.course_subject, HASQUALITY.course_number, 'rweeks2010@hotmail.com')
FROM HASQUALITY, INTERESTS, COURSE
WHERE INTERESTS.user_email='rweeks2010@hotmail.com' AND INTERESTS.tag_name=HASQUALITY.tag_name AND HASQUALITY.course_subject=COURSE.course_subject AND HASQUALITY.course_number=COURSE.course_number;

-- Get list of all tags in database
SELECT tag_name
FROM TAG;

-- For use in maintaining a session. When token expires from user machine, the server requests a new token for them and deletes the old one.
SELECT TOKEN.user_email
FROM TOKEN
WHERE TOKEN.token='token_var';

INSERT INTO TOKEN VALUES ('token_var', 'user_email_var');

-- get user password hash using email
SELECT password_hash
FROM USER
WHERE user_email='user_email_variable';

-- Get list of admins
SELECT USER.user_email
FROM USER
WHERE USER.is_admin='1';



UPDATE USER
SET is_admin = 1
WHERE USER.user_email='rweeks2010@hotmail.com';

-- This is to get a list of all users that have verified their account with a UALR email address
SELECT USER.user_email, UALREMAIL.ualr_email
FROM USER, UALREMAIL
WHERE USER.user_email=UALREMAIL.user_email;

-- For admin use, gets list of tags suggested by users so they can be made official tags
SELECT SUGGESTEDTAGS.course_subject, SUGGESTEDTAGS.course_number, COURSE.course_name, SUGGESTEDTAGS.tag_name
FROM COURSE, SUGGESTEDTAGS
WHERE SUGGESTEDTAGS.course_subject=COURSE.course_subject AND SUGGESTEDTAGS.course_number=COURSE.course_number
ORDER BY COURSE.course_name;

DELIMITER $$
CREATE FUNCTION getCourseTagCount(course_sub varchar(4), course_num varchar(4), user_mail varchar(255)) 
RETURNS bigint(20)
    READS SQL DATA
BEGIN
	DECLARE courseTagCount BIGINT;
    
    SELECT DISTINCT COUNT(*)
    INTO courseTagCount
    FROM HASQUALITY
    WHERE HASQUALITY.course_subject=course_sub 
		AND HASQUALITY.course_number=course_num 
		AND HASQUALITY.tag_name IN (SELECT INTERESTS.tag_name
								 FROM	INTERESTS
                                 WHERE 	INTERESTS.user_email=user_mail);
    
    RETURN (courseTagCount);
END$$
DELIMITER ;


-- This is to select all used tags
SELECT HASQUALITY.tag_name
FROM HASQUALITY;

-- This is to add a saved tag to the database for a certain user.
INSERT INTO INTERESTS VALUES ('tag_name_var', 'user_email_var');

-- This is to delete a saved tag from the database for a certain user
DELETE
FROM INTERESTS
WHERE tag_name='tag_name_var' AND user_email='user_email_var';

select count(*)
FROM course;

SELECT COURSE.course_subject, COURSE.course_number, COURSE.course_name, COURSE.course_desc, GROUP_CONCAT(DISTINCT tag_name ORDER BY tag_name SEPARATOR ', ') tag_name
FROM COURSE
JOIN HASQUALITY ON (HASQUALITY.course_subject=COURSE.course_subject AND HASQUALITY.course_number=COURSE.course_number)
GROUP BY COURSE.course_number;

SELECT COURSE.course_subject, COURSE.course_number, COURSE.course_name, COURSE.course_desc, GROUP_CONCAT(DISTINCT tag_name ORDER BY tag_name SEPARATOR ', ') tag_name
FROM COURSE
JOIN HASQUALITY ON (HASQUALITY.course_subject=COURSE.course_subject AND HASQUALITY.course_number=COURSE.course_number)
GROUP BY COURSE.course_number;

Select distinct course.course_subject, course.course_number, course.course_name
from course, hasquality
where course.course_subject!=HASQUALITY.course_subject AND course.course_number!=HASQUALITY.course_number;

	INSERT INTO hasquality values ('IFSC', '1105', 'First Year');
	INSERT INTO hasquality values ('IFSC', '1110', 'Ethics');
	INSERT INTO hasquality values ('IFSC', '1110', 'Intro');
	INSERT INTO hasquality values ('IFSC', '1202', 'Object-Oriented');
	INSERT INTO hasquality values ('IFSC', '1202', 'Programming');
	INSERT INTO hasquality values ('IFSC', '1310', 'Web Design');
	INSERT INTO hasquality values ('IFSC', '2200', 'ETHICS');
	INSERT INTO hasquality values ('IFSC', '2300', 'Object-Oriented');
	INSERT INTO hasquality values ('IFSC', '2305', 'Computer Systems');
	INSERT INTO hasquality values ('IFSC', '2315', 'Computer Systems');
	INSERT INTO hasquality values ('IFSC', '2340', 'Software');
	INSERT INTO hasquality values ('IFSC', '3300', 'Networks');
	INSERT INTO hasquality values ('IFSC', '3315', 'Networks');
	INSERT INTO hasquality values ('IFSC', '3320', 'Database');
	INSERT INTO hasquality values ('IFSC', '3330', 'Database');
	INSERT INTO hasquality values ('IFSC', '3342', 'Mobile');
	INSERT INTO hasquality values ('IFSC', '3360', 'Computer Systems');
	INSERT INTO hasquality values ('IFSC', '3391', 'Software');
	INSERT INTO hasquality values ('IFSC', '3392', 'Software');
-- INSERT INTO hasquality values ('IFSC', '4301', 'Theory');
	INSERT INTO hasquality values ('IFSC', '4325', 'Data Mining');
	INSERT INTO hasquality values ('IFSC', '4330', 'Database');
	INSERT INTO hasquality values ('IFSC', '4330', 'Security');
	INSERT INTO hasquality values ('IFSC', '4339', 'Networks');
	INSERT INTO hasquality values ('IFSC', '4339', 'Security');
-- INSERT INTO hasquality values ('IFSC', '4345', 'Data Science');
	INSERT INTO hasquality values ('IFSC', '4350', 'E-Commerce');
	INSERT INTO hasquality values ('IFSC', '4360', 'Software');
	INSERT INTO hasquality values ('IFSC', '4376', 'Security');
	INSERT INTO hasquality values ('IFSC', '4391', 'Software');
	INSERT INTO hasquality values ('IFSC', '4392', 'Software');
	INSERT INTO hasquality values ('IFSC', '4396', 'Capstone');
	INSERT INTO hasquality values ('IFSC', '4398', 'Capstone');