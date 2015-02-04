package br.com.dextra.pointz.hooks;

import io.yawp.repository.hooks.Hook;
import br.com.dextra.pointz.models.Month;
import br.com.dextra.pointz.models.Transaction;

public class TransactionHook extends Hook<Transaction> {

	@Override
	public void afterSave(Transaction transaction) {
		Month.add(yawp, transaction.getDate(), transaction.getPointz());
	}
}
