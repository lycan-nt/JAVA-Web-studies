public class HR extends LeaveHandler {

    @Override
    public String applyLeave(Leave leave) {

        //HR can approve up to 21 days, otherwise it will pass to the Manager
        if(leave.getNumberOfDays() <= 21){
            //Employee tier should be 3 or above & reason type should not be "Regular" to get approved
            if(leave.getEmpTier() <= 3 && !leave.getReason().equals(ReasonType.REGULAR)){
                return "Your leave days has been APPROVED by HR";
            }else{
                return "Your leave request has been DENIED by HR";
            }
        }else{
            return superVisor.applyLeave(leave);
        }
    }

}
