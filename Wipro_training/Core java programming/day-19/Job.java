package tasks;

	class Job {
	    int id;     // Job Id
	    int deadline; // Deadline of job
	    int profit;  // Profit if job is completed before or on deadline
	    
	    // Constructor
	    public Job(int id, int deadline, int profit) {
	        this.id = id;
	        this.deadline = deadline;
	        this.profit = profit;
	    }
	}


