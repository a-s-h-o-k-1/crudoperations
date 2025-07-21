# 🚀 Java Application Build Guide

This project is a Java application built using **Java 17** and **Maven 3.9**.

This README provides step-by-step instructions to build and run the application directly on your local system without Docker.

---

## 📦 Prerequisites

Make sure the following software is installed on your machine:

| Tool     | Version                  | Download Link                          |
|----------|--------------------------|-----------------------------------------|
| Java     | 17 (Temurin/OpenJDK)     | [Download Java 17](https://adoptium.net/) |
| Maven    | 3.9                      | [Download Maven](https://maven.apache.org/download.cgi) |
| Git      | Latest                   | [Download Git](https://git-scm.com/downloads) |

### ✅ Verify Installations

Run these commands in your terminal to check versions:

```bash
java --version
# Expected: openjdk 17.x.x

mvn --version
# Expected: Apache Maven 3.9.x

git --version
# Expected: git version x.x.x


## 📦 Prerequisites

Make sure the following software is installed on your machine:

| Tool     | Version                  | Download Link                          |
|----------|--------------------------|-----------------------------------------|
| Java     | 17 (Temurin/OpenJDK)     | [Download Java 17](https://adoptium.net/) |
| Maven    | 3.9                      | [Download Maven](https://maven.apache.org/download.cgi) |
| Git      | Latest                   | [Download Git](https://git-scm.com/downloads) |

### ✅ Verify Installations

Run these commands in your terminal to check versions:
```bash
java --version
# Expected: openjdk 17.x.x

mvn --version
# Expected: Apache Maven 3.9.x

git --version
# Expected: git version x.x.x

 Step 1: Clone the repository
bash

git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name

 Step 2: Build using Maven   
mvn clean package
This will:

Clean any previous builds

Compile the Java code

Run tests

Package the application into a JAR file

After a successful build, the JAR file will be located in the target/ directory:
target/your-application-name.jar

🧪 Run the Application
You can run the built JAR file using Java 17:

bash
Copy
Edit
java -jar target/your-application-name.jar
By default, the application will start on http://localhost:8080.

Make sure JAVA_HOME is set to Java 17:

bash
Copy
Edit
export JAVA_HOME=/path/to/java17
export PATH=$JAVA_HOME/bin:$PATH
If tests fail during mvn clean package and you want to skip tests:

bash
Copy
Edit
mvn clean package -DskipTests
