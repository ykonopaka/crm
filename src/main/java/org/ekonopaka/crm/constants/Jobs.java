package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.JobType;

public class Jobs {

	public static final String OUAP = "label.ouap.job.type";
	public static final String OUNP = "label.ounp.job.type";
	public static final String NOUAP = "label.nouap.job.type";
	public static final String NOUNP = "label.nounp.job.type";
	public static final String NP = "label.np.job.type";
	public static final String RETIREE = "label.retiree.job.type";
	public static final String WORKING_RETIREE = "label.wr.job.type";
	public static final String SELF_EMPLOYED = "label.sep.job.type";
	public static final String SAILOR = "label.sailor.job.type";
	
	public static List<JobType> generate()	{
		List<JobType> jobTypes = new ArrayList<JobType>();
		jobTypes.add(new JobType(1, Jobs.OUAP, true));
		jobTypes.add(new JobType(2, Jobs.OUNP, true));
		jobTypes.add(new JobType(3, Jobs.NOUAP, true));
		jobTypes.add(new JobType(4, Jobs.NOUNP, true));
		jobTypes.add(new JobType(5, Jobs.NP, true));
		jobTypes.add(new JobType(6, Jobs.RETIREE, true));
		jobTypes.add(new JobType(7, Jobs.WORKING_RETIREE, true));
		jobTypes.add(new JobType(8, Jobs.SELF_EMPLOYED, true));
		jobTypes.add(new JobType(9, Jobs.SAILOR, true));
		
		return jobTypes;
	}
}
