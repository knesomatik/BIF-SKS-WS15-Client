#!/usr/bin/env bash

wsimport -d src/main/java "http://localhost:8080/BookWS?wsdl" -Xnocompile
