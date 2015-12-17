wsimport:
	wsimport -d src/main/java "http://localhost:8080/BookWS?wsdl" -Xnocompile -encoding utf-8 -B-mark-generated -B-Xsync-methods

build: wsimport
	mvn -B -T 2C clean -Dmaven.test.skip=true
	mvn -B -T 2C package -Dmaven.test.skip=true

test: build
	./cli authors add Siegfried Maier 1975-07-09T00:00:00
	./cli publishers add IT-Verlag 1010 AT
	./cli books import books.xml
