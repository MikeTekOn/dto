package weclaw.repositories;

import org.springframework.data.repository.CrudRepository;

import weclaw.domain.ApplicationUser;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {

}