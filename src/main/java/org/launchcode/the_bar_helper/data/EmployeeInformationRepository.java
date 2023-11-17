package org.launchcode.the_bar_helper.data;

import org.launchcode.the_bar_helper.models.EmployeeInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeInformationRepository extends CrudRepository<EmployeeInformation, Integer> {
}
