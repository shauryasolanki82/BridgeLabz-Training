class ProcessNode {
  int processId;
  int burstTime;
  int remainingTime;
  int priority;
  int waitingTime;
  int turnaroundTime;
  ProcessNode next;
  ProcessNode(int pid, int burstTime, int priority) {
    this.processId = pid;
    this.burstTime = burstTime;
    this.remainingTime = burstTime;
    this.priority = priority;
    this.waitingTime = 0;
    this.turnaroundTime = 0;
    this.next = null;
  }
}

class RoundRobinScheduler {
  private ProcessNode head = null;
  private int timeQuantum;
  private int currentTime = 0;
  private int processCount = 0;
  private int totalWaitingTime = 0;
  private int totalTurnaroundTime = 0;
  RoundRobinScheduler(int timeQuantum) {
      this.timeQuantum = timeQuantum;
  }
  // Add process at end
  public void addProcess(int pid, int burstTime, int priority) {
      ProcessNode newNode = new ProcessNode(pid, burstTime, priority);
      if (head == null) {
          head = newNode;
          newNode.next = head;
      } else {
          ProcessNode temp = head;
          while (temp.next != head) {
              temp = temp.next;
          }
          temp.next = newNode;
          newNode.next = head;
      }
      processCount++;
  }
  // Remove process by ID
  private void removeProcess(ProcessNode prev, ProcessNode curr) {
      if (curr == head && curr.next == head) {
          head = null;
      } else {
          if (curr == head) {
              ProcessNode last = head;
              while (last.next != head) {
                  last = last.next;
              }
              head = head.next;
              last.next = head;
          } else {
              prev.next = curr.next;
          }
      }
  }
  // Simulate Round Robin Scheduling
  public void simulate() {
      if (head == null) {
          System.out.println("No processes to schedule.");
          return;
      }
      ProcessNode current = head;
      ProcessNode prev = null;
      System.out.println("\n--- Round Robin Scheduling ---");
      while (head != null) {
          displayProcesses();
          if (current.remainingTime > timeQuantum) {
              currentTime += timeQuantum;
              current.remainingTime -= timeQuantum;
          } else {
              currentTime += current.remainingTime;
              current.remainingTime = 0;
              current.turnaroundTime = currentTime;
              current.waitingTime =
                      current.turnaroundTime - current.burstTime;
              totalWaitingTime += current.waitingTime;
              totalTurnaroundTime += current.turnaroundTime;
              System.out.println(
                  "Process " + current.processId + " completed."
              );
              removeProcess(prev, current);
              if (prev != null)
                  current = prev.next;
              else
                  current = head;
              continue;
          }
          prev = current;
          current = current.next;
      }
      displayAverages();
  }
  // Display processes after each round
  private void displayProcesses() {
    if (head == null) return;
    ProcessNode temp = head;
    System.out.println("\nCurrent Circular Queue:");
    do {
      System.out.println(
        "PID: " + temp.processId +
        ", Remaining Time: " + temp.remainingTime +
        ", Priority: " + temp.priority
      );
      temp = temp.next;
    } while (temp != head);
  }
  // Display average times
  private void displayAverages() {
      System.out.println("\n--- Scheduling Summary ---");
      System.out.println("Average Waiting Time: " +
              (double) totalWaitingTime / processCount);
      System.out.println("Average Turnaround Time: " +
              (double) totalTurnaroundTime / processCount);
  }
}

public class RoundRobinCPU {
  public static void main(String[] args) {
    RoundRobinScheduler scheduler = new RoundRobinScheduler(4);
    scheduler.addProcess(1, 10, 2);
    scheduler.addProcess(2, 5, 1);
    scheduler.addProcess(3, 8, 3);
    scheduler.simulate();
  }
}
