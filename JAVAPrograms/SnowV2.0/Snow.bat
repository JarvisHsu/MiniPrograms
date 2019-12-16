::author:Ðì¼ÑÎ°(JarvisHsu)::
::echo Game.class and Snow.class is not exist. 
::javac -encoding utf-8 Game.java Snow.java
::start
@echo off 
echo welcome and use my production
echo This is my MiniProgram , It's Snow version 2.0
echo update more snow.
echo This Mean It never be Stop.
echo Enjoy it.
IF not exist ./Game.class. javac -encoding utf-8 Game.java Snow.java
IF not exist ./Snow.class. javac -encoding utf-8 Game.java Snow.java
java Game
echo end
pause
