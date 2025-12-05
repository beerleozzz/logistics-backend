# 1. ใช้ Maven เพื่อสร้างไฟล์ .jar (Build Stage)
FROM maven:3.9.6-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# 2. ใช้ Java 17 เพื่อรันโปรแกรม (Run Stage)
FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
```
