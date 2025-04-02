[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/F6ro3pjN)
# საბოლოო გამოცდა.
## 2025-03-19


წარმოიდგინეთ თქვენს კომპანიას სურს აწარმოოს ფილმების/სერიალების შეფასების სისტემა.  
ამის განხორციელება თქვენ დაგევალათ.

### მოთხოვნები & ამოცანის აღწერა

**Entity-ები და entity-ების მინიმალური მოთხოვნები**:

`Movie`: ფილმის/სერიალის ენთითი
 * `name` - დასახელება.
 * `description` - აღწერა

`Episode` ფილმის/სერიალის ეპიზოდის ენთითი
 * `session` - სეზონის ნომერი
 * `episode` - ეპიზოდის ნომერი
 * `name` - ეპიზოდის დასახელება
 * `description` - აღწერა
 * `releaseDate` - გამოშვების თარიღი

`Score` - შეფასების ენთითი
* `persionalNo` - მომხმარებლის (ჩათვალეთ ის უკე არსებობს ბაზაში) პირადი ნომერი - მხოლოდ რიცხვები 11 სიგრძის.
* `score` - შეფასება 
* `eposode` - რომელი ეპიზოდი შეაფასა.

**ფუნქციონალი**:
 * უნდა შეიძლებოდეს ფილმების და სერიალების CRUD (შექნმა, წაკითხვა, განახლება, წაშლა)
 * მომხამარებელს  საშუალება ეძლევა შეაფასოს ფილმი.
 * მომხამარებელს  საშუალება ეძლევა შეაფასოს სერიალის ეპიზოდი (უშუალოდ სერიალი არა).
 * სერიალის შემთხვევაში session და episode აუცილებელი ველია;
 * ზოგიერთი ფილმი შედგება ნაწილისგან ასეთ შემთხვეაში მომხმარებელმა ნაწილი უნდა შეაფასოს 
   * მაგალითად _Pirates of the Caribbean_ (კარიბის ზღვის მეკობრეები) ის შედგება რამდენიმე ნაწილისგან 
   _The Curse of the Black Pearl_, _Dead Man's Chest_, _At World's End_, _On Stranger Tides_, _Dead Men Tell No Tales_
   უშუალოდ ამ ეპიზოდების შეფასება უნდა მოხდეს და არა _Pirates of the Caribbean_
 * ეპიზოდის score (შეფასება) ითვლება, ამ ეპიზოდზე გაკეთებული შეფასებების საშუალო არითმეტიკულით.
   * თუ ეპიზოდი ჯერ არავის შეუფასებია ე.წ. default მნიშვნელობა მიენიჭოს, რომელიც კონფიგურირებადი იქნება.
 * სერიალის შეფასება ხდება მისი ყველა ეპიზოდის შეფასების საშუალო არითმეტიკულით.
 * ფილმის შეფასებაც ისევე იმუშავებს როგორც სერიალის შეფასება
 * დაამატეთ endpoint ძებნა - რომელიც სახელის მიხედვით მოძებნის ფილმს/სერიალს.
   * ექნება 1 boolean პარამეტრიც რომელიც დააბრუნებს ეპიზოდების სიას მხოლოდ მაშინ თუ პარამეტრი true იქნება.

**ტექნიკური მოთხოვნები**
 * დაიცავით სახელების დარქმევის შეთანხმება
 * დაიცავით REST-WS-ის ენდპოინტების შექმნის შეთანხმება
 * გამოიყენეთ ე.წ. ვალიდატორი.
 * გქონდეთ ე.წ. Swagger დოკუმენტაცია როგორც მოდელებზე ასევე კონტროლერებზე.

### მაგალითი

Pirates of the Caribbean ფილმზე, ეპიზოდებზე არის ასეთი შეფასებები;
 1. The Curse of the Black Pearl - 7,8,5,6,7,8 
 2. Dead Man's Chest - 4,9,7,6,8,5,4,8,5,9 
 3. At World's End - 1,9,7,10,7,6,8,7 
 4. On Stranger Tides - 8,7,6,8,9,10 
 5. Dead Men Tell No Tales 7

და ამ ფილმის მოძენბისას უნდა დაბრუნდეს შემდეგი მნიშვნელობა
``` JSON
{
  "name": "Pirates of the Caribbean",
  "description": "American fantasy supernatural swashbuckler film series",
  "releaseDate": "2003-07-09",
  "score": 7.0 // საშუალო (6.5, 6.8, 6.9, 7, 8) = 7.04 ამიტომ 7.0
  "episodes" [
    {
        "episode": 1,
        "name": "The Curse of the Black Pearl",
        "description": "Blacksmith Will Turner teams up with eccentric pirate Captain Jack Sparrow to save Turner's love ... AND SO ON",
        "releaseDate": "2003-07-09",
        "score": 6.8 // საშუალო (7,8,5,6,7,8) = 6.8333333 ამიტომ 6.8
    },{
        "episode": 2,
        "name": "Dead Man's Chest",
        "description": "PLOT OF Dead Man's Chest.",
        "releaseDate": "2006-07-07",
        "score": 6.5 // საშუალო (4,9,7,6,8,5,4,8,5,9) = 6.5 
    },{
        "episode": 3,
        "name": "At World's End",
        "description": "PLOT OF At World's End.",
        "releaseDate": "2007-05-25",
        "score": 6.9 // საშუალო (1,9,7,10,7,6,8,7) = 6.875
    },{
        "episode": 4,
        "name": "On Stranger Tides",
        "description": "PLOT OF On Stranger Tides.",
        "releaseDate": "2011-05-20",
        "score": 8.0 // საშუალო (8,7,6,8,9,10) = 8
    },{
        "episode": 5,
        "name": "Dead Men Tell No Tales",
        "description": "PLOT OF Dead Men Tell No Tales.",
        "releaseDate": "2017-05-26",
        "score": 7.0 // საშუალო (7) = 7
    }
  ]
}
```
ხოლო თუ ეპიზოდების გარეშე მოვითხოვე მოძენბა შესაბამისად
``` JSON
{
  "name": "Pirates of the Caribbean",
  "description": "American fantasy supernatural swashbuckler film series",
  "releaseDate": "2003-07-09",
  "score": 7.0 // საშუალო (6.5, 6.8, 6.9, 7, 8) = 7.04 ამიტომ 7.0
}
```


## **გისურვებთ წარმატებებს** !!!