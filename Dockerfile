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
*(โค้ดนี้จะสั่งให้ Cloud โหลด Maven มา Compile โค้ดคุณ แล้วเอาไฟล์ที่ได้ไปรันครับ)*

---

#### 2. เอาโค้ดขึ้น GitHub (โกดังเก็บของ)
ถ้าคุณยังไม่มีบัญชี GitHub ให้สมัครก่อนนะครับ (ฟรี)

**วิธีเอาโค้ดขึ้น (แบบง่ายที่สุดสำหรับมือใหม่):**
1.  ล็อกอินเข้าเว็บ **GitHub.com**
2.  กดปุ่ม **+ (New Repository)** มุมขวาบน
3.  ตั้งชื่อว่า `logistics-backend` -> กด **Create repository**
4.  คุณจะเห็นหน้าที่มีลิงก์ `https://github.com/....` ให้เปิดหน้านี้ค้างไว้
5.  กลับมาที่ **VS Code** (เปิดโฟลเดอร์ `backend` ไว้นะครับ)
6.  เปิด Terminal แล้วพิมพ์คำสั่งตามนี้ทีละบรรทัด:

```powershell
git init
git add .
git commit -m "First commit"
git branch -M main
# บรรทัดข้างล่างนี้ ให้ก๊อปปี้จากหน้าเว็บ GitHub ของคุณมาวาง (ที่ขึ้นต้นว่า git remote add origin...)
git remote add origin https://github.com/ชื่อคุณ/logistics-backend.git 
git push -u origin main