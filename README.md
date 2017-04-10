# stock_test
1) Clonse sourcecode
 - Setup java 8, maven 3.3.xxx
2) Go to stock-test-app folder
3) Run command: mvn clean install
4) Go to stock-test-api folder
5) Run command: mvn spring-boot:run
6) Try use POST Man tool to access rest api:
    - http://localhost:8080/api/v2/GE/closePrice?startDate=2017-01-01&endDate=2017-01-03
    - http://localhost:8080/api/v2/GE/200mda?startDate=2017-01-01
    - http://localhost:8080/api/v2/200mda?startDate=2017-01-01

7) To Test Cache system:
    - First time, Access URL: http://localhost:8080/api/v2/GE/closePrice. This is first time so It loads so slow
    - Second time, Access URL: http://localhost:8080/api/v2/GE/closePrice. Because GE ticker is cached so this request will response so faster
