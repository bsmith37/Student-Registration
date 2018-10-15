# Student-Registration
A system that imitates a simple class registration system for students.
This was a project for CS232 - Computer Programming II.

I have described each class in the order of lowest-level to highest-level along with the methods.

Time - This class is a representation of time as hours and minutes in military time. Time can be passed a String or two ints.
        convertStringToHoursMins(String time) - converts a String into an int-array to be converted into a Time object.
        before(Time time) - recieves a Time object and determines whether the recieved time is before the current Time.
        after(Time time) - recieves a Time object and determines whether the recieved time is after the current Time.
        equals(Time time) - recieves a Time object and determines whether the recieved time is equal to the current Time.
        setTime(String time) - recieves a String to convert into a Time object
        toString() - returns the current time as a String.
        getters and setters for each variable (Hour and Minute)

Timerange- This class is a representation of a range of time using two Time objects as a starting time and ending time.
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
        addCourse(Course course) - adds a passed course to the student's Course array after checking for conflictions with other Courses and not exceeding the 5 Course limit.

Main - The main class to run the registration simulation and print the results.
