package bridgelabz.json;

import org.json.JSONObject;
import org.json.JSONArray;

public class Student {
	public static void main(String[] args) {
		JSONArray subjects = new JSONArray();
		subjects.put("Physics");
		subjects.put("Chemistry");
		subjects.put("Maths");
		JSONObject students = new JSONObject();
		students.put("Name", "Harshit");
		students.put("Age", 16);
		students.put("Subjects", subjects);
		System.out.println(students.toString());
	}
}
