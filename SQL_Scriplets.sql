-- SQL Script file to pull from for backend

-- Replace my email address with a variable containing an email address of a user to retrieve all courses they have saved to their account. Single quotes are required.
SELECT SAVES.course_subject, SAVES.course_number
FROM SAVES
WHERE SAVES.user_email = 'rweeks2010@hotmail.com';


-- This is to save a course to a user account. Replace the strings with variables as before
INSERT INTO SAVES VALUES('MATH', '4400', 'bob@bob.bob');


-- This is to delete a course from the user's saved course list. Replace the strings with the variables.
DELETE
FROM SAVES
WHERE course_subject='MATH' AND course_number='4400' AND user_email='bob@bob.bob';

-- This is to get all courses with a certain tag. Replace the string "AI" with the desired tag value (probably in variable form)
SELECT course_subject, course_number
FROM HASQUALITY
WHERE HASQUALITY.tag_name = 'Games';

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

select * from token;

-- get user password hash using email
SELECT password_hash
FROM USER
WHERE user_email='user_email_variable';

-- Get list of admins
SELECT USER.user_email
FROM USER
WHERE USER.is_admin='1';

select * from USER;

UPDATE USER
SET is_admin = 1
WHERE USER.user_email='tag_admin@gmail.com';

-- This is to get a list of all users that have verified their account with a UALR email address
SELECT USER.user_email, UALREMAIL.ualr_email
FROM USER, UALREMAIL
WHERE USER.user_email=UALREMAIL.user_email;

SELECT SUGGESTEDTAGS.course_subject, SUGGESTEDTAGS.course_number, COURSE.course_name, SUGGESTEDTAGS.tag_name
FROM COURSE, SUGGESTEDTAGS
WHERE SUGGESTEDTAGS.course_subject=COURSE.course_subject AND SUGGESTEDTAGS.course_number=COURSE.course_number
ORDER BY COURSE.course_name;

-- This is to select all used tags
SELECT DISTINCT HASQUALITY.tag_name
FROM HASQUALITY;

INSERT INTO COURSE values ('CPSC', '1105', 'First Year Experience for CPSC/IFSC Majors', '
A survey of the Computer and Information Science majors with coverage of Interpersonal and Team Communication skills, Time Management & Goal Setting, Techniques for Discovering, Organizing & Presenting Information, Self-Initiated Learning, and Overview of Campus-based resources. Activities include service learning projects, field trips, guest speakers, demonstrations, faculty presentations, and social networks. Two hour lab per week. One credit hours.');

DELETE
from COURSE
where course_number='1105' AND course_subject='CPSC';