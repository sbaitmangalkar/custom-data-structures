package com.custom.datastructures.blockchain;

/**
 * Building blocks of <code>BlockChain</code>
 * 
 * @author Shyam Baitmangalkar | catch.shyambaitmangalkar@gmail.com
 * 
 * @param <Transaction>
 */
public class Block<Transaction> {
	int hash;
	Block<Transaction> previous;
	Transaction transaction;

	public Block(Transaction transaction) {
		this.transaction = transaction;
		this.hash = computeHash();
	}
	
	/**
	 * Computes hash (digital signature) 
	 * @return
	 */
	private int computeHash() {
		int result = 1;
		result = 31 * result + (transaction == null ? 0 : transaction.hashCode());
		result = 31 * result + (previous == null ? 0 : previous.hash);

		return result;
	}

	@Override
	public String toString() {
		return "Block [hash=" + hash + ", previous=" + previous + ", transaction=" + transaction + "]";
	}
}
