package br.com.dextra.pointz.models;

public enum TransactionType {

	GITHUB_COMMIT(10);

	private int pointz;

	private TransactionType(int pointz) {
		this.pointz = pointz;
	}

	public int getPointz() {
		return pointz;
	}
}
