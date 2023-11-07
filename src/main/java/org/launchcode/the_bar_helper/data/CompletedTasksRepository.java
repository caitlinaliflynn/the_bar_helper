package org.launchcode.the_bar_helper.data;

import org.launchcode.the_bar_helper.models.CompletedTasks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedTasksRepository extends CrudRepository<CompletedTasks, Integer> {
}
