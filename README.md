# Quotes
> Quotes is a simple project that uses a simple frontend as well as a backend with PostgreSQL and Springboot.

## Features
This project features:
- A website made in HTML/CSS.
- A random quote website.
- A backend written in Java using Springboot.
- PostgreSQL integration in the backend.

## Building
If you wish to build this project, you must have [docker](https://www.docker.com/) installed. Docker is used in this context
to maintain containers and host the project properly. 

To make a new build:
```bash
# If you are on MacOS, you must run this command once.
chmod +x ./mvnw

# Creating a clean build:
./mvnw clean package -DskipTests

# Using Docker to host the backend:
# You may now open up the "index.html" within the "frontend" folder.
docker compose up --build

# Closing Docker (Once you are done!)
docker compose down
```

## Stack
This project uses a simple stack as it is meant to be practice, the tech stack is:

**Frontend:** HTML, CSS, and JavaScript.

**Backend:** Java with Springboot

**Database:** PostgreSQL using JPA

## Credits
Saumil Sharma, Kason Lai, Ceazar Opaon, Ashkan Rahbar Yazdi

This project is licensed under the **MIT license**.
