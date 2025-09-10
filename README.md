# 📌 Test Automation Projects (Selenium, Cucumber & Gauge)

This repository contains **test automation projects** developed with **Selenium WebDriver, Cucumber (BDD), and Gauge**.  
The tests are designed for different websites such as **Amazon, BBC News, and Pinterest**, covering real-world scenarios like login, search, filtering, and user interactions.  

---

## 🚀 Covered Projects
- **Amazon Automation**
  - Product search and filtering
  - Brand selection and seller filtering
  - Add to cart and validation  

- **BBC News Automation**
  - Reading and navigating news
  - Searching news articles
  - Sign-up & Sign-in flows (valid/invalid credentials)  

- **Pinterest Automation**
  - Login & Sign-up flows
  - Validation of email/password fields
  - Save, like, share, and comment on pins  

---

## 🛠 Tech Stack
- **Selenium WebDriver** – Web automation  
- **Cucumber (BDD, Gherkin)** – Scenario definition  
- **Gauge** – Reporting & scenario readability  
- **Java** – Programming language  
- **Maven/Gradle** – Dependency management  
- **JUnit/TestNG** – Test runner  

---


---

# 📑 Example Scenarios

## Amazon Feature

Feature: Amazon

  Scenario: Add Apple product to cart
    Given Amazon.com is opened
    When Cookie is accepted
    When A product is searched
    When Filter is set to products shipped by Amazon
    When Brand Apple is selected
    When First product is chosen
    When Product is added to cart
    Then Product should be in the cart
    
## BBC News Feature

Feature: BBC News

  @SearchTheNews
  Scenario: Search a news article
    Given Go to the website of BBC News
    When Click the search button
    When Click the search textfield
    When Write your search
    Then Click the search icon


## Pinterest Feature

Feature: Pinterest Automation

  @Login
  Scenario Outline: True Email & Password
    Given User is on the Login page
    When User logs in with "<email>" and "<password>"
    Then User should be logged in successfully

    Examples:
      | email               | password   |
      |@gmail.com           |            |

## 🎯 Purpose

The purpose of this repository is to:

Gain hands-on experience in test automation

Practice BDD with Cucumber and Gauge

Build reusable and maintainable automation frameworks

Cover a variety of real-world website scenarios



## ▶️ How to Run
1. Clone the repository:  
   ```bash
   git clone https://github.com/username/test-automation-projects.git
