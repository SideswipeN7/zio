package com.whynot.zio.repo;

import com.whynot.zio.db.StudentRow;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentRow,Long> {
}
