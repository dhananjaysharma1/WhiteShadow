# WhiteShadow (Pokedex + Pokemon Info )

**ScreenShot**
<img src="https://www.linkpicture.com/q/WhatsApp-Image-2023-03-20-at-19.38.01.jpeg" width="50%" height="50%">

## Build Versions and Configurations
The android project is run under the following configurations

**Gradle Plugin** v 7.2.2 

**Gradle version** v7.3.3

**JAVA** Java 8 (1.8)

## Architecture
The android Architecture follows the MVVM pattern defined by the Android Jetpack Architecture component (https://developer.android.com/jetpack/docs/guide).

**In the Android app a separation of concerns is adhered to as so:**

**UI (Fragment / Activity)** - should only contain logic that handles the UI and operating system interactions.

**ViewModel** - should only communicate with data via a repository, they should never touch the database or external source directly

**Repository** - should only contain logic that handles the retrieval and storage of data (Be that from an external source or SQLite) they should not contain any 'android' code.

## Dependency Injection
Dependency injection is satisfied via Koin (https://insert-koin.io/). There is a Dependencies.kt file at the app root where the app dependencies are declared, this is initialized in the Application class. Try and keep all dependency declarations in the Dependencies.kt file, however if a dependency requires an object that can only be created at runtime declare the dependency as high up as possible, preferably the Activity.

## Spotless
The Android Bitrise CI runs a Spotless (https://github.com/diffplug/spotless) Lint check on each and every build. To ensure that your branch will pass this check once pushed up please run
**./gradlew spotlessApply** before pushing your branch up to the repo.