public class Doctor{
    private String doctorName;
    private String specialty;
    private boolean isAvailable;

    public Doctor(String doctorName, String specialty, boolean isAvailable){
        this.doctorName = doctorName;
        this.specialty = specialty;
        this.isAvailable = isAvailable;
    }

    String getDoctorName(){
        return doctorName;
    }
    String getSpeciality(){
        return specialty;
    }
    boolean getIsAvailable(){
        return isAvailable;
    }

    public String toString(){
        return doctorName;
    }
}