#NoEnv  ; Recommended for performance and compatibility with future AutoHotkey releases.
; #Warn  ; Enable warnings to assist with detecting common errors.
SendMode Input  ; Recommended for new scripts due to its superior speed and reliability.
SetWorkingDir %A_ScriptDir%  ; Ensures a consistent starting directory.

wb := ComObjCreate("InternetExplorer.Application")
wb.visible := true
wb.navigate("https://ualr.edu/catalogs/undergraduate-catalog/course-codes/")
sleep 10000
;wb.document.getElementsByClassName("ualr-accordion")[0].getElementsByClassName("ualr-accordion-panel")[21].getElementsByTagName("p")[0].innerText
index := 0
Loop
{
	courseCode := ""
	courseDesc := ""
	try
	{
		;~ innerText := wb.document.getElementsByClassName("ualr-accordion")[0].getElementsByClassName("ualr-accordion-panel")[21].getElementsByTagName("p")[index].innerText
		innerText := wb.document.getElementsByClassName("ualr-accordion")[0].getElementsByClassName("ualr-accordion-panel")[42].getElementsByTagName("p")[index].innerText
	}
	catch
	{
		wb.Close
		ExitApp
	}
	;MsgBox %innerText%
	Loop, Parse, innerText, `r
	{
		if (A_Index == 1){
			courseCode := A_LoopField
			continue
			}
		if (A_Index == 2){
			courseDesc := A_LoopField
			continue
			}
		else break
	}
	;MsgBox %courseCode%
	;MsgBox %courseDesc%
	courseSubject := ""
	courseNumber := ""
	courseName := ""
	Loop, Parse, courseCode, " "
	{
		if (A_Index == 1){
			courseSubject := A_LoopField
			continue
			}
		if (A_Index == 2){
			courseNumber := A_LoopField
			continue
			}
		if (A_Index >= 3){
			if (courseName == "")
				courseName := A_LoopField
			else
				courseName := courseName . " " . A_LoopField
			continue
			}
		if (A_Loopfield == "")
			break
	}
	courseDesc := Trim(courseDesc, "`n`r")
	;MsgBox %courseSubject%
	;MsgBox %courseNumber%
	;MsgBox %courseName%
	sqlString := "INSERT INTO COURSE values ('" . courseSubject . "', '" . courseNumber . "', '" . courseName . "', '" . courseDesc . "');`n"
	;MsgBox %sqlString%
	;Send, "INSERT INTO COURSE values ('" . courseSubject . "', '" . courseNumber . "', '" . courseName . "', '" . courseDesc . "');`n"
	Clipboard := sqlString
	Send, ^v
	Send {Enter}
	sleep 500
	;FileAppend, %sqlString%, C:\Users\Christian Weeks\Desktop\sql.txt
	index++
}