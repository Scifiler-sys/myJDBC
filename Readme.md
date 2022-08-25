# Docker
* It is a way of packaging our application that has a bunch of dependencies that we had to install (SDK, external packages, etc.) into one single package that we can send to multiple computers and have it run flawlessly without the need of any installation process or setup process
* It is a containerization ecosystem (more on this on the later notes)

## What is the purpose of Docker? (v1)
* Imagine you need to deliver your application to a lot of people
* But hey to even start using your application you gotta tell the person to download this file (manually)
* And then this file needs another file to run and this file needs another another file to run
* Just think of all the game launchers you use nowadays like steam or epic store, when you get a game you just need to press one button and that actually downloads everything you will ever need for that game even its dependencies
* This is where Docker shines, just give the person an image and bam you can run the application

## What is the purpose of Docker? (v2)
* Analogy with business and hiring more people
* It allows developers to work in standardized environments using Containers
    * Meaning they can work with whatever development environment (Java, .NET, Ruby, etc.) they want with whatever OS (Windows, Linux, Mac, etc.) they want and still be able to give their application to everyone (as long as they have a docker engine)
* It makes it perfect for CI/CD workflows and for scaling
    * It is easy to spin up a new computer and have an application running to accomodate for more people (This is future topic but this is how container orchestration works)
    * Developers can write code locally in their own preferred development environment and then share it using Docker container

## What is Virtualization? (VM)
* It is a creation of a virtual machine that simulates a real computer with an operating system
* A tightly isolate software container with an OS and application inside
* You can create multiple VMs on one single physical computer
    * So in theory, if you have a very powerful computer, you can have a windows OS, Linux OS, and MacOS running at the same time
    * Do not that they **CANNNOT** interact with each other because they are **ISOLATED** meaning my windowsOS cannot just copy a file there and paste it to my MacOS
* There is another layer called a **hypervisor** that dictates the computing resources to each VM
    * Same thing as saying hey my WindowOS will have 2 gb of ram and my MacOS will have 4 gbs of ram

## What is Containerization?
* A type of VM that is faster/lightweight compared to your traditional VM
* Instead of having individual OS for each application, you can share **ONE** OS for each application
    * To give you an idea why that is a LOT more lightweight:
        * Windows 11 OS needs at least 18 gbs of harddrive, needs at least 4 gbs of ram
        * MacOS needs at least 12 gbs, at least 4 gbs of ram
        * AND you still need to run your very own computers OS system
* How does it accomplish running all in one shared OS?
    * It involves bundling an application together with all the configuration files, libraries, and dependencies required
    * Basically get everything the application needs to run it
* When creating a container, the allocation of resoruces is dynamic
    * Meaning it will use as much resrouces the container needs to run the application
    * Ex: If running your app requires 1 gb of ram then it will just need that 1 gb of ram and will either increase or decrease that required depending on the workload
    * Vastly different from a traditional VM that must have at least 4 gb of ram available to even start

## Pros
* Responsive deployement and scaling
    * Docker containers can run on most things (physical or virtual machine, data center, cloud providers, etc.)
    * You can scale up or tear down application as business dictates (based on demand)
* Run more worklods on the same hardware
    * Since containers is very lightweight unlike virtual machines, you can do other stuff while docker is running


## Docker artifacts/Terminology
* Dockerfile
    * IT IS NOT AN IMAGE
    * It is just a text document that will dictate to the docker enginer how to **MAKE** an image
* Docker Images
    * They are standalone package that includes everything for the application to run such as the code itself, dependencies, configuration, etc.
    * They are immutable file and represents an application and its virtual environment at a specific point in time
        * Immutable meaning you cannot change it thats why we have to create a new image everytime we update the application
* Docker Container
    * An image cannot run on its own. It needs a docker container to run the image
    * In other words, Containers are the runnable instance of a docker image
    * Think of a CD, it has all the information you need to start an application/install application/play music but it needs a disc drive to actually run it
* Docker Registry
    * It is a server-side or cloud application where you can store your images and make it easy to distribute to everyone else
    * Think of github but just for docker images
    * Ex: Dockerhub
* Docker ignore
    * It is like .gitignore
    * It will ignore certain files in your application to not put inside of image
