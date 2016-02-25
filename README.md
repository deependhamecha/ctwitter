# Setup for this project #

First of all, Welcome to Ctwitter application, which is a Twitter clone application.

### What do you require to get started? ###

* [Xampp Server](https://www.apachefriends.org/download.html)
* [JDK 1.8 and above](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [An Eclipse IDE for reviewing code](https://eclipse.org/downloads/)
* [Apache Tomcat 8](https://tomcat.apache.org/download-80.cgi)

### Working of this application ###

![ArchofCtwitter.jpg](https://bitbucket.org/repo/8GnbyA/images/2025643578-ArchofCtwitter.jpg)

[Full View](https://bitbucket.org/repo/8GnbyA/images/2025643578-ArchofCtwitter.jpg)

### If all above files are available then lets get started. ###

* Install XAMPP
 Then start 'Apache' and 'MySQL' (Note: Your MySQl port should be configured at 3306). Open your favourite browser and type 'http://localhost/phpmyadmin' (If you have configured before then login with root privileges). Then Select 'Databases' and Create Database with name 'twitterdb'.

* Install JDK 8.

* Install/Extract Apache Tomcat 8 
(Note:By Default its configured on 8080 and we need that port only for our application and if its not configured on 8080 then easiest way is to do it via Eclipse IDE By going to **Window** -> **Show View** -> **Servers** -> Double on configured **Server**, under **Ports** -> **HTTP/1.1** -> Change it to **8080**).If you didn't understand keep reading then below steps will redirect you here.

* Extract Eclipse.

* Clone the repository & open it in one of the Eclipse Workspace.

* [Add Apache Tomcat Server to Eclipse but remember to Select Apache Tomcat 8.0](https://www.eclipse.org/webtools/jst/components/ws/1.0M9/tutorials/InstallTomcat.html)

* Now, we are good to go with running our application by right Clicking on the **project(ctwitter)** > **Run As** > **Run on Server** > Select **Apache Tomcat**.

* Go to [http://localhost:8080/ctwitter](http://localhost:8080/ctwitter)
and SignUp before Signing in. After you create first account do not login, Go to Eclipse IDE and Press 'Ctrl'+'Shift'+'R', type 'hibernate.cfg.xml' and open it. Go to line number 27 **<property name="hbm2ddl.auto">create</property>** and comment this by pressing 'Ctrl' + 'Shift' + '/'. Then Right click on the project and Select **Run as** > **Run on Server**.

* Now We are good to go to use the application