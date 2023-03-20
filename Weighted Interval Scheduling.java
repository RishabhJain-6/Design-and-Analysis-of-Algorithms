import java.util.*;

class WIS {
	static class Job {
		int id, start, finish, weight;

		Job(int i, int s, int f, int w) {
			this.id = i;
			this.start = s;
			this.finish = f;
			this.weight = w;
		}

		@Override
		public String toString() {
			return "( Job ID: " + this.id + ", Job Start Time: " + this.start + ", Job Finish Time: " + this.finish
					+ ", Job Weight: " + this.weight + ") ";
		}
	}

	public static void findMaxProfitJobs(ArrayList<Job> jobs) {
		// sort the jobs according to end time
		Collections.sort(jobs, new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				return o1.finish - o2.finish;
			}
		});

		int n = jobs.size();
		if (n == 0) {
			return;
		}

		// tasks[i] stores the index of non-conflicting jobs involved in the
		// maximum profit, which ends with the ith job
		ArrayList<ArrayList<Integer>> tasks = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			tasks.add(new ArrayList<>());
		}

		// maxProfit[i] stores the total profit of jobs in tasks[i]
		int[] maxProfit = new int[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				// update ith job if the jth job is non-conflicting and leading to
				// the maximum profit
				if (jobs.get(j).finish <= jobs.get(i).start && maxProfit[i] < maxProfit[j]) {
					tasks.set(i, new ArrayList<>(tasks.get(j)));
					maxProfit[i] = maxProfit[j];
				}
			}

			// end current task with ith job
			tasks.get(i).add(i);
			maxProfit[i] += jobs.get(i).weight;
		}

		// find an index with the maximum profit
		int index = 0;
		for (int i = 1; i < n; i++) {
			if (maxProfit[i] > maxProfit[index]) {
				index = i;
			}
		}

		System.out.print("Jobs involved in the maximum profit: \n");
		int t_profit = 0;
		for (Integer i : tasks.get(index)) {
			System.out.println(jobs.get(i));
			t_profit += jobs.get(i).weight;
		}
		System.out.println("\nMaximum Profit: " + t_profit);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter number of jobs: ");
		int n = scn.nextInt();
		ArrayList<Job> jobs = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			int s, f, w;
			System.out.println("Job " + i);
			System.out.print("Enter start time: ");
			s = scn.nextInt();
			System.out.print("Enter finish time: ");
			f = scn.nextInt();
			System.out.print("Enter weight: ");
			w = scn.nextInt();
			jobs.add(new Job(i, s, f, w));
		}
//		jobs.add(new Job(1, 1, 3, 20));
//		jobs.add(new Job(2, 3, 6, 20));
//		jobs.add(new Job(3, 5, 12, 100));
//		jobs.add(new Job(4, 7, 9, 70));
//		jobs.add(new Job(5, 10, 14, 60));
		findMaxProfitJobs(jobs);
	}
}
