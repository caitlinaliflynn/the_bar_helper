package org.launchcode.the_bar_helper.data;

import org.launchcode.the_bar_helper.models.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends CrudRepository<Position, Integer> {
}
