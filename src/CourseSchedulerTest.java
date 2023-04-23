import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseSchedulerTest {

    @org.junit.jupiter.api.Test
    void addCourse() {

        CourseScheduler scheduler = new CourseScheduler();

        // Test adding a single class
        scheduler.addCourse("ClassA");
        assertEquals(1, scheduler.courses.size());
        assertEquals("ClassA", scheduler.courses.get(0).courseName);

        // Test adding multiple classes
        scheduler.addCourse("ClassB");
        scheduler.addCourse("ClassC");
        assertEquals(3, scheduler.courses.size());
        assertEquals("ClassB", scheduler.courses.get(1).courseName);
        assertEquals("ClassC", scheduler.courses.get(2).courseName);

        System.out.println(scheduler);
    }

    @org.junit.jupiter.api.Test
    void addPrerequisite() {
    }
}