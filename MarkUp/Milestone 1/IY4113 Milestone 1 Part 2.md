# IY4113 Milestone 1 Part 2

| Assessment Details | Please Complete All Details                                             |
| ------------------ | ----------------------------------------------------------------------- |
| Group              | Group A                                                                 |
| Module Title       | IY4113 Applied Software Engineering using Object-Orientated Programming |
| Assessment Type    | Milestone 1                                                             |
| Module Tutor Name  | Jonathan Shore                                                          |
| Student ID Number  | P489062                                                                 |
| Date of Submission | 22/03/2026                                                              |
| Word Count         | 1597                                                                    |
| GitHub Link        | https://github.com/t0489062Bashar/T0489062_IY4113_JAVA                  |

- [x] *I confirm that this assignment is my own work. Where I have referred to academic sources, I have provided in-text citations and included the sources in
  the final reference list.*
- [x] *Where I have used AI, I have cited and referenced appropriately.

------------------------------------------------------------------------------------------------------------------------------

### Purpose of the Program

------------------------------------------------------------------------------------------------------------------------------

Is to act as a public transport companion travel app that allows the user to keep track of their daily travels, allowing them to save the details of each individual journey, such as the starting zone, destination zone, whether the trip is during peak or off-peak times and the passenger type. The program shall calculate the base fare for the journey based on this information using a dataset (which is editable by administrators), before applying any valid discounts or caps. The program shall allow the user to log in as a **rider** by either creating a new profile (which shall capture the rider's name, passenger type and default payment option) or loading an existing profile. While logged into a rider profile, journeys shall be saved to that particular profile in JSON format Alternatively, the user shall be able to log into a password protected **administrator** mode which will allow them to view and edit fare rules, discounts, daily caps, and peak time windows. All changes shall be validated before being saved and enforced.

### Core program functionality

- **Support multiple roles**
  
  - Allow the user to log in using a rider profile, loading all previous journeys made by that profile.
  
  - Allow the user to create a new rider profile, capturing and validating their name, passenger type, and default payment method.
  
  - Allow the user to log into a password-protected administartor mode, allowing them to edit the confdiguration file for the system, including fare rules, discounts, daily caps, and peak time windows. All changes shall be validated before being saved and enforced.

- **Load config file**
  
  - Load configuration data from a pre-existing JSON config file.
  
  - If the config file is missing, the system shall use safe values provided through a default dataset

- **Manage journeys**
  
  - Store multiple journeys, each with its own details (date, zones, passenger type, time band) as well as calculate the total.
  
  - Assign a unique ID to each journey.
  
  - Display summary (exported as a CSV file, and a text report) which includes:
    
    - Number of journeys
    
    - Total cost
    
    - Average cost per journey
    
    - Most expensive journey by charged fare, with ID
    
    - Whether cap was reached, and how much the rider saved due to the cap
    
    - Category counts: 
      
       peak vs off-peak, counts per zone
  
  - Recalculate totals when necessary
  
  - Allow the import and export of journeys in CSV format.
  
  - Save journeys to their respective rider in JSON format.

- **Display user menu**
  
  - Show a simple menu that allows the user to choose what they'd like to do.
  
  - Have clear prompts to signify successful actions.
  
  - Loop the menu until the user exists.

- **Allow the user to manage journeys**
  
  - Remove journeys from the list using its ID.
  
  - Add multiple journeys per session.
  
  - List all journeys.
  
  - Filter journeys by journey details (Zone, Time band, Passenger type, Date).
  
  - Reset list.

- **Validate inputs**
  
  - Validate all information entered by the user and prevent program crash.
  
  - Alert the user if any inputs are invalid, communicating the error clearly.

- **Enforce daily caps and discounts**
  
  - Enforce daily cap and discounts for respective passenger types.
    
    ### System constraints (limitations / rules)

- **Daily cap and discounts**: each passenger type (adult, student, child, senior citizen) has their own respective daily cap and discount rate.

- **Information needed**: All trip information is needed for the app to save the journey (e.g., starting zone, ending zone, passenger type).

- **Booking rule**: a booking can only succeed if **all requested seats** are valid and available.

- **Scope constraint**: journeys are tied only to zones, not to a mode of transport or specific location.

- **Session uniqueness**: journey IDs are generated to be unique during the run, but there’s no guarantee across separate runs since nothing is saved.

### Input Process Output Table

------------------------------------------------------------------------------------------------------------------------------

| Select role          | User role choice (1-2)                                                   | Validate input is an integer in range; route to chosen function                                                                               | Confirmation of selected option / next screen shown                                             |
| -------------------- | ------------------------------------------------------------------------ | --------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
| Load rider profile   | Rider profile choice (1-x)(if applicable)                                | Validate input is an integer in range; load chosen rider profile                                                                              | Confirmation of chosen profile OR "Invalid choice" OR "No rider profiles found" OR "File error" |
| Create rider profile | riderName, passengerType, paymentMethod                                  | Validate inputs aren't blank; validate choice for passenger type; create rider profile and write to JSON file                                 | Confirmation of profile creation OR "Invalid input" OR "File error"                             |
| Access admin mode    | adminPassword                                                            | Check entered password matches existing password; load admin profile                                                                          | Confirmation of correct password OR "Invalid password" OR "File error"                          |
| Edit fare rules      | Base fares, passenger discounts, daily caps, peak windows                | Validate input data; update config file                                                                                                       | Confirmation of update OR "Invalid input" OR "File error"                                       |
| Display main menu    | User menu choice (0–7)                                                   | Validate input is an integer in range; route to chosen function                                                                               | Confirmation of selected option / next screen shown                                             |
| Add Journey          | Date, TimeBand, StartZone, EndZone                                       | Validate journey details; calculate and store: date, zones crossed, base fare, discounted fare (if applicable), fare after applying daily cap | Confirmation of journey details                                                                 |
| Filter journeys      | Search condition (Passenger type, Time band, StartZone or EndZone, Date) | Filter all journeys by the input search condition                                                                                             | Display all journeys that match the filter input by the user.                                   |
| Remove journey       | JourneyID                                                                | Remove journey with matching ID from log and recalculate totals                                                                               | Confirmation of journey removal and display new total OR "journey ID not found"                 |
| Reset day            | Confirmation                                                             | Clear all journeys and totals from Log.                                                                                                       | Confirm reset OR “No journeys recorded”                                                         |
| Save day             | User choice (1-2)                                                        | Validate input is an integer in range; save rider profile and journeys if applicable                                                          | Confirmation of day state being saved OR "Invalid input" OR "File error"                        |
| Exit program         | Menu choice = 0                                                          | End loop; terminate program                                                                                                                   | “Goodbye!” message                                                                              |

---

![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow1.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow2.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow3.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow4.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow5.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow6.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow7.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow8.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow9.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow10.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow11.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow12.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow13.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow14.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow15.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow16.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow17.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow18.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow19.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow20.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow21.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow22.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow23.jpg)![](C:\NTIC\Java\MarkUp\Part%202\Milestone%201\Flow24.jpg)

Please check github for clearer images: https://github.com/t0489062Bashar/T0489062_IY4113_JAVA

------------------------------------------------------------------------------------------------------------------------------

### Research (minimum of 1 required, preferrebly 2)

---



------------------------------------------------------------------------------------------------------------------------------Name of program: Trippanion
Reference (link): [GitHub - thekampany/tripproject: Trippanion is a Trip Planning Companion application for family and friends · GitHub](https://github.com/thekampany/tripproject)
What it does well (2-3 features that work effectively): 

1. Allows collaboration between multiple users

2. Shows a map including places relevant to the trip itinerary

3. Allows the user to create a checklist for the trip


What it does poorly (at least 1 feature):

- Could be difficult to install and set up

Key design ideas you could reuse (e.g., layout, navigation, input/output, program structure): Graphical user interface
Screenshot (showing the interface/output):

![](C:\Users\paper\AppData\Roaming\marktext\images\2026-03-22-23-19-39-image.png)

---

Name of program: TravelCompanion
Reference (link): [GitHub - sjaindl/TravelCompanion: A travel app that offers all in one place: Discovering, planning and remembering travels · GitHub](https://github.com/sjaindl/TravelCompanion) 

What it does well (2-3 features that work effectively):

1. Allows user to drop pins on desired locations to explore

2. Displays basic information about the destination and country, as well as photos

3. Offers Wikipedia and Wikivoyage articles about the destination

What it does poorly (at least 1 feature):

- Could be difficult to install for normal users (requires and IDE and commands to install)

Key design ideas you could reuse (e.g., layout, navigation, input/output, program structure): Pins and user trips persisting between runs.
Screenshot (showing the interface/output):![](C:\Users\paper\AppData\Roaming\marktext\images\2026-03-22-23-31-36-image.png)

------------------------------------------------------------------------------------------------------------------------------

### Gantt Chart

------------------------------------------------------------------------------------------------------------------------------

![](C:\Users\paper\AppData\Roaming\marktext\images\2026-03-22-23-41-38-image.png)
------------------------------------------------------------------------------------------------------------------------------

### Diary Entries

------------------------------------------------------------------------------------------------------------------------------

20/03/2026 Diary Entry 1 - Analysis
------------------------------------------------------------------------------------------------------------------------------

To begin with, I retrieved the work I completed for the analysis of part 1, polished it, and built off it. I carefully analysed the assignment brief in order to ascertain the requirements that must be met in order for the program to be considered functional. I carefully implemented the new challenges and pre-requisites posed by part 2 into my pre-existing analysis for part 1, and produced a new functional requirement list and input-process-output table to account for the new roles and files that the program must now handle.



## 21/03/2026 Diary Entry 2 - Design

The following day, I began to do the same with my flowchart designs for part 1. I created new flowcharts to facilitate the new required systems, seamlessly integrated them with the pre-existing diagrams, and edited the old designs where it was required.







---

### References

- thekampany (2026). *Trippanion*. Retrieved from: [GitHub - thekampany/tripproject: Trippanion is a Trip Planning Companion application for family and friends · GitHub](https://github.com/thekampany/tripproject)  [Accessed 22 March 2026]

- Jaindl, S. (2025). *TravelCompanion*. Retrieved from: [GitHub - sjaindl/TravelCompanion: A travel app that offers all in one place: Discovering, planning and remembering travels · GitHub](https://github.com/sjaindl/TravelCompanion) [Accessed 22 March 2026]
