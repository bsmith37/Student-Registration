public class Main {
    public enum Result { SUCCESS, INVALID, FULL, OVERLOAD, DUPLICATE, CONFLICT };
    
    public static Result selectCourse(Student student, 
                                      CourseOfferings offerings,
                                      int courseIndex) {
        // TODO
        // Try to add the specified course (by index) to the student's
        // schedule. If successful, increase its enrollment by 1. Return
        // the appropriate result in each case.
        // SUCCESS - no errors
        // INVALID - course index is invalid
        // FULL - course is full
        // OVERLOAD - student schedule is full
        // DUPLICATE - student schedule already contains the course
        // CONFLICT - course conflicts with another on student schedule
        
        try{
            Course c = offerings.getCourse(courseIndex);
            if(c.getEnrolled() == c.getCapacity()){
                return Result.FULL;
            }
            else{
                Student.Result r = student.addCourse(c);
                if(r == Student.Result.OVERLOAD) return Result.OVERLOAD;
                if(r == Student.Result.DUPLICATE) return Result.DUPLICATE;
                if(r == Student.Result.CONFLICT) return Result.CONFLICT;
                else{
                    c.setEnrolled(c.getEnrolled()+1);
                    return Result.SUCCESS;
                }
            
                
            }
        
        }
        catch(ArrayIndexOutOfBoundsException e){
            return Result.INVALID;
        }
        
    }

    public static void main(String[] args) throws java.io.FileNotFoundException  {
        // TODO
        // For each index in the set [1, 3, 0, 6, 5, 7, 8, 9, 10, 11, 12]
        //    Display the offerings
        //    Choose the index
        //    Display the result
        //
        // The results should be 
        // FULL, SUCCESS, DUPLICATE, FULL, SUCCESS, CONFLICT, 
        // SUCCESS, SUCCESS, SUCCESS, OVERLOAD, OVERLOAD
        // 
        // The input file with the course offerings is located
        // at the path "./Root/res/input.txt".
        int[] courseChoices = {1, 3, 0, 6, 5, 7, 8, 9, 10, 11, 12};
        Student stu = new Student();
        CourseOfferings offerings = new CourseOfferings("input.txt");
        for(int i = 0; i < courseChoices.length; i++){
            int index = courseChoices[i];
            System.out.println(offerings);
            Result r = selectCourse(stu, offerings, index);
            System.out.println(r + "\n");
        }
    }
}
