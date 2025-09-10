@BBCNews
Feature: BBC News

  @ClickSportNews
  Scenario: Click sport news
    Given Go to the website of BBC News
    When Click one categori
    Then Click one news

  @SearchTheNews
  Scenario: Search the news
    Given Go to the website of BBC News
    When Click the search button
    When Click the search textfield
    When Write your search
    Then Click the search icon

  @SearchAtAnotherPage
  Scenario: Search the news
    Given User at another page
    When Click the search button at another page
    When Click the search textfield at another page
    When Write your search at another page
    Then Click the search icon at another page

  @NewsFromMenu
  Scenario: Read News from Menu
    Given Go to the website of BBC News
    When Click the search button
    When Click the category of menu
    When Click the subcategory of menu
    Given Click the news

  @SignUpYes
  Scenario Outline: Sign Up with Yes
    Given Go to the sign up page
    When Click "<email>" textfield and write email
    When Click continue
    When Click "<password>" textfield and write password
    When Click continue
    When Choose Yes, I want Emails
    Then Click Register

    Examples:
      | email               | password   |
      |         @gmail.com  | 13579gokce   |

  @SignUpNo
  Scenario Outline: Sign Up with No
    Given Go to the sign up page
    When Click "<email>" textfield and write email
    When Click continue
    When Click "<password>" textfield and write password
    When Click continue
    When Choose No Thanks
    Then Click Register

    Examples:
      | email                   | password     |
      | @gmail.com              | 13579gokce   |


  @WrongFormatofPassword
  Scenario Outline: Sign Up with Wrong Format of Password
    Given Go to the sign up page
    When Click "<email>" textfield and write email
    When Click continue
    When Click "<password>" textfield and write password
    When Click continue
    Then Check "<error>" message about password format

    Examples:
      | email                   | password   | error |
      |             @gmail.com  | 9gokce     | Sorry, that password isn't valid. Please include a letter.|

  @WrongFormatofEmail
  Scenario Outline: Sign Up with Wrong Format of Email
    Given Go to the sign up page
    When Click "<email>" textfield and write email
    When Click continue
    Then Check "<error>" message about email format

    Examples:
      | email                   | error                                                                  |
      |                         | Sorry, that email doesn’t look right. Please check it's a proper email.|

  @SuccessfullSignIn
  Scenario Outline: Succesfully Sign In
    Given Go to the login page
    When Click "<email>" textfield and write email
    When Click continue
    When Click "<password>" textfield and write password
    Then Click Sign In
    Examples:
      | email               | password     |
      |                     | 13579gokce   |

  @LoginWithWrongPassword
  Scenario Outline: Login with Wrong Password
    Given Go to the login page
    When Click "<email>" textfield and write email
    When Click continue
    When Click "<password>" textfield and write password
    When Click Sign In
    Then Check "<error>" message about wrong password

    Examples:
      | email               | password     | error                                                        |
      |                     | 2345666gokce   | Sorry, that password isn't valid. Please include a letter. |


  @SaveNews
  Scenario: Save If You Want
    Given Go to the login page
    When Click "<email>" textfield and write email
    When Click continue
    When Click "<password>" textfield and write password
    When Click Sign In
    When Click the news in homepage
    Then Click Save

  @ShowYourSaves
  Scenario Outline: See What You Saved
    Given Go to the login page
    When Click "<email>" textfield and write email
    When Click continue
    When Click "<password>" textfield and write password
    When Click Sign In
    When Click Your Account Page
    Then Click Saved

    Examples:
      | email               | password     |
      |                     | 13579gokce   |

  @Signout
  Scenario Outline: Sign out
    Given Go to the login page
    When Click "<email>" textfield and write email
    When Click continue
    When Click "<password>" textfield and write password
    When Click Sign In
    When Click Your Account Page
    Then Click Sign Out

    Examples:
      | email               | password     |
      |                     | 13579gokce   |
