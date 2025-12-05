# 1. Build Stage
FROM maven:3.9.6-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# 2. Run Stage (ใช้ตัวเต็ม Debian เพื่อแก้ปัญหา Connection)
FROM eclipse-temurin:17-jdk
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
```
*(สังเกตว่าต้องไม่มีคำว่า `-alpine` ในบรรทัด `FROM` ตัวที่ 2 นะครับ)*

---

### 🚀 ส่งขึ้น Cloud รอบแก้ตัว
เมื่อแก้ไฟล์เสร็จแล้ว กด Save แล้วรันคำสั่งเดิมเลยครับ:

```powershell
git add .
git commit -m "Fix Dockerfile final"
git push