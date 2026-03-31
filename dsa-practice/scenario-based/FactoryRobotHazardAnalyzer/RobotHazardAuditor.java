public class RobotHazardAuditor {

public double CalculateHazardRisk(double armPrecision, int workerDensity, String machineryState) throws RobotSafetyException{
    if(armPrecision < 0.0 || armPrecision >1.0){
        throw new RobotSafetyException("Error: Arm Precision must be 0.0-0.1");
    }
    if(workerDensity <1 || workerDensity >20){
        throw new RobotSafetyException("Error Worker density mut be 1-20");
    }
    if((!machineryState.equals("Worn")) && (!machineryState.equals("Faulty")) && (!machineryState.equals("Critical"))){
        throw new RobotSafetyException("Error: Unsupported machinery state");
    }
    double machineRiskFactor = 0;
    if(machineryState.equals("Worn")){
        machineRiskFactor = 1.3;
    }
    if(machineryState.equals("Faulty")){
        machineRiskFactor = 2.0;
    }
    if(machineryState.equals("Critical")){
        machineRiskFactor = 3.0;
    }
    double hazardRisk = ((1.0-armPrecision)*15.0)+(workerDensity*machineRiskFactor);
    return hazardRisk;
}
}
