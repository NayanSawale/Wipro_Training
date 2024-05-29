package tasks;
import java.util.*;
public class JobSequencing {

	 public static List<Job> jobSequencing(List<Job> jobs) {
	        // Sort jobs in descending order of profit
	        jobs.sort((a, b) -> b.profit - a.profit);
	        
	        // Find the maximum deadline to define the size of the result array
	        int maxDeadline = 0;
	        for (Job job : jobs) {
	            if (job.deadline > maxDeadline) {
	                maxDeadline = job.deadline;
	            }
	        }
	        
	        // To keep track of free time slots
	        boolean[] result = new boolean[maxDeadline];
	        // To store the sequence of jobs
	        Job[] jobOrder = new Job[maxDeadline];
	        
	        // Iterate through all given jobs
	        for (Job job : jobs) {
	            // Find a free slot for this job (starting from the last possible slot)
	            for (int j = Math.min(maxDeadline, job.deadline) - 1; j >= 0; j--) {
	                // Free slot found
	                if (!result[j]) {
	                    result[j] = true;
	                    jobOrder[j] = job;
	                    break;
	                }
	            }
	        }
	        
	        // Collect the jobs in the result array to return the job sequence
	        List<Job> jobSequence = new ArrayList<>();
	        for (int i = 0; i < maxDeadline; i++) {
	            if (result[i]) {
	                jobSequence.add(jobOrder[i]);
	            }
	        }
	        return jobSequence;
	    }

	    public static void main(String[] args) {
	        List<Job> jobs = Arrays.asList(
	            new Job(1, 2, 100),
	            new Job(2, 1, 19),
	            new Job(3, 2, 27),
	            new Job(4, 1, 25),
	            new Job(5, 3, 15)
	        );

	        List<Job> jobSequence = jobSequencing(jobs);
	        System.out.println("Job sequence to maximize profit:");
	        for (Job job : jobSequence) {
	            System.out.print("Job " + job.id + " ");
	        }
	    }

}
