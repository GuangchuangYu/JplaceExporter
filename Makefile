compile:
	javac -classpath .:beast.jar JplaceExporter.java

test:
	javac -classpath .:beast.jar TEST.java;\
	java -classpath .:beast.jar TEST
