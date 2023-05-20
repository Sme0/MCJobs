package me.smeo.sorcerymcjobs.models;

import java.util.Date;

public class JobStats {
    private String uuid;
    private String job;
    private Date jobStart;

    public JobStats(String uuid, String job, Date jobStart) {
        this.uuid = uuid;
        this.job = job;
        this.jobStart = jobStart;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getJobStart() {
        return jobStart;
    }

    public void setJobStart(Date jobStart) {
        this.jobStart = jobStart;
    }

}
