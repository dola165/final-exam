# final_exam
**this was a final exam for my 22 week long java course. everything here was written in slightly less than 3 hours so it is far from perfect.**


Imagine Your Company Wants to Develop a Movie/Series Rating System
You have been assigned the task of implementing it.

 Requirements & Task Description
 Entities and Their Minimum Requirements:

`Movie`: (Represents a movie or TV series)
 * `name`- The title of the movie or series
 * `description` - A brief description

`Episode` (Represents an episode of a movie or series)
 * `session` - The season number
 * `episode`- The episode number
 * `name` - The title of the episode
 * `description` - A brief description
 * `releaseDate` - The release date

`Score` (Represents a user rating)
 * `persionalNo` - The user's personal number (assume the user already exists in the database)
 Must be exactly 11 digits, containing only numbers
 * `score` - The rating given by the user
 * `eposode` - The episode being rated

⚙️ Functionality:
✅ CRUD operations for movies and series (Create, Read, Update, Delete)
✅ Users can rate a movie
✅ Users can rate an episode of a series (but not the series itself)
✅ If the content is a series, both season and episode fields are mandatory
✅ Some movies consist of multiple parts, and users must rate individual parts

Example: Pirates of the Caribbean consists of several installments:
* The Curse of the Black Pearl
* Dead Man’s Chest
* At World’s End
* On Stranger Tides
* Dead Men Tell No Tales

Users must rate these installments separately, not the entire Pirates of the Caribbean franchise

✅ The score of an episode is calculated as the average of all user ratings for that episode

If an episode has not yet been rated, it should have a configurable default value

✅ The score of a series is calculated as the average of all its episodes' ratings

✅ The score of a movie (if it consists of multiple parts) is also calculated as the average of all its parts' ratings

✅ Implement a search endpoint to find movies/series by name

It should include a boolean parameter to determine whether episode details should be included in the response

🛠️ Technical Requirements:
🔹 Follow standard naming conventions

🔹 Adhere to RESTful API design principles

🔹 Implement input validation

🔹 Provide Swagger API documentation for both models and controllers

📌 Example
Consider a scenario where the Pirates of the Caribbean movies have been rated as follows:

Episode Title	Ratings;
 1.The Curse of the Black Pearl -	7, 8, 5, 6, 7, 8
 2.Dead Man's Chest	- 4, 9, 7, 6, 8, 5, 4, 8, 5, 9
 3.At World's End	- 1, 9, 7, 10, 7, 6, 8, 7
 4.On Stranger Tides - 8, 7, 6, 8, 9, 10
 5.Dead Men Tell No Tales	- 7

``` JSON
{
  "name": "Pirates of the Caribbean",
  "description": "American fantasy supernatural swashbuckler film series",
  "releaseDate": "2003-07-09",
  "score": 7.0,  // Average of (6.5, 6.8, 6.9, 7, 8) = 7.04 → rounded to 7.0
  "episodes": [
    {
        "episode": 1,
        "name": "The Curse of the Black Pearl",
        "description": "Blacksmith Will Turner teams up with eccentric pirate Captain Jack Sparrow to save Turner's love ... AND SO ON",
        "releaseDate": "2003-07-09",
        "score": 6.8  // Average (7,8,5,6,7,8) = 6.833333 → rounded to 6.8
    },
    {
        "episode": 2,
        "name": "Dead Man's Chest",
        "description": "PLOT OF Dead Man's Chest.",
        "releaseDate": "2006-07-07",
        "score": 6.5  // Average (4,9,7,6,8,5,4,8,5,9) = 6.5
    },
    {
        "episode": 3,
        "name": "At World's End",
        "description": "PLOT OF At World's End.",
        "releaseDate": "2007-05-25",
        "score": 6.9  // Average (1,9,7,10,7,6,8,7) = 6.875 → rounded to 6.9
    },
    {
        "episode": 4,
        "name": "On Stranger Tides",
        "description": "PLOT OF On Stranger Tides.",
        "releaseDate": "2011-05-20",
        "score": 8.0  // Average (8,7,6,8,9,10) = 8.0
    },
    {
        "episode": 5,
        "name": "Dead Men Tell No Tales",
        "description": "PLOT OF Dead Men Tell No Tales.",
        "releaseDate": "2017-05-26",
        "score": 7.0  // Average (7) = 7.0
    }
  ]
}
``` 
If episode details are not requested, the response should be:

``` JSON
{
  "name": "Pirates of the Caribbean",
  "description": "American fantasy supernatural swashbuckler film series",
  "releaseDate": "2003-07-09",
  "score": 7.0  // Average (6.5, 6.8, 6.9, 7, 8) = 7.04 → rounded to 7.0
}
``` 
