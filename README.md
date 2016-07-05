# atmosphere-server-agent-lib
The server-agent libraries of the ATMOSPHERE mobile testing framework

## Project setup
>This project depends on the [atmosphere-commons](https://github.com/MusalaSoft/atmosphere-commons) libraries, so make sure you publish atmosphere-commons to your local Maven repository first.

### Build the project
You can build the project using the included gradle wrapper by running:
* `./gradlew build` on Linux/macOS<br/>
* `gradlew build` on Windows.

### Publish to Maven Local
If the build is successful, also run:
* `./gradlew publishToMavenLocal` (Linux/macOS)
* `gradlew publishToMavenLocal` (Windows)

to publish the jar to the local Maven repository so other projects that depend on it can use it.
