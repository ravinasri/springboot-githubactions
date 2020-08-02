package com.sample.springbootgithubactions.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.springbootgithubactions.model.Library;

public interface LibraryRepository extends JpaRepository<Library,Long> {

}
