# MyBigNumberProject

Đây là project Java mô phỏng thuật toán cộng 2 số lớn dưới dạng chuỗi, tương tự cách học sinh tiểu học thực hiện (từng chữ số một, có nhớ).

##  Mục tiêu

- Cộng hai chuỗi số lớn (`String`) mà không dùng kiểu `int` trực tiếp.
- Ghi log từng bước cộng và phần nhớ sử dụng `java.util.logging.Logger`.
- Kiểm thử tự động bằng **JUnit 4** để đảm bảo kết quả chính xác.

---

##  Cấu trúc thư mục

```plaintext
MyBigNumberProject/
├── pom.xml                      <-- Cấu hình Maven, khai báo thư viện JUnit
├── src/
│   ├── main/
│   │   └── java/
│   │       └── MyBigNumber.java       <-- File chứa hàm cộng chuỗi lớn
│   └── test/
│       └── java/
│           └── MyBigNumberTest.java   <-- File chứa các Unit Test (JUnit)
