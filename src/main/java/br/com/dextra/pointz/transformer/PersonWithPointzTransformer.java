package br.com.dextra.pointz.transformer;

import io.yawp.repository.transformers.Transformer;

import java.util.List;

import br.com.dextra.pointz.models.Person;
import br.com.dextra.pointz.models.Transaction;

public class PersonWithPointzTransformer extends Transformer<Person> {

	@SuppressWarnings("unused")
	private class PersonWithPointz extends Person {
		private Integer pointz;

		public PersonWithPointz(Person person) {
			this.copyPerson(person);
			this.pointz = fetchPointz(person);
		}

		private void copyPerson(Person person) {
			this.setId(person.getId());
			this.setName(person.getName());
		}
	}

	@Override
	public PersonWithPointz defaults(Person person) {
		return new PersonWithPointz(person);
	}

	private Integer fetchPointz(Person person) {
		int pointz = 0;
		for (Transaction t : allTransactions(person)) {
			pointz += t.getPointz();
		}
		return pointz;
	}

	private List<Transaction> allTransactions(Person person) {
		return yawp(Transaction.class).where("personId", "=", person.getId()).list();
	}
}
