-- SQL Script file to pull from for backend

-- Replace my email address with a variable containing an email address of a user to retrieve all courses they have saved to their account. Single quotes are required.
SELECT SAVES.course_subject, SAVES.course_number
FROM SAVES
WHERE SAVES.user_email = 'rweeks2010@hotmail.com';