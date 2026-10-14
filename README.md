# Java JDBC + MySQL Demo

A small JDBC example that connects to a local MySQL database, inserts a student row, and reads student records.

## Requirements

- JDK 17 or later
- MySQL Server
- MySQL Connector/J on the classpath
- A database named `college1` and a `student` table compatible with the demo's three columns

## Configure credentials

Set these environment variables before running the program. Do not commit real credentials.

macOS/Linux:

```bash
export DB_URL='jdbc:mysql://localhost:3306/college1'
export DB_USER='your_mysql_user'
export DB_PASSWORD='your_mysql_password'
```

Windows PowerShell:

```powershell
$env:DB_URL='jdbc:mysql://localhost:3306/college1'
$env:DB_USER='your_mysql_user'
$env:DB_PASSWORD='your_mysql_password'
```

Compile and run with Connector/J available on the classpath. Example (adjust the JAR path):

```bash
javac JdbcDemo.java
java -cp ".:mysql-connector-j.jar" JdbcDemo
`

On Windows, use `; ` rather than `:` as the classpath separator.

## Security notes

- The program reads database credentials from the environment rather than source code.
- Use a dedicated database account with only the permissions needed for the demo.
- Avoid committing database dumps or local environment files.
- The insert example uses a fixed sample ID; rerunning it may conflict with a primary key. Adjust the sample data or schema as needed.
