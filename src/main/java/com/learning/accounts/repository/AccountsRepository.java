package com.learning.accounts.repository;

import com.learning.accounts.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // TO make as Repo Class for Spring to use as JPA repo.
public interface AccountsRepository extends CrudRepository<Account, Long> {

    Account findByCustomerId(int customerId);
}
