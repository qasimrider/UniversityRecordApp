# University-App

###### This Application is build on a Multi modules using MVVM, Clean Architecture approaches 

The Approach to write this software is pretty much in an isolated way. Below are the brief description of the modules in the software

## Core Libs
1. HILT for DI
2. Jetpack Architecture components
3. Toml dependencies

## App 
This is the Gateway to the whole application containing DI Initialization and in our case it contain MainActivity.
On top of that this module have all the dependency which are present in our application
###### Purposes
1. Initializing Dependency Injection
2. Hosting the Application Root 


## Common
In this module common classes are kept to provide support to the other modules 
###### Purposes
1. Base classes for Fragments & Activities
2. Application Common classes like (Styles,colors,Extensions)
3. This module don't have any dependency from the project

## Dtos
This is providing the binding capabilities to the UI layer in order to show the data. This is kind of the bridge between Repositories and data module with out having cyclic dependency.This module dont have any dependency from the application
###### Purpose
1. Displaying the Actual data to the UI layer 


## Data
This module is on the bottom layer of the project. Dealing with repository only to get the data from the Network API client, also dump the data in DB And obviously it can access the DTOS & common module
###### Purpose
1. Dealing with the Retrofit client to get the data
2. Dealing with Room and save the data


## Feature
Here we have 2 feature module one contains list and the other contains detail UI

