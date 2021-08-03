# RSS-WEB-READER

The RSS-WEB-READER is a simple RSS reader that is being developed using Java SAX API, Docker Compose and PostgreSQL.
The front-end is not the focus of this project, however improvements will be made.

## Requirements

- Docker
- Docker Compose
## How To Run

Simply run `docker-compose up` in the project folder.

Compose will set up PostgreSQL 13.3 & Tomcat 9.0.50 (8080).

Access [localhost:8080/rss-web-reader/addRSS.jsp](http://localhost:8080/rss-web-reader/addRSS.jsp) to add RSS link and then access [localhost:8080/rss-web-reader/](http://localhost:8080/rss-web-reader/) to view feed.