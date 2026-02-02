package com.marcos.open_jobs.modules.company.repositories;

import com.marcos.open_jobs.modules.company.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
}
