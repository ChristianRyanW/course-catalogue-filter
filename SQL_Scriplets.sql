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