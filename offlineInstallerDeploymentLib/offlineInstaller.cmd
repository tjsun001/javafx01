@echo on

:: Get ADMIN Privs
:-------------------------------------
mkdir "%windir%\BatchGotAdmin"
if '%errorlevel%' == '0' (
  rmdir "%windir%\BatchGotAdmin" & goto gotAdmin 
) else ( goto UACPrompt )

:UACPrompt
    echo Set UAC = CreateObject^("Shell.Application"^) > "%temp%\getadmin.vbs"
    echo UAC.ShellExecute %0, "", "", "runas", 1 >> "%temp%\getadmin.vbs"

    "%temp%\getadmin.vbs"
    exit /B

:gotAdmin
    if exist "%temp%\getadmin.vbs" ( del "%temp%\getadmin.vbs" )
    pushd "%CD%"      
    CD /D "%~dp0"
:-------------------------------------
:: End Get ADMIN Privs

java  -cp offlineinstaller.jar;jfxrt.jar;FPS_logo_2018.png offlineinstaller.offlineinstaller.Main --doAutoReboot=true --wsusHome= --wsusHome=c:\Users\Administrator\Downloads\wsus
