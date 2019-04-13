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
WHERE HASQUALITY.tag_name = 'AI';

-- This is to get all of the courses that have tags that the user has saved.
SELECT DISTINCT HASQUALITY.course_subject, HASQUALITY.course_number
FROM HASQUALITY, INTERESTS
WHERE INTERESTS.user_email='rweeks2010@hotmail.com' AND INTERESTS.tag_name=HASQUALITY.tag_name;
