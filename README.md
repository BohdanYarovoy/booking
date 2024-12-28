<div align="center">
  <img src="https://github.com/BohdanYarovyi/booking/blob/master/screensots/favicon.png" alt="Logo" />
  <h1 style="font-weight: 800; font-size: 60px;">Booking</h1>
</div>

**Booking** is a convenient system for booking hotel rooms, which allows guests to automatically select and book rooms, as well as create booking requests through an intuitive interface. The system provides convenient access to all the necessary information for managers, including the functions of auditing requests, tracking their status and quick request management. Thanks to the system, you can effectively organize the booking process, reduce the workload on staff and improve the customer experience. **Booking - was created as a training project.**

## Content
- [Description](https://github.com/BohdanYarovyi/booking/tree/master?tab=readme-ov-file#booking)
- [Features](https://github.com/BohdanYarovyi/booking/tree/master?tab=readme-ov-file#-features)
- [Overview](https://github.com/BohdanYarovyi/booking/tree/master?tab=readme-ov-file#the-site-looks-like-)
- [Technical Details](https://github.com/BohdanYarovyi/booking/tree/master?tab=readme-ov-file#what-was-used-%EF%B8%8F)
- [Installation & Setup](https://github.com/BohdanYarovyi/booking/tree/master?tab=readme-ov-file#installation--setup-)
- [About me](https://github.com/BohdanYarovyi/booking/edit/master/README.md#about-me)

## 📋 Features  
- Ease of use
- Real-time communication
- Beautiful design
- Secure data
- Fast booking
- Minimum required information for booking

## The site looks like 🫣

### Home 🥹
![Home page](https://github.com/BohdanYarovyi/booking/blob/master/screensots/index.png)
*This is the initial page where the user begins their interaction with the site. From here, they can navigate to various parts of the application.*

### Registration ✍
![Registration page](https://github.com/BohdanYarovyi/booking/blob/master/screensots/register.png)=
*In order to proceed, users must register for an account. The registration form collects necessary information such as name, email, and password.*

### Login 🤨
![Login page](https://github.com/BohdanYarovyi/booking/blob/master/screensots/login.png)
*Once registered, users can log in to their account with their credentials to access additional features, such as making reservations.*

### Room Selection 🕵️
![Room selection page](https://github.com/BohdanYarovyi/booking/blob/master/screensots/rooms.png)
*To make a reservation, the user must select a room from the available options. Each room listing provides details such as price, availability, and description.*

### Room details 😃
![Room details page](https://github.com/BohdanYarovyi/booking/blob/master/screensots/reservation.png)
*To make a reservation, the user needs to select an available room, check-in date, check-out date, and number of people. After that, the system will calculate the cost of accommodation.*

### Room is blocking 🛡️
![Room details page after do reservation](https://github.com/BohdanYarovyi/booking/blob/master/screensots/inReservationMoment.png)
*After making a reservation, the room will be blocked for booking by other users.*
*Also, the request to book this room has been sent for confirmation by the manager.*

### Application in your profile 😏
![Profile page](https://github.com/BohdanYarovyi/booking/blob/master/screensots/profileAfterReservation.png)
*After creating booking application you may see it in your profile page. There you available to pay or cancel the application.*

### Manager panel 🤔
![Manager panel](https://github.com/BohdanYarovyi/booking/blob/master/screensots/adminPanel.png)
*Manager has a convenient control panel for manage requests. For continuing booking room, manager must approve. Manager may reject your request as well.*

### Your request was approved by manager 🫠
![Profile page after manager approving](https://github.com/BohdanYarovyi/booking/blob/master/screensots/afterAdminConfirming.png)
*After approving request by manager, you will have the request with status 'For pay', that say about it is time to pay for the room 💰*
*For this system gives you 1 dayn ⏳*

### He who pays, eats 😅
![Profile page after paying](https://github.com/BohdanYarovyi/booking/blob/master/screensots/afterPaying.png)
*After paying, you have a room for living 💃*

## What was used 🛠️
1. Java 
2. Spring Boot(Web, Security, Data JPA)
3. No BD (in memory because I had to create the site within 3 days)
4. Thymeleaf
5. HTML, CSS

## Installation & Setup 💿

### Step 1: Clone repository
Clone this repository to your local machine:
```bash
git clone https://github.com/BohdanYarovyi/booking.git
```

### Step 2: Go to the project directory
```bash
cd booking
```

### Step 3: If you don't have all the dependencies yet, install them using Maven 
For Linux:
```
./mvnw install
```
or for Windows:
```
mvnw install
```

### Step 4: Now you can run the application:
For linux:
```
./mvnw spring-boot:run
```
or for Windows:
```
mvnw spring-boot:run
```

### Step 5: Access to the application
After the application starts, you can follow the link in your browser: `http://localhost:8080`

## About me ✌
Thank you for checking out my project!  
I am a passionate Java Developer with a strong interest in backend development.

Feel free to connect with me:

- ⛓️‍💥 [LinkedIn](https://www.linkedin.com/in/%D0%B1%D0%BE%D0%B3%D0%B4%D0%B0%D0%BD-%D1%8F%D1%80%D0%BE%D0%B2%D0%B8%D0%B9-6a4445252/?locale=en_US)
- ✉️ [Gmail](mailto:bogdan.yarovoy.01@gmail.com)

I’m always open to learning new things, collaborating on projects, and discussing innovative ideas in the field of software development.
