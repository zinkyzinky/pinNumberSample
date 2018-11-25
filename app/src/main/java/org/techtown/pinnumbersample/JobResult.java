package org.techtown.pinnumbersample;

import java.util.Objects;

public class JobResult {

    private final int jobCode;
    private final int resultCode;
    private final Throwable throwable;

    public JobResult(int jobCode, int resultCode, Throwable throwable) {
        this.jobCode = jobCode;
        this.resultCode = resultCode;
        this.throwable = throwable;
    }

    public static JobResult of(int jobCode, int resultCode) {
        return new JobResult(jobCode, resultCode, null);
    }

    public static JobResult of(int jobCode, int resultCode, Throwable throwable) {
        return new JobResult(jobCode, resultCode, throwable);
    }

    public int getJobCode() {
        return jobCode;
    }

    public int getResultCode() {
        return resultCode;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public boolean is(int jobCode, int resultCode) {
        return this.jobCode == jobCode && this.resultCode == resultCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobResult jobResult = (JobResult) o;
        return jobCode == jobResult.jobCode &&
                resultCode == jobResult.resultCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobCode, resultCode);
    }

    @Override
    public String toString() {
        return "JobResult{" +
                "jobCode=" + jobCode +
                ", resultCode=" + resultCode +
                ", throwable=" + throwable +
                '}';
    }
}
