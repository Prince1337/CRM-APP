# Verwende das offizielle MySQL-Image als Basis
FROM mysql:latest

# Umgebungsvariablen für MySQL-Konfiguration
ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=mydatabase
ENV MYSQL_USER=myuser
ENV MYSQL_PASSWORD=mypassword

# Exponiere den Standard-MySQL-Port
EXPOSE 3306

# Starte den MySQL-Server
CMD ["mysqld"]