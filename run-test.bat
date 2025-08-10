@echo off
REM Jalankan test
mvn clean test

REM Buat folder sementara untuk simpan history
if exist temp-history rmdir /s /q temp-history
mkdir temp-history

REM Copy history lama kalau ada
if exist report-history\history (
    xcopy report-history\history temp-history\history /E /I /Y
)

REM Generate report baru ke folder report-history
allure generate target\allure-results --clean -o report-history

REM Kembalikan history ke report baru
if exist temp-history\history (
    xcopy temp-history\history report-history\history /E /I /Y
)

REM Buka report di browser
allure open report-history

pause
