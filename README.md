# Setup for this project #

First of all welcome to Ctwitter application, which is nothing but a twitter clone application.
### What do you require to get started? ###

* [Xampp Server](https://www.apachefriends.org/download.html)
* [JDK 1.8 and above](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [An Eclipse IDE for reviewing code](https://eclipse.org/downloads/)
* [Apache Tomcat 8](https://tomcat.apache.org/download-80.cgi)
* [Library Dependencies]()

### Working of this application ###

![ArchofCtwitter.jpg](https://bitbucket.org/repo/8GnbyA/images/2025643578-ArchofCtwitter.jpg)

[Full View](https://bitbucket.org/repo/8GnbyA/images/2025643578-ArchofCtwitter.jpg)

### If all above files are available then lets started. ###

* Install XAMPP
 Then start 'Apache' and 'MySQL' (Note: Your MySQl port should be configured at 3306). Open your favourite browser and type 'localhost/phpmyadmin' (If you have configured before then login with root privileges). Then Select 'Databases' and Create Database with name 'twitterdb'.

* Install JDK 8.

* Install/Extract Apache Tomcat 8 
(Note:By Default its configured on 8080 and we need that port only for our application and if its not configured on 8080 then easiest way is to do it via Eclipse IDE By going to Window -> Show View -> Servers -> Double on configured Server, under Ports -> HTTP/1.1 -> Change it to 8080).If you didn't understand keep reading then below steps will redirect you here.

* Extract Eclipse.

* Clone the repository & open it in one of the Eclipse Workspace.

* 
* Press 'Ctrl'+'Shift'+'R', type 'hibernate.cfg.xml' and open it. Go to line number 27.