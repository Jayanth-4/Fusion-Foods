Fusion Foods :
---------------
Fusion Foods is a food delivery web application that allows users to browse restaurants, view their menus, add items to a cart, and complete payments. The project emphasizes a clean, responsive user interface and robust backend functionality to handle cart management, restaurant menu listings, and user authentication.

Features:-
--------------
* Restaurant Listings: Display a variety of restaurants on the homepage. The layout is responsive, ensuring smooth transitions across different device sizes.
* Menu View: Each restaurant has a dedicated menu page where users can view the items, their prices, and descriptions. The menu is designed to fit various screen sizes, maintaining an intuitive user experience.
* Cart Management: Users can add items to the cart, update the quantity, and view the total price. Items from only one restaurant can be added to the cart at a time, with an alert if a user attempts to add from multiple restaurants.
* Responsive Sidebar: A cart sidebar slides in from the right when clicked, providing easy access to cart details. This sidebar is fully responsive.
* Checkout Flow: Once items are added to the cart, users can proceed to checkout. If the cart is empty, a friendly message is displayed.
* User Authentication: The project includes a simple login, signup, and logout functionality. Once logged in, users can add items to the cart and manage their orders.
* Responsive Design: Every page, including the homepage, restaurant menu, cart, and payment page, is built to be responsive across different screen sizes.
* Smooth Animations: Advanced CSS animations are used to ensure a modern and engaging user experience.
  
Technologies Used:-
-------------------
* Frontend:
HTML: For structuring the web pages.
CSS: For styling and ensuring the application is responsive.
JavaScript: For adding interactivity and smooth transitions across the site.
* Backend:
JEE: Java Enterprise Edition for handling backend logic.
JDBC: For database interactions.
JSP
* Database:
MySQL: Used to store restaurant and menu details, user data, and cart information.

Installation and Setup:-
-------------------------
* Clone the Repository:git clone https://github.com/your-username/fusion-foods.git
* Set Up MySQL Database:Create a MySQL database named fusion_foods.
Run the provided SQL scripts to set up the required tables (users, restaurants, menu_items, cart, etc.).
Configure Backend:
* Update the hibernate.cfg.xml or application.properties (depending on your setup) with your MySQL database credentials.
Deploy on a Servlet Container:
* Use a servlet container like Tomcat to deploy the WAR file of the project.
Run the Application:
* Open the application in your browser, navigate to the homepage, and start exploring restaurants.
  
Project Structure:-
------------------
Fusion-Foods/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.fusionfoods.dao/
│   │   │   ├── com.fusionfoods.dao.impl/
│   │   │   ├── com.fusionfoods.model/
│   │   │   ├── com.fusionfoods.servlets/
│   ├── webapp/
│   │   ├── WEB-INF/
│   │   │   ├── pages/
│   │   │   │   ├── cart.jsp
│   │   │   │   ├── menu.jsp
│   │   │   │   ├── payment.jsp
│   │   │   ├── resources/
│   │   │   │   ├── css/
│   │   │   │   ├── js/
├── README.md
├── pom.xml
└── .gitignore

Known Limitations:-
-------------------
* Secure payment gateways have not been implemented. Only basic cart and checkout functionalities are supported.
* Error handling and logging need further enhancement.
  
Future Improvements:-
----------------------
* Payment Gateway: Integrate with a secure payment gateway like Stripe or PayPal.
* Admin Panel: Add an admin interface for managing restaurants and menus.
* Search & Filters: Improve restaurant and menu filtering options.

Contact:-
----------
For any questions or feedback, feel free to reach out at jayanthmourya27@gmail.com.
