StokManagement Web Application / Stok Yönetim Web Uygulaması

Bu proje, işletmelerin stok hareketlerini takip edebilmesi için geliştirilmiş bir dinamik stok yönetim sistemidir. Kullanıcılar stok ekleyebilir, güncelleyebilir ve silebilir. Ayrıca Power BI entegrasyonu sayesinde canlı veri analizi ve görselleştirme yapılabilir.

This project is a dynamic stock management system designed for businesses to track stock movements. Users can add, update, and delete stock items. It also includes Power BI integration for live data visualization and analysis.

🔹 Özellikler / Features

Stok Yönetimi / Stock Management

Stok ekleme, güncelleme ve silme / Add, update, and delete stock items

Kullanıcı bazlı işlemler, yetki kontrolü / User-based actions with access control

Dinamik raporlama için API endpointleri / API endpoints for dynamic reporting

Power BI Entegrasyonu / Power BI Integration

Canlı veri analizi ve görselleştirme / Live data analysis and visualization

Sadece görseller Power BI üzerinde gösterilir, güvenlik açıklarına karşı veri korumalı / Only visualizations are shown on Power BI; backend and sensitive data are protected

Güvenlik / Security

JWT tabanlı kullanıcı doğrulama / JWT-based user authentication

Role ve yetki kontrolü / Role-based access control

Hassas veriler Power BI’da gösterilmez / Sensitive data is not exposed in Power BI

Dinamik ve İşletmeye Özel Tasarım / Dynamic & Business-Oriented

İşletmeler için stok takibi ve raporlama odaklı / Focused on stock tracking and reporting for businesses

API ve veri tabanı ile esnek kullanım / Flexible usage with API and database

🔹 Teknolojiler / Technologies

Java 17

Spring Boot 3

Spring Security & JWT

Spring Data JPA

PostgreSQL

Maven

Power BI (canlı veri görselleştirme için)

🔹 Kurulum / Setup

Repository’yi klonlayın / Clone the repository:

git clone https://github.com/cakmaak/StokManagement.git
cd StokManagement


PostgreSQL bağlantı ayarlarını application.properties dosyasında yapılandırın / Configure PostgreSQL connection in application.properties:

spring.datasource.url=jdbc:postgresql://[HOST]:5432/[DB_NAME]
spring.datasource.username=[USERNAME]
spring.datasource.password=[PASSWORD]
spring.jpa.hibernate.ddl-auto=update


Projeyi Maven ile çalıştırın / Run the project with Maven:

mvn spring-boot:run


Uygulama varsayılan olarak http://localhost:8080 adresinde çalışacaktır / The app will run at http://localhost:8080 by default.

🔹 API Endpoints (Örnekler / Examples)

Stok İşlemleri / Stock Operations

POST /stok - Yeni stok ekleme / Add new stock

PUT /stok/{id} - Stok güncelleme / Update stock

DELETE /stok/{id} - Stok silme (sadece ilgili kullanıcı) / Delete stock (only own user)

GET /stok - Tüm stok hareketlerini listeleme / List all stock movements

Kullanıcı ve Yetki / User & Authorization

JWT ile güvenli erişim / Secure access with JWT

Role tabanlı erişim / Role-based authorization

Power BI

API endpointleri Power BI ile bağlanabilir / API endpoints can be connected to Power BI

Canlı veri görselleştirme / Live data visualization

🔹 Kullanım / Usage

Kullanıcı giriş yaptıktan sonra JWT token alır / User receives JWT token after login.

Kullanıcı sadece kendi stok hareketlerini güncelleyebilir / Users can only update their own stock records.

Power BI canlı analizi sadece görselleri gösterir, veri tabanı ve hassas bilgiler korunur / Power BI live analysis shows only visuals; backend and sensitive data are protected.

İşletmeler için dinamik stok takibi ve raporlama sağlar / Provides dynamic stock tracking and reporting for businesses.

🔹 Lisans / License

Bu proje MIT lisansı ile lisanslanmıştır / This project is licensed under MIT License.
