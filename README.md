# CRUD app using SpringBoot, Docker and Unit test
#### *Disclaimer:* This is my personal SpringBoot, Docker and Unit test review/practice project. It's not expected to be all correct or nice looking. Its main purpose is for reviewing knowledge and unit tests practicing only!
Original tutorials coming from:
- youtube channel [Dan Vega](https://www.youtube.com/watch?v=UgX5lgv4uVM&ab_channel=DanVega)
- Spring testing web [documents](https://spring.io/guides/gs/testing-web)
## To run this app
open terminal within root folder of this project and run below command to setup Docker container for Postgres database
> docker-compose up

run the CrudExampleApplication to bootstrap the web application. Available routes:
- /api/car/{id}
- /api/car/findAll
- /api/car/add
- /api/car/delete
- /api/car/find/{make}
- /api/user/save
- /api/user/{id}
- /api/user/findAll
- /api/user/deleteById
- /api/user/update


## Thank you for visiting!