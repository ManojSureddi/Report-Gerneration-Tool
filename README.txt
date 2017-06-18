
Backend :
	1:Import the eclipse project into your eclipse
	2:Install apache tomcat 7 
	3.Please download the jars from 
		https://drive.google.com/folderview?id=0B0Lmvz7PeR8PfmxHOHNXbmxQemtWY0V1OHJFYmVEQ2xKa05pWkE2Y0pHRmVTX2FmYjRwZTA&usp=sharing
	and replace it in the Manoj Sureddi-Front End Web Designer\Code\Backend\crossoverfed\WebContent\WEB-INF
	This because of the restriction on space during upload
	4.Point eclipse to run the project on this server
	
FrontEnd:
	1.Download apache2 server or wamp and install it 
	2.Place the folder inside the frontend folder inside "www" folder of wamp server. If you are using Apache2 please change the "Directory root" and the "Directory Path" inside httpd.conf file
	3.If you are using wamp please start the wamp and run the folder in localhost
		eg:http://127.0.0.1/crossover/#/login
	if you are using Apache2 run localhost to run the application
		eg:http://127.0.0.1/#/

and yes the application will be up and running.

Note:This has cross domain header enabled so it can accept requests from other hosts.That is why the frontend and backend are running on different hosts
Technology used:
Front end : AngularJs,HTML,CSS3
Backend: Java,Spring MVC,Hibernate,MySQL

