package br.com.dextra.pointz.transformer;

import io.yawp.repository.transformers.Transformer;
import br.com.dextra.pointz.models.Transaction;

public class TransactionWithValueTransformer extends Transformer<Transaction> {

	@SuppressWarnings("unused")
	private class TransactionWithValue extends Transaction {
		private Integer value;

		public TransactionWithValue(Transaction transaction) {
			this.copyTransaction(transaction);
			this.value = transaction.getType().getPointz();
		}

		private void copyTransaction(Transaction t) {
			this.setId(t.getId());
			this.setPerson(t.getPerson());
			this.setType(t.getType());
			this.setDate(t.getDate());
			this.setReference(t.getReference());
		}
	}

	@Override
	public TransactionWithValue defaults(Transaction transaction) {
		return new TransactionWithValue(transaction);
	}
}
