# project_management_app

# PROFILES:
- dev (runs on H2)
- default (runs on MYSQL)
- currently dev profile is active. to deactivate dev profile, comment 4 line in application.properties

# ENVIRONMENT VARIABLES
- MYSQL credentials are set in .env files
- to set your credentials, edit .env.example and delete suffix .example 
- spring-dotenv, which in turn is based on dotenv-java is a library that enables Spring applications to access and use environment variables from .env files.

