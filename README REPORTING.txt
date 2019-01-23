To get maven to report html results from eclipse,
right-click pom.xml->run as->run configurations
In Goals, put surefire-report:report
and run
it will create a folder called site, so refresh the project explorer to see it.

But the html report will be missing images, so do this to get them,
If you run this first, it will produce all the css & images for future reporting:
mvn site -DgenerateReports=false