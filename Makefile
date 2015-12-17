wsimport:
<<<<<<< HEAD
	wsimport -d src/main/java "http://localhost:8080/BookWS?wsdl" -Xnocompile -encoding utf-8 -B-mark-generated -B-Xsync-methods
=======
	wsimport -d src/main/java "http://$(shell docker-machine ip default):9991/BookWS?wsdl" -Xnocompile -encoding utf-8 -B-mark-generated -B-Xsync-methods
>>>>>>> f58e01a048e7b79ce479bd018dd14d85ed07d96a

build: wsimport
	mvn -B -T 2C clean -Dmaven.test.skip=true
	mvn -B -T 2C package -Dmaven.test.skip=true

test: build
	./cli --host=$(shell docker-machine ip default):9991 authors add Siegfried Maier 1975-07-09T00:00:00
	./cli --host=$(shell docker-machine ip default):9991 publishers add IT-Verlag 1010 AT
	./cli --host=$(shell docker-machine ip default):9991 books import books.xml
