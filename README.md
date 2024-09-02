# note-app-be
note-app-be (SPRING BOOT - DOCKER)  +info 

Avvio attraverso la creazione di un container DOCKER ,comando:

docker run -d --name esis-to-do-list -e POSTGRES_PASSWORD=admin -e POSTGRES_USER=admin -e POSTGRES_DB=esis-to-do-list_db -p 5435:5432 postgres


Avvio del Progetto Spring Boot da Intellij IDE:

-Aprire sul progetto, andare sul file main e RUN

*Se necessario da Maven lanciare un CLEAN e poi INSTALL (disabilitare i test prima se non sono disponibili)
