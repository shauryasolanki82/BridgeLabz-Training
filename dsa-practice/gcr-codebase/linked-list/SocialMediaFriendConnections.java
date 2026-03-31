import java.util.HashSet;
import java.util.Set;

// Node representing a User
class UserNode {
    int userId;
    String name;
    int age;
    Set<Integer> friends;   // Stores friend IDs
    UserNode next;

    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new HashSet<>();
        this.next = null;
    }
}

// Singly Linked List for Users
class SocialNetwork {
    private UserNode head;

    // Add a new user
    public void addUser(int id, String name, int age) {
        UserNode newUser = new UserNode(id, name, age);
        newUser.next = head;
        head = newUser;
    }

    // Find user by ID
    private UserNode findUserById(int id) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Search user by Name or ID
    public void searchUser(String key) {
        UserNode temp = head;
        while (temp != null) {
            if (String.valueOf(temp.userId).equals(key) || temp.name.equalsIgnoreCase(key)) {
                System.out.println("User Found: " + temp.userId + ", " + temp.name + ", Age: " + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    // Add friend connection
    public void addFriend(int id1, int id2) {
        UserNode u1 = findUserById(id1);
        UserNode u2 = findUserById(id2);

        if (u1 != null && u2 != null) {
            u1.friends.add(id2);
            u2.friends.add(id1);
            System.out.println("Friend connection added.");
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Remove friend connection
    public void removeFriend(int id1, int id2) {
        UserNode u1 = findUserById(id1);
        UserNode u2 = findUserById(id2);

        if (u1 != null && u2 != null) {
            u1.friends.remove(id2);
            u2.friends.remove(id1);
            System.out.println("Friend connection removed.");
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Find mutual friends
    public void mutualFriends(int id1, int id2) {
        UserNode u1 = findUserById(id1);
        UserNode u2 = findUserById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }

        Set<Integer> mutual = new HashSet<>(u1.friends);
        mutual.retainAll(u2.friends);

        System.out.println("Mutual Friends IDs: " + mutual);
    }

    // Display all friends of a user
    public void displayFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friends);
        } else {
            System.out.println("User not found.");
        }
    }

    // Count number of friends for each user
    public void countFriends() {
        UserNode temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friends.size() + " friends.");
            temp = temp.next;
        }
    }
}

// Main Class
public class SocialMediaFriendConnections {
    public static void main(String[] args) {
        SocialNetwork sn = new SocialNetwork();
        // Adding users
        sn.addUser(1, "Alice", 22);
        sn.addUser(2, "Bob", 24);
        sn.addUser(3, "Charlie", 23);
        sn.addUser(4, "Daisy", 21);
        // Friend connections
        sn.addFriend(1, 2);
        sn.addFriend(1, 3);
        sn.addFriend(2, 3);
        sn.addFriend(3, 4);
        // Operations
        sn.displayFriends(1);
        sn.mutualFriends(1, 2);
        sn.searchUser("Charlie");
        sn.removeFriend(1, 3);
        sn.displayFriends(1);
        sn.countFriends();
    }
}
