import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlightUtil {
        public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException{
            if(flightNumber == null){
                throw new InvalidFlightException("The flight number "+flightNumber+" is invalid");
            }
            String regex = "FL-[1-9]{1}[0-9]{3}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(flightNumber);
            if(matcher.matches()){
                return true;
            }
            throw new InvalidFlightException("The flight number "+flightNumber+" is invalid");
        }
        public boolean validateFlightName(String flightName) throws InvalidFlightException {

            if (flightName == null) {
                throw new InvalidFlightException("The flight name " + flightName + " is invalid");
            }

            if (flightName.equalsIgnoreCase("SpiceJet") ||
            flightName.equalsIgnoreCase("Vistara") ||
            flightName.equalsIgnoreCase("IndiGo") ||
            flightName.equalsIgnoreCase("Air Arabia")) {

            return true;
            }
            throw new InvalidFlightException("The flight name " + flightName + " is invalid");
        }
        public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException{
            if(passengerCount>0 && passengerCount <=396 && flightName.equalsIgnoreCase("spicejet")){
                return true;
            }
            else if(passengerCount>0 && passengerCount <=615 && flightName.equalsIgnoreCase("vistara")){
                return true;
            }
            else if(passengerCount > 0 && passengerCount <= 230 && flightName.equalsIgnoreCase("IndiGo")){
                return true;
            }

            else if(passengerCount>0 && passengerCount <=130 && flightName.equalsIgnoreCase("Air Arabia")){
                return true;
            }
            throw new InvalidFlightException("Invalid details related to flight");
        }
        public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException{
            if(currentFuelLevel < 0){
                throw new InvalidFlightException("You entered current fuel detail in negative");
            }
            if(flightName.equalsIgnoreCase("SpiceJet") && currentFuelLevel<= 200000){
                return 200000 - currentFuelLevel;
            }
            else if(flightName.equalsIgnoreCase("Vistara") && currentFuelLevel<= 300000){
                return 300000 - currentFuelLevel;
            }
            else if(flightName.equalsIgnoreCase("IndiGo") && currentFuelLevel<= 250000){
                return 250000 - currentFuelLevel;
            }
            else if(flightName.equalsIgnoreCase("Air Arabia") && currentFuelLevel<= 150000){
                return 150000 - currentFuelLevel;
            }
            throw new InvalidFlightException("Fuel limit exceeded");
        }
    }

