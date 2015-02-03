package br.com.dextra.pointz.actions;

import io.yawp.repository.IdRef;
import io.yawp.repository.actions.Action;
import io.yawp.repository.actions.annotations.PUT;
import br.com.dextra.pointz.models.Person;
import br.com.dextra.pointz.models.Transaction;

public class ResetPeople extends Action<Person> {

	@PUT("reset")
	public void reset() {
		deleteTransactions();
		deletePeople();
	}

	private void deletePeople() {
		for (IdRef<Person> id : yawp(Person.class).ids()) {
			id.delete();
		}
	}

	private void deleteTransactions() {
		for (IdRef<Transaction> id : yawp(Transaction.class).ids()) {
			id.delete();
		}
	}
}
