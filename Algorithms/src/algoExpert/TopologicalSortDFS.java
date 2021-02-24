package algoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * ALGOEXPERT DEPTH FIRST SEARCH SOLUTION 
 * TIME ->(O)J+D
 * J->JOBS
 * D->Dependencies
 * SPACE ->(O)J+D
 * 
 */

public class TopologicalSortDFS {
	static class JobGraph
	{
		//temporary adding all the nodes 
		public List<JobNode>nodes;
		//graph will map the integer job to jobNode
		public Map<Integer,JobNode>graph;

		public JobGraph(List<Integer>jobs)
		{
			nodes=new ArrayList<>();
			graph=new HashMap<>();

			for(Integer job:jobs)
				addNode(job);
		}

		//converting the integer nodes into object and adding into graph
		public void addNode(Integer job)
		{
			graph.put(job,new JobNode(job));
			nodes.add(graph.get(job));
		}
		public JobNode getNode(Integer job)
		{
			if(!graph.containsKey(job))
				addNode(job);

			return graph.get(job);
		}
		public void addPrereq(Integer job,Integer prereq)
		{
			JobNode jobNode=getNode(job);
			JobNode prereqNode=getNode(prereq);

			jobNode.prereqs.add(prereqNode);
		}

		@Override
		public String toString() {
			return "JobGraph [nodes=" + nodes + ", graph=" + graph + "]";
		}
		
	}
	//class for each node
	static class JobNode
	{
		public Integer job;
		public List<JobNode>prereqs;
		//visiting means if it is in the process
		public boolean visiting;
		public boolean visited;

		public JobNode(Integer job) {
			this.job=job;
			prereqs=new ArrayList<JobNode>();
			visiting=false;
			visited=false;
		}

		@Override
		public String toString() {
			return "JobNode [job=" + job + ", prereqs=" + prereqs + ", visiting=" + visiting + ", visited=" + visited + "]";
		}


	}
	//courseSchedule210 
	/*
	 * Step1 : convert data into graph
	 * 	
	 * 
	 */

	public static void main(String[] args) {

		List<Integer>jobs=new ArrayList<Integer>();
		jobs.add(1);
		jobs.add(2);
		jobs.add(3);
		jobs.add(4);

		List<Integer[]>deps=new ArrayList<>();
		deps.add(new Integer[] {1,2});
		deps.add(new Integer[] {1,3});
		deps.add(new Integer[] {3,2});
		deps.add(new Integer[] {4,2});
		deps.add(new Integer[] {4,3});

		System.out.println(topologicalSort(jobs, deps));

	}
	public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {

		JobGraph graph=createJobGraph(jobs, deps);
		


		return getOrderedJobs(graph);
	}

	public static boolean dfs(JobNode node,List<Integer>orderedJobs)
	{
		if(node.visited)
			return false;

		if(node.visiting) // contains cycle
			return true;

		node.visiting=true;

		for(JobNode prereqNode:node.prereqs)
		{
			boolean containsCycle=dfs(prereqNode, orderedJobs);
			if(containsCycle)
				return true;
		}
		node.visited=true;
		node.visiting=false;
		orderedJobs.add(node.job);
		return false;
	}

	public static JobGraph createJobGraph(List<Integer>jobs,List<Integer[]>deps)
	{
		JobGraph graph=new JobGraph(jobs);

		System.out.println(graph.toString());
		for(Integer[]dep:deps)
		{
			//converting Integer job deps into JobNode prereqs
			graph.addPrereq(dep[1],dep[0]);
		}
		return graph;
	}
	public static List<Integer>getOrderedJobs(JobGraph graph)
	{
		List<Integer>orderedJobs=new ArrayList<Integer>();
		List<JobNode>nodes=new ArrayList<>(graph.nodes);

		while(nodes.size()>0)
		{
			JobNode jobNode=nodes.get(nodes.size()-1);
			nodes.remove(nodes.size()-1);

			boolean containsCycle=dfs(jobNode, orderedJobs);

			if(containsCycle)
				return new ArrayList<Integer>();
		}

		return orderedJobs;
	}


}
