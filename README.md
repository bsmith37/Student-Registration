# Student-Registration
A system that imitates a simple class registration system for students.
This was a project for CS232 - Computer Programming II.

To create this pseudo registration system, five classes were needed : Time, TimeRange, Course, CourseOfferings, and Student.

Time is made up of two ints: hour, range is 0-23, and minute, range 0-59. Time can be passed two ints or one string (Time(16,30) or
Time("1630")). If two ints are passed, Time will check if the ints are within the ranges and, if ints are accepted, will set the variables.
If a String is passed to Time, Time will call a helper method to parse the numbers into an int array. The variables will be set to the
elements of the int array. If the elements are not valid, the time will be set to a default of 0:0. Time also has three methods to determine
if the Time is before, after, or equaling another Time.

TimeRange is contstructed using two Time objects -- startTime and endTime. When constructed, TimeRange will check to make sure the two
passed Times are not equal. TimeRange is also able to determine the amount of time between startTime and endTime using the method
getDuration() -- which will return the number of minutes as an int. Using contains(Time time), TimeRange can determine if a given time is
within the TimeRange. Using overlaps(TimeRange otherRange), TimeRange can determine whether another TimeRange overlaps with itself.

Course is constructed by several variables: department, number, section, days, time, building, room, faculty, capacity, and enrolled. String department is the department of the course -- for example "CS" for computer science. String number is the course number --
"304". int section is the particular section of the class -- 2. String days are the days of the week that a course is held -- Sunday through
Saturday is represented as "NMTWRFS". TimeRange time is the time the course is held -- 12pm to 1pm. String building is the building the
course is in -- "AH" for Ayers. String room is the room that the course is in -- "359". String faculty is the last name of the professor
teaching the class -- Professor John Doe would be "Doe". int capacity is the number of students that the course can hold. int enrolled is
the number of students currently enrolled in the course. Course also has an enum for days -- Day dayEnum. This class only has getters and
setters except for isFull(), to check if the course can fit another student; meetsOn(Day day), checks if Course is meets on a given day and
returns true or false; and conflictsWith(Course course), which checks the TimeRange of another Course for overlapping times.

CourseOfferings is constructed by an array of Courses and the number of actual Courses in the array -- the default array size is 100 with 0
courses. CourseOfferings can read in a .txt file with the listed Course data (example below) and fill the array by building Courses usin
the .txt file. CourseOfferings can add another course to array manually by using addCourse(Course c).
        Example of input file for CourseOfferings should be formatted as follows:
        
        CS 230 1 MWF 1000 1130 AH 257 Doe 20 18
        CS 230 2 MWF 0815 0945 AH 257 Jones 20 18
        CS 230 3 TWR 1245 1415 AH 363 Smith 20 12
        
Student is constructed by a Course array, the number of Courses in the array -- the default Course array size is 5. Student also has an enum
for representing the status a Course being added to the array (SUCCESS, OVERLOAD, DUPLICATE, or CONFLICT). Student only has one method:
addCourse(Course c), which adds the Course to Student's Course array if the Course does not overlap a course already taken by Student, a
duplicate of a taken Course, or conflicting with a taken Course.

Main ceates a Student, retrieves the CourseOfferings, and attempts to add 11 Courses into student.


I have described each class in the order of lowest-level to highest-level along with the methods.

Time - This class is a representation of time as hours and minutes in military time. Time can be passed a String or two ints.
        convertStringToHoursMins(String time) - converts a String into an int-array to be converted into a Time object.
        before(Time time) - recieves a Time object and determines whether the recieved time is before the current Time.
        after(Time time) - recieves a Time object and determines whether the recieved time is after the current Time.
        equals(Time time) - recieves a Time object and determines whether the recieved time is equal to the current Time.
        setTime(String time) - recieves a String to convert into a Time object
        toString() - returns the current time as a String.
        getters and setters for each variable (Hour and Minute)

TimeRange- This class is a representation of a range of time using two Time objects as a starting time and ending time.
        contains(Time time) - recieves a Time object to determine if the recieved time is within the current TimeRange.
        overlaps(TimeRange otherRange) - recieves another TimeRange object to determine if it and the current TimeRange overlap.
        getDuration() - returns the amount of time between the startTime and endTime in minutes.
        toString() - returns the current TimeRange as a string.
        getters and setters for each variable (startTime and endTime)

Course - This class holds all the relevant information about a particular course: Day, Department, Course Number, Section, Days, Time, Building, Room, Faculty, Capacity, and Enrolled.
        isFull() - returns true if the enrolled is greater than or equal to capacity.
        meetsOn(Day day) - recieves a Day enum to check if the Course meets on the recieved Day.
        conflictsWith(Course course) - recieves a Course object to determine whether the courses overlap.
        toString() - returns the Course as a String.
        getters and setters for all variables.
        
CourseOfferings - This class reads in a text file containing all available Courses and holds them in a Course array.
        addCourse(Course c) - adds a new Course to CourseOfferings.
        getCourse(int index) - returns the Course at the index passed.
        setCourse(int index, Course course) - sets the Course at the specified index to the Course passed.
        getNumCourses() - returns the number of Courses in CourseOfferings.
        toString() - returns a String of CourseOfferings.        

Student - This class represents the account the student will use to register for up to 5 Courses.
        addCourse(Course course) - adds a passed course to the student's Course array after checking for conflictions with other Courses and
        not exceeding the 5 Course limit.

Main - The main class to run the registration simulation and print the results.
