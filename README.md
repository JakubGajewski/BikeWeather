# BikeWeather

This Java application is created to help cyclists with planning their trips.

We can check here if the outdoor conditions in chosen cities are good for outdoor activities. Application informs you about weather conditions and air pollution, and warns if some dangers (like high air pollution level or thunderstorms) may appear.

API used in the application are OpenWeatherMap and Airly.

It's multithreaded application, user's input starts a new thread, which asks for JSON file, so user doesn't have to wait for it.

Design-patterns used in the application are:
- Observer - MainController observs RestService, and is notified if we get some new informations;
- Singleton - there is only one instance of InformationModel;
- MVC architecture.

To run this app on your computer, you need to create your own ApiKeys class, put it to the services package, create the fields named "weatherApiKey" and "pollutionApiKey" and insert there your own keys, which you can get for free at API's providers websites. Enjoy!

NOTE#1: this is DEVELOPMENT VERSION, right now it works quite well, but I still need to:
- repair some bugs, check if user's inputs are correct and handle errors and exceptions, that may occur;
- add some new features, like more information about weather and new kinds of weather alerts;
- make a nice GUI;
- and the most important thing - write some tests.

NOTE#2: this application is based on the WeatherForecast application, which was made at Akademia Kodu Java Bootcamp with my colleagues. However, it's only the root, and I've added / changed a lot of functionalities.
