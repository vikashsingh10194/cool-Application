Feature: Parent Search By Item Number

  @Search @en_US @P1
  Scenario Outline: Parent searches for and locates item by Item Number
    Given A Parent Who is logged-in
    When the parent searches for "<ValidItemNumber>"
    Then the parent should be presented with the "<ItemDescription>", "<GradeRange>", "<AuthorName>", "<ListPrice>"

    Examples: 
      | ValidItemNumber | ItemDescription                                              | GradeRange | AuthorName         | ListPrice |
      | #35G4           | Harry Potter and the Sorcerer’s Stone: Illustrated Edition | 3-7        | by J.K. Rowling    | 39.99     |
      | #14L5           | Old School                                                   | 3-7        | Jeff Kinney        | 13.95     |
      | #44T4           | The Marvels                                                  | 4-7        | by Brian Selznick  | 32.99     |
      | #21B4           | Flip and Flop                                                | Pre-K-2    | by Dawn Apperley   | 12.95     |
      | #78K4           | Snowman Magic                                                | Pre-K-1    | by Katherine Tegen | 12.99     |
