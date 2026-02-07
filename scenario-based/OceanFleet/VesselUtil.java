import java.util.ArrayList;
import java.util.List;

public class VesselUtil {
    private List<Vessel> vesselList = new ArrayList<>();
    public VesselUtil(){

    }
    public void addVesselPerformance(Vessel vessel){
        vesselList.add(vessel);
    }

    public Vessel getVesselById(String vesselId){
        for(int i=0;i<vesselList.size();i++){
            if(vesselId.equals(vesselList.get(i).vesselId)){
                return vesselList.get(i);
            }
        }
        System.out.println("Vessel Id "+vesselId+" not found");
        return null;
    }
    public List<Vessel> getHighPerformanceVessels(){
        List<Vessel> output = new ArrayList<>();
        double highestSpeed = 0.0;
        for(Vessel vessels : vesselList){
            if(highestSpeed < vessels.averageSpeed){
                highestSpeed = vessels.averageSpeed;
            }
        }
        for(Vessel vessels : vesselList){
            if(vessels.averageSpeed == highestSpeed){
                output.add(vessels);
            }
        }
        return output;
    }
}
