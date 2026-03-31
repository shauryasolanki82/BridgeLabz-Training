package scenario_based;

import java.util.PriorityQueue;
import java.util.Scanner;

class InvalidBackupPathException extends Exception {
    public InvalidBackupPathException(String message) {
        super(message);
    }
}

class BackupTask implements Comparable<BackupTask> {
    String folderName;
    int priority; 
    long timestamp;

    BackupTask(String folderName, int priority) {
        this.folderName = folderName;
        this.priority = priority;
        this.timestamp = System.nanoTime(); 
    }

    public String getPriorityLabel() {
        if (priority == 1) return "CRITICAL";
        if (priority == 2) return "HIGH";
        return "NORMAL";
    }

    @Override
    public int compareTo(BackupTask other) {
        if (this.priority != other.priority) {
            return this.priority - other.priority;
        }
        return Long.compare(this.timestamp, other.timestamp);
    }

    @Override
    public String toString() {
        return "[" + getPriorityLabel() + "] Backup: " + folderName;
    }
}

class BackupScheduler {
    private PriorityQueue<BackupTask> taskQueue;

    BackupScheduler() {
        taskQueue = new PriorityQueue<>();
    }

    public void scheduleTask(String path, int priority) throws InvalidBackupPathException {
        if (path == null || path.trim().isEmpty()) {
            throw new InvalidBackupPathException("Backup path cannot be empty.");
        }
        if (path.contains("root") || path.contains("system32")) {
            throw new InvalidBackupPathException("Access denied: Restricted system path.");
        }
        if (priority < 1 || priority > 3) {
            System.out.println("Error: Priority must be 1 (Critical), 2 (High), or 3 (Normal).");
            return;
        }

        BackupTask newTask = new BackupTask(path, priority);
        taskQueue.add(newTask);
        System.out.println("Scheduled: " + newTask);
    }

    public void runBackups() {
        System.out.println("STARTING BACKUP SEQUENCE");
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks pending.");
            return;
        }

        while (!taskQueue.isEmpty()) {
            BackupTask task = taskQueue.poll();
            System.out.println("Processing -> " + task.folderName + " (" + task.getPriorityLabel() + ")");
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ALL BACKUPS COMPLETED");
    }

    public void viewPendingTasks() {
        System.out.println("Pending Tasks");
        if (taskQueue.isEmpty()) {
            System.out.println("[Queue Empty]");
            return;
        }
        
        PriorityQueue<BackupTask> tempQueue = new PriorityQueue<>(taskQueue);
        while (!tempQueue.isEmpty()) {
            System.out.println(tempQueue.poll());
        }
    }
}

public class FileBackupSystem {
    public static void main(String[] args) {
        BackupScheduler scheduler = new BackupScheduler();
        Scanner input = new Scanner(System.in);
        int choice, priority;
        String path;

        System.out.println("AUTOMATED BACKUP SCHEDULER");
        System.out.println("Priority Levels: 1=Critical, 2=High, 3=Normal");

        while (true) {
            System.out.println("1. Schedule New Backup");
            System.out.println("2. Execute All Backups");
            System.out.println("3. View Pending Queue");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();
            } else {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Folder Path: ");
                    path = input.nextLine();
                    System.out.print("Enter Priority (1-3): ");
                    if (input.hasNextInt()) {
                        priority = input.nextInt();
                        try {
                            scheduler.scheduleTask(path, priority);
                        } catch (InvalidBackupPathException e) {
                            System.out.println("EXCEPTION: " + e.getMessage());
                        }
                    } else {
                        input.nextLine();
                        System.out.println("Invalid priority input.");
                    }
                    break;
                case 2:
                    scheduler.runBackups();
                    break;
                case 3:
                    scheduler.viewPendingTasks();
                    break;
                case 4:
                    System.out.println("Shutting down scheduler.");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
