package org.launchcode.the_bar_helper.data;

import org.launchcode.the_bar_helper.models.TodoTasks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoTasksRepository extends CrudRepository<TodoTasks, Integer> {
}
