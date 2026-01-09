class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class CircularTaskScheduler {
    private TaskNode head;
    private TaskNode current;

    // Add at beginning
    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
        } else {
            TaskNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
    }

    // Add at end
    public void addAtEnd(int id, String name, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
        } else {
            TaskNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int position, int id, String name, int priority, String dueDate) {
        if (position <= 1 || head == null) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        TaskNode temp = head;
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove task by Task ID
    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        TaskNode temp = head;
        TaskNode prev = null;

        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    TaskNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                    if (current == temp) current = head;
                } else {
                    prev.next = temp.next;
                    if (current == temp) current = temp.next;
                }
                System.out.println("Task removed: " + taskId);
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task not found.");
    }

    // View current task and move to next
    public void viewNextTask() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }

        displayTask(current);
        current = current.next;
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        TaskNode temp = head;
        System.out.println("\nTask List:");
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        TaskNode temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }

    // Helper method
    private void displayTask(TaskNode task) {
        System.out.println(
            "Task ID: " + task.taskId +
            ", Name: " + task.taskName +
            ", Priority: " + task.priority +
            ", Due Date: " + task.dueDate
        );
    }
}

public class TaskSchedulerApp {
    public static void main(String[] args) {
        CircularTaskScheduler scheduler = new CircularTaskScheduler();

        scheduler.addAtBeginning(1, "Design UI", 1, "2026-01-10");
        scheduler.addAtEnd(2, "Develop Backend", 2, "2026-01-15");
        scheduler.addAtPosition(2, 3, "Database Setup", 1, "2026-01-12");

        scheduler.displayAllTasks();

        scheduler.viewNextTask();
        scheduler.viewNextTask();

        scheduler.searchByPriority(1);

        scheduler.removeByTaskId(2);
        scheduler.displayAllTasks();
    }
}
