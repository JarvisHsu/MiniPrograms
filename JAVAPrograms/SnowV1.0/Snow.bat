::author:Ðì¼ÑÎ°(JarvisHsu)::
::echo Game.class and Snow.class is not exist. 
::javac -encoding utf-8 Game.java Snow.java
::start
@echo off 
echo welcome to use my production
echo This is a MiniProgram , there are 1000 peices of Snow.
echo This Mean It can be Stop.
echo Enjoy it.
IF not exist ./Game.class. IF not exist ./Snow.class. (
	javac -encoding utf-8 Game.java Snow.java
) 
java Game
echo end
pause
