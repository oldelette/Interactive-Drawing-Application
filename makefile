all: compile

compile:
	javac DrawPanel.java
	javac Frame.java
	javac MyOwnShape.java
	javac MyLine.java
	javac MyOval.java
	javac MyRectangle.java
	javac MyRoundRect.java
	javac MyShape.java
	javac Mytest.java
	
	java Mytest

