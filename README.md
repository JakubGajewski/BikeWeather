# BikeWeather

This Java application is created to help cyclists with planning their trips!

We can check here if the outdoor conditions in picked city are good for outdoor activities. Application informs you about weather conditions and air pollution, and warns, if some dangers (like high pollution level or thunderstorms) may appear.

API used in the application are OpenWeatherMap and Airly.

It's multithreaded application, user's input starts new thread, which asks for JSON file, so user don't have to wait for it.

Design-patterns used in application are:
- Observer - MainController observs RestService, and is notified if we get some new informations;
- Singleton - there is only one instance of InformationModel;
- MVC architecture.

To run this app on your computer, you need to create your own ApiKeys class, put it to Services packages, and in fields weatherApiKey and pollutionApiKey insert your own keys. Enjoy!

NOTE: this is development versions, right now it works well, but I want to add some new functionalities, like more information about weather and new kind of weather alerts. In the future I also plan to connect with Windy API to check for the wind conditions and make some nice GUI.
