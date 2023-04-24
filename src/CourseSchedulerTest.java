import org.junit.jupiter.api.Test;

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

        // To inform repeated course is being added.
        scheduler.addCourse("IST 210");
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

        scheduler.addPrerequisite("IST 311", "IST 412", 1);
        assertEquals(2, scheduler.courses.get(0).edges.size());
        assertEquals("IST 412", scheduler.courses.get(0).edges.get(1).preRequisite.courseName);
        assertEquals(2, scheduler.courses.get(0).edges.get(1).weight);

        System.out.println("\nPrerequisite: Courses Led-to");
        System.out.println(scheduler);
    }

    @Test
    void BFS() {
        CourseScheduler scheduler = new CourseScheduler();

        scheduler.addCourse("IST 242");
        scheduler.addCourse("IST 311");
        scheduler.addCourse("IST 412");
        scheduler.addCourse("IST 310");
        scheduler.addCourse("IST 316");

        // Test adding a prerequisite between two classes
        scheduler.addPrerequisite("IST 242", "IST 311", 1);
        scheduler.addPrerequisite("IST 311", "IST 412", 1);
        scheduler.addPrerequisite("IST 242", "IST 310", 1);
        scheduler.addPrerequisite("IST 310", "IST 316", 1);


        // Original Path
        System.out.println("\nThe original paths in given graph:");
        System.out.println(scheduler.BFS("IST 242", "IST 412"));
        System.out.println(scheduler.BFS("IST 242", "IST 316"));

        // Shorter Path
        scheduler.addPrerequisite("IST 242", "IST 412", 1);
        scheduler.addPrerequisite("IST 242", "IST 316", 1);

        System.out.println("The shorter paths that replace original paths in given graph:");
        System.out.println(scheduler.BFS("IST 242", "IST 412"));
        System.out.println(scheduler.BFS("IST 242", "IST 316"));

        scheduler.addCourse("A");
        scheduler.addCourse("B");
        scheduler.addCourse("C");
        scheduler.addCourse("D");
        scheduler.addCourse("E");
        scheduler.addCourse("F");

        scheduler.addPrerequisite("A", "B", 1);
        scheduler.addPrerequisite("B", "C", 1);
        scheduler.addPrerequisite("C", "D", 1);
        scheduler.addPrerequisite("B", "E", 1);
        scheduler.addPrerequisite("D", "F", 1);

        System.out.println("\nThe paths available in given graph:");
        System.out.println(scheduler.BFS("A","E"));
        System.out.println(scheduler.BFS("B","F"));
        System.out.println(scheduler.BFS("A","F"));
    }
}