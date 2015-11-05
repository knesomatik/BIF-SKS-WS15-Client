#!/usr/bin/env bash

wsimport -d src/main/java "http://localhost:9991/BookWS?wsdl" -Xnocompile
