# hcl booking api
High Level Brief :

The Meeting Room Availability Problem is solved in 2 parts

1. Backend is implemented in Spring Boot

The App is Deployed in EC2 Instance and the Swagger UI exposes the End Points and Model Objects

1. The UI is Done in Angulat 8 with Routing / Ng Boot Strap

This App is deployed in Amazon EC2 and for Demo I have enabled CORS

1. Github URL : [https://github.com/deepaknchandwani/hclbookingapi](https://github.com/deepaknchandwani/hclbookingapi)

1. Spring Boot is deployed in EC2 Non SSL

 URL : [http://ec2-18-189-192-25.us-east-2.compute.amazonaws.com:8085/swagger-ui.html](http://ec2-18-189-192-25.us-east-2.compute.amazonaws.com:8085/swagger-ui.html)[](http://ec2-18-189-192-25.us-east-2.compute.amazonaws.com:8085/swagger-ui.html)


1. The UI Is Hosted in EC2 NON SSL

 URL : [http://ec2-18-189-192-25.us-east-2.compute.amazonaws.com:8085/](http://ec2-18-189-192-25.us-east-2.compute.amazonaws.com:8085/)[](http://ec2-18-189-192-25.us-east-2.compute.amazonaws.com:8085/)
 
1. The UI Is Hosted in S3 SSL

 URL : [https://hcldemoapi.s3.us-east-2.amazonaws.com/index.html](https://hcldemoapi.s3.us-east-2.amazonaws.com/index.html)[](https://hcldemoapi.s3.us-east-2.amazonaws.com/index.html) 
 
 1. The UI Is Hosted On Load Balancer Non SSL , Even Preferxing ALB mapps to Non SSL Termination Node

 URL : [https://deepakec2lunix-1999385340.us-east-2.elb.amazonaws.com/](https://deepakec2lunix-1999385340.us-east-2.elb.amazonaws.com/)[](https://deepakec2lunix-1999385340.us-east-2.elb.amazonaws.com/) 
 
 1. The UI Is Hosted in EC2 with SSL using Route 53 with public Domain, Sub Domain / can use private Domain too

 URL : [https://amgmedical.net/](https://amgmedical.net/)[](https://amgmedical.net/) 

1. The DataBase is on another Amazon Lunix EC2 instance deployed in a docker container

Have attached the Creation Sql and seed data for creation

1. Due to time constrains could not add Mockito Test Coverage but have used Test Class which uses rest template to make service call.

1. Angular testing have not started but planning to use Jasmine / karma.

Regards.

Linkeden : https://www.linkedin.com/in/deepak-chandwani-159114162/

GitHub   : https://github.com/deepaknchandwani/

skypeid  : deepakchandwani
