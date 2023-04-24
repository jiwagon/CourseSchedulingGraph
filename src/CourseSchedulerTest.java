import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseSchedulerTest {

    @org.junit.jupiter.api.Test
    void addCourse() {

        CourseScheduler scheduler = new CourseScheduler();

        // Test adding a single class
        scheduler.addCourse("IST 110");
        assertEquals(1, scheduler.courses.size());
        assertEquals("IST 110", scheduler.courses.get(0).courseName);

        // Test adding multiple classes
        scheduler.addCourse("IST 210");
        scheduler.addCourse("IST 216");
        assertEquals(3, scheduler.courses.size());
        assertEquals("IST 210", scheduler.courses.get(1).courseName);
        assertEquals("IST 216", scheduler.courses.get(2).courseName);

        System.out.println(scheduler);
    }

    @org.junit.jupiter.api.Test
    void addPrerequisite() {
        CourseScheduler scheduler = new CourseScheduler();

        // Add classes to the scheduler
        scheduler.addCourse("IST 242");
        scheduler.addCourse("IST 311");
        scheduler.addCourse("IST 412");

        // Test adding a prerequisite between two classes
        scheduler.addPrerequisite("IST 242", "IST 311", 1);
        assertEquals(1, scheduler.courses.get(0).edges.size());
        assertEquals("IST 311", scheduler.courses.get(0).edges.get(0).preRequisite.courseName);
        assertEquals(1, scheduler.courses.get(0).edges.get(0).weight);

        // Test adding multiple prerequisites between the same classes
        scheduler.addPrerequisite("IST 242", "IST 412", 2);
        assertEquals(2, scheduler.courses.get(0).edges.size());
        assertEquals("IST 412", scheduler.courses.get(0).edges.get(1).preRequisite.courseName);
        assertEquals(2, scheduler.courses.get(0).edges.get(1).weight);

        System.out.println(scheduler);
    }
}