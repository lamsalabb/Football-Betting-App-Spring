# Football Betting App

A full-stack football betting web application built with **Java 21** and **Spring Boot 3.4**. The application allows users to authenticate, view football match information, and place simulated bets using a persistent MySQL-backed system.

---

## Features

* **User Authentication:** Secure registration, login, and access control managed via Spring Security.
* **Match & Score Management:** View upcoming matches, actual scores, and match metadata.
* **Simulated Betting System:** Place bets using virtual currency (coins) with automated payout processing.
* **Data Persistence:** Robust user, match, and betting data management powered by MySQL and Spring Data JPA.
* **Server-Side Rendering:** Interactive UI views rendered via Thymeleaf templates.
* **Email Notifications:** Email service integration powered by Spring Mail.

---

## Tech Stack

* **Language:** Java 21
* **Framework:** Spring Boot 3.4.4
* **Web Layer:** Spring MVC, Thymeleaf
* **Security:** Spring Security
* **Database:** MySQL
* **Persistence:** Spring Data JPA / Hibernate
* **Build Tool:** Maven
* **Testing:** Spring Boot Test, Spring Security Test

---

## Architecture

The application follows a standard layered Spring Boot architecture:

```text
Web Browser
    │
    ▼
Controllers  ──► (Renders Thymeleaf Templates)
    │
    ▼
 Services    ──► (Business & Payout Logic)
    │
    ▼
Repositories ──► (Spring Data JPA)
    │
    ▼
MySQL Database
