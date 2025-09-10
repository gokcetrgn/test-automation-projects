@PinterestOtomasyon
  Feature: Pinterest Otomasyon

    @Website
    Scenario: Go to Website
      Given User is on Pinterest homepage
      Then Homepage should be displayed

    @GoToLogin
    Scenario: Go to Login Page
      Given User is on Pinterest homepage
      When User clicks on the Login button
      Then Login page should be displayed

    @GoToSignUp
    Scenario: Go To Sign Up Page
      Given User is on Pinterest homepage
      When User clicks on the Sign Up button
      Then Sign Up page should be displayed

  @GoToDiscoverPageFromHeader
  Scenario: Go To Discovery Page
    Given User is on Pinterest homepage
    When User clicks on the Discover button from header
    Then Discover page should be displayed

    @GoToDiscoverPageFromHeader
    Scenario: Go To Discovery Page
      Given User is on Pinterest homepage
      When User clicks on the Discover button from header
      Then Discover page should be displayed

    @EmailCheck
      Scenario: Checking email textfield
      Given User is on Pinterest homepage
      When User clicks on the Login button
      Then User clicks on the email textfield

    @PasswordCheck
    Scenario: Checking email textfield
      Given User is on Pinterest homepage
      When User clicks on the Login button
      Then User clicks on the password textfield

    @EmptyEmail
    Scenario Outline: Checking email textfield
      Given User is on the Login page
      When User tries to login without entering email
      Then Check the "<error>" message about email
      Examples:
        | error                                               |
        | Bir şey eksik! E-postanızı eklemeyi unutmayın.      |

    @WrongFormatEmail
    Scenario Outline: Checking email textfield
      Given User is on the Login page
      When User logs in with "<email>"
      Then Check the "<error>" message about wrong format of email
      Examples:
        |email             | error                                                              |
        |gnaztrgnil.com    | Bu bir e-posta adresine benzemiyor.|

    @HasNoEmailInDatabase
    Scenario Outline: Checking email textfield
      Given User is on the Login page
      When User logs in with "<email>"
      Then Check the "<error>" message about email if dont have in database
      Examples:
        |email               | error                                                              |
        |gnabaen@hotmail.com | Girdiğiniz e-posta hiçbir hesaba ait değil.|



    @EmptyPassword
    Scenario Outline: Checking email textfield
      Given User is on the Login page
      When User logs in with "<email>"
      Then Check the "<error>" message about password
      Examples:
       |email             | error                                                              |
       |gnaztrgn@gmail.com| Girdiğiniz parola yanlış. Tekrar deneyin veya Parolanızı yenileyin.|


    @WrongPasswordAfterThreeSteps
    Scenario Outline: Checking email textfield
      Given User is on the Login page
      When User logs in with "<email>" and "<password>"
      Then Check the "<error>" message after three try
      Examples:
        |email             | password       | error                                                              |
        |gnaztrgn@gmail.com| 34170372155Gg. | Hımm... Bu parola doğru değil. Oturum açmanıza yardımcı olması için bir e-posta gönderdik.|



    @Login
    Scenario Outline: True Email & True Password
      Given User is on the Login page
      When User logs in with "<email>" and "<password>"
      Then User should be logged in successfully
      Examples:
        | email              | password        |
        | gnaztrgn@gmail.com | 34170372155Gg.  |

    @SuccesfullSignUp
    Scenario Outline: Succesfull Sign Up
      Given User is on the Sign Up page
      When User signs up with "<email>", "<password>", "<birthday>", "<name>", gender, country
      And selects preferred categories and interests
      Then User should be registered successfully
      Examples:
        |email             | password       | birthday | name     |
        |gad3b90894@gardsiir.com| 34170372155Gg. | 29052003 | Gokcenaz |

    @ShowPictures
    Scenario: User can see the heart icon after clicking a photo
      Given User is on the HomePage
      When the user clicks on a photo
      Then the heart icon should be visible

    @LikePictures
    Scenario: User can click the heart icon after clicking a photo
      Given User is on the HomePage
      When the user clicks on a photo
      Then the heart icon should be clicked

    @ShareAndCopyLink
    Scenario: User can share the photo with copy link
      Given User is on the HomePage
      When the user clicks on a photo
      Then user clicked share button and copy link

    @SavePicture
    Scenario: User can save the photo
      Given User is on the HomePage
      When the user clicks on a photo
      Then user clicked save button

    @DownloadPicture
    Scenario: user can download the photo
      Given User is on the HomePage
      When the user clicks on a photo
      Then user clicks comment icon and writes "<comment>" about photo

    @AddComment
    Scenario Outline:
      Examples:
        | comment  |
        |"Beautiful!!"  |

