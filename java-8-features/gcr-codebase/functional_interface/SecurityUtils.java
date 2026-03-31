package functional_interface;

public interface SecurityUtils {
	
	static boolean passwordStrengthValidator(String password) {
		if(password==null || password.length()<8) return false;
		boolean hasLowerCase=false;
		boolean hasUpperCase=false;
		boolean hasDigit=false;
		boolean hasSpecial=false;
		for(char c:password.toCharArray()) {
			if(Character.isUpperCase(c)) {
				hasUpperCase=true;
			}else if(Character.isLowerCase(c)) {
				hasLowerCase=true;
			}else if(Character.isDigit(c)) {
				hasDigit=true;
			}else {
				hasSpecial=true;
			}
		}
		return hasUpperCase && hasLowerCase && hasDigit && hasSpecial;
	}
}
