# 1. Build Stage (เหมือนเดิม)
FROM maven:3.9.6-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# 2. Run Stage (เปลี่ยนจาก alpine เป็นตัวปกติ เพื่อแก้ปัญหา Connection)
FROM eclipse-temurin:17-jdk
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
```

---

### 🚀 ส่งขึ้น Cloud ใหม่
1.  **Terminal:** พิมพ์คำสั่งส่งของขึ้นไป:
    ```powershell
    git add .
    git commit -m "Switch to standard JDK image"
    git push