# oauth-sb-student

This project overrides basic auth of spring security to OAuth2 based auth using google open id.  

Create a new project in google cloud using google api console.  

create new openId credentials for a web app.  

add them in config file.  

start the project.  

visit 

```
localhost:8080/login
```

or
```
localhost:8080/api/v1/user
```

Output

![Screenshot 2024-08-31 165750](https://github.com/user-attachments/assets/d0983ac5-b76d-46a7-aa83-90a1a9e4a43e)

After login, you will get complete principal details.  

![Screenshot 2024-08-31 165858](https://github.com/user-attachments/assets/978a8ff2-d8b4-49a3-9b9c-e24f51f5934f)

--------------------

Added functionality to save user data to postgres DB.  

Create a .env file in resources folder.  

Add these to it.  

```
DB_URL=
DB_USER=
DB_PASSWORD=
CLIENT_ID=
CLIENT_SECRET=
REDIRECT=
```

create database accordingly as well.  

run application.  

visit same urls. after login, check tables.  

Output

![Screenshot 2024-08-31 184006](https://github.com/user-attachments/assets/7f04a163-be50-4e80-ba7a-6889bc5e9b26)

