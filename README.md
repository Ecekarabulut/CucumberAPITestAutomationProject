<div align="center">
 SipayAutomationProject
</div>



# 🐾 Swagger Pet Store API Test Automation Framework

Bu proje, **Swagger Pet Store API** üzerinde test otomasyonu sağlamak için geliştirilmiştir. Proje, BDD yaklaşımı ve REST API test süreçlerini içermektedir.

---

## 🚀 Kullanılan Teknolojiler

- ⚙️ **Java** – Ana programlama dili  
- 🥒 **Cucumber** – BDD (Davranışa Dayalı Geliştirme) framework'ü  
- 📦 **Rest Assured** – REST API testi için kütüphane  
- 🧪 **JUnit** – Test framework'ü  
- ☕ **Maven** – Proje ve bağımlılık yönetimi  

---

## 🧱 Proje Yapısı

- ✅ **POJO Sınıflar:** `Pet`, `Category`, `Tag` sınıfları ile JSON dönüşümleri için modeller oluşturuldu  
- ✅ **API Katmanı:** `PetStoreApi.java` ile Page Object Model benzeri yapıda API çağrıları yönetildi  
- ✅ **Feature Dosyaları:** Gherkin dili kullanılarak anlaşılır senaryolar yazıldı  
- ✅ **Step Definitions:** Test adımları Cucumber step definition'lar ile kodlandı  

---

## 🧪 Test Senaryoları

| İşlem        | Açıklama                            |
|--------------|-------------------------------------|
| ➕ Create     | Yeni bir pet oluşturma             |
| 🔍 Read       | ID ile pet bilgisini getirme        |
| 🔄 Update     | Var olan pet bilgilerini güncelleme |

---

## ✨ Özellikler

- ✅ Gherkin dilinde açık ve anlaşılır test senaryoları  
- ✅ Veri tabanlı testler (Cucumber `DataTable` kullanımı)  
- ✅ OOP prensiplerine uygun mimari yapı  
- ✅ Her test adımında loglama  
- ✅ Status code ve body doğrulamaları  
- ✅ HTML tabanlı raporlama  
- ✅ Detaylı response kontrolü (pet ismi, status vb.)  
- ✅ API yanıt formatı kontrolleri  

---


## ✨ Ekran Görüntüsü

![image](https://github.com/user-attachments/assets/210a0e2a-f7de-474a-a228-6e07d2f036f6)



# POMXML
 
 <?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>APICucumberTestAutomationProject</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <cucumber.version>7.11.1</cucumber.version>
        <rest-assured.version>5.3.0</rest-assured.version>
        <jackson.version>2.15.2</jackson.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- Cucumber Dependencies -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>${cucumber.version}</version>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>${cucumber.version}</version>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-picocontainer</artifactId>
            <version>${cucumber.version}</version>
        </dependency>

        <!-- Rest Assured -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>${rest-assured.version}</version>
        </dependency>

        <!-- Jackson for JSON -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>${jackson.version}</version>
        </dependency>

        <!-- JUnit -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>

        <!-- Extent Reports -->
        <dependency>
            <groupId>com.aventstack</groupId>
            <artifactId>extentreports</artifactId>
            <version>5.0.9</version>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.26</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version>
                <configuration>
                    <includes>
                        <include>**/*Runner.java</include>
                    </includes>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>${maven.compiler.source}</source>
                    <target>${maven.compiler.target}</target>
                    <annotationProcessorPaths>
                        <path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                            <version>1.18.26</version>
                        </path>
                    </annotationProcessorPaths>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project> 
