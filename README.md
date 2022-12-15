# Movie review database

by `Runtime Terror`

(Sara, Saad, Radhika, Isabel)

Welcome to our README for our BNTA back-end project: an API that let's you post reviews about movies (and read other user's reviews)! :smiley: 

## Technologies used

Java 17.0.5
 
Spring Boot:
1. Spring Web
2. Spring Boot DevTools
3. Spring Data JPA
4. PostgreSQL Driver

 ## Installation
  1. Clone project from GitHub
  2. Open project in IntelliJ
  3. Create a Postgres database called "movie_reviews_db"
 
 ## Project aims
 To establish an MVP:
  - A restful API that allows its users to post and search for reviews about movies.
  - Implement a many-to-one relationship between a Review class and both a User and Movie class.
  - CRUD functionality:
    - Create (@Post)
      
      - Movies: Creates a new movie object (with title, genre, duration and year) and saves it to the movie repository.
      
      - Users: Creates a new user object (with name) and saves it to the user repository.
      
      - Reviews: Creates a new review object (rating and review body) and saves it to the user repository.
      
    - Read (@Get)
      
      - Movies: Displays all movies, and allows for filtering of movies by: title, genre, duration and year.
      
      - Users: Displays all users, and allows for filtering of users by: name.
      
      - Reviews: Displays all reviews, and allows for filtering of reviews by: rating, review body, movie id/title and user id/name.
      
    - Update (@Patch)

      - Movies: Allows users to update movies on the database - update title, genre, duration and year.
      
      - Users: Allows users to update users on the database - update name.
      
      - Reviews: Allows users to update reviews on the database - update name.
      
    - Delete (@Delete)

      - Movies: Deletes a movie object and all its corresponding reviews from the database.
      
      - Users: Deletes a user object and all its corresponding reviews from the database.
      
      - Reviews: Deletes a review object from the database.
    
 To explore and implement Extensions:
  - Implemented filtering options for Review, User and Movie models in repositories.
  - Implemented partial updates in services classes for each Class for use via @PatchMapping in controllers.
  - Implemented a point system
  - Explored implementing a generic service interface via class inheritance
 
- Any relevant diagrams such as ERDs or UML diagrams

Three models are included: Review, Movie and User.

<img width="924" alt="UML and ERD" src="https://user-images.githubusercontent.com/20325422/207849156-5654cbf4-3dd3-48e5-8775-b66a75697b83.png">

- A list of example routes and what information they expect to receive
 
   - Please provide example data and the exact path of each implemented route 
 
   - Routes should be in a list organised **by-route** and not by request method (i.e. `GET`, `POST`)
 
- Further extensions that you would have liked to include (to provide context) 
 
- While you should aim to test your app thoroughly, squashing any persistent bugs, the README should contain any additional quirks that a user should be made aware of
  - Derived queries in Repositories for filtering requests.
