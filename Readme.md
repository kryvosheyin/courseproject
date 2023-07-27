# Course project Kanboard

<h3>Need to install</h3>

- java
- maven
- docker

<h3>Launch project locally</h3>

  &nbsp; download docker file: <br />
  &nbsp; docker-compose [file](https://github.com/robot-dreams-code/QA-Automation-2/blob/main/lesson%203%20docker/docker-compose.yml)<br />


<h3>Tests execution<br></h3>

Tests can be run with configuration of system property and/or profiles in console <br />

> mvn clean test -Pprofile_name -Dsystem_property=value

The default parameters are taken from _environment.properties_ file<br />

<h4>Profiles</h4>

> * ui<br/>
> * api

<h4><br>System parameters<br/></h4>

> * browser (String)
> * headless (boolean)
> * api_uri (String)
> * api_url (String)
> * api_token (String)

Example:<br>

> 'mvn clean test' - runs all tests<br>
> 'mvn clean test -Papi' - runs 'API' tests<br>
> 'mvn clean test -Pui -Dbrowser_name=firefox -Dheadless=true' - runs 'UI' tests in 'Fireforx' browser in headless mode