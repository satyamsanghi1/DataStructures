package algoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * ALGOEXPERT BREADTH FIRST SEARCH SOLUTION 
 * TIME ->(O)J+D
 * J->JOBS
 * D->Dependencies
 * SPACE ->(O)J+D
 */
class JobGraph
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
	public void addDep(Integer job,Integer dep)
	{
		JobNode jobNode=getNode(job);
		JobNode depNode=getNode(dep);

		jobNode.deps.add(depNode);
		depNode.noOfPrereqs+=1;
	}

	@Override
	public String toString() {
		return "JobGraph [ graph=" + graph + "]";
	}
	
}
//class for each node
class JobNode
{
	public Integer job;
	public List<JobNode>deps;
	public int noOfPrereqs;
	

	public JobNode(Integer job) {
		this.job=job;
		deps=new ArrayList<JobNode>();
		noOfPrereqs=0;
	}


	@Override
	public String toString() {
		return "JobNode [job=" + job + ", deps=" + deps + ", noOfPrereqs=" + noOfPrereqs + "]";
	}

}
public class TopologicalSortBFS {
	//courseSchedule210 
	/*
	 * Step1 : convert data into graph
	 * STEP2 :creating a list of  nodes which have 0 dependencies
	 * 	STEP3: Iterating over this list of nodes having 0 dependencies
	 * 			->for each of this node
	 * 				-adding this node into list of ordered jobs
	 * 				-Removing dependencies for this node
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
		
		deps.add(new Integer[] {4,2});
		deps.add(new Integer[] {4,3});

		System.out.println(topologicalSort(jobs, deps));

	}
	public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {

		JobGraph graph=createJobGraph(jobs, deps);
		return getOrderedJobs(graph);
	}

	
	public static JobGraph createJobGraph(List<Integer>jobs,List<Integer[]>deps)
	{
		JobGraph graph=new JobGraph(jobs);

	
		for(Integer[]dep:deps)
		{
		graph.addDep(dep[0],dep[1]);
		}
		//System.out.println(graph.graph.toString());
		return graph;
	}
	public static List<Integer>getOrderedJobs(JobGraph graph)
	{
		List<Integer>orderedJobs=new ArrayList<Integer>();
		List<JobNode>nodesWithNoPrereqs=new ArrayList<>();
		
		//adding all the nodes which have 0 prereqs
		for(JobNode jobNode:graph.nodes)
		{
			if(jobNode.noOfPrereqs==0)
			{
				nodesWithNoPrereqs.add(jobNode);
			}
		}

		//iterating over this list 
		while(nodesWithNoPrereqs.size()>0)
		{
			//getting the last node 
			JobNode node=nodesWithNoPrereqs.get(nodesWithNoPrereqs.size()-1);
			
			nodesWithNoPrereqs.remove(nodesWithNoPrereqs.size()-1);
			// adding this node to our orderedjobs list(answer)
			orderedJobs.add(node.job);
			//removing dependencies over this node
			removeDeps(node, nodesWithNoPrereqs);
			
		}
		// for cycle check
		/*
		 * at the end if there are still preReqs remaning ,
		 * then there is a cycle
		 */
		
		boolean graphHasEdge=false;
		for( JobNode node:graph.nodes)
		{
			if(node.noOfPrereqs>0)
				graphHasEdge=true;
		}

		return graphHasEdge?new ArrayList<Integer>():orderedJobs;
	}
	public static void removeDeps(JobNode node,List<JobNode>nodesWithNoPrereqs)
	{
		//iterating over the dependencies of this node
		while(node.deps.size()>0)
		{
			//getting the node from last 
			JobNode dep=node.deps.get(node.deps.size()-1);
			
			node.deps.remove(node.deps.size()-1);
			
			//subtracting one from each of dependent node 
			dep.noOfPrereqs--;
			
			//if this dep node has 0 dependencies , add it into nodesWithNodeprereqs List
			if(dep.noOfPrereqs==0)
				nodesWithNoPrereqs.add(dep);
		}
		
	}


}
