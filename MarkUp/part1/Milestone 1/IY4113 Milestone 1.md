# IY4113 Milestone 1

| Assessment Details | Please Complete All Details                                      |
| ------------------ | ---------------------------------------------------------------- |
| Group              | 443 A                                                            |
| Module Title       | Applied Software Engineering using Object Orientated Programming |
| Assessment Type    | java fundamentals part 1                                         |
| Module Tutor Name  | Jonathan Shore                                                   |
| Student ID Number  | P489062                                                          |
| Date of Submission | 25/01/2026                                                       |
| Word Count         | 1200                                                             |

- [x] *I confirm that this assignment is my own work. Where I have referred to academic sources, I have provided in-text citations and included the sources in
  the final reference list.*
- [x] *Where I have used AI, I have cited and referenced appropriately.*

------------------------------------------------------------------------------------------------------------------------------

### Purpose of the Program

------------------------------------------------------------------------------------------------------------------------------

 Is to act as a public transport companion travel app that allows the user to keep track of their daily travels, allowing them to save the details of each individual journey, such as the starting zone, destination zone, whether the trip is during peak or off-peak times and the passenger type. The program shall calculate the base fare for the journey based on this information using a dataset, before applying any valid discounts or caps.

### Core program functionality

- **Manage journeys**
  
  - Store multiple journeys, each with its own details (date, zones, passenger type, time band) as well as calculate the total.
  - Assign a unique ID to each journey
  - Display summaries such as total costs, averages, and category counts

- **Display user menu**
  
  - Show a simple menu that allows the user to choose what they'd like to do.
  
  - Have clear prompts to signify successful actions.
  
  - Loop the menu until the user exists

- **Allow the user to manage journeys**
  
  - Remove journeys from the list using its ID.
  
  - Add multiple journeys per session.
  
  - List all journeys.
  
  - Filter journeys by journey details (Zone, Time band).
  
  - Reset list.

- **Validate inputs**
  
  - Validate all information entered by the user.
  
  - Alert the user if any inputs are invalid.

- **Enforce daily caps and discounts**
  
  - Enforce daily cap and discounts for respective passenger types.
    
    ### System constraints (limitations / rules)

- **No persistence**: journeys exist only while the program is running (no file/database use).

- **Console UI only**: interaction is via text menus and keyboard input.

- **Daily cap and discounts**: each passenger type (adult, student, child, senior citizen) has their own respective daily cap and discount rate.

- **Information needed**: All trip information is needed for the app to save the journey (e.g., starting zone, ending zone, passenger type).

- **Booking rule**: a booking can only succeed if **all requested seats** are valid and available.

- **Scope constraint**: journeys are tied only to zones, not to a mode of transport or specific location.

- **Session uniqueness**: journey IDs are generated to be unique during the run, but there’s no guarantee across separate runs since nothing is saved.

------------------------------------------------------------------------------------------------------------------------------

### Input Process Output Table

------------------------------------------------------------------------------------------------------------------------------

| Feature / Task    | Inputs                                                                   | Processing (what the system does)                                                                                                             | Outputs                                                                                                                                       |
| ----------------- | ------------------------------------------------------------------------ | --------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------- |
| Start program     | None (program launch)                                                    | Create `Day` object, create Log, initialise running totals for each passenger type                                                            | Main menu displayed                                                                                                                           |
| Display main menu | User menu choice (0–7)                                                   | Validate input is an integer in range; route to chosen function                                                                               | Confirmation of selected option / next screen shown                                                                                           |
| Add Journey       | Date, TimeBand, StartZone, EndZone, PassengerType                        | Validate journey details; calculate and store: date, zones crossed, base fare, discounted fare (if applicable), fare after applying daily cap | Confirmation of journey details                                                                                                               |
| Assign ID         | Journey                                                                  | Assign a unique ID to journey                                                                                                                 | None                                                                                                                                          |
| List all journeys | Log                                                                      | Load all journeys for the day, and their details                                                                                              | Display all journeys done that day in a list, showing each journey's details, as well as base fare, the discount applied and the charged fare |
| Filter journeys   | Search condition (Passenger type, Time band, StartZone or EndZone, Date) | Filter all journeys by the input search condition                                                                                             | Display all journeys that match the filter input by the user.                                                                                 |
| Remove journey    | JourneyID                                                                | Remove journey with matching ID from log and recalculate totals                                                                               | Confirmation of journey removal and display new total OR "journey ID not found"                                                               |
| Reset day         | Confirmation                                                             | Clear all journeys and totals from Log.                                                                                                       | Confirm reset OR “No journeys recorded”                                                                                                       |
| Round Values      | Fares and Totals                                                         | Round all prices to 2 decimal points.                                                                                                         | None                                                                                                                                          |
| Exit program      | Menu choice = 0                                                          | End loop; terminate program                                                                                                                   | “Goodbye!” message                                                                                                                            |

------------------------------------------------------------------------------------------------------------------------------

### Gantt Chart

------------------------------------------------------------------------------------------------------------------------------

![](C:\Users\paper\AppData\Roaming\marktext\images\2026-01-25-22-28-23-image.png)
------------------------------------------------------------------------------------------------------------------------------

### Diary Entries

------------------------------------------------------------------------------------------------------------------------------

### 

### 25/01/2026 **Diary Entry 1 – Agony**

Today I tackled the entirety of milestone 1, and completed it to the best of my abilities. Sitting down and attempting all the milestone objectives in one sittinge has certainly been an experience. An experience that could be described in many words, such as: boring, monotonous, mind numbing, and most fitting of all, soul draining. This is because I had to interact with my least favourite part of computer science: working to plan on how to work on other things. I despise it for the same reason I despise algorithm design; it feels like a waste of both my time and energy.

But I digress. I carefully analysed the program specification and was able to identify what I believe to be the core program competencies, as well its constraints. I then analysed the potential inputs and outputs handled by the program and created an input-process-output table based on that. It feels like I both overanalysed the inputs/outputs, and didn't analyse them enough at the same time. I created a Gantt Chart online using ClickUp and added the milestone 1 and milestone 2 tasks.

I am tired, yet it feels like I haven't done any work. Why even bother.

------------------------------------------------------------------------------------------------------------------------------