* Docker Configuration
    * Just extra information to tell the docker container on how to run the image
    * We won't touch this and just use the default settings

## Docker instructions
* Don't confuse them with docker commands that is the CLI commands we put on the terminal
* These are instructions to tell docker how to make this image and what it needs
* From
    * Initialized our build stage and sets the base image
    * Essentially this is where we indicate what we need to be able to create/run our application
* Workdir
    * Sets the working directory
    * Just creates a folder and that is where we will copy and paste our files into that folder
* Copy
    * Copy and paste files for image
    * So it essentially moves the files from your local directory and paste into the image
* Run
    * It will execute the CLI commands you specify in the run command
    * Essentially, if you need to run something in the terminal (like dotnet build), you use the run instructions

# Docker CLI
* Docker build - builds an image using the existing Dockerfile
* Docker run - runs a container containing whatever image you specify
* Docker login - let's us login to docker
* Docker pull - grabs a remote repository from dockerhub

# Docker Daemon
* As we know, daemon means just any background process happening in your computer that you don't really control
* This is where the majority of the "thinking" that is happening with docker
* It will manage our containers, image creation, connecting to the registry, etc.

# Making a docker image
1. Create a Dockerfile
2. Add the corresponding docker instructions 
3. docker build
4. docker run

# Introduction to more AWS
* AWS has a bunch of services that is more than just creating a database
* AWS RDS is just one of the many things you can do in AWS
* Once we go into deeper into DevOps, we start going into the realm of how can we actually deliver our product to the masses
* At the moment, our rest api can only be access by your computer and no one else so I will go deeper in AWS that gives us all the capabilities to have your app access to everyone

# AWS EC2
* EC2 stands for Elastic Compute Cloud
* A web service that provides a resizable compute capacity in the AWS cloud
* Essentially we are renting a computer that exists in some Amazon server that most likely have state of the art internet, computer components, maintanance crew, etc.
* We have complete control of how much "beefy" we want our server to have
## EC2 instance
* Now we aren't really renting one entire computer to handle our server (We can but that is a hella lot more expensive to do so)
* Instead, we are just renting a part of a computer that is shared by several other AWS customers
    * Hence sometimes your server is running fast and sometimes it is running very slow
    * It all depends what the other customers are doing at that same computer
* That is what an EC2 instance is, a virtual server used for running our application
## AWS Elastic Beanstalk
* It is an EC2 but with one very special thing, it helps with the deployement of your application
* Getting a standalone EC2 is similar to getting a brand new computer. It doesn't have anything that will allow it to deploy your application
* Each of the computer we are using right now has all the capability to share things to the internet... We just have to configure it and it is not easy without any networking knowledge at all.
* Instead we use Elastic Beanstalk, it IS an EC2 instance BUT it takes care all the information of actually allowing our application to be shared by all using the internet.
* It is as simple as uploading our code and behold it gets deployed
    * Fancy way of saying a description of it, it abstracts the networking and configuration required when trying to deploy an application to the internet.
* It has other fancy features that makes deployement life easier such as logging, monitoring tools, provides all other services required to deploy your app. 

## Manually deploying app to EC2
1. Create EC2 instance
2. SSH to EC2
3. apt update
3. Install docker
4. docker login
5. docker pull
6. docker run

# Introduction to Code Analysis
* A further way for a computer to analyze your code to ensure you are following good coding practices and also gives you a direction on certain things you might want to change
* Does not actually check if the functions are working on your app (that is what unit tests are for) and more about looking at your c# files and ensuring you follow good coding practicies
* It will perform a **static code anaylsis**
    * Just the fancy way of saying, it will check your code without running it and just scanning your c# files and seeing any patterns that might be bad coding practices
    * If done by a human, that is what we call a code review (just for your fun information)
## SonarCloud
* An online platform that helps store all of our code analysis
## Terminology to understand the report you are getting
* Bugs - They have a chance that will break your application entirely and should be handled quickly
    * Hence when an application crashed we mostly say it is probably cause of a bug in the program
* Code Smells - They checked how properly coded your application is
    * Ex: Creating a variable you never use, having commented out code, unused imports, etc.
* Code coverage - How much lines of your code is tested by a unit test
    * So if our unit tests covers 100 lines of code in a 300 lines of code would give a 33.33% code coverage

