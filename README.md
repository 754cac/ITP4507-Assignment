# ITP4507-Assignment

This repository contains the implementation of the Sport Teams Management System (STMS) for the ITP4507 assignment. The STMS is a team sport management system developed by the Magical Athletes Teams Management Company. It provides functionality for managing different sports teams and players' information.

## Contents

- [Introduction](#introduction)
- [System Functions](#system-functions)
- [Design Principles](#design-principles)
- [Design Patterns](#design-patterns)
- [Assumptions](#assumptions)
- [Application Design](#application-design)
- [Testing](#testing)
- [Source Code](#source-code)

## Introduction

The STMS is designed to support the management of various team sports. It currently supports volleyball and football teams, and the system is built to be easily extendable to support additional team sports in the future. The existing classes `Team`, `VolleyballTeam`, `FootballTeam`, and `Player` are to be kept unchanged.

## System Functions

The following functions are provided by the STMS:

1. Create a Team record: Allows creating a new team for a specific sport.
2. Set the current team: Sets the current team by providing the Team ID.
3. Add a player to the current team: Adds a player to the currently selected team.
4. Modify the position of a player in the current team: Updates the position of a player in the current team.
5. Delete a player from the current team: Removes a player from the current team.
6. Show the current team: Displays the information of the current team.
7. Display all teams: Displays the information of all teams.
8. Change the name of the current team: Updates the name of the current team.
9. Undo last command: Reverts the last command executed.
10. Redo the last undone command: Executes the last undone command.
11. Show undo/redo list: Displays the list of executed commands that can be undone or redone.
12. Exit System: Terminates the STMS.

## Design Principles

The system design adheres to the following design principle:

- Open Closed Principle: The system design is open for extension but closed for modification. It allows for the addition of new features or team sports without modifying the existing classes.

## Design Patterns

The following design patterns are applied in the STMS:

1. Command Pattern: The Command pattern is used to implement various system functions as individual commands. Each command encapsulates a particular action and can be executed, undone, or redone.

2. Factory Pattern or Abstract Factory Pattern: The Factory or Abstract Factory pattern is used to create different types of Command objects and team/player objects. It enables the system to instantiate the appropriate objects based on the specific sport or team requirements.

3. Memento Pattern: The Memento pattern is used to provide the undo and redo functionality for modifying a player's position and changing a team's name. It allows capturing and restoring the internal state of objects without exposing their implementation details.

## Assumptions

The following assumptions are made for the STMS:

1. The system is implemented as a console application.
2. Team IDs are unique identifiers used to manage teams.
3. Players within a team are identified by their id and are assumed to be unique.
4. The scope of the system is focused on managing players within teams, and extensive functionalities like match schedules or statistics are not included.
5. Ignore command case, and assume user input are all correct.

## Application Design

The application design is detailed in the [Class Diagram](./class-diagram.png). It illustrates the relationships and interactions between the main classes, including `Team`, `VolleyballTeam`, `FootballTeam`, and `Player`. The class diagram represents the usage of the Command pattern, Factory/Abstract Factory pattern, and Memento pattern in the system.

## Testing

A thorough automated test script are developed to ensure the proper functionality and correctness of the system. The test plan covers all the system functions, considering various scenarios and edge cases. The test cases are executed to validate the expected behavior of the system.
