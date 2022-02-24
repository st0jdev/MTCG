@echo off

REM --------------------------------------------------
REM Monster Trading Cards Game
REM --------------------------------------------------
title Monster Trading Cards Game
echo CURL Testing for Monster Trading Cards Game
echo.

REM --------------------------------------------------
echo 1) Create Users (Registration)
REM Create User
curl -X POST http://localhost:10001/users --header "Content-Type: application/json" -d "{\"Username\":\"kienboec\", \"Password\":\"daniel\"}"
echo.
curl -X POST http://localhost:10001/users --header "Content-Type: application/json" -d "{\"Username\":\"altenhof\", \"Password\":\"markus\"}"
echo.
curl -X POST http://localhost:10001/users --header "Content-Type: application/json" -d "{\"Username\":\"admin\",    \"Password\":\"istrator\"}"
echo.

echo should fail:
curl -X POST http://localhost:10001/users --header "Content-Type: application/json" -d "{\"Username\":\"kienboec\", \"Password\":\"daniel\"}"
echo.
curl -X POST http://localhost:10001/users --header "Content-Type: application/json" -d "{\"Username\":\"kienboec\", \"Password\":\"different\"}"
echo. 
echo.

REM --------------------------------------------------
echo 2) Login Users
curl -X POST http://localhost:10001/sessions --header "Content-Type: application/json" -d "{\"Username\":\"kienboec\", \"Password\":\"daniel4\"}"
echo.
curl -X POST http://localhost:10001/sessions --header "Content-Type: application/json" -d "{\"Username\":\"altenhof\", \"Password\":\"markus\"}"
echo.
curl -X POST http://localhost:10001/sessions --header "Content-Type: application/json" -d "{\"Username\":\"admin\",    \"Password\":\"istrator\"}"
echo.

echo should fail:
curl -X POST http://localhost:10001/sessions --header "Content-Type: application/json" -d "{\"Username\":\"kienboec\", \"Password\":\"different\"}"
echo.
echo.

REM --------------------------------------------------
echo 3) Show stats
curl -X POST http://localhost:10001/stats --header "Content-Type: application/json" -d "{\"Username\":\"kienboec\"}"
echo.																																																																																		 				    
curl -X POST http://localhost:10001/stats --header "Content-Type: application/json" -d "{\"Username\":\"altenhof\"}"
echo.																																																																																		 				    
curl -X POST http://localhost:10001/stats --header "Content-Type: application/json" -d "{\"Username\":\"admin\"}"
echo.
echo.

REM --------------------------------------------------
echo 4)Show scoreboard
curl -X GET http://localhost:10001/scoreboard --header "Content-Type: application/json" -d "{\"Username\":\"kienboec\"}"
echo.
echo.

REM --------------------------------------------------
echo 5) Wins/Losses
curl -X POST http://localhost:10001/loss --header "Content-Type: application/json" -d "{\"Username\":\"kienboec\"}"
echo.
curl -X POST http://localhost:10001/win --header "Content-Type: application/json" -d "{\"Username\":\"kienboec\"}"
echo.
curl -X POST http://localhost:10001/win --header "Content-Type: application/json" -d "{\"Username\":\"kienboec\"}"
echo.
curl -X POST http://localhost:10001/win --header "Content-Type: application/json" -d "{\"Username\":\"kienboec\"}"
echo newStats
curl -X POST http://localhost:10001/stats --header "Content-Type: application/json" -d "{\"Username\":\"kienboec\"}"
echo.
echo.

REM --------------------------------------------------
echo 6) changePassword
curl -X POST http://localhost:10001/changepw --header "Content-Type: application/json" -d "{\"Username\":\"kienboec\", \"Password\":\"daniel\",\"NewPassword\":\"daniel2\",\"ConfNewPassword\":\"daniel2\"}
echo.
echo.
REM --------------------------------------------------
echo end...

REM this is approx a sleep 
ping localhost -n 100 >NUL 2>NUL
@echo on
