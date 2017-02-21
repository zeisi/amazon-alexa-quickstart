# [![N|Solid](https://www.pmandcode.com/wp-content/uploads/2017/02/1487705099__code.png)](https://www.pmandcode.com/) Amazon Alexa Skill Quick Start

This repository includes some sample code necessary for running the backend of an Amazon Alexa skill.
Most of the code is a trimmed down version of [Amazons SDK samples](https://github.com/amzn/alexa-skills-kit-java/), I mostly refactored it for better readability.
### Basics

  - Java 8
  - Maven packaged (see below)
  - Runs on Amazon Lambda

### Included

  - Java classes + launcher to run code locally
  - Maven pom.xml for packaging
  - Speech assets for Amazon Alexa Skill
    - Intent Schema
    - Sample Utterances
    - customSlotTypes

### Getting Started
  - Import project into Java IDE of your choice (e.g. Eclipse, STS), using the `pom.xml`. This should pull all needed dependencies.
  - `com.pmandcode.ScheduleSpeechlet` is your main starting point, everything else is there to help you.
  - You can use `com.pmandcode.Launcher` to locally launch the server, just run it as a java application
  - You can find a test file in `src/test/resource/test.json`, you can use this with a REST client like [Restlet](https://restlet.com/modules/client/) to locally test your api.
    

### Compile

To build the backend, make sure you have the following installed:
 - Java SE Development Kit 8
 - Apache Maven 3.x 

To build the package run:

```sh
$ cd [project root folder containing pom.xml]
$ mvn clean assembly:assembly -DdescriptorId=jar-with-dependencies package
```

### Links

* [Alexa Getting Started Guide](ttps://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/getting-started-guide")
* [Amazon Lambda](https://console.aws.amazon.com/lambda)