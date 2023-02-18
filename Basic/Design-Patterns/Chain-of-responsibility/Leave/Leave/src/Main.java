public class Main {
    public static void main(String[] args) {

        TeamLeader teamLeader = new TeamLeader();
        ProjectLeader projectLeader = new ProjectLeader();
        HR hr = new HR();
        Manager manager = new Manager();

        teamLeader.setSuperVisor(projectLeader);
        projectLeader.setSuperVisor(hr);
        hr.setSuperVisor(manager);

        Leave leave1 = new Leave(12,3, ReasonType.REGULAR);
        System.out.println(teamLeader.applyLeave(leave1));

        Leave leave2 = new Leave(5,5, ReasonType.REGULAR);
        System.out.println(teamLeader.applyLeave(leave2));

        Leave leave3 = new Leave(12,3, ReasonType.REGULAR);
        System.out.println(teamLeader.applyLeave(leave3));

        Leave leave4 = new Leave(18,2, ReasonType.CRITICAL);
        System.out.println(teamLeader.applyLeave(leave4));

        Leave leave5 = new Leave(18,2, ReasonType.REGULAR);
        System.out.println(teamLeader.applyLeave(leave5));

        Leave leave6 = new Leave(30,2, ReasonType.SPECIAL);
        System.out.println(teamLeader.applyLeave(leave6));
    }
}