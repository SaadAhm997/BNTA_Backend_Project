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
  
  <img width="924" alt="UML and ERD" src="https://user-images.githubusercontent.com/20325422/207849156-5654cbf4-3dd3-48e5-8775-b66a75697b83.png">
  
  - CRUD functionality:
    - Create (`@Post`)
      
      - Movies: Creates a new movie object (with title, genre, duration and year) and saves it to the movie repository.
      
      - Users: Creates a new user object (with name) and saves it to the user repository.
      
      - Reviews: Creates a new review object (rating and review body) and saves it to the user repository.
      
    - Read (`@Get`)
      
      - Movies: Displays all movies, and allows for filtering of movies by: title, genre, duration and year.
      
      - Users: Displays all users, and allows for filtering of users by: name.
      
      - Reviews: Displays all reviews, and allows for filtering of reviews by: rating, review body, movie id/title and user id/name.
      
    - Update (`@Patch`)

      - Movies: Allows users to update movies on the database - update title, genre, duration and year.
      
      - Users: Allows users to update users on the database - update name.
      
      - Reviews: Allows users to update reviews on the database - update name.
      
    - Delete (`@Delete`)

      - Movies: Deletes a movie object and all its corresponding reviews from the database.
      
      - Users: Deletes a user object and all its corresponding reviews from the database.
      
      - Reviews: Deletes a review object from the database.
    
 To explore and implement Extensions:
- Implemented filtering options for Review, User and Movie models in repositories.
- Implemented partial updates in services classes for each Class for use via `@PatchMapping` in controllers.
- Implemented a point system
- Explored implementing a generic service interface via class inheritance

## Routes ##
localhost:8080...

|       HTTP Request Path        | Request Type | Description                          |
|:------------------------------:|:-------------|:-------------------------------------|
|           .../users            | GET          | Display all users                    |
|           .../users            | POST         | Add a new user                       |
|          .../users/1           | GET          | Find user by id                      |
|          .../users/1           | PATCH        | Update user                          |
|          .../users/1           | DELETE       | Delete user                          |
|       .../user/?name=Ed        | GET          | Get user by name                     |
|           .../movies           | GET          | Display all movies                   |
|           .../movies           | POST         | Add a new movie                      |
|          .../movies/1          | GET          | Find movie by id                     |
|          .../movies/1          | PATCH        | Update movie details                 |
|          .../movies/1          | DELETE       | Remove a movie                       |
|  .../movies/?title=TheMartian  | GET          | Filter movies by title               |
|    .../movies/?duration=90     | GET          | Filter movies by duration            |
|     .../movies/?year=1990      | GET          | Filter movies by year of release     |
|   .../movies/?genre=thriller   | GET          | Filter movies by genre               |
|          .../reviews           | GET          | Display all reviews                  |
|           .../review           | POST         | Add a new review                     |
|          .../review/1          | GET          | Find review by id                    |
|          .../review/1          | PATCH        | Update a review                      |
|          .../review/1          | DELETE       | Remove a review                      |
|      .../review/?rating=2      | GET          | Filter reviews by rating             |
|  .../review/?reviewBody=Lorem  | GET          | Filter reviews by review text/body   |
|     .../review/?movieId=2      | GET          | Filter reviews by movie id           |
| .../review/?movieTitle=Arrival | GET          | Filter reviews by movie title        |
|      .../review/?userId=2      | GET          | Filter reviews by associated user id |
|  .../review/?userName=Patrick  | GET          | Filter reviews by user name          |

### A list of example routes and what information they expect to receive

### Posting a review

/reviews

`@RequestBody` Review review

Example: POST "http://localhost:8080/reviews"

JSON: 

   ```
   
   {
   "reviewBody": "Loved it!",  
    "rating": 10,
    "movie": {
        "id": 1
    },
    "user": {
        "id": 4
    } 
   }
   
   ```


### Filtering

/movies

`@PathVariable: /{id}`
Example: GET "http://localhost:8080/movies/2"

`@RequestParam: Optional<String> genre`

`@RequestParam: Optional<Integer> year`

`@RequestParam: Optional<Integer> duration`

`@RequestParam: Optional<String> title` 

Example: For "http://localhost:8080/movies/?title=The Martian"

### Deleting

/movies

`@PathVariable: /{id}`
Example: DELETE "http://localhost:8080/movies/2"


 
## Quirks

  - Derived queries for filtering requests are found in the Repositories.
