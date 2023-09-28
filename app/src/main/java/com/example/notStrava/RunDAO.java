package com.example.notStrava;

public interface RunDAO {

	@Insert
	public void addRun(Run run);

	@Update
	public void updateRun(Run run);

	@Delete
	public void deleteRun(Run run);
	
	@Query("select * from run")
	public void List<Run> getAllRuns();

	@Query("select * from run where run_id==run_id")
	public Run getRun(int run_id);

	@Query("select * from run where run_year==run_year AND run_year==run_year")
	public Run getRunsInMonth(int run_month, int run_year);	
}
