/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Badmus
 */
public class Report {
    
    private String driver_id, takings, percentage, jobs_done;

    public Report(String driver_id, String takings, String percentage, String jobs_done) {
        this.driver_id = driver_id;
        this.takings = takings;
        this.percentage = percentage;
        this.jobs_done = jobs_done;
    }

    public String getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public String getTakings() {
        return takings;
    }

    public void setTakings(String takings) {
        this.takings = takings;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getJobs_done() {
        return jobs_done;
    }

    public void setJobs_done(String jobs_done) {
        this.jobs_done = jobs_done;
    }
    
    
}
