# Room Occupancy Manager

## 1. Clone the repo 


    git clone https://github.com/zbyszekpy-code/Occupancy


## 2. Build and start app (from repo folder)

Java 11 or later installed (set JAVA_HOME)


    mvnw.cmd spring-boot:run


## 3. Send test reqest

```
curl --location --request GET 'localhost:8080/calculateUsage?premiumCount=3&economyCount=3' \
--header 'Content-Type: application/json' \
--data-raw '[23, 45, 155, 374, 22, 99, 100, 101, 115, 209]
'
```
