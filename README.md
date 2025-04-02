# final_exam
this was a final exam for my 22 week long java course. everything here was written in slightly less than 3 hours.
Imagine your company wants to develop a movie/series rating system.
You have been assigned to implement it.

Requirements & Task Description
Entities and their minimum requirements:
Movie - The entity for a movie or series

name - Title

description - Description

Episode - The entity for a movie/series episode

season - Season number

episode - Episode number

name - Episode title

description - Description

releaseDate - Release date

Score - The entity for ratings

personalNo - The personal number of the user (assume the user already exists in the database). Only numeric values, exactly 11 digits long.

score - Rating

episode - The episode that was rated.

Functionality
CRUD operations (Create, Read, Update, Delete) must be supported for movies and series.

Users must be able to rate a movie.

Users must be able to rate an episode of a series (not the series itself).

For series, both season and episode fields are required.

Some movies consist of multiple parts, and users must rate each part separately.

Example: Pirates of the Caribbean consists of multiple parts (The Curse of the Black Pearl, Dead Man's Chest, At World's End, On Stranger Tides, Dead Men Tell No Tales). Users should rate these individual parts, not Pirates of the Caribbean as a whole.

An episode’s score is calculated as the arithmetic mean of all ratings given to that episode.

If an episode has not been rated yet, it should have a configurable default rating.

A series’ score is calculated as the arithmetic mean of all its episodes’ ratings.

A movie’s score is calculated in the same way as a series’ score.

A search endpoint should be available to find a movie or series by name.

The search endpoint should include a boolean parameter:

If true, the response should include the list of episodes.

If false, only the movie/series information should be returned.

Technical Requirements
Follow proper naming conventions.

Follow REST API endpoint conventions.

Use validation mechanisms.

Provide Swagger documentation for both models and controllers.

Example
Consider ratings for Pirates of the Caribbean episodes:

The Curse of the Black Pearl: 7, 8, 5, 6, 7, 8

Dead Man's Chest: 4, 9, 7, 6, 8, 5, 4, 8, 5, 9

At World's End: 1, 9, 7, 10, 7, 6, 8, 7

On Stranger Tides: 8, 7, 6, 8, 9, 10

Dead Men Tell No Tales: 7

When searching for Pirates of the Caribbean, the response should be:

With episodes included:
json
Copy
Edit
{
  "name": "Pirates of the Caribbean",
  "description": "American fantasy supernatural swashbuckler film series",
  "releaseDate": "2003-07-09",
  "score": 7.0, // Average (6.5, 6.8, 6.9, 7, 8) = 7.04 → Rounded to 7.0
  "episodes": [
    {
        "episode": 1,
        "name": "The Curse of the Black Pearl",
        "description": "Blacksmith Will Turner teams up with eccentric pirate Captain Jack Sparrow to save Turner's love ... AND SO ON",
        "releaseDate": "2003-07-09",
        "score": 6.8 // Average (7,8,5,6,7,8) = 6.8333333 → Rounded to 6.8
    },
    {
        "episode": 2,
        "name": "Dead Man's Chest",
        "description": "PLOT OF Dead Man's Chest.",
        "releaseDate": "2006-07-07",
        "score": 6.5 // Average (4,9,7,6,8,5,4,8,5,9) = 6.5
    },
    {
        "episode": 3,
        "name": "At World's End",
        "description": "PLOT OF At World's End.",
        "releaseDate": "2007-05-25",
        "score": 6.9 // Average (1,9,7,10,7,6,8,7) = 6.875 → Rounded to 6.9
    },
    {
        "episode": 4,
        "name": "On Stranger Tides",
        "description": "PLOT OF On Stranger Tides.",
        "releaseDate": "2011-05-20",
        "score": 8.0 // Average (8,7,6,8,9,10) = 8
    },
    {
        "episode": 5,
        "name": "Dead Men Tell No Tales",
        "description": "PLOT OF Dead Men Tell No Tales.",
        "releaseDate": "2017-05-26",
        "score": 7.0 // Average (7) = 7
    }
  ]
}
Without episodes:
json
Copy
Edit
{
  "name": "Pirates of the Caribbean",
  "description": "American fantasy supernatural swashbuckler film series",
  "releaseDate": "2003-07-09",
  "score": 7.0 // Average (6.5, 6.8, 6.9, 7, 8) = 7.04 → Rounded to 7.0
}
