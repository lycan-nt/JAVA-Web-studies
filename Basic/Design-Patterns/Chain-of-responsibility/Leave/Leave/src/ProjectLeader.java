public class ProjectLeader extends LeaveHandler {

    @Override
    public String applyLeave(Leave leave) {
        System.out.println("PROJECT LEADER LEVEL");
        //"reasonType" is not going to be consider under TeamLeader & ProjectLeader
        //Project Leader can approve up to 14 days, otherwise it will pass to the HR
        if(leave.getNumberOfDays() <= 14){
            //Employee tier should be 3 or above to get approved
            if(leave.getEmpTier() <= 3){
                return "Your leave days has been APPROVED by Project Leader";
            }else{
                return "You employee Tier level is too low for request " + leave.getNumberOfDays() + " days";
            }
        }else{
            return superVisor.applyLeave(leave);
        }
    }

}
