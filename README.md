# TestAssignment for Android Developer Job

Test Submitted by Syed Zain Ali

The app should allow users to search for weather information by entering a city name. 
It will display both current weather conditions and a 5-day weather forecast.
The app should be responsive and handle different states (loading, errors, success) effectively.

Core Features
   a. Third-Party API Integration
   Integrate with a weather API (e.g., OpenWeatherMap, WeatherAPI) to fetch current weather and forecast data.
   Use the API key to authenticate requests. Example endpoint:
   https://api.openweathermap.org/data/2.5/forecast?q={city name}&appid=your-api-key

   Parse and display the following:
   Current weather conditions: temperature, humidity, wind speed, and weather description.
   5-day weather forecast: including daily high/low temperatures and weather conditions.

   b. Search Functionality
   Provide a search bar for the user to input the city name.
   Display results after the user submits a valid input (minimum length of 4 characters).
   Handle user errors, such as empty inputs or invalid city names.

   c. Weather Display
   The app should display:
   Current weather: Shows the current temperature, weather condition (sunny, cloudy, etc.), humidity, and wind speed.
   5-day weather forecast: Displays forecasted weather for the upcoming 5 days, including temperature highs and lows.
  
   d. View Navigation
   Use a ViewPager to navigate between two fragments:
   Current Weather Fragment
   Forecast Weather Fragment
   Use TabLayout to visually represent the two views and enable easy navigation.
  
   e. State Management
   Implement state management to handle different app states (loading, success, error).
   Show a ProgressBar when the data is being fetched.
   Display an error message if the API request fails or returns no data.

   f. Data Caching
   Cache the weather data locally (using SessionManager or any other storage technique) to reduce unnecessary API requests and allow for offline access to previously fetched data.
   Ensure data is only fetched from the API when the cache is outdated or missing.


MVVM App Architecture talks
* [Build a MVVM Android app architecture - Google I/O'19](https://www.youtube.com/watch?v=9eIhMFTs1Q8&pp=ygUZbXZ2bSBhcmNoaXRlY3R1cmUgYW5kcm9pZA%3D%3D)


## Project Characteristics

This project makes use of the following tools and solutions:

* 100% [Kotlin](https://kotlinlang.org/)
* Modern architecture (Clean Architecture, Model-View-ViewModel)
* Dependency Injection
* Testing (Unit, UI)

* Tech-stack
    * [Retrofit](https://square.github.io/retrofit/) - networking
    * [Jetpack](https://developer.android.com/jetpack)
    * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform an action when lifecycle state changes
    * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
    * [Data Binding](https://developer.android.com/topic/libraries/data-binding/) - declaratively bind UI components in layouts to data sources.
    * [Room](https://developer.android.com/topic/libraries/architecture/room) - persistence


* Architecture
    * Clean Architecture (at module level)
    * MVVM (presentation layer)
    * [Android Architecture components](https://developer.android.com/topic/libraries/architecture)
    * ([ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel), [LiveData](https://developer.android.com/topic/libraries/architecture/livedata), [Navigation](https://developer.android.com/jetpack/androidx/releases/navigation), [SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args) plugin)


* Gradle
    * [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
    * Plugins ([SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args))


## Architecture
Clean Architecture is the "core architecture" of this application. The main purpose of this approach is to achieve a separation of concerns which Clean architecture helps with and in
making the code loosely coupled. This approach results in a more testable and flexible code.


* **Presentation**: Layer with the Android Framework, the MVVM pattern and the DI module. Depends on domain to access the use cases and on DI, to inject dependencies. This is the layer closest
  to what the user sees on the screen.
    - **MVVM**: The Model View ViewModel pattern helps with the separation of concerns, dividing the user interface with the logic behind. It combines very well with Android Architecture Components like LiveData and DataBinding.
* **Domain**: This is the core layer of the application with the business logic. It contains the use cases, in charge of calling the correct repository or data member.The domain layer is independent of any other layers.
* **Data**: Layer with the responsibility of managing the application data and exposes these data sources as repositories to the domain layer. Typical responsibilities of this layer is to retrieve data from the internet and optionally cache this data locally.

### Dependency Injection with Hilt
Dependency injection is closely related to two SOLID concepts: dependency inversion, which states that high level modules should not depend on low level modules,
both should depend on abstractions; and single responsibility principle,
which states that every class or module is responsible for just a single piece of functionality.

